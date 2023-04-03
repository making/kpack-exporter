package lol.maki.kpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import lol.maki.kpack.BuiltinAlertProps.Slack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Component
public class BuiltinAlertSender {

	private final RestTemplate restTemplate;

	private final BuiltinAlertProps props;

	private final Logger logger = LoggerFactory.getLogger(BuiltinAlertSender.class);

	public BuiltinAlertSender(RestTemplateBuilder restTemplateBuilder, BuiltinAlertProps props) {
		this.restTemplate = restTemplateBuilder.build();
		this.props = props;
	}

	@Async
	public void sendAlert(AlertType alertType, String resourceType, String namespace, String name) {
		if (this.props.isEnabled()) {
			alertType.log(logger);
			final Object payload = buildPayload(alertType, resourceType, namespace, name);
			final RequestEntity<?> request = RequestEntity.post(this.props.getWebhookUrl())
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
			final ResponseEntity<String> response = this.restTemplate.exchange(request, String.class);
			logger.debug("Response: {}", response);
		}
	}

	Object buildPayload(AlertType alertType, String resourceType, String namespace, String name) {
		return switch (this.props.getType()) {
			case SLACK -> {
				final Slack slack = this.props.getSlack();
				final Map<String, Object> payload = new HashMap<>();
				payload.put("channel", slack.getChannel());
				payload.put("blocks", List.of(Map.of("type", "section", "text",
						Map.of("type", "mrkdwn", "text", alertType.textTemplate().formatted(resourceType)))));
				final List<String> text = new ArrayList<>();
				final List<Map<String, Object>> blocks = new ArrayList<>();
				if (StringUtils.hasLength(namespace)) {
					text.add("*Namespace*: `%s`".formatted(namespace));
				}
				text.add("*Name*: `%s`".formatted(name));
				if (StringUtils.hasLength(this.props.getCluster())) {
					text.add("*Cluster*: `%s`".formatted(this.props.getCluster()));
				}
				payload.put("attachments", List.of(Map.of("color", alertType.color(), "blocks", List.of(Map.of("type",
						"section", "text", Map.of("type", "mrkdwn", "text", String.join("\n", text)))))));
				if (StringUtils.hasLength(slack.getUsername())) {
					payload.put("username", slack.getUsername());
				}
				if (StringUtils.hasLength(slack.getIconUrl())) {
					payload.put("icon_url", slack.getIconUrl());
				}
				yield payload;
			}
			case GENERIC -> this.props.getGeneric()
				.getTemplate()
				.replace("${RESULT}", alertType.name())
				.replace("${TYPE}", resourceType)
				.replace("${NAMESPACE}", namespace)
				.replace("${NAME}", name)
				.replace("${CLUSTER}", this.props.getCluster())
				.replace("${TEXT}", alertType.textTemplate().formatted(resourceType))
				.replace("\"null\"", "null");
		};
	}

	enum AlertType {

		SUCCESS(":white_check_mark: *Incident for `%s` resolved*", "#00ff00",
				logger -> logger.info("Firing alert (Success)")),
		FAILURE(":rotating_light: *New Incident for `%s`*", "#ff0000", logger -> logger.warn("Firing alert (Failure)"));

		private final String textTemplate;

		private final String color;

		private final Consumer<Logger> log;

		AlertType(String textTemplate, String color, Consumer<Logger> log) {
			this.textTemplate = textTemplate;
			this.color = color;
			this.log = log;
		}

		public String textTemplate() {
			return this.textTemplate;
		}

		public String color() {
			return this.color;
		}

		public void log(Logger logger) {
			this.log.accept(logger);
		}

	}

}

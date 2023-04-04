package lol.maki.kpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lol.maki.kpack.BuiltinAlertProps.Slack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

	public void sendAlert(AlertType alertType, String kind, String namespace, String name) {
		if (this.props.isEnabled()) {
			alertType.log(logger);
			final Object payload = buildPayload(alertType, kind, namespace, name);
			final RequestEntity<?> request = RequestEntity.post(this.props.getWebhookUrl())
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
			final ResponseEntity<String> response = this.restTemplate.exchange(request, String.class);
			logger.debug("Response: {}", response);
		}
	}

	Object buildPayload(AlertType alertType, String kind, String namespace, String name) {
		return switch (this.props.getType()) {
			case SLACK -> {
				final Slack slack = this.props.getSlack();
				final Map<String, Object> payload = new HashMap<>();
				payload.put("channel", slack.getChannel());
				payload.put("blocks", List.of(Map.of("type", "section", "text",
						Map.of("type", "mrkdwn", "text", alertType.textTemplate().formatted(kind)))));
				final List<String> text = new ArrayList<>();
				if (StringUtils.hasLength(namespace)) {
					text.add("Namespace: `%s`".formatted(namespace));
				}
				text.add("Name: `%s`".formatted(name));
				if (StringUtils.hasLength(this.props.getCluster())) {
					text.add("Cluster: `%s`".formatted(this.props.getCluster()));
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
				.replace("${KIND}", kind)
				.replace("${NAMESPACE}", namespace)
				.replace("${NAME}", name)
				.replace("${CLUSTER}", this.props.getCluster())
				.replace("${TEXT}", alertType.textTemplate().formatted(kind))
				.replace("\"null\"", "null");
		};
	}

}

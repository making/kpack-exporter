package lol.maki.kpack;

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
	public void sendAlertSuccess(String metricName, String resourceName) {
		if (this.props.isEnabled()) {
			logger.info("Firing alert (Success)");
			final Object payload = buildPayload(true, metricName, resourceName);
			final RequestEntity<?> request = RequestEntity.post(this.props.getWebhookUrl())
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
			final ResponseEntity<String> response = this.restTemplate.exchange(request, String.class);
			logger.debug("Response: {}", response);
		}
	}

	@Async
	public void sendAlertFailure(String metricName, String resourceName) {
		if (this.props.isEnabled()) {
			logger.warn("Firing alert (Failure)");
			final Object payload = buildPayload(false, metricName, resourceName);
			final RequestEntity<?> request = RequestEntity.post(this.props.getWebhookUrl())
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
			final ResponseEntity<String> response = this.restTemplate.exchange(request, String.class);
			logger.debug("Response: {}", response);
		}
	}

	Object buildPayload(boolean success, String metricName, String resourceName) {
		return switch (this.props.getType()) {
			case SLACK -> {
				final Slack slack = this.props.getSlack();
				final Map<String, Object> payload = new HashMap<>();
				payload.put("channel", slack.getChannel());
				payload
					.put("blocks",
							List.of(Map.of("type", "section", "text",
									Map.of("type", "mrkdwn", "text",
											(success ? ":white_check_mark: *Incident resolved for `%s`*"
													: ":rotating_light: *New Incident for `%s`*")
												.formatted(metricName)))));
				payload.put("attachments",
						List.of(Map.of("color", success ? "#00ff00" : "#ff0000", "blocks", List.of(Map.of("type",
								"section", "text",
								Map.of("type", "mrkdwn", "text", "*Resource Name*: `%s`".formatted(resourceName)))))));
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
				.replace("${RESULT}", success ? "SUCCESS" : "FAILURE")
				.replace("${METRICS}", metricName)
				.replace("${RESOURCE}", resourceName);
		};
	}

}

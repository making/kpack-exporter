package lol.maki.kpack;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "builtin-alert")
public final class BuiltinAlertProps {

	private boolean enabled = false;

	private AlertType type = AlertType.GENERIC;

	private String webhookUrl;

	@NestedConfigurationProperty
	private Slack slack = new Slack();

	@NestedConfigurationProperty
	private Generic generic = new Generic();

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public AlertType getType() {
		return type;
	}

	public void setType(AlertType type) {
		this.type = type;
	}

	public String getWebhookUrl() {
		return webhookUrl;
	}

	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}

	public Slack getSlack() {
		return slack;
	}

	public void setSlack(Slack slack) {
		this.slack = slack;
	}

	public Generic getGeneric() {
		return generic;
	}

	public void setGeneric(Generic generic) {
		this.generic = generic;
	}

	public enum AlertType {

		SLACK, GENERIC

	}

	public static final class Slack {

		private String channel;

		private String username = "kpack-exporter";

		private String iconUrl = "https://raw.githubusercontent.com/pivotal/kpack/main/docs/assets/kpack.png";

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getIconUrl() {
			return iconUrl;
		}

		public void setIconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
		}

	}

	public static final class Generic {

		private String template = "{\"result\": \"${RESULT}\", \"metrics\": \"${METRICS}\", \"resource\": \"${RESOURCE}\"}";

		public String getTemplate() {
			return template;
		}

		public void setTemplate(String template) {
			this.template = template;
		}

	}

}

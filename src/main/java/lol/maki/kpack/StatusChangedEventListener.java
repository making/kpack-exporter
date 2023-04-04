package lol.maki.kpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StatusChangedEventListener {

	private final BuiltinAlertSender alertSender;

	private final Logger logger = LoggerFactory.getLogger(StatusChangedEventListener.class);

	public StatusChangedEventListener(BuiltinAlertSender alertSender) {
		this.alertSender = alertSender;
	}

	@EventListener
	@Async
	public void handleEvent(StatusChangedEvent event) {
		logger.debug("Handling {}", event);
		this.alertSender.sendAlert(event.alertType(), event.kind(), event.namespace(), event.name());
	}

}

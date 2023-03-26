package lol.maki.kpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KpackExporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KpackExporterApplication.class, args);
	}

	@Bean
	public ApplicationListener<ApplicationReadyEvent> warning() {
		final Logger log = LoggerFactory.getLogger(KpackExporterApplication.class);
		return event -> {
			log.warn("""
					**************************************************************
					kpack-expoerter is not a VMware product.
					This software is not supported by VMware.
					**************************************************************
					""");
		};
	}

}

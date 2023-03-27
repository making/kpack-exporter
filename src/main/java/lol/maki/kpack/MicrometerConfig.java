package lol.maki.kpack;

import io.micrometer.core.instrument.config.MeterFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MicrometerConfig {

	@Bean
	public MeterFilter customMeterFilter() {
		return MeterFilter.deny(id -> {
			String uri = id.getTag("uri");
			// exclude requests to actuator endpoints
			return uri != null && (uri.equals("/readyz") || uri.equals("/livez") || uri.startsWith("/actuator"));
		});
	}

}
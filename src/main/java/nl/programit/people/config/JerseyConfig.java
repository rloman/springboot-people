package nl.programit.people.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import nl.programit.people.rest.service.PersonService;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JerseyConfig.class);
	
	private static final Class<?>[] REGISTEREDCLASSES = new Class[]{PersonService.class};
	
	public JerseyConfig() {
		
		for(Class<?> clazz : REGISTEREDCLASSES) {
			LOGGER.debug("Registering [{}] rest service", clazz.getSimpleName());
			register(clazz);
		}
	}
}
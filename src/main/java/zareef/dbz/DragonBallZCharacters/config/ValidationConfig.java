package zareef.dbz.DragonBallZCharacters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class ValidationConfig {
	@Bean
	public ValidatingMongoEventListener validationMongoEventListener() {
		return new ValidatingMongoEventListener(validator());
	}
	
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}

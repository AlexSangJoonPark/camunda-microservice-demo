package au.com.deloitte.pe.camunda.demo.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class RabbitConfiguration {

	@Autowired
	private MessageConverter messageConverter;

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}
	
	@Bean
	public MessageConverter messageConverter() {
	    return new Jackson2JsonMessageConverter();
	}
	
//	@Bean
//	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//	   DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//	   factory.setMessageConverter(messageConverter);
//	   return factory;
//	}
}


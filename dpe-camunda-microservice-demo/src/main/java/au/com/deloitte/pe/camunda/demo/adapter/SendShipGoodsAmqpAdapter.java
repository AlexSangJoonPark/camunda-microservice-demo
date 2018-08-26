package au.com.deloitte.pe.camunda.demo.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.deloitte.pe.camunda.demo.DemoConstants;
import au.com.deloitte.pe.camunda.demo.model.OrderItem;

@Component
public class SendShipGoodsAmqpAdapter implements JavaDelegate {

	@Autowired
	protected RabbitTemplate rabbitTemplate;

	@Override
	public void execute(DelegateExecution exec) throws Exception {

		String processInstanceId = exec.getProcessInstanceId();
		String orderId = (String) exec.getVariable(DemoConstants.VAR_NAME_orderId);
		int amount = (int) exec.getVariable(DemoConstants.VAR_NAME_amount);
		OrderItem orderItem = new OrderItem(orderId, amount);
		rabbitTemplate.convertAndSend(DemoConstants.EXCHANGE_NAME, DemoConstants.ROUTING_KEY, orderItem, 
				new MessagePostProcessor() {
					@Override
					public Message postProcessMessage(Message message) throws AmqpException {
						message.getMessageProperties().setCorrelationId(processInstanceId);
						return message;
					}
				});
	}

}

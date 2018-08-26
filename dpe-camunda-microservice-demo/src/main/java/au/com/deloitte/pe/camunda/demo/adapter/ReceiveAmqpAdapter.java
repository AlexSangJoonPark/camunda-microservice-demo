package au.com.deloitte.pe.camunda.demo.adapter;

import java.util.Map;
import java.util.UUID;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import au.com.deloitte.pe.camunda.demo.DemoConstants;
import au.com.deloitte.pe.camunda.demo.model.OrderItem;

@Component
@Profile("!test")
public class ReceiveAmqpAdapter {

	@Autowired
	private ProcessEngine camunda;

	public ReceiveAmqpAdapter() {
	}

	public ReceiveAmqpAdapter(ProcessEngine camunda) {
		this.camunda = camunda;
	}

	/**
	 * Dummy method to handle the shipGoods command message - as we do not have a
	 * shipping system available in this small example
	 */
	@RabbitListener(bindings = @QueueBinding( //
			value = @Queue(value = DemoConstants.QUEUE_NAME, durable = "true"), //
			exchange = @Exchange(value = DemoConstants.EXCHANGE_NAME, type = "topic", durable = "true"), //
			key = "*"))
	@Transactional
//	public void dummyShipGoodsCommand(OrderItem orderItem, @Headers Map headers) {
	public void dummyShipGoodsCommand(OrderItem orderItem, 
			@Header(name=AmqpHeaders.CORRELATION_ID) String correlationId) {
		String orderId = orderItem.getOrderId();
//		String correlationId = (String) headers.get(AmqpHeaders.CORRELATION_ID);
		handleGoodsShippedEvent(orderId, UUID.randomUUID().toString(), correlationId);
	}

	public void handleGoodsShippedEvent(String orderId, String shipmentId, String processInstanceId) {
		
		MessageCorrelationBuilder correlation = camunda.getRuntimeService()
				.createMessageCorrelation(DemoConstants.MSG_NAME_GoodsShipped) //
//				.processInstanceVariableEquals(DemoConstants.VAR_NAME_orderId, orderId) //
				.processInstanceId(processInstanceId)
				.setVariable(DemoConstants.VAR_NAME_shipmentId, shipmentId);
		correlation.correlate();
		
		System.out.println(String.format("received order: %s, processInstanceId: %s", orderId, processInstanceId));
	}
	
}

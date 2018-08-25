package au.com.deloitte.pe.camunda.demo.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.deloitte.pe.camunda.demo.DemoConstants;

@Component
public class SendShipGoodsAmqpAdapter implements JavaDelegate {

  @Autowired
  protected RabbitTemplate rabbitTemplate;
  
  @Override
  public void execute(DelegateExecution exec) throws Exception {
    String orderId = (String) exec.getVariable(DemoConstants.VAR_NAME_orderId);    
    
    String exchange = "shipping";
    String routingKey = "createShipment";
    
    rabbitTemplate.convertAndSend(exchange, routingKey, orderId);
  }

}

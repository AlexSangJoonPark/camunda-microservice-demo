package au.com.deloitte.pe.camunda.demo;

public class DemoConstants {

  public static final String PROCESS_KEY_order = "order";
  
  public static final String VAR_NAME_orderId = "orderId";
  public static final String VAR_NAME_amount = "amount";
  public static final String VAR_NAME_shipmentId = "shipmentId";
  public static final String VARIABLE_paymentTransactionId = "paymentTransactionId";
  
  public static final String MSG_NAME_GoodsShipped = "Message_GoodsShipped";
  
  
  public static final String EXCHANGE_NAME = "shipping";
  public static final String ROUTING_KEY = "createShipment";
  public static final String QUEUE_NAME = "shipping_create_test";

}

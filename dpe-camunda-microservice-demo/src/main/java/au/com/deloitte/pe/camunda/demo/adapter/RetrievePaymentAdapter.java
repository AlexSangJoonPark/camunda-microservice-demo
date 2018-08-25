package au.com.deloitte.pe.camunda.demo.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import au.com.deloitte.pe.camunda.demo.DemoConstants;
import au.com.deloitte.pe.camunda.demo.model.CreateChargeRequest;
import au.com.deloitte.pe.camunda.demo.model.CreateChargeResponse;

@Component
@ConfigurationProperties
public class RetrievePaymentAdapter implements JavaDelegate {

//  @Autowired
//  private RestTemplate rest;

  private String restProxyHost;
  private String restProxyPort;

  private String restEndpoint() {
    return "http://" + restProxyHost + ":" + restProxyPort + "/payment/charges";
  }
  
  @Override
  public void execute(DelegateExecution exec) throws Exception {
    CreateChargeRequest request = new CreateChargeRequest();
    request.amount = (int) exec.getVariable(DemoConstants.VAR_NAME_amount);
    
//    CreateChargeResponse response = rest.postForObject( //
//        restEndpoint(), //
//        request, //
//        CreateChargeResponse.class);
    
    exec.setVariable(DemoConstants.VARIABLE_paymentTransactionId, "mocked-tx-id-001");
  }

  public String getRestProxyHost() {
    return restProxyHost;
  }

  public void setRestProxyHost(String restProxyHost) {
    this.restProxyHost = restProxyHost;
  }

  public String getRestProxyPort() {
    return restProxyPort;
  }

  public void setRestProxyPort(String restProxyPort) {
    this.restProxyPort = restProxyPort;
  }

}
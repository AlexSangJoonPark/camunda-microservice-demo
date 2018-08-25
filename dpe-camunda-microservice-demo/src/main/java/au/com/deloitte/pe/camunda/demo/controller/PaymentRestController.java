package au.com.deloitte.pe.camunda.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.deloitte.pe.camunda.demo.model.CreateChargeRequest;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
  
  @RequestMapping(path="/charges", method=RequestMethod.POST)
  public String createCharge(CreateChargeRequest request) {
    return "{\"transactionId\": \"77412\"}";
  }
}

package au.com.deloitte.pe.camunda.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("timer:foo")
//          .to("log:bar");
    }
}
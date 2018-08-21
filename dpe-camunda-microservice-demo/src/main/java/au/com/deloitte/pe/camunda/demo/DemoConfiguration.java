package au.com.deloitte.pe.camunda.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoConfiguration {
}
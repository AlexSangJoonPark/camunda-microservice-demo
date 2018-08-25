package au.com.deloitte.pe.camunda.demo;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private RuntimeService runtimeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Start a process when the boot application up
	 */
	@PostConstruct
	public void startProcess() {
//	  runtimeService.startProcessInstanceByKey("dpeDevBrownbagProcess");
	}
}

package au.com.deloitte.pe.camunda.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	private final DemoProperties properties;

	@Autowired
	public DemoService(DemoProperties properties) {
	    this.properties = properties;
	}

	@PostConstruct
	public void openConnection() {
//		InetAddress ip = this.properties.getRemoteAddress();
		
	}

}
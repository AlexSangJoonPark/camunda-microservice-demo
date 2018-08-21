package au.com.deloitte.pe.camunda.demo;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties("demo")
@Getter @Setter @NoArgsConstructor
public class DemoProperties {

	private boolean enabled;
	
	@NotNull
	private InetAddress remoteAddress;

	private final Security security = new Security();

	public static class Security {

		private String username;

		private String password;

		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));
		
	}
	
}
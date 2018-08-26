package au.com.deloitte.pe.camunda.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class DemoActuatorInfoContributor implements InfoContributor {

	@Override
    public void contribute(Info.Builder builder) {
        Map<String, String> details = new HashMap<>();
        details.put("brownbag", "Camunda BPM as a Microservice!");
        Map<String, Object> tracks = new HashMap<>();
        tracks.put("dev", details);
        builder.withDetail("dpe", tracks);
    }

}
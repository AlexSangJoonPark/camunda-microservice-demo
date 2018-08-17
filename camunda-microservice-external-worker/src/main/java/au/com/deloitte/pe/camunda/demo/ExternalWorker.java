package au.com.deloitte.pe.camunda.demo;

import java.util.logging.Logger;

import org.camunda.bpm.client.ExternalTaskClient;

public class ExternalWorker {

	private final static Logger LOGGER = Logger.getLogger(ExternalWorker.class.getName());

	public static void main(String[] args) {
		ExternalTaskClient client = ExternalTaskClient.create().baseUrl("http://localhost:8080/rest").build();

		// subscribe to an external task topic as specified in the process
		client.subscribe("charge-card").lockDuration(1000) // the default lock duration is 20 seconds, but you can
															// override this
				.handler((externalTask, externalTaskService) -> {
					// Put your business logic here

					// Get a process variable
					String item = (String) externalTask.getVariable("item");
					Long amount = (Long) externalTask.getVariable("amount");
					LOGGER.info(
							"Charging credit card with an amount of '" + amount + "'€ for the item '" + item + "'...");

					// Complete the task
					externalTaskService.complete(externalTask);
				}).open();
	}

}

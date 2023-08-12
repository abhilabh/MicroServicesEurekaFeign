package apresiliancediscoveryservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApResilianceDiscoveryService2Application {

	public static void main(String[] args) {
		SpringApplication.run(ApResilianceDiscoveryService2Application.class, args);
	}

}

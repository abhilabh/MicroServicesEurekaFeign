package apresiliancediscoveryservice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("servive2")
public class ApResilianceDiscoveryService2Controller {
	@Value("Default message")
	String message;
	
	@Value("${server.port}")
	String serverPort;
	
	@GetMapping("/greeting")
	public String getResponse() {
		return message;
	}
	
	@GetMapping("/loadbalancerusingribbon")
	public String getResponseUsingRibbon() {
		
		List<String> list = Arrays.asList("walker","tester", "random", "boiler", "Don");
		Random random = new Random();
		int next = random.nextInt(list.size());
		return list.get(next) + " port: " + serverPort;
	}

}

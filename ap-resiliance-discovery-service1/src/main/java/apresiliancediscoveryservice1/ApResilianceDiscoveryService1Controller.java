package apresiliancediscoveryservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("servive1")
public class ApResilianceDiscoveryService1Controller {
	@Value("Default message")
	String message;
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	FeignInterfaceService1 connFeignInterfaceService1;
	
	@GetMapping("/getMessage")
	public String getResponse() {
		return message;
	}

	@GetMapping("/getServiceApp")
	public String getServiceApp() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("AP-SERVICE2-APP", false);
		String baseUrlString = instanceInfo.getHomePageUrl();
		baseUrlString += "/servive2/greeting";
		
		return restTemplate.getForObject(baseUrlString, String.class);
	}
	
	@CircuitBreaker(name="greetdemo", fallbackMethod = "myFallBackMethod")
	@GetMapping("/feigntestapp")
	public String getServiceAppUsingFeign() {
		return connFeignInterfaceService1.getGreetString();
	}
	
	
	@GetMapping("/loadbalancertest")
	public String getLoadBalancerTest() {
		return connFeignInterfaceService1.getRibbonLoadbalanceTest();
	}
	
	
	public String myFallBackMethod(Throwable trThrowable) {
		return "This is fall back method";
	}
}

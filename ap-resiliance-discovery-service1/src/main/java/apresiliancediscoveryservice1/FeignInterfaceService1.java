package apresiliancediscoveryservice1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="AP-SERVICE2-APP")
public interface FeignInterfaceService1 {
	
	@GetMapping("/servive2/greeting")
	public String getGreetString();
	
	@GetMapping("/servive2/loadbalancerusingribbon")
	public String getRibbonLoadbalanceTest();

}

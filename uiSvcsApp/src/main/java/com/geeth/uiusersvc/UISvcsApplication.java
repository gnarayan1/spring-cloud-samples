package com.geeth.uiusersvc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@Configuration
@RestController
@RequestMapping("ui")
public class UISvcsApplication {
	
	@Autowired
	UserClient userClient;

	  @Value("${someURL:cognizant.com}")
	  private String URL;
	  
	  @Value("${featureFlag.abc}")
	  private boolean abcFeatureflag;
	  
	  @Value("${abc}")
	  private String abc;
	
	public static void main(String[] args) {
		SpringApplication.run(UISvcsApplication.class, args);
	}
	
	 @RequestMapping(value = "/userroles/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	  public UserRoles getUserAndRoles(@PathVariable(name = "id") int id) 
	  {		 
		 User user = userClient.getUser(id);
		 String[] roles = userClient.getRoles(id);		
		 return new UserRoles(user, roles);
	  }
	 
	 
	 @RequestMapping(value = "/coupleofprops", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public Map<String, Object> getCoupleOfProps() 
	  {		 
		Map<String, Object> propMap = new HashMap<>();
		propMap.put("url", URL);
		propMap.put("abcFeatureflag", abcFeatureflag);
		propMap.put("abc", abc);
		
		return propMap;
	  }

}

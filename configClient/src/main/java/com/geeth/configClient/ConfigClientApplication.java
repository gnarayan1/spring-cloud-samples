package com.geeth.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	
	@RefreshScope
	@RestController
	class URLRestController {

	  @Value("${someURL:cognizant.com}")
	  private String URL;
	  
	  @Value("${featureFlag.abc}")
	  private boolean abcFeatureflag;

	  @RequestMapping("/configurl")
	  String getURL() {
	    return this.URL;
	  }
	  
	  @RequestMapping("/isAbcOn")
	  boolean isAbcOn() {
	    return this.abcFeatureflag;
	  }
	  
	}

}

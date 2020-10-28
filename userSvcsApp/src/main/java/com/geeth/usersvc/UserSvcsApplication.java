package com.geeth.usersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("user")
public class UserSvcsApplication {

	@RequestMapping(method = RequestMethod.GET, value="/profile/{userid}")
	public User prof(@PathVariable(name = "userid") int userid) {
		System.out.println("=======> In User call");
		return new User(userid, "Joe", "Exotic", "joe@tigerking.com");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/roles/{userid}")
	public String[] roles(@PathVariable(name = "userid") int userid) {
		return new String[] {"claimview", "price", "audit"};
	}

	public static void main(String[] args) {
		SpringApplication.run(UserSvcsApplication.class, args);
	}

}

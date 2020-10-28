package com.geeth.uiusersvc;

import org.springframework.stereotype.Component;

@Component
public  class UserFallback implements UserClient {
	 
	public User getUser(int id) {
		System.out.println("FAILURE : USER PROFILE SERVICE");
		return new User(0, "Default", "Default", "error@erro.com");
	}
	
	public String[] getRoles(int id) {
		System.out.println("FAILURE :ROLES SERVICE");
		return new String[]{"ANONYMOUS"};
	}

	
}
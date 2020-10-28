package com.geeth.uiusersvc;

public class UserRoles {
	
	private User user;
	private String[] roles;
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the roles
	 */
	public String[] getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	
	public UserRoles() {
		
	}
	
	public UserRoles(User user, String[] roles) {
		this.user = user;
		this.roles = roles;
	}

}

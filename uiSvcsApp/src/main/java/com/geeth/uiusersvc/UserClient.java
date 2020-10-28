/**
 * 
 */
package com.geeth.uiusersvc;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author geeth.narayanan
 *
 */

//@LoadBalancerClient(name = "server", configuration = LoadBalancerConfig.class)
//@FeignClient(name = "USERSVCS", fallback = UserFallback.class)
@FeignClient(name = "APIGATEWAY", fallback = UserFallback.class)
public interface UserClient {

	//@LoadBalanced()
	@GetMapping("usersvcs/user/profile/{userid}")
	public User getUser(@PathVariable("userid") int id);

	//@LoadBalanced
	@GetMapping("usersvcs/user/roles/{userid}")
	public String[] getRoles(@PathVariable("userid") int id);

}

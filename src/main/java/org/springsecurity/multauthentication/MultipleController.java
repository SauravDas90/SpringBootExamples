package org.springsecurity.multauthentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultipleController {
	
	@GetMapping("/api/jwt/test")
	public String jwtMethod(){
		return "jwt-tested";
		
	}
	
	@GetMapping("/api/smuser/test")
	public String siteminderMethod(){
		return "site-minder tested";
		
	}
	
	@GetMapping("/api/jwt/unauthorized/test")
	public String unauthorized(){
		return "unauthorized tested";
		
	}
	
	

}

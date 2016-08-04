package net.element.bootapp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	public static final String LOGGER=null;
	
	@RequestMapping("/web/boot")
	public String restBootCall(){
		
		System.out.println("Inside Boot App call");
		return "Spring boot accessed successfully";
	}
	
	@RequestMapping("/rest/androidboot")
	public String restBootCallAndroid(){
		
		System.out.println("Calling Android app");
		return "Android call received successfully";
	}
	@RequestMapping(value="/web/login", method={RequestMethod.POST,RequestMethod.GET},consumes="application/x-www-form-urlencoded")
	public String validateLogin(@RequestBody User user){
		
		if(user != null && (user.getUserName()!=null || !user.getUserName().isEmpty()))
		{
			if(user != null && (user.getPassword()!=null || !user.getPassword().isEmpty()))
			{
				if(user.getPassword().equalsIgnoreCase("Ger@123"))
					return "Authentication SuccessFul \n";
					
			}
		}
		
		return "Authentication Failed. Try again \n";
	}
	
	@RequestMapping(value="/web/login1", method={RequestMethod.POST,RequestMethod.GET})
	public String validateLoginGet(@RequestParam("name") String user){

				if(user.equalsIgnoreCase("Ger@123"))
					return "Authentication SuccessFul \n";
				else
		
		return "Authentication Failed. Try again \n";
	}
	

}

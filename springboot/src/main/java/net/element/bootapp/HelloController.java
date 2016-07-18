package net.element.bootapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/web/boot")
	public String restBootCall(){
		
		System.out.println("Inside Boot App call");
		return "Spring boot accessed successfully";
	}
	

}

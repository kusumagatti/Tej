package com.sathya.springbootmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
 
	@GetMapping("/test")
	public String greet() {
		return "myview";
	}
	
}

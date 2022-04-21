package com.misc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${spring.application.name}")
	String appName;
	
	
	
	@GetMapping(value="/appname")
	public String getAppName() {
		return this.appName;
		
	}

}

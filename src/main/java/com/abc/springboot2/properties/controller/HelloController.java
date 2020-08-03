package com.abc.springboot2.properties.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/say")
	public Object say() {
		return "say hello";
	}
}

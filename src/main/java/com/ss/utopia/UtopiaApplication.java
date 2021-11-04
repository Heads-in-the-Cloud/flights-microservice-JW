package com.ss.utopia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class UtopiaApplication extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UtopiaApplication.class);
	}
	public static void main(String[] args) {
//		SpringApplication.run(UtopiaApplication.class, args);
	}
	@RequestMapping(value = "/")
	public String test() {
		return "Tester";
	}
}

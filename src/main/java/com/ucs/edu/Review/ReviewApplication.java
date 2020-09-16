package com.ucs.edu.Review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ReviewApplication extends SpringBootServletInitializer{
	@SuppressWarnings("rawtypes")
	private static Class applicationClass = ReviewApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
}

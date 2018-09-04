package com.virtualan.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Spring boot rest controller with virtualan
 * 
 * @author Elan Thangamani
 *
 */
@Configuration 
@EnableAutoConfiguration 
@ComponentScan 
public class VirtualanSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualanSpringBootApplication.class, args);
	}
}

package com.webhook.springrestfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/** Add @SpringBootApplication
 * Add @EnableAutoconfiguration
 * To Enable Auto-Configuration indicate this is a spring context
 **/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.webhook.springrestfull"})
public class SpringrestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestfullApplication.class, args);
	}

}

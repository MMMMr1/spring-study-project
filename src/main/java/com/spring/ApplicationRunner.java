package com.spring;

import com.spring.config.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
		System.out.println("Count  " + context.getBeanDefinitionCount());
		System.out.println(context.getBean("pool1"));
		System.out.println(context.getBean("userRepository"));
		System.out.println(context.getBean(DataBaseProperties.class));
  
	}
}

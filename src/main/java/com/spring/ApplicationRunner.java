package com.spring;

import com.spring.config.ApplicationConfiguration;
import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CrudRepository;
import com.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

			ConnectionPool pool2 = context.getBean("pool1",ConnectionPool.class);
			System.out.println(pool2);
			var companyServise = context.getBean("companyService", CompanyService.class);
			System.out.println(companyServise.findById(1));
		}
	}
}

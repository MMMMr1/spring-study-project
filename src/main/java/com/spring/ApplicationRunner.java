package com.spring;

import com.spring.config.ApplicationConfiguration;
import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

			ConnectionPool pool2 = context.getBean("pool1",ConnectionPool.class);
			System.out.println(pool2);
			var companyRepository = context.getBean("companyRepository", CrudRepository.class);
			System.out.println(companyRepository.findById(1));
		}
	}
}

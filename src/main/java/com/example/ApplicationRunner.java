package com.example;

import com.example.config.ApplicationConfiguration;
import com.example.database.pool.ConnectionPool;
import com.example.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {

			ConnectionPool pool1 = context.getBean("pool1", ConnectionPool.class);
			System.out.println(pool1);
			var companyRepository = context.getBean("companyRepository", CrudRepository.class);
			System.out.println(companyRepository.findById(1));
		}
	}
}

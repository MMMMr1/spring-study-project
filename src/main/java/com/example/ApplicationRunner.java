package com.example;

import com.example.database.pool.ConnectionPool;
import com.example.database.repository.CrudRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {

			ConnectionPool pool1 = context.getBean("pool1", ConnectionPool.class);
			System.out.println(pool1);
			var companyRepository = context.getBean("companyRepository", CrudRepository.class);
			System.out.println(companyRepository.findById(1));
		}
	}
}

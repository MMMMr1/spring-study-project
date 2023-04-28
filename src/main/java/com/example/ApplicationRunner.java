package com.example;

import com.example.database.pool.ConnectionPool;
import com.example.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {

			ConnectionPool pool1 = context.getBean("p1", ConnectionPool.class);
			System.out.println(pool1);
			CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
			System.out.println(companyRepository);
		}
	}
}

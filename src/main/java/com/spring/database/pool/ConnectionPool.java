package com.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool  {
    @Value("postgres")
    private final String username;
    @Value("12")
    private final Integer poolSize;

    @PostConstruct
    private void init(){
        System.out.println("initialization");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Clean connection pool");
    }
}

package com.spring.config;

import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.UserRepository;
import com.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
//@ImportResource("classpath:application.xml")

@Configuration
public class ApplicationConfiguration {
    @Bean
    public UserRepository userRepository2(ConnectionPool pool2){
        return new UserRepository(pool2);
    }

}

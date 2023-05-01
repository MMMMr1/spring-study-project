package com.spring.config;

import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CrudRepository;
import com.spring.database.repository.UserRepository;
import com.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.spring",
                useDefaultFilters = false,
                includeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
                }
)
public class ApplicationConfiguration {
    @Bean("pool2")
    public ConnectionPool pool2(@Value("${db.username}") String name){
        return new ConnectionPool(name, 20);
    }
    @Bean
    public ConnectionPool pool3( ){
        return new ConnectionPool("test-pool", 20);
    }
    @Bean
    public UserRepository userRepository2(ConnectionPool pool2){
        return new UserRepository(pool2);
    }
    @Bean
    public UserRepository userRepository3( ){
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        ConnectionPool connectionPool3 = pool3();
        return new UserRepository(pool3());
    }

}

package com.example.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

public class ConnectionPool implements InitializingBean {
    private  final String username;
    private final Integer poolSize;
    private final List<Object> arg;
    private  Map<String,Object> properties;

    public ConnectionPool(String username, Integer poolSize, List<Object> arg, Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.arg = arg;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
    @PostConstruct
    private void init(){
        System.out.println("initialization");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("properties set");
    }
    @PreDestroy
    private void destroy(){
        System.out.println("Clean connection pool");
    }
}

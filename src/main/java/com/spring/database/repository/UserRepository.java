package com.spring.database.repository;

import com.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(  ConnectionPool pool2) {
        this.connectionPool = pool2;
    }
}
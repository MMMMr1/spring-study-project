package com.example.database.repository;

import com.example.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;

    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    public static CompanyRepository of(ConnectionPool connectionPool){
        return new CompanyRepository(connectionPool);
    }
}

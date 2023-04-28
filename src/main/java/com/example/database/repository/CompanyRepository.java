package com.example.database.repository;

import com.example.beanpostprocesssor.InjectBean;
import com.example.database.pool.ConnectionPool;

public class CompanyRepository {
    @InjectBean
    private  ConnectionPool connectionPool;
 }

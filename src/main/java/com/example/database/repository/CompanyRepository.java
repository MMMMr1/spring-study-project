package com.example.database.repository;

import com.example.beanpostprocesssor.Auditing;
import com.example.beanpostprocesssor.InjectBean;
import com.example.beanpostprocesssor.Transaction;
import com.example.database.entity.Company;
import com.example.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;

import java.util.Optional;
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private  ConnectionPool connectionPool;
    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method ...");
//        заглушка
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method ...");
    }
}

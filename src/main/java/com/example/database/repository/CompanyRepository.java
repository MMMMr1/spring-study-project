package com.example.database.repository;

import com.example.beanpostprocesssor.Auditing;
import com.example.beanpostprocesssor.InjectBean;
import com.example.beanpostprocesssor.Transaction;
import com.example.database.entity.Company;
import com.example.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;
    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }
    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }
    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method ...");
        return Optional.of(new Company(id));
    }
    @Override
    public void delete(Company entity) {
        System.out.println("delete method ...");
    }
}

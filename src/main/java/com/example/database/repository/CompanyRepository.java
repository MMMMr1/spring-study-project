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

import java.util.List;
import java.util.Optional;
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
//    @Resource(name = "pool1")
    @Autowired
//    @Qualifier("pool1")
    private  ConnectionPool pool1;
    @Autowired
    private List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private Integer poolSize;
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
    @Autowired
    public void setPool1(ConnectionPool pool1) {
        this.pool1 = pool1;
    }
}

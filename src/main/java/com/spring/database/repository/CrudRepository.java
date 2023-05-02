package com.spring.database.repository;

import org.springframework.stereotype.Component;

import java.util.Optional;

public interface CrudRepository <K,E>{
    Optional<E> findById (K id);
    void delete (E entity);

}

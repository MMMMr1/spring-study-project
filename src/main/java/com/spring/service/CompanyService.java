package com.spring.service;

import com.spring.database.entity.Company;
import com.spring.database.repository.CrudRepository;
import com.spring.dto.CompanyReadDto;
import com.spring.listener.entity.AccessType;
import com.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CrudRepository<Integer, Company> companyCrudRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    public CompanyService(CrudRepository<Integer, Company> companyCrudRepository,
                          UserService userService, ApplicationEventPublisher eventPublisher) {
        this.companyCrudRepository = companyCrudRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }
    public Optional<CompanyReadDto> findById(Integer id){
        return companyCrudRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }
}
package com.spring.demo;

import com.spring.database.entity.Company;
import com.spring.database.repository.CrudRepository;
import com.spring.dto.CompanyReadDto;
import com.spring.listener.entity.EntityEvent;
import com.spring.service.CompanyService;
import com.spring.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.*;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;
    @Mock
    private CrudRepository<Integer, Company> companyCrudRepository;
    @Mock
    private UserService userService;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;
    @Test
    void findById(){
        doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyCrudRepository).findById(COMPANY_ID);
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult,actual));
//      проверяем что ивент был отправлен
        verify(eventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(eventPublisher,userService);

    }
}

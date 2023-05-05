package com.spring.integration.service;

import com.spring.config.DataBaseProperties;
import com.spring.database.entity.Company;
import com.spring.dto.CompanyReadDto;
import com.spring.integration.annotation.IT;
import com.spring.listener.entity.EntityEvent;
import com.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DataBaseProperties dataBaseProperties;
    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult,actual));
    }
}

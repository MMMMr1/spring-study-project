package com.spring.integration.service;

import com.spring.config.DataBaseProperties;
import com.spring.dto.CompanyReadDto;
import com.spring.integration.annotation.IT;
import com.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


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

package com.spring.integration.service;

import com.spring.config.DataBaseProperties;
import com.spring.dto.CompanyReadDto;
import com.spring.integration.IntegrationTestBase;
import com.spring.integration.annotation.IT;
import com.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
public class CompanyServiceIT extends IntegrationTestBase {
    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DataBaseProperties dataBaseProperties;
    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID, "djjdj");
        actualResult.ifPresent(actual -> assertEquals(expectedResult,actual));
    }
}

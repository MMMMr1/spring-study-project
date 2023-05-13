package com.spring.integration.database.repository;

import com.spring.database.entity.Company;
import com.spring.database.repository.CompanyRepository;
import com.spring.integration.IntegrationTestBase;
import com.spring.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@RequiredArgsConstructor
class CompanyRepositoryTest extends IntegrationTestBase {
    private static final Integer APPLE_ID = 14;
    private final TransactionTemplate transactionTemplate;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries() {
        companyRepository.findByName("google");
        companyRepository.findByNameContainingIgnoreCase("a");
    }

    @Test
    @Disabled
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }
    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(transaction -> {
            Company company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            Assertions.assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    @Disabled
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }


}
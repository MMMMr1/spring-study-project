package com.spring.integration.database.repository;

import com.spring.database.entity.Company;
import com.spring.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@IT
@RequiredArgsConstructor
@Transactional
//@Commit
class CompanyRepositoryTest {
    private final EntityManager entityManager;

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        Assertions.assertThat(company.getLocales()).hasSize(2);
    }

    @Test
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
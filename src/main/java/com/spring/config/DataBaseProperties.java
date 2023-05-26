package com.spring.config;

import jakarta.validation.constraints.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
@Validated
@ConfigurationProperties(prefix = "db")
public record DataBaseProperties(
        String username,
        String password,
        String driver,
        String url,
        String hosts,
        PoolProperties pool,
        List<PoolProperties> pools,
        Map<String, Object> properties) {
    public static record PoolProperties(Integer size,
                                        Integer timeout) {
    }
}

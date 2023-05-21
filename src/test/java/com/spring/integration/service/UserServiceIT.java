package com.spring.integration.service;

import com.spring.database.entity.Role;
import com.spring.database.pool.ConnectionPool;
import com.spring.dto.UserCreateEditDto;
import com.spring.dto.UserReadDto;
import com.spring.integration.IntegrationTestBase;
import com.spring.integration.annotation.IT;
import com.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;


@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {
    private static final Long USER_1 = 1L;
    private static final Integer COMPANY_1 = 1;
    private final UserService userService;
    @Test
    void  findAll(){
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }
    @Test
    void findById(){
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("ivan@gmail.com", user.getUsername()));
    }
    @Test
    void create(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        UserReadDto actualResult = userService.create(userDto);
        assertEquals(userDto.getUsername(),actualResult.getUsername());
        assertEquals(userDto.getFirstname(),actualResult.getFirstname());
        assertEquals(userDto.getLastname(),actualResult.getLastname());
        assertEquals(userDto.getBirthDate(),actualResult.getBirthDate());
        assertEquals(userDto.getCompanyId(),actualResult.getCompany().id());
        assertSame(userDto.getRole(),actualResult.getRole());
    }
    @Test
    void update(){
        UserCreateEditDto userDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        Optional<UserReadDto> actualResult = userService.update(USER_1, userDto);
        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> {
            assertEquals(userDto.getUsername(),user.getUsername());
            assertEquals(userDto.getFirstname(),user.getFirstname());
            assertEquals(userDto.getLastname(),user.getLastname());
            assertEquals(userDto.getBirthDate(),user.getBirthDate());
            assertEquals(userDto.getCompanyId(),user.getCompany().id());
            assertSame(userDto.getRole(),user.getRole());
        });
    }
    @Test
    void delete(){
        assertTrue(userService.delete(USER_1));
        assertFalse(userService.delete(-1134L));
    }


}

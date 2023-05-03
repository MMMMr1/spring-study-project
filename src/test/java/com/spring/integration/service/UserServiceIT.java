package com.spring.integration.service;

import com.spring.database.pool.ConnectionPool;
import com.spring.integration.annotation.IT;
import com.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;

@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {
    private final UserService userService;
    private final ConnectionPool pool;
    @Test
    void  test1(){
        System.out.println("test1");
    }
    @Test
    void  test2(){
        System.out.println("test2");
    }
    @Test
    void  test3(){
        System.out.println("test3");
    }
}

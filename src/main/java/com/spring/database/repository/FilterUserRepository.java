package com.spring.database.repository;

import com.spring.database.entity.User;
import com.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}

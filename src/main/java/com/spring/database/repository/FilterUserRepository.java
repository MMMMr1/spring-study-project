package com.spring.database.repository;

import com.spring.database.entity.Role;
import com.spring.database.entity.User;
import com.spring.dto.PersonalInfo;
import com.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);
}

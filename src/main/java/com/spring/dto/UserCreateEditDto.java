package com.spring.dto;

import com.spring.database.entity.Company;
import com.spring.database.entity.Role;
import jakarta.persistence.*;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}

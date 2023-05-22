package com.spring.dto;

import com.spring.database.entity.Company;
import com.spring.database.entity.Role;
import jakarta.persistence.*;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}

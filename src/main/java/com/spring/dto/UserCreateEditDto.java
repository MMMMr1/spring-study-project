package com.spring.dto;

import com.spring.database.entity.Role;
import com.spring.validation.UserInfo;
import com.spring.validation.group.CreateAction;
import com.spring.validation.group.UpdateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = {CreateAction.class})
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Size(min = 3, max = 64)
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
    MultipartFile image;
}

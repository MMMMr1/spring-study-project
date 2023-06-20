package com.spring.mapper;

import com.spring.database.entity.Company;
import com.spring.database.entity.User;
import com.spring.database.repository.CompanyRepository;
import com.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);
        return user;
    }
    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(UserCreateEditDto object, User user) {
        user.setUsername(object.getUsername());
        user.setBirthDate(object.getBirthDate());
        user.setLastname(object.getLastname());
        user.setFirstname(object.getFirstname());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));
        Optional.ofNullable(object.getRawPassword())
                .filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);
        Optional.ofNullable(object.getImage())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image -> user.setImage(image.getOriginalFilename()));
    }
    private Company getCompany(Integer companyId){
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);

    }

}

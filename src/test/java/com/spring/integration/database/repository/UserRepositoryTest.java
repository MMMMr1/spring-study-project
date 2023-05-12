package com.spring.integration.database.repository;

import com.spring.database.entity.Role;
import com.spring.database.entity.User;
import com.spring.database.repository.UserRepository;
import com.spring.dto.PersonalInfo;
import com.spring.dto.UserFilter;
import com.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.spring.database.entity.QUser.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {
    private final UserRepository userRepository;
    @Test
    void checkJdbcTemplate(){
        var allByCompanyIdAndRole = userRepository.findAllByCompanyIdAndRole(1, Role.USER);
        assertThat(allByCompanyIdAndRole).hasSize(1);
        System.out.println();
    }

    @Test
    void checkAuditing(){
        var user = userRepository.findById(1L).get();
        user.setBirthDate(user.getBirthDate().plusYears(1L));
        userRepository.flush();
        System.out.println();
    }
    @Test
    void checkCustomImplementation(){
        UserFilter filter = new UserFilter(
                null, "ov", LocalDate.now()
        );
        var users = userRepository.findAllByFilter(filter);
        assertThat(users).hasSize(4);
    }
    @Test
    void testQuerydslPredicates(){
        var predicate = user.firstname.containsIgnoreCase("ivaN")
                .and(user.birthDate.before(LocalDate.now()));
        Page<User> allValues = userRepository.findAll(predicate, Pageable.unpaged());
        assertThat(allValues.getContent()).hasSize(1);
    }
    @Test
    void checkProjections(){
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
    }
    @Test
    void checkUpdate(){
        User ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN, ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        int resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);
//        ivan.getCompany().getName();   // LazyInitializationException - no Session
        User theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER, theSameIvan.getRole());
    }
    @Test
    void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
    }
    @Test
    void checkFirstTop(){
        Optional<User> topUser = userRepository.findTopByOrderByIdDesc();
        assertTrue(topUser.isPresent());
        topUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }
    @Test
    void checkPageable(){
        PageRequest pageable = PageRequest.of(0, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));
        while (slice.hasNext()){
             slice = userRepository.findAllBy(slice.nextPageable());
             slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }
    @Test
    void checkSort(){
        var sort = Sort.sort(User.class);
        sort.by(User::getUsername)
                .and(sort.by(User::getLastname));
        Sort sortByName = Sort.by("firstname").and(Sort.by("lastname"));
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore (LocalDate.now(), sort);
        assertThat(allUsers).hasSize(3);
    }
}
package com.spring.service;

import com.spring.beanpostprocesssor.Transaction;
import com.spring.database.repository.UserRepository;
import com.spring.dto.UserCreateEditDto;
import com.spring.dto.UserReadDto;
import com.spring.mapper.UserCreateEditMapper;
import com.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;
    public List<UserReadDto> findAll(){
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .collect(Collectors.toList());
    }
    public Optional<UserReadDto> findById(Long id){
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }
    @Transactional
    public UserReadDto create(UserCreateEditDto userDto){
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }
    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto){
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto,entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }
    @Transactional
    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(entity ->{
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}

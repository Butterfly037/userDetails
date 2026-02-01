package com.userdetails.service;

import com.userdetails.dto.UserDetailsDto;

import java.util.List;

public interface UserDetailsService {

    UserDetailsDto createUser(UserDetailsDto userDetailsDto);
    UserDetailsDto updateUser(Long id,UserDetailsDto userDetailsDto);
    void deleteUserUser(Long id);
    List<UserDetailsDto> getUserDetails();
    UserDetailsDto retriveUserDetailsById(Long id);
}

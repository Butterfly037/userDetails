package com.userdetails.service;

import com.userdetails.dto.UserDetailsDto;
import com.userdetails.entity.UserDetails;
import com.userdetails.exception.UserNotFoundException;
import com.userdetails.repository.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailsDto createUser(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = mapUserDetails(userDetailsDto);
        UserDetails userDetailsWithId = userDetailsRepository.save(userDetails);
        userDetailsDto.setUserId(userDetailsWithId.getUserId());
        return userDetailsDto;
    }

    @Override
    public UserDetailsDto updateUser(Long id, UserDetailsDto userDetailsDto) {
        UserDetails user = userDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id " + id));
        userDetailsDto.setUserId(user.getUserId());
        user.setUserName(userDetailsDto.getUserName());
        user.setUserMobileNumber(userDetailsDto.getUserMobileNumber());
        userDetailsRepository.save(user);
        return userDetailsDto;
    }

    @Override
    public void deleteUserUser(Long id) {
        UserDetails user = userDetailsRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id " + id));
        if (user != null) {
            userDetailsRepository.deleteById(id);
        }
    }

    @Override
    public List<UserDetailsDto> getUserDetails() {
        List<UserDetails> userDetails = userDetailsRepository.findAll();
        return userDetails.stream().map(this::mapUserDetailsDto).collect(Collectors.toList());
    }

    @Override
    public UserDetailsDto retriveUserDetailsById(Long id) {
        UserDetails userDetails= userDetailsRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id " + id));
        return mapUserDetailsDto(userDetails);
    }

    private UserDetails mapUserDetails(UserDetailsDto userDetailsDto) {
        return new UserDetails(userDetailsDto.getUserId(), userDetailsDto.getUserName(), userDetailsDto.getUserMobileNumber());
    }

    private UserDetailsDto mapUserDetailsDto(UserDetails userDetails) {
        return new UserDetailsDto(userDetails.getUserId(), userDetails.getUserName(), userDetails.getUserMobileNumber());
    }
}
package com.userdetails.dto;

public class UserDetailsDto {

    private Long userId;
    private String userName;
    private String userMobileNumber;

    public UserDetailsDto() {
    }

    public UserDetailsDto(Long userId, String userName, String userMobileNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }
}

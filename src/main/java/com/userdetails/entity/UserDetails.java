package com.userdetails.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="UserDetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "UserMobileNumber")
    private String userMobileNumber;

    public UserDetails() {
    }

    public UserDetails(Long userId, String userName, String userMobileNumber) {
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

package com.d3vlin13.medicalappointmentadvisor.model;

import com.d3vlin13.medicalappointmentadvisor.enums.UserType;

public abstract class User {
    private static int idCounter = 0;
    private final int id;
    private final UserType userType;
    private String email;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;

    public User(UserType userType, String email, String password, String name) {
        this.id = ++idCounter;
        this.userType = userType;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

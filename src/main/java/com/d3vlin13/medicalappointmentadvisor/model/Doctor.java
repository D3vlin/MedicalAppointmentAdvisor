package com.d3vlin13.medicalappointmentadvisor.model;

import com.d3vlin13.medicalappointmentadvisor.enums.UserType;

public class Doctor extends User {
    private String speciality;

    public Doctor(String email, String password, String name) {
        super(UserType.DOCTOR, email, password, name);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}

package com.d3vlin13.medicalappointmentadvisor.model;

public class Doctor extends User {
    private String speciality;

    public Doctor(String email, String password, String name) {
        super(email, password, name);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}

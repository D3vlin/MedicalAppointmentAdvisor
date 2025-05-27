package com.d3vlin13.medicalappointmentadvisor.model;

import com.d3vlin13.medicalappointmentadvisor.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    private String speciality;
    private final List<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String email, String password, String name) {
        super(UserType.DOCTOR, email, password, name);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public void addAvailableAppointments(AvailableAppointment availableAppointment) {
        this.availableAppointments.add(availableAppointment);
    }
}

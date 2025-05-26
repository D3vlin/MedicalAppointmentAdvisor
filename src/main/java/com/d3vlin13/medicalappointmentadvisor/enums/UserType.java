package com.d3vlin13.medicalappointmentadvisor.enums;

public enum UserType {
    DOCTOR(1),
    PATIENT(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

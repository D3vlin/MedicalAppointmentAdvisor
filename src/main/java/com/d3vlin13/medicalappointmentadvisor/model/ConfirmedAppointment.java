package com.d3vlin13.medicalappointmentadvisor.model;

import java.text.ParseException;

public class ConfirmedAppointment extends Appointment {
    private Patient patient;
    private Doctor doctor;

    public ConfirmedAppointment(Patient patient, Doctor doctor, String date, String time) throws ParseException {
        super(date, time);
        this.patient = patient;
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

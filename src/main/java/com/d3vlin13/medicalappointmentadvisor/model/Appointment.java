package com.d3vlin13.medicalappointmentadvisor.model;

import java.util.Date;

public class Appointment implements ISchedulable {
    private static int id = 0;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, Date date, String time) {
        id++;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void schedule(Date date, String time) {

    }
}

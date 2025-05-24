package com.d3vlin13.medicalappointmentadvisor.model;

public class Doctor {
    private static int id = 0;
    private String name;
    private String speciality;

    public Doctor(String name) {
        this.name = name;
        id++;
    }

    public void showName() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}

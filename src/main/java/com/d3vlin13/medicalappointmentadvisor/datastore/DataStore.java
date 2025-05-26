package com.d3vlin13.medicalappointmentadvisor.datastore;

import com.d3vlin13.medicalappointmentadvisor.model.Doctor;
import com.d3vlin13.medicalappointmentadvisor.model.Patient;

import java.util.ArrayList;
import java.util.List;

public final class DataStore {
    private static final DataStore instance = new DataStore();
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();

    static {
        doctors.add(new Doctor("general@email.com", "general", "Alejandro"));
        doctors.add(new Doctor("optometrist@email.com", "optometrist", "Karen"));

        patients.add(new Patient("pepito@email.com", "pepito", "Pepito"));
    }

    private DataStore() {}

    public static DataStore getInstance() {
        return instance;
    }

    public Doctor getDoctorByEmail(String email) {
        return doctors.stream()
                .filter(d -> d.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Patient getPatientByEmail(String email) {
        return patients.stream()
                .filter(d -> d.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

}

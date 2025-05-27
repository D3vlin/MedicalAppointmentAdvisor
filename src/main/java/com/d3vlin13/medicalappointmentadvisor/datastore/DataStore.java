package com.d3vlin13.medicalappointmentadvisor.datastore;

import com.d3vlin13.medicalappointmentadvisor.model.AvailableAppointment;
import com.d3vlin13.medicalappointmentadvisor.model.Doctor;
import com.d3vlin13.medicalappointmentadvisor.model.Patient;
import com.d3vlin13.medicalappointmentadvisor.model.User;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.util.ArrayList;
import java.util.List;

public final class DataStore {
    private static final DataStore instance = new DataStore();
    private static final List<Doctor> doctors = new ArrayList<>();
    public static final List<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();

    static {
        try {
            Doctor doctorGeneral = new Doctor("general@email.com", "general", "Alejandro");
            doctorGeneral.addAvailableAppointments(new AvailableAppointment("June/10/2025", "10:00"));
            doctorGeneral.addAvailableAppointments(new AvailableAppointment("June/11/2025", "14:00"));
            doctors.add(doctorGeneral);
            checkDoctorAvailableAppointments(doctorGeneral);

            Doctor doctorOptometrist = new Doctor("optometrist@email.com", "optometrist", "Fernando");
            doctorOptometrist.addAvailableAppointments(new AvailableAppointment("July/23/2025", "12:00"));
            doctorOptometrist.addAvailableAppointments(new AvailableAppointment("July/24/2025", "16:00"));
            doctors.add(doctorOptometrist);
            checkDoctorAvailableAppointments(doctorOptometrist);

            doctors.add(new Doctor("optometrist@email.com", "optometrist", "Karen"));
        } catch (Exception e) {
            Printer.logError("Error creating DataStore");
        }

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

    public static Doctor findDoctorByUser(User user) {
        return doctors.stream()
                .filter(d -> d.getId() == (user.getId()))
                .findFirst()
                .orElse(null);
    }

    public static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (!doctor.getAvailableAppointments().isEmpty() && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }


}

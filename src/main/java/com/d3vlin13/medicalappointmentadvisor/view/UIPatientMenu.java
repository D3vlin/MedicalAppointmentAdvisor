package com.d3vlin13.medicalappointmentadvisor.view;

import com.d3vlin13.medicalappointmentadvisor.datastore.DataStore;
import com.d3vlin13.medicalappointmentadvisor.model.AvailableAppointment;
import com.d3vlin13.medicalappointmentadvisor.model.Doctor;
import com.d3vlin13.medicalappointmentadvisor.util.IMenuAction;
import com.d3vlin13.medicalappointmentadvisor.util.MenuUtils;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class UIPatientMenu {
    static private final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    static public void showPatientMenu() {
        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Book an appointment");
        options.put(2, "My appointments");
        options.put(0, "Logout");

        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();
        actions.put(1, () -> {
            UIPatientMenu.showBookAppointmentMenu();
            return true;
        });

        actions.put(2, () -> {
            Printer.logSystem("::My appointments");
            Printer.progressBar("Processing", 20, 100);
            return true;
        });

        actions.put(0, () -> {
            Printer.logSystem("::Logout");
            return false;
        });

        MenuUtils.showMenu("Patient", options, actions);
    }

    private static void showBookAppointmentMenu() {
        Printer.progressBar("Processing", 20, 100);
        Printer.logSystem("::Book an appointment");

        Map<Integer, String> options = new LinkedHashMap<>();
        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();

        int i = 1;
        for (Doctor doctor : DataStore.doctorsAvailableAppointments) {
            for (AvailableAppointment availableAppointment : doctor.getAvailableAppointments()) {
                options.put(i, doctor.getName() + " | " + availableAppointment.toString());
                actions.put(i, () -> UIPatientMenu.bookAppointment(doctor, availableAppointment));
                i++;
            }
        }

        options.put(0, "Return");
        actions.put(0, () -> {
            Printer.logSystem("::Return");
            return false;
        });

        MenuUtils.showMenu("Book a appointment", options, actions);
    }

    static private boolean bookAppointment(Doctor doctor, AvailableAppointment availableAppointment) {
        final boolean[] cancelAppointment = {false};
        Printer.logSystem("::" + doctor.getName() + " | " + availableAppointment.toString());

        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Confirm");
        options.put(0, "Change Appointment");

        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();
        actions.put(1, () -> {
            Printer.logSystem("::Appointment confirmed");
            cancelAppointment[0] = false;
            return false;
        });

        actions.put(0, () -> {
            Printer.logSystem("::Change Appointment");
            cancelAppointment[0] = true;
            return false;
        });

        MenuUtils.showMenu("Confirm your appointment", options, actions);
        return cancelAppointment[0];
    }
}

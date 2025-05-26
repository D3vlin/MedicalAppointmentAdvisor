package com.d3vlin13.medicalappointmentadvisor.view;

import com.d3vlin13.medicalappointmentadvisor.datastore.DataStore;
import com.d3vlin13.medicalappointmentadvisor.enums.UserType;
import com.d3vlin13.medicalappointmentadvisor.model.Doctor;
import com.d3vlin13.medicalappointmentadvisor.model.Patient;
import com.d3vlin13.medicalappointmentadvisor.model.User;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.util.Scanner;

public class UIAuth {
    static private final Scanner SC = new Scanner(System.in);

    static User showAuthMenu(UserType userType) {
        User userLogged = null;
        int attempts = 0;

        while (attempts < 3) {
            Printer.logInfo("Insert your email:");
            Printer.logIndicatorSystem();
            String email = Printer.GetInput();

            Printer.logInfo("\nInsert your password:");
            Printer.logIndicatorSystem();
            String password = Printer.GetInput();

            userLogged = switch (userType) {
                case DOCTOR -> DataStore.getInstance().getDoctorByEmail(email);
                case PATIENT -> DataStore.getInstance().getPatientByEmail(email);
            };

            if (userLogged != null && password.equals(userLogged.getPassword())) {
                Printer.logSystem("Welcome " + (userType == UserType.DOCTOR ? "Dr. " : "Patient ") + userLogged.getName());
                return userLogged;
            } else {
                attempts++;
                Printer.logWarn("The data entered is not correct. Try again.");
            }
        }

        Printer.logError("Too many failed login attempts. Access denied.");
        return null;
    }
}

package com.d3vlin13.medicalappointmentadvisor.view;

import com.d3vlin13.medicalappointmentadvisor.enums.UserType;
import com.d3vlin13.medicalappointmentadvisor.model.User;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.time.LocalDate;

public class UIMenu {
    static private final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    static public void showMenu() {
        Printer.logInfo("Welcome user");

        User userLogged = null;
        int response = 0;

        do {
            Printer.logInfo("Choose the desired option\n");
            Printer.logInfo("1. Doctor");
            Printer.logInfo("2. Patient");
            Printer.logInfo("0. Exit");
            Printer.logIndicatorSystem();

            response = Printer.ValidateIntegerInput();

            switch (response) {
                case 1 -> {
                    Printer.logSystem("Doctor");
                    userLogged = UIAuth.showAuthMenu(UserType.DOCTOR);
                    if (userLogged == null) {
                        response = 0;
                    } else {
                        showDoctorMenu();
                    }
                }

                case 2 -> {
                    Printer.logSystem("Patient");
                    userLogged = UIAuth.showAuthMenu(UserType.PATIENT);
                    if (userLogged == null) {
                        response = 0;
                    } else {
                        showPatientMenu();
                    }
                }

                case 0 -> {
                    Printer.logSystem("Exit");
                }

                default -> Printer.logWarn("Please select a correct answer!");
            }
        } while (response != 0);
    }

    static private void showDoctorMenu() {

    }

    static private void showPatientMenu() {
        int response;

        do {
            Printer.logInfo("Patient\n");
            Printer.logInfo("1. Book an appointment");
            Printer.logInfo("2. My appointments");
            Printer.logInfo("0. Return");
            Printer.logIndicatorSystem();

            response = Printer.ValidateIntegerInput();

            switch (response) {
                case 1:
                    Printer.logSystem("::Book an appointment");

                    int currentMonth = LocalDate.now().getMonthValue();
                    for (int i = 1; i <= 3; i++) {
                        int nextMonthIndex = (currentMonth - 1 + i) % 12;
                        Printer.logSystem(MONTHS[nextMonthIndex]);
                    }
                    break;

                case 2:
                    Printer.logSystem("::My appointments");
                    Printer.progressBar("Processing", 20, 100);
                    break;

                case 0:
                    Printer.logSystem("Return");
                    break;

                default:
                    Printer.logWarn("Please select a correct answer!");
            }
        } while (response != 0);
    }
}

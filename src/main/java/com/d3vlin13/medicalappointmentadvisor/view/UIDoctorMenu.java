package com.d3vlin13.medicalappointmentadvisor.view;

import com.d3vlin13.medicalappointmentadvisor.datastore.DataStore;
import com.d3vlin13.medicalappointmentadvisor.model.AvailableAppointment;
import com.d3vlin13.medicalappointmentadvisor.model.Doctor;
import com.d3vlin13.medicalappointmentadvisor.model.User;
import com.d3vlin13.medicalappointmentadvisor.util.IMenuAction;
import com.d3vlin13.medicalappointmentadvisor.util.MenuUtils;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public final class UIDoctorMenu {
    static private final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static private Doctor doctorLogged;


    static public void showDoctorMenu(User userLogged) {
        doctorLogged = DataStore.findDoctorByUser(userLogged);

        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Add Available Appointment");
        options.put(2, "My Schedule Appointments");
        options.put(0, "Logout");

        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();
        actions.put(1, () -> {
            UIDoctorMenu.showAddAvailableAppointmentsMenu();
            return true;
        });
        actions.put(2, () -> {
            UIDoctorMenu.showMyScheduleAppointments();
            return true;
        });

        actions.put(0, () -> {
            Printer.logSystem("::Logout");
            return false;
        });

        MenuUtils.showMenu("Doctor", options, actions);
    }

    private static void showAddAvailableAppointmentsMenu() {
        Printer.logSystem("::Add Available Appointment");

        Map<Integer, String> options = new LinkedHashMap<>();
        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();

        int currentMonth = LocalDate.now().getMonthValue();
        for (int i = 1; i <= 3; i++) {
            int nextMonthIndex = (currentMonth - 1 + i) % 12;
            options.put(i, MONTHS[nextMonthIndex]);
            actions.put(i, () -> UIDoctorMenu.showSelectAvailableDayMenu(nextMonthIndex));
        }

        options.put(0, "Return");
        actions.put(0, () -> {
            Printer.logSystem("::Return");
            return false;
        });

        MenuUtils.showMenu("Select a Month", options, actions);
    }

    private static boolean showSelectAvailableDayMenu(int nextMonthIndex) {
        final boolean[] changeDate = {false};
        Printer.logSystem("::" + MONTHS[nextMonthIndex]);

        Printer.logInfo("\nInsert the day available:");
        Printer.logIndicatorSystem();
        int availableDay = Printer.ValidateIntegerInput();
        String availableDate = MONTHS[nextMonthIndex] + "/" + availableDay + "/" + LocalDate.now().getYear();

        Printer.logInfo("\nInsert the hour available example [16:00]:");
        Printer.logIndicatorSystem();
        String availableHour = Printer.GetInput();

        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Correct");
        options.put(0, "Change Date");

        Map<Integer, IMenuAction> actions = new LinkedHashMap<>();
        actions.put(1, () -> {
            try {
                doctorLogged.addAvailableAppointments(new AvailableAppointment(availableDate, availableHour));
                Printer.logSystem("::Correct -> Available date confirmed!");
                DataStore.checkDoctorAvailableAppointments(doctorLogged);
                changeDate[0] = false;

            } catch (Exception e) {
                Printer.logError("The date format is incorrect!");
                changeDate[0] = true;
            }
            return false;
        });
        actions.put(0, () -> {
            Printer.logSystem("::Change Date");
            changeDate[0] = true;
            return false;
        });

        MenuUtils.showMenu("Your available date is: " + availableDate + " " + availableHour, options, actions);
        return changeDate[0];
    }

    private static void showMyScheduleAppointments() {
        Printer.progressBar("Processing", 20, 100);
        Printer.logSystem("::My Schedule Appointments");

        for (AvailableAppointment availableAppointment : doctorLogged.getAvailableAppointments()) {
            Printer.logSystem(availableAppointment.toString());
        }
    }
}

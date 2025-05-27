package com.d3vlin13.medicalappointmentadvisor.view;

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
            Printer.logSystem("::Book an appointment");
            int currentMonth = LocalDate.now().getMonthValue();
            for (int i = 1; i <= 3; i++) {
                int nextMonthIndex = (currentMonth - 1 + i) % 12;
                Printer.logSystem(MONTHS[nextMonthIndex]);
            }
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
}

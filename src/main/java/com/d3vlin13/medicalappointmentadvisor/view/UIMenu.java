package com.d3vlin13.medicalappointmentadvisor.view;

import com.d3vlin13.medicalappointmentadvisor.enums.UserType;
import com.d3vlin13.medicalappointmentadvisor.model.User;
import com.d3vlin13.medicalappointmentadvisor.util.IMenuAction;
import com.d3vlin13.medicalappointmentadvisor.util.MenuUtils;
import com.d3vlin13.medicalappointmentadvisor.util.Printer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UIMenu {
    static public void showMenu() {
        Printer.logInfo("Welcome user");

        Map<Integer, String> options = new LinkedHashMap<>();
        options.put(1, "Doctor");
        options.put(2, "Patient");
        options.put(0, "Exit");

        Map<Integer, IMenuAction> actions = new HashMap<>();
        actions.put(1, () -> {
            Printer.logSystem("::Doctor");
            User userLogged = UIAuth.showAuthMenu(UserType.DOCTOR);
            if (userLogged != null) {
                UIDoctorMenu.showDoctorMenu(userLogged);
                return true;
            } else {
                return false;
            }
        });

        actions.put(2, () -> {
            Printer.logSystem("::Patient");
            User userLogged = UIAuth.showAuthMenu(UserType.PATIENT);
            if (userLogged != null) {
                UIPatientMenu.showPatientMenu();
                return true;
            } else {
                return false;
            }
        });

        actions.put(0, () -> {
            Printer.logSystem("::Exit");
            return false;
        });

        MenuUtils.showMenu("Choose the desired option", options, actions);
    }
}

package com.d3vlin13.medicalappointmentadvisor;

import com.d3vlin13.medicalappointmentadvisor.util.Printer;
import com.d3vlin13.medicalappointmentadvisor.view.UIMenu;

public class Main {
    public static void main(String[] args) {
        Printer.loadingAnimation("Loading system", 1);
        Printer.logDebug("MedicalAppointmentAdvisor Ready!");
        UIMenu.showMenu();
        Printer.logDebug("System terminated. Thank you for using MedicalAppointmentAdvisor.");
    }
}
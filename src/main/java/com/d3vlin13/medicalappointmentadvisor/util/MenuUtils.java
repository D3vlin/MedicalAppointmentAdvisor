package com.d3vlin13.medicalappointmentadvisor.util;

import java.util.Map;

public class MenuUtils {
    public static void showMenu(String title, Map<Integer, String> options, Map<Integer, IMenuAction> actions) {
        int response;
        boolean continueMenu = true;

        while (continueMenu){
            Printer.logInfo("\n" + title + "\n");
            for (Map.Entry<Integer, String> option : options.entrySet()) {
                Printer.logInfo(option.getKey() + ". " + option.getValue());
            }

            Printer.logIndicatorSystem();
            response = Printer.ValidateIntegerInput();

            if (actions.containsKey(response)) {
                continueMenu = actions.get(response).execute();
            } else {
                Printer.logWarn("Please select a correct answer!");
            }
        }
    }
}

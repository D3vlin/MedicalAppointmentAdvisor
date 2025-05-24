package com.d3vlin13.medicalappointmentadvisor.util;

import java.io.PrintStream;

public class Printer {
    private static final PrintStream printer = System.out;

    private static final String RESET = "\u001B[0m";
    private static final String TRACE = "\u001B[30m";   // BLACK
    private static final String DEBUG = "\u001B[34m";   // BLUE
    private static final String INFO = "\u001B[32m";    // GREEN
    private static final String WARN = "\u001B[33m";    // YELLOW
    private static final String ERROR = "\u001B[31m";   // RED
    private static final String FATAL = "\u001B[35m";   // PURPLE
    private static final String SYSTEM = "\u001B[36m";  // CYAN
    private static final String DEFAULT = "\u001B[37m"; // WHITE

    public static void log(String message) {
        printer.println(message);
    }

    public static void logTrace(String message) {
        print(TRACE, message);
    }

    public static void logDebug(String message) {
        print(DEBUG, ( message + "\n"));
    }

    public static void logInfo(String message) {
        print(INFO, message);
    }

    public static void logWarn(String message) {
        print(WARN, message + "\n");
    }

    public static void logError(String message) {
        print(ERROR, message);
    }

    public static void logFatal(String message) {
        print(FATAL, message);
    }

    public static void logSystem(String message) {
        print(SYSTEM, message);
    }

    public static void logIndicatorSystem() {
        printer.print(SYSTEM + "> " + RESET);
    }

    public static void logDefault(String message) {
        print(DEFAULT, message);
    }

    private static void print(String levelColor, String message) {
        printer.println(levelColor + message + RESET);
    }

    public static void loadingAnimation(String message, int seconds) {
        printer.print(DEBUG + message + RESET);
        for (int i = 0; i < seconds * 3; i++) {
            try {
                Thread.sleep(333);
                printer.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        printer.println();
    }

    public static void progressBar(String task, int steps, int delayMillis) {
        printer.print(WARN + task + ": [" + RESET);
        for (int i = 0; i < steps; i++) {
            printer.print(WARN + "#" + RESET);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        printer.println(WARN + "] Done!" + RESET + "\n");
    }
}

package com.d3vlin13.medicalappointmentadvisor.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public abstract class Appointment {
    private static int idCounter = 0;
    private final int id;
    private final Date date;
    private final LocalTime time;

    public Appointment(String date, String time) throws ParseException, DateTimeParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM/dd/yyyy", Locale.ENGLISH);

        this.id = ++idCounter;
        this.date = dateFormat.parse(date);
        this.time = LocalTime.parse(time);
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}

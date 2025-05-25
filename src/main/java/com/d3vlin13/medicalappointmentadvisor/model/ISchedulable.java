package com.d3vlin13.medicalappointmentadvisor.model;

import java.util.Date;

public interface ISchedulable {
    void schedule(Date date, String time);
}

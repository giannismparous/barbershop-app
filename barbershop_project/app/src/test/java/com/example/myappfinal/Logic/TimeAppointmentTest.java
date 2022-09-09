package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TimeAppointmentTest {

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll() throws ParseException {
        TimeAppointment.addTimes();
    }

    /**
     * Ελέγχει την getTime
     */
    @Test
    public void getTime() {
        assertEquals(TimeAppointment.getTimeAppointment(3).getTime(),"9:00");
    }

    /**
     * Ελέγχει την getTimeAppointmentTime
     */
    @Test
    public void getTimeAppointmentTime() {
        assertEquals(TimeAppointment.getTimeAppointmentTime(3),"9:00");
    }

    /**
     * Ελέγχει την getCode
     */
    @Test
    public void getCode() {
        assertEquals(TimeAppointment.getCode("9:00"),3);
    }

    /**
     * Ελέγχει την getKey
     */
    @Test
    public void getKey() {
        Map<Integer , String> times = new HashMap<>();
        times.put(1,"8:00");
        times.put(2,"8:30");
        times.put(3,"9:00");
        times.put(4,"9:30");
        times.put(5,"10:00");
        times.put(6,"10:30");
        times.put(7,"11:00");
        times.put(8,"11:30");
        times.put(9,"12:00");
        times.put(10,"12:30");
        times.put(11,"13:00");
        times.put(12,"13:30");
        times.put(13,"14:00");
        times.put(14,"14:30");
        times.put(15,"15:00");
        times.put(16,"15:30");
        assertEquals(TimeAppointment.getKey(times,"15:30"),16);
        assertEquals(TimeAppointment.getKey(times,"XX"),-1);
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @After
    public void deleteAll(){
        TimeAppointment.deleteTimes();
    }
}
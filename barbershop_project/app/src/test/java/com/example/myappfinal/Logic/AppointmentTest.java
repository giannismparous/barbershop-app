package com.example.myappfinal.Logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.SearchView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentTest {

    Appointment appointment,appointment2;
    String today;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll() throws ParseException {
        DateAppointment.addDates();
        TimeAppointment.addTimes();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        today =formatter.format(date);
        Service.addServices();
        appointment=new Appointment(Service.getService(1),new TimeAppointment("8:00"),new DateAppointment(today),"Giannis","696969699");
        appointment2=new Appointment(Service.getService(1),new TimeAppointment("08:00"),new DateAppointment("19/03"));
    }

    /**
     * Ελέγχει την getAppointments
     */
    @Test
    public void getAppointments(){
        assertEquals(2,Appointment.getAppointments().size());
    }

    /**
     * Ελέγχει την isFree
     */
    @Test
    public void isFree(){
        assertFalse(Appointment.isFree(1,1));
        assertTrue(Appointment.isFree(2,1));
    }

    /**
     * Ελέγχει την getAppId
     */
    @Test
    public void getAppId() {
        assertEquals(appointment.getId(),1);
        assertEquals(appointment2.getId(),2);
    }

    /**
     * Ελέγχει την getName
     */
    @Test
    public void getName() {
        assertEquals(appointment.getName(),"Giannis");
    }

    /**
     * Ελέγχει την getPhone
     */
    @Test
    public void getPhone() {
        assertEquals(appointment.getPhone(),"696969699");
    }

    /**
     * Ελέγχει την getService
     */
    @Test
    public void getService() {
        assertEquals(appointment.getService().getName(),"Haircut");
        assertEquals(appointment2.getService().getName(),"Haircut");
    }

    /**
     * Ελέγχει την getDate
     */
    @Test
    public void getDate() {
        assertEquals(appointment.getDate(),today);
        assertEquals(appointment2.getDate(),"19/03");
    }

    /**
     * Ελέγχει την getStartTime
     */
    @Test
    public void getStartTime() {
        assertEquals(appointment.getStartTime(),"8:00");
        assertEquals(appointment2.getStartTime(),"08:00");
    }

    /**
     * Ελέγχει την getStateActive
     */
    @Test
    public void getStateActive() {
        assertEquals(appointment.getState(), "Active");
        assertEquals(appointment2.getState(),"Active");
    }

    /**
     * Ελέγχει την getStateCompleted
     */
    @Test
    public void getStateCompleted() {
        assertTrue(appointment.complete());
        assertFalse(appointment.complete());
        assertFalse(appointment.cancel());
        assertEquals(appointment.getState(), "Completed");
    }

    /**
     * Ελέγχει την getStateCanceled
     */
    @Test
    public void getStateCanceled() {
        assertTrue(appointment.cancel());
        assertFalse(appointment.cancel());
        assertFalse(appointment.complete());
        assertEquals(appointment.getState(), "Canceled");
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @After
    public void resetAll(){
        Appointment.resetCounterId();
    }

}
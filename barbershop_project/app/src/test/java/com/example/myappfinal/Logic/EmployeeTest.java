package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    Employee employee;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll(){
        employee=new Employee("G","P","J","B","E","PH");
        Employee.resetAppointments();
    }

    /**
     * Ελέγχει την createAnAppointment
     */
    @Test
    public void createAnAppointment() {
        assertEquals(0,employee.getHistory().size());
        employee.createAnAppointment(1,1,1,"G","PH");
        assertEquals(1,employee.getHistory().size());
    }

    /**
     * Ελέγχει την addAppointment
     */
    @Test
    public void addAppointment() {
        assertEquals(0,employee.getHistory().size());
        employee.addAppointment(new Appointment(new Service("K"),new TimeAppointment("T"),new DateAppointment("D")));
        assertEquals(1,employee.getHistory().size());
    }

    /**
     * Ελέγχει την isEmpty
     */
    @Test
    public void isEmpty() {
        assertTrue(employee.isEmpty());
        employee.addAppointment(new Appointment(new Service("K"),new TimeAppointment("T"),new DateAppointment("D")));
        assertFalse(employee.isEmpty());
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @After
    public void resetAll(){
        Employee.resetAppointments();
    }
}
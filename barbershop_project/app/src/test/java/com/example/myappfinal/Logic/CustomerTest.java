package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    Customer customer;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll(){
        customer=new Customer("G","P","J","B","E","PH",'M');
    }

    /**
     * Ελέγχει την getCustomers
     */
    @Test
    public void getCustomers(){
        assertEquals(1,Customer.getCustomers().size());
    }

    /**
     * Ελέγχει την createAnAppointment
     */
    @Test
    public void createAnAppointment() {
        assertEquals(0,customer.getHistory().size());
        customer.createAnAppointment(1,1,1);
        assertEquals(1,customer.getHistory().size());

    }

    /**
     * Ελέγχει την addAppointment
     */
    @Test
    public void addAppointment() {
        assertEquals(0,customer.getHistory().size());
        customer.addAppointment(new Appointment(new Service("K"),new TimeAppointment("T"),new DateAppointment("D")));
        assertEquals(1,customer.getHistory().size());
    }

    /**
     * Ελέγχει την isEmpty
     */
    @Test
    public void isEmpty() {
        assertTrue(customer.isEmpty());
        customer.addAppointment(new Appointment(new Service("K"),new TimeAppointment("T"),new DateAppointment("D")));
        assertFalse(customer.isEmpty());
    }

    /**
     * Ελέγχει την getGender
     */
    @Test
    public void getGender() {
        assertEquals(customer.getGender(),'M');
    }

    /**
     * Ελέγχει την getAppointment
     */
    @Test
    public void getAppointment() {
        Appointment app=new Appointment(new Service("K"),new TimeAppointment("T"),new DateAppointment("D"));
        customer.addAppointment(app);
        assertEquals(app,customer.getAppointment(0));
    }

    /**
     * Ελέγχει τις vote,hasVoted και getStars
     */
    @Test
    public void voting(){
        assertFalse(customer.hasVoted());
        customer.vote(4);
        assertTrue(customer.hasVoted());
        assertEquals(4,customer.getStars());

    }

    /**
     * Επαναφέρει τα πάντα
     */
    @AfterClass
    public static void resetAll(){
        Customer.clear();
        Employee.resetAppointments();
        Appointment.resetCounterId();
    }

}
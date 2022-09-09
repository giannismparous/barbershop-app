package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll() {
        Service.addServices();
    }

    /**
     * Ελέγχει την getId
     */
    @Test
    public void getId() {
        assertEquals(Service.getService(1).getId(),1);
    }

    /**
     * Ελέγχει την getName
     */
    @Test
    public void getName() {
        assertEquals(Service.getService(1).getName(),"Haircut");
    }

    /**
     * Ελέγχει την getServiceName
     */
    @Test
    public void getServiceName() {
        assertEquals(Service.getServiceName(1),"Haircut");
        assertNull(Service.getServiceName(0));
    }

    /**
     * Ελέγχει την getPrice
     */
    @Test
    public void getPrice(){
        assertEquals(10,Service.getPrice());
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @After
    public void resetAll(){
        Service.deleteServices();
    }
}
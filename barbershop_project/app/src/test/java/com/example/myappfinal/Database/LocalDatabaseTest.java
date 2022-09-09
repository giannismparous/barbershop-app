package com.example.myappfinal.Database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LocalDatabaseTest {

    LocalDatabase DB;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll(){
        DB=new LocalDatabase();
    }

    /**
     * Ελέγχει την getUsernames
     */
    @Test
    public void getUsernames() {
        assertEquals(0,DB.getUsernames().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getUsernames().size());
        assertEquals("A",DB.getUsernames().get(0));
    }

    /**
     * Ελέγχει την getPasswords
     */
    @Test
    public void getPasswords() {
        assertEquals(0,DB.getPasswords().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getPasswords().size());
        assertEquals("B",DB.getPasswords().get(0));
    }

    /**
     * Ελέγχει την getFns
     */
    @Test
    public void getFns() {
        assertEquals(0,DB.getFns().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getFns().size());
        assertEquals("C",DB.getFns().get(0));
    }

    /**
     * Ελέγχει την getLns
     */
    @Test
    public void getLns() {
        assertEquals(0,DB.getLns().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getLns().size());
        assertEquals("D",DB.getLns().get(0));
    }

    /**
     * Ελέγχει την getEmails
     */
    @Test
    public void getEmails() {
        assertEquals(0,DB.getEmails().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getEmails().size());
        assertEquals("E",DB.getEmails().get(0));
    }

    /**
     * Ελέγχει την getPhones
     */
    @Test
    public void getPhones() {
        assertEquals(0,DB.getPhones().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getPhones().size());
        assertEquals("F",DB.getPhones().get(0));
    }

    /**
     * Ελέγχει την checkusername
     */
    @Test
    public void checkusername() {
        assertFalse(DB.checkusername("A"));
        DB.insertData("A","B","C","D","E","F");
        assertTrue(DB.checkusername("A"));
    }

    /**
     * Ελέγχει την checkusernamePassword
     */
    @Test
    public void checkusernamePassword() {
        assertFalse(DB.checkUsernamePassword("A","B"));
        DB.insertData("A","B","C","D","E","F");
        assertTrue(DB.checkUsernamePassword("A","B"));
    }

    /**
     * Ελέγχει την insertData
     */
    @Test
    public void insertData() {
        assertEquals(0,DB.getUsernames().size());
        assertEquals(0,DB.getPasswords().size());
        assertEquals(0,DB.getFns().size());
        assertEquals(0,DB.getLns().size());
        assertEquals(0,DB.getPhones().size());
        assertEquals(0,DB.getEmails().size());
        DB.insertData("A","B","C","D","E","F");
        assertEquals(1,DB.getUsernames().size());
        assertEquals(1,DB.getPasswords().size());
        assertEquals(1,DB.getFns().size());
        assertEquals(1,DB.getLns().size());
        assertEquals(1,DB.getPhones().size());
        assertEquals(1,DB.getEmails().size());
    }

    /**
     * Ελέγχει την takeTests
     */
    @Test
    public void takeTests(){
        assertNull(DB.takeFirstName("A"));
        assertNull(DB.takeLastName("A"));
        assertNull(DB.takePhone("A"));
        assertNull(DB.takeEmail("A"));
        DB.insertData("A","B","C","D","E","F");
        assertEquals("C",DB.takeFirstName("A"));
        assertEquals("D",DB.takeLastName("A"));
        assertEquals("F",DB.takePhone("A"));
        assertEquals("E",DB.takeEmail("A"));
    }
}
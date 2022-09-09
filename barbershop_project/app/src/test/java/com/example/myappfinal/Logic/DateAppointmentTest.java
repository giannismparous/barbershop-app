package com.example.myappfinal.Logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateAppointmentTest {

    String today;
    Map<Integer , String> dates = new HashMap<>();

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @Before
    public void setAll() throws ParseException {
        DateAppointment.addDates();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        today =formatter.format(date);
    }

    /**
     * Ελέγχει την getDate
     */
    @Test
    public void getDate() {
        assertEquals(DateAppointment.getDateAppointment(1).getDate(),today);
    }

    /**
     * Ελέγχει την getDateAppointmentDate
     */
    @Test
    public void getDateAppointmentDate() {
        assertEquals(DateAppointment.getDateAppointmentDate(1),today);
    }

    /**
     * Ελέγχει την getCode
     */
    @Test
    public void getCode() {
        assertEquals(DateAppointment.getCode(today),1);
    }

    /**
     * Ελέγχει την getKey
     */
    @Test
    public void getKey() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        String keep_date =formatter.format(date);
        dates.put(1, keep_date);

        for(int i = 1 ; i < 7 ; i++ ) {
            keep_date=getNextDate(keep_date);
            dates.put(i+1, keep_date);
        }

        assertEquals(1,DateAppointment.getKey(dates,today));
        assertEquals(-1,DateAppointment.getKey(dates,"X"));
    }

    /**
     * Ελέγχει την getNextDate
     */
    public String getNextDate(String  curDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @After
    public void resetAll(){
        DateAppointment.deleteDates();
        dates.clear();
    }
}
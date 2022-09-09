package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAppointment implements Serializable {

    private String date;
    private static final int  numberOfDate=7;
    private static HashMap <Integer , DateAppointment> dates = new HashMap<>();
    private static HashMap <Integer , String> datesStrings = new HashMap<>();

    /**
     * Constructor του DateAppointment
     * @param date Η ημερομηνία του DateAppointment σε String
     */
    public DateAppointment(String date){
        this.date=date;
    }

    /**
     * Μέθοδος κλάσης που εισάγει όλες τις διαθέσιμες ημερομηνίες κλεισίματος ραντεβού.
     */
    public static void addDates() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        String keep_date =formatter.format(date);
        dates.put(1, new DateAppointment(keep_date));
        datesStrings.put(1, keep_date);

        for(int i = 1 ; i < numberOfDate ; i++ ) {
            keep_date=getNextDate(keep_date);
            datesStrings.put(i+1, keep_date);
            dates.put(i+1, new DateAppointment(keep_date));
        }

    }

    /**
     * Επιστρέφει την ημερομηνία του DateAppointment.
     * @return Ημερομηνία του DateAppointment
     */
    public String getDate(){
        return date;
    }

    /**
     * Επιστρέφει την ημερομηνία του DateAppointment με το συγκεκριμένο key.
     * @param key Το κλειδί του DateAppointment που θέλουμε
     * @return Ημερομηνία του DateAppointment με το συγκεκριμένο key
     */
    public static String getDateAppointmentDate(int key) {
        return datesStrings.get(key);
    }

    /**
     * Επιστρέφει το DateAppointment με το συγκεκριμένο key.
     * @param key Το κλειδί του DateAppointment που θέλουμε
     * @return Το DateAppointment με το συγκεκριμένο key
     */
    public static DateAppointment getDateAppointment(int key) {
        return dates.get(key);
    }

    /**
     * Επιστρέφει την επόμενη ημερομηνία από την σημερινή.
     * @param curDate Σημερινή ημερομηνία σε String
     * @return  Την αυριανή ημερομηνία σε String.
     */
    private static String getNextDate(String  curDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    /**
     * Επιστρέφει τον κωδικό μια συγκεκριμένης ημερομηνίας με βάση την
     * ημερομηνία που του δίνουμε.
     * @param  name  Η ημερομηνία που δίνουμε
     * @return      Ο κωδικός της ημερομηνίας
     */
    public static int getCode(String name){

        return getKey(datesStrings,name);

    }

    /**
     * Βοηθητική συνάρτηση για την getCode(String name)
     * @param  map  Το συγκεκριμένο HashMap
     * @param  value Το value του οποίου το key ψάχνουμε
     * @return -1 αν δεν υπάρχει, αλλίως το κλειδί
     */
    public static <Integer, String> int getKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String > entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return (int)entry.getKey();
            }
        }
        return -1 ;
    }

    /**
     * Καθαρίζει τις λίστες με τα DateAppointments.
     */
    public static void deleteDates(){
        dates.clear();
        datesStrings.clear();
    }

}

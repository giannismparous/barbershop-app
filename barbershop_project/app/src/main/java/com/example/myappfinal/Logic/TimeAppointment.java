package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TimeAppointment implements Serializable {

    private String time;
    public static HashMap<Integer , TimeAppointment> times = new HashMap<>();
    public static HashMap<Integer , String> timesStrings = new HashMap<>();

    /**
     * Constructor του TimeAppointment
     * @param time Η ώρα του TimeAppointment σε String
     */
    public TimeAppointment(String time){
        this.time=time;
    }

    /**
     * Εισάγει όλες τις διαθέσιμες ώρες κλεισίματος ραντεβού για
     * υπηρεσίες στον HashMap times με key τον κωδικό της ώρας και
     * value την ώρα σε String. Είναι static γιατί οι ώρες πρέπει
     * να ανήκουν στην κλάση και όχι σε κάθε αντικείμενο τύπου TimeAppointment
     * ξεχωριστά.
     */

    public static void addTimes() throws ParseException {

          times.put(1,new TimeAppointment("8:00"));
          times.put(2,new TimeAppointment("8:30"));
          times.put(3,new TimeAppointment("9:00"));
          times.put(4,new TimeAppointment("9:30"));
          times.put(5,new TimeAppointment("10:00"));
          times.put(6,new TimeAppointment("10:30"));
          times.put(7,new TimeAppointment("11:00"));
          times.put(8,new TimeAppointment("11:30"));
          times.put(9,new TimeAppointment("12:00"));
          times.put(10,new TimeAppointment("12:30"));
          times.put(11,new TimeAppointment("13:00"));
          times.put(12,new TimeAppointment("13:30"));
          times.put(13,new TimeAppointment("14:00"));
          times.put(14,new TimeAppointment("14:30"));
          times.put(15,new TimeAppointment("15:00"));
          times.put(16,new TimeAppointment("15:30"));
          timesStrings.put(1,"8:00");
          timesStrings.put(2,"8:30");
          timesStrings.put(3,"9:00");
          timesStrings.put(4,"9:30");
          timesStrings.put(5,"10:00");
          timesStrings.put(6,"10:30");
          timesStrings.put(7,"11:00");
          timesStrings.put(8,"11:30");
          timesStrings.put(9,"12:00");
          timesStrings.put(10,"12:30");
          timesStrings.put(11,"13:00");
          timesStrings.put(12,"13:30");
          timesStrings.put(13,"14:00");
          timesStrings.put(14,"14:30");
          timesStrings.put(15,"15:00");
          timesStrings.put(16,"15:30");

    }

    /**
     * Επιστρέφει την ώρα του TimeAppointment.
     * @return Η ώρα του TimeAppointment
     */
    public String getTime(){
        return time;
    }

    /**
     * Επιστρέφει το TimeAppointment με το συγκεκριμένο key.
     * @param key Το κλειδί του DateAppointment που θέλουμε
     * @return Το TimeAppointment με το συγκεκριμένο key
     */
    public static TimeAppointment getTimeAppointment(int key){
        return times.get(key);
    }

    /**
     * Επιστρέφει την ώρα του TimeAppointment με το συγκεκριμένο key.
     * @param key Το κλειδί του DateAppointment που θέλουμε
     * @return Την ώρα του TimeAppointment με το συγκεκριμένο key
     */

    public static String getTimeAppointmentTime(int key) {
        return timesStrings.get(key);
    }

    /**
     * Επιστρέφει τον κωδικό μια συγκεκριμένης ώρας με βάση την
     * ώρα που του δίνουμε.
     * @param  name  Η ώρα που δίνουμε
     * @return      Ο κωδικός της ώρας
     */

    public static int getCode(String name){

        return getKey(timesStrings,name);

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
     * Καθαρίζει τις λίστες με τα TimeAppointments.
     */
    public static void deleteTimes(){
        timesStrings.clear();
        times.clear();
    }

}

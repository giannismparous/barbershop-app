package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Customer extends User implements Serializable {

    private char gender;
    private static HashMap<String,Customer> customers=new HashMap<>();
    private ArrayList <Appointment> appointmentHistory;
    private boolean voted;
    private int stars;

    /**
     * Constructor του User.
     * @param  u  Username
     * @param  p  Password
     * @param f Όνομα
     * @param l Επώνυμο
     * @param e Email
     * @param ph Τηλέφωνο
     * @param g Γένος
     */
    public Customer(String u , String p , String f , String l, String e , String ph,char g) {

        super(u,p,f,l,e,ph);
        stars=-1;
        gender=g;
        voted=false;
        appointmentHistory=new ArrayList<Appointment>();
        customers.put(u,this);
    }

    /**
     * Δημιουργεί ραντεβού για τον χρήστη αναλόγως τα στοιχεία που δέχεται
     * και το προσθέτει και στη λίστα με τα ραντεβού του συγκρεκριμένου πελάτη.
     * @param  serviceId  Κωδικός της υπηρεσίας
     * @param  date  Κωδικός της ημερομηνίας
     * @param  startTime Κωδικός της ώρας
     */


    public void createAnAppointment(int serviceId, int date, int startTime) {
        Appointment ap = new Appointment(Service.getService(serviceId),  TimeAppointment.getTimeAppointment(startTime), DateAppointment.getDateAppointment(date));
        Customer.getCustomer(getUsername()).addAppointment(ap);
    }

    /**
     * Προσθέτει το ραντεβού που θέλουμε στη λίστα με τα
     * ραντεβού του συγκρεκριμένου πελάτη.
     * @param  appointment  Ραντεβού
     */
    public void addAppointment(Appointment appointment) {
        appointmentHistory.add(appointment);

    }
    /**
     * Επιστρέφει το ιστορικό των ραντεβού του
     * συγκρεκριμένου πελάτη ως ArrayList.
     * @return  Ιστορικό ραντεβού
     */
    public ArrayList<Appointment> getHistory(){
        return appointmentHistory;
    }

    /**
     * Επιστρέφει True αν τα appointments που
     * έχει κλείσει είναι 0, αλλιώς False.
     * @return  True αν δεν έκλεισε κανένα ραντεβού, αλλιώς False.
     */
    public boolean isEmpty(){
        return appointmentHistory.isEmpty();
    }
    /**
     * Επιστρέφει το γένος του.
     * @return  Χαρακτήρας γένους (M ή F).
     */
    public char getGender() {
        return gender;
    }

    /**
     * Επιστρέφει ραντεβού με βάση τον κωδικό του.
     * @param appointmentId Κωδικός του ραντεβού του πελάτη
     * @return  Το ραντεβού του πελάτη
     */
    public Appointment getAppointment(int appointmentId) {
        return appointmentHistory.get(appointmentId);
    }

    /**
     * Επιστρέφει τον πελάτη με το συγκεκριμένο username.
     * @param username To username του πελάτη
     * @return  Ο πελάτης με το συγκεκριμένο username
     */
    public static Customer getCustomer(String username){
        return customers.get(username);
    }

    /**
     * Πραγματοποιεί κριτική του πελάτη για το κατάστημα.
     * @param stars Τα αστέρια που επέλεξε ο πελάτης
     */
    public void vote(int stars){
        voted=true;
        this.stars=stars;
    }

    /**
     * Επιστρέφει true αν ο πελάτης έχει πραγματοποιήσει
     * κριτική, αλλιώς false.
     * @return true αν ο πελάτης έχει πραγματοποιήσει κριτική, αλλιώς false
     */
    public boolean hasVoted(){
        return voted;
    }

    /**
     * Επιστρέφει τα αστέρια της κριτικής του πελάτη.
     * @return Τα αστέρια της κριτικής του πελάτη.
     */
    public int getStars(){
        return stars;
    }

    /**
     * Επιστρέφει Collection με όλους τους customers που υπάρχουν στο σύστημα.
     * @return true αν ο πελάτης έχει πραγματοποιήσει κριτική, αλλιώς false
     */
    public static Collection<Customer> getCustomers(){
        return customers.values();
    }

    /**
     * Διαγράφει όλους τους customers απο τη λίστα με τους customers.
     */
    public static void clear(){
        customers.clear();
    }
}

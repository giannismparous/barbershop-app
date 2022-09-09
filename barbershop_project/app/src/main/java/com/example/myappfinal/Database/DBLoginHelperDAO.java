package com.example.myappfinal.Database;

public interface DBLoginHelperDAO {

    /**
     * Ελέγχει αν το username υπάρχει στη βάση.
     * @param username Το username που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    public Boolean checkusername(String username);

    /**
     * Καταχωρεί χρήστη με τα συγκεκριμένα στοιχεία στη βάση
     * @param username Το username του χρήστη
     * @param password Το password του χρήστη
     * @param fn Το όνομα του χρήστη
     * @param ln Το επώνυμο του χρήστη
     * @param email Το email του χρήστη
     * @param phone Το τηλέφωνο του χρήστη
     * @return True αν καταχωρήθηκαν με επιτυχία, αλλίως false
     */
    public Boolean insertData(String username , String password,String fn, String ln, String email,String phone);

    /**
     * Ελέγχει αν ο χρήστη με αυτό το
     * username και το password υπάρχει στη βάση.
     * @param user Το username του χρήστη που ψάχνουμε
     * @param user Το pass του χρήστη που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    public Boolean checkUsernamePassword(String user, String pass);

    /**
     * Επιστρέφει το όνομα του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το όνομα του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeFirstName(String user);

    /**
     * Επιστρέφει το επώνυμο του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το επώνυμο του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeLastName(String user);

    /**
     * Επιστρέφει το email του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το email του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeEmail(String user);

    /**
     * Επιστρέφει το τηλέφωνο του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το τηλέφωνο του χρήστη αν υπάρχει, αλλίως null
     */
    public String takePhone(String user);
}

package com.example.myappfinal.Database;

import java.util.ArrayList;

public class LocalDatabase implements DBLoginHelperDAO{

    private ArrayList<String>  usernames;
    private ArrayList<String>  passwords;
    private ArrayList<String>  fns;
    private ArrayList<String>  lns;
    private ArrayList<String>  emails;
    private ArrayList<String>  phones;

    /**
     * Επιστρέφει ArrayList με τα usernames
     * @return ArrayList με τα usernames
     */
    public ArrayList<String> getUsernames() {
        return usernames;
    }

    /**
     * Επιστρέφει ArrayList με τα passwords
     * @return ArrayList με τα passwords
     */
    public ArrayList<String> getPasswords() {
        return passwords;
    }

    /**
     * Επιστρέφει ArrayList με τα ονόματα
     * @return ArrayList με ονόματα
     */
    public ArrayList<String> getFns() {
        return fns;
    }

    /**
     * Επιστρέφει ArrayList με τα επώνυμα
     * @return ArrayList με τα επώνυμα
     */
    public ArrayList<String> getLns() {
        return lns;
    }

    /**
     * Επιστρέφει ArrayList με τα emails
     * @return ArrayList με τα emails
     */
    public ArrayList<String> getEmails() {
        return emails;
    }

    /**
     * Επιστρέφει ArrayList με τα τηλέφωνα
     * @return ArrayList με τα τηλέφωνα
     */
    public ArrayList<String> getPhones() {
        return phones;
    }

    /**
     * Constructor του LocalDatabase
     */
    public LocalDatabase(){
        usernames=new ArrayList<String>();
        passwords=new ArrayList<String>();
        fns=new ArrayList<String>();
        lns=new ArrayList<String>();
        emails=new ArrayList<String>();
        phones=new ArrayList<String>();
    }

    /**
     * Ελέγχει αν το username υπάρχει στη βάση.
     * @param username Το username που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    @Override
    public Boolean checkusername(String username) {
        return usernames.contains(username);
    }

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
    @Override
    public Boolean insertData(String username, String password, String fn, String ln, String email, String phone) {
        if (usernames.contains(username))return false;
        usernames.add(username);
        passwords.add(password);
        fns.add(fn);
        lns.add(ln);
        emails.add(email);
        phones.add(phone);
        return true;
    }

    /**
     * Ελέγχει αν ο χρήστη με αυτό το
     * username και το password υπάρχει στη βάση.
     * @param user Το username του χρήστη που ψάχνουμε
     * @param user Το pass του χρήστη που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    @Override
    public Boolean checkUsernamePassword(String user, String pass) {
        for (int i=0;i<usernames.size();i++){
            if (usernames.get(i).equals(user) && passwords.get(i).equals(pass))return true;
        }
        return false;
    }

    /**
     * Επιστρέφει το όνομα του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το όνομα του χρήστη αν υπάρχει, αλλίως null
     */
    @Override
    public String takeFirstName(String user) {
        for (int i=0;i<usernames.size();i++){
            if (usernames.get(i).equals(user))return fns.get(i);
        }
        return null;
    }

    /**
     * Επιστρέφει το επώνυμο του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το επώνυμο του χρήστη αν υπάρχει, αλλίως null
     */
    @Override
    public String takeLastName(String user) {
        for (int i=0;i<usernames.size();i++){
            if (usernames.get(i).equals(user))return lns.get(i);
        }
        return null;
    }

    /**
     * Επιστρέφει το email του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το email του χρήστη αν υπάρχει, αλλίως null
     */
    @Override
    public String takeEmail(String user) {
        for (int i=0;i<usernames.size();i++){
            if (usernames.get(i).equals(user))return emails.get(i);
        }
        return null;
    }

    /**
     * Επιστρέφει το τηλέφωνο του χρήστη με το συγκεκριμένο username.
     * @param user Το username του χρήστη
     * @return Το τηλέφωνο του χρήστη αν υπάρχει, αλλίως null
     */
    @Override
    public String takePhone(String user) {
        for (int i=0;i<usernames.size();i++){
            if (usernames.get(i).equals(user))return phones.get(i);
        }
        return null;
    }
}

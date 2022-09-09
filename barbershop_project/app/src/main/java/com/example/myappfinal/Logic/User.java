package com.example.myappfinal.Logic;

import java.io.Serializable;

public class User implements Serializable {

	private String Username;
	private String Password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	/**
	 * Constructor του User.
	 * @param  u  Username
	 * @param  p  Password
	 * @param f Όνομα
	 * @param l Επώνυμο
	 * @param e Email
	 * @param ph Τηλέφωνο
	 */

	public User (String u , String p , String f , String l, String e , String ph) {

		Username=u;
		Password=p;
		firstName=f;
		lastName=l;
		email=e;
		phoneNumber=ph;
		
	}


	/**
	 * Επιστρέφει το username.
	 * @return Το username
	 */

	public String getUsername() {
		return Username;
	}

	/**
	 * Επιστρέφει το password.
	 * @return Το password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * Επιστρέφει το First Name.
	 * @return Το firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Επιστρέφει το Last Name.
	 * @return Το lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Επιστρέφει το email.
	 * @return Το email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Επιστρέφει το phone number.
	 * @return Το phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Δημιουργεί ραντεβού για τον χρήστη με βάση την υπηρεσία, την μέρα
	 * και την ώρα που θέλουμε.
	 * @param service Κωδικός service που θέλουμε να κλείσουμε ραντεβού
	 * @param day Μέρα που θέλουμε να κλείσουμε ραντεβού
	 * @param time Ώρα που θέλουμε να κλείσουμε ραντεβού
	 */

	public void createAnAppointment(int service, int day, int time) {
	}

	/**
	 * Δημιουργεί ραντεβού για τον χρήστη με βάση την υπηρεσία, την μέρα,
	 * την ώρα, το όνομα και το τηλέφωνο που θέλουμε.
	 * @param service Κωδικός service που θέλουμε να κλείσουμε ραντεβού
	 * @param day Μέρα που θέλουμε να κλείσουμε ραντεβού
	 * @param time Ώρα που θέλουμε να κλείσουμε ραντεβού
	 */
	public void createAnAppointment(int service, int day, int time, String name, String phone) {
	}

}

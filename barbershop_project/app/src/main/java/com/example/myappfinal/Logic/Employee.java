package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User implements Serializable {

	private static ArrayList<Appointment> appointmentHistory = appointmentHistory=new ArrayList<Appointment>();


	/**
	 * Constructor του Employee.
	 * @param  u  Username
	 * @param  p  Password
	 * @param f Όνομα
	 * @param l Επώνυμο
	 * @param e Email
	 * @param ph Τηλέφωνο
	 */
	public Employee(String u , String p , String f , String l, String e , String ph) {
		
		super(u,p,f,l,e,ph);
		
	}

	/**
	 * Δημιουργεί ραντεβού για έναν χρήστη αναλόγως τα στοιχεία που δέχεται
	 * και το προσθέτει και στη λίστα με τα ραντεβού του.
	 * @param  serviceId  Κωδικός της υπηρεσίας
	 * @param  date  Κωδικός της ημερομηνίας
	 * @param  startTime Κωδικός της ώρας
	 * @param  name  Όνομα πελάτη
	 * @param  phone Τηλέφωνο πελάτη
	 */
	public void createAnAppointment(int serviceId, int date, int startTime,String name , String phone) {


		Appointment ap = new Appointment(Service.getService(serviceId),TimeAppointment.getTimeAppointment(startTime), DateAppointment.getDateAppointment(date), name, phone);
		addAppointment(ap);
	}

	/**
	 * Προσθέτει το ραντεβού που θέλουμε στη λίστα με τα
	 * ραντεβού του.
	 * @param  appointment  Ραντεβού
	 */
	public void addAppointment(Appointment appointment) {
		appointmentHistory.add(appointment);

	}

	/**
	 * Επιστρέφει το ιστορικό των ραντεβού του
	 * ως ArrayList.
	 * @return  Ιστορικό ραντεβού
	 */
	public static ArrayList<Appointment> getHistory(){
		return appointmentHistory;
	}

	/**
	 * Επιστρέφει True αν τα appointments που
	 * έχει κλείσει είναι 0, αλλιώς False.
	 * @return  True αν δεν έκλεισε κανένα ραντεβού, αλλιώς False.
	 */
	public static boolean isEmpty(){
		return appointmentHistory.isEmpty();
	}

	/**
	 * Διαγράφει όλα τα ραντεβού απ'τη λίστα με τα ραντεβού.
	 */
	public static void resetAppointments(){
		appointmentHistory.clear();
	}
}

package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Appointment implements Serializable {

	private static int increaseId=0;
	private static HashMap<Integer,Appointment> appointments=new HashMap<>();
	private int id;
	private  String name;
	private String phone;
	private Service service;
	public enum State {active, completed, canceled};
	private State state;
	private TimeAppointment timeAppointment;
	private DateAppointment dateAppointment;

	/**
	 * Constructor του Appointment.
	 * @param  service  Όνομα service
	 * @param  dateAppointment  Ημερομηνία
	 * @param timeAppointment Ώρα που ξεκινάει το ραντεβού
	 */
	public Appointment(Service service, TimeAppointment timeAppointment, DateAppointment dateAppointment) {
		increaseId++;
		id=increaseId;
		this.service=service;
		this.timeAppointment = timeAppointment;
		this.dateAppointment=dateAppointment;
		state= State.active;
		appointments.put(id,this);
	}
	/**
	 * Constructor του Appointment.
	 * @param  service  Όνομα service
	 * @param  dateAppointment  Ημερομηνία
	 * @param timeAppointment Ώρα που ξεκινάει το ραντεβού
	 * @param name Όνομα χρήστη
	 * @param phone Τηλέφωνο χρήστη
	 */
	public Appointment(Service service, TimeAppointment timeAppointment, DateAppointment dateAppointment,String name , String phone) {
		increaseId++;
		id=increaseId;
		this.name = name;
		this.phone = phone;
		this.service=service;
		this.timeAppointment = timeAppointment;
		this.dateAppointment=dateAppointment;
		state= State.active;
		appointments.put(id,this);
	}

	/**
	 * Επιστρέφει true αν η μέρα και η ώρα όπου έχει επιλέξει είναι ελεύθερη
	 * @return Την κατάσταση της ώρας εκείνης της μέρας οπου επέλεξε
	 */
	public static boolean isFree(int day, int time){
		for (Appointment app: appointments.values()){
			if (!app.state.equals(State.canceled) && app.getDate().equals(DateAppointment.getDateAppointmentDate(day)) && app.getStartTime().equals(TimeAppointment.getTimeAppointmentTime(time)))return false;
		}
		return true;
	}

	/**
	 * Επιστρέφει το id του ραντεβού.
	 * @return Το id του ραντεβού
	 */
	public int getId(){return id;}

	/**
	 * Επιστρέφει το όνομα του ραντεβού.
	 * @return Το όνομα του ραντεβού
	 */
	public String getName(){return name ;}

	/**
	 * Επιστρέφει το τηλέφωνο του ραντεβού.
	 * @return Το τηλέφωνο του ραντεβού
	 */
	public String getPhone(){return phone;}

	/**
	 * Επιστρέφει το όνομα της υπηρεσίας του ραντεβού.
	 * @return Την υπηρεσία του ραντεβού.
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Επιστρέφει την ημερομηνία του ραντεβού.
	 * @return Την ημερομηνία του ραντεβού.
	 */
	public String getDate() {
		return dateAppointment.getDate();
	}

	/**
	 * Επιστρέφει την ώρα που ξεκινάει του ραντεβού.
	 * @return Την ώρα που ξεκινάει το ραντεβού.
	 */
	public String getStartTime() {
		return timeAppointment.getTime();
	}

	/**
	 * Επιστρέφει την κατάσταση του ραντεβού (ενεργό, ολοκληρωμένο ή ακυρωμένο).
	 * @return Την κατάσταση του ραντεβού σε String.
	 */
	public String getState() {

		if(state== State.active)
			return "Active";
		else if(state==State.completed)
			return "Completed";
		else
			return "Canceled";
	}

	/**
	 * Ακυρώνει το ραντεβού αν είναι active
	 * και επιστρέφει true, διαφορετικά επιστρέφει false.
	 * @return Αν ακύρωσει το ραντεβού true, αλλιώς false.
	 */
	public boolean cancel() {

		if (state==State.active){
			state=State.canceled;
			return true;
		}
		return false;

	}

	/**
	 * Ολοκληρώνει το ραντεβού αν είναι active
	 * και επιστρέφει true, διαφορετικά επιστρέφει false.
	 * @return Αν ολοκληρώσει το ραντεβού true, αλλιώς false.
	 */
	public boolean complete() {

		if (state==State.active){
			state=State.completed;
			return true;
		}
		return false;
	}

	/**
	 * Κάνει reset το id counter της κλάσης και
	 * καθαρίζει την λίστα των ραντεβού.
	 */
	public static void resetCounterId(){
		increaseId=0;
		appointments.clear();
	}

	/**
	 * Επιστρέφει Collection με τα appointments
	 * που υπάρχουν.
	 * @return Collection με τα appointments που υπάρχουν
	 */
	public static Collection<Appointment> getAppointments(){
		return appointments.values();
	}
}

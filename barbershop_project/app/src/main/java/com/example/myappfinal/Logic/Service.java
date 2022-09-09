package com.example.myappfinal.Logic;

import java.io.Serializable;
import java.util.HashMap;

public class Service implements Serializable {

	private final String name;
	private int id;
	private static int increaseId=0;
	private static HashMap <Integer , Service > services = new HashMap<Integer,Service>();
	private static final int price=10;

	/**
	 * Constructor του Service
	 * @param name Όνομα του service
	 */
	public Service(String name){
		this.name=name;
		increaseId++;
		id=increaseId;
	}

	/**
	 * Εισάγει όλες τις διαθέσιμες υπηρεσίες στο σύστημα στο HashMap
	 * services που για κλείδι έχει τον κωδικό του Service και
	 * για value το όνομα του Service. Η συγκεκριμένη μέθοδος είναι static
	 * γιατί οι υπηρεσίες πρέπει να είσαγονται στο σύστημα στην κλάση
	 * Service και όχι για κάθε αντικείμενο τύπου Service.
	 */

	public static void addServices(){
		services.put(1,new Service("Haircut"));
		services.put(2 ,new Service("Shaving"));
		services.put(3,new Service("Hair Dye"));
		services.put(4,new Service("Hair Massage"));
	}

	/**
	 * Επιστρέφει το id του Service.
	 * @return Το id του Service.
	 */
	public int getId(){
		return id;
	}

	/**
	 * Επιστρέφει το όνομα του Service.
	 * @return Το όνομα του Service.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Επιστρέφει το Service με βάση το key που δίνεται
	 * ως παράμετρος.
	 * @param  key  Το id του Service που ζητάμε
	 * @return      Το όνομα της υπηρεσίας ως αντικείμενο τύπου String.
	 */

	public static Service getService(int key){
		return services.get(key);
	}

	/**
	 * Επιστρέφει το όνομα του Service με βάση το key που δίνεται
	 * ως παράμετρος.
	 * @param  key  Το id του Service που ζητάμε
	 * @return      Το όνομα της υπηρεσίας ως αντικείμενο τύπου String.
	 */
	public static String getServiceName(int key){
		if (services.get(key)!=null)return services.get(key).getName();
		return null;
	}

	/**
	 * Καθαρίζει την λίστα με τα Services και μηδενίζει
	 * το increaseId.
	 */
	public static void deleteServices(){
		services.clear();
		increaseId=0;
	}

	/**
	 * Επιστρέφει την τιμή τον Services.
	 * @return Η τιμή τον Services
	 */
	public static int getPrice(){
		return price;
	}

}

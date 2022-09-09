package com.example.myappfinal.Controller;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.Appointment;
import com.example.myappfinal.Logic.Customer;
import com.example.myappfinal.Logic.DateAppointment;
import com.example.myappfinal.Logic.Employee;
import com.example.myappfinal.Logic.Service;
import com.example.myappfinal.Logic.TimeAppointment;
import com.example.myappfinal.Logic.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConfirmAppointmentControllerTest {

    static ConfirmAppointmentController confirmAppointmentController;
    static String today;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll() throws ParseException {
        confirmAppointmentController=new ConfirmAppointmentController();
        DateAppointment.addDates();
        TimeAppointment.addTimes();
        Service.addServices();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        today =formatter.format(date);
    }

    /**
     * Ελέγχει την createAnAppointment
     */
    @Test
    public void createAnAppointment() {
        User user=new Customer("giannis","t","Giannis","Mparous","email@gmail.com","6969696969",'M');
        confirmAppointmentController.createAnAppointment(user,1,1,1);
        assertEquals(Customer.getCustomer(user.getUsername()).getAppointment(0).getStartTime(),"8:00");
        assertEquals(Customer.getCustomer(user.getUsername()).getAppointment(0).getService().getName(),"Haircut");
        assertEquals(Customer.getCustomer(user.getUsername()).getAppointment(0).getDate(),today);
    }

    /**
     * Ελέγχει την createAnAppointment
     */
    @Test
    public void CreateAnAppointment() {
        User user=new Employee("giannis2","t","Giannis","Mparous","email@gmail.com","6969696969");
        confirmAppointmentController.createAnAppointment(user,1,1,2,"Giannis","6969696969");
        System.out.print(Employee.getHistory().size());
        assertEquals(Employee.getHistory().get(0).getStartTime(),"8:30");
        assertEquals(Employee.getHistory().get(0).getService().getName(),"Haircut");
        assertEquals(Employee.getHistory().get(0).getDate(),today);
        assertEquals(Employee.getHistory().get(0).getName(),"Giannis");
        assertEquals(Employee.getHistory().get(0).getPhone(),"6969696969");
    }

    /**
     * Επαναφέρει τα πάντα
     */
    @AfterClass
    public static void resetAll(){
        Appointment.resetCounterId();
        Customer.clear();
        Employee.resetAppointments();
    }
}
package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConfirmAppointmentModelTest {

    static ConfirmAppointmentModel confirmAppointmentModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        confirmAppointmentModel=new ConfirmAppointmentModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        confirmAppointmentModel.setUser(user);
        assertEquals(user,confirmAppointmentModel.getUser());
    }

    /**
     * Ελέγχει τις setService και getService
     */
    @Test
    public void setAndGetService() {
        int service=1;
        confirmAppointmentModel.setService(service);
        assertEquals(service,confirmAppointmentModel.getService());
    }

    /**
     * Ελέγχει τις setDay και getDay
     */
    @Test
    public void setAndGetDay() {
        int day=3;
        confirmAppointmentModel.setDay(day);
        assertEquals(day,confirmAppointmentModel.getDay());
    }

    /**
     * Ελέγχει τις setTime και getTime
     */
    @Test
    public void setAndGetTime() {
        int time=5;
        confirmAppointmentModel.setTime(5);
        assertEquals(5,confirmAppointmentModel.getTime());
    }

    /**
     * Ελέγχει τις setName και getName
     */
    @Test
    public void setAndGetName() {
        String name="A";
        confirmAppointmentModel.setName(name);
        assertEquals(name,confirmAppointmentModel.getName());
    }

    /**
     * Ελέγχει τις setPhone και getPhone
     */
    @Test
    public void setAndGetPhone() {
        String phone="5";
        confirmAppointmentModel.setPhone(phone);
        assertEquals(phone,confirmAppointmentModel.getPhone());
    }

    /**
     * Ελέγχει την getConfirmAppointmentPresenter
     */
    @Test
    public void getConfirmAppointmentPresenter() {
        assertNotNull(confirmAppointmentModel.getConfirmAppointmentPresenter());
    }

}
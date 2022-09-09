package com.example.myappfinal.Model;

import static org.junit.Assert.*;

import com.example.myappfinal.Logic.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class EvaluateModelTest {

    static EvaluateModel evaluateModel;

    /**
     * Ρυθμίζει τις αρχικές πληροφορίες
     */
    @BeforeClass
    public static void setAll(){
        evaluateModel=new EvaluateModel();
    }

    /**
     * Ελέγχει τις setUser και getUser
     */
    @Test
    public void setAndGetUser() {
        User user=new User("giannis","t","Giannis","Mparous","email@gmail.com","6969696969");
        evaluateModel.setUser(user);
        assertEquals(user,evaluateModel.getUser());
    }

    /**
     * Ελέγχει τις setR1 και getR1
     */
    @Test
    public void setAndGetR1() {
        float f=3;
        evaluateModel.setR1(f);
        assertEquals(f,evaluateModel.getR1(),0);
    }

}
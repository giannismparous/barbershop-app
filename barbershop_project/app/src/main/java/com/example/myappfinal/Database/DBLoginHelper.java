package com.example.myappfinal.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBLoginHelper extends SQLiteOpenHelper implements DBLoginHelperDAO{


    private static final String  DBNAME = "LoginUser.db";

    /**
     * Constructor του DBLoginHelper
     * @param context Το context
     */
    public DBLoginHelper( Context context) {
        super(context,DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password Text,firstName TEXT, lastName TEXT, email TEXT, phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
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
    public Boolean insertData(String username , String password,String fn, String ln, String email,String phone){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("firstName",fn);
        contentValues.put("lastName",ln);
        contentValues.put("email",email);
        contentValues.put("phone",phone);

        long result = MyDB.insert("users",null , contentValues);

        if(result==-1) return false;
        else return true;

    }

    /**
     * Ελέγχει αν το username υπάρχει στη βάση.
     * @param username Το username που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select username from users where username=?", new String[]{username});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    /**
     * Ελέγχει αν ο χρήστη με αυτό το
     * username και το password υπάρχει στη βάση.
     * @param username Το username του χρήστη που ψάχνουμε
     * @param password Το pass του χρήστη που ψάχνουμε
     * @return True αν υπάρχει, αλλίως false
     */
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select username,password from users where username=? and password=?", new String[]{username,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    /**
     * Επιστρέφει το όνομα του χρήστη με το συγκεκριμένο username.
     * @param name Το username του χρήστη
     * @return Το όνομα του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeFirstName(String name){
        String value="";
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String selectQuery = "SELECT firstName from users where username = \"" + name + "\"";
        Cursor cursor = MyDB.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            value = cursor.getString(0);
        }
        return value;
    }

    /**
     * Επιστρέφει το επώνυμο του χρήστη με το συγκεκριμένο username.
     * @param name Το username του χρήστη
     * @return Το επώνυμο του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeLastName(String name){
        String value="";
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String selectQuery = "SELECT lastName from users where username = \"" + name + "\"";
        Cursor cursor = MyDB.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            value = cursor.getString(0);
        }
        return value;
    }

    /**
     * Επιστρέφει το email του χρήστη με το συγκεκριμένο username.
     * @param name Το username του χρήστη
     * @return Το email του χρήστη αν υπάρχει, αλλίως null
     */
    public String takeEmail(String name){
        String value="";
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String selectQuery = "SELECT email from users where username = \"" + name + "\"";
        Cursor cursor = MyDB.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            value = cursor.getString(0);
        }
        return value;
    }

    /**
     * Επιστρέφει το email του χρήστη με το συγκεκριμένο username.
     * @param name Το username του χρήστη
     * @return Το τηλέφωνο του χρήστη αν υπάρχει, αλλίως null
     */
    public String takePhone(String name){
        String value="";
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String selectQuery = "SELECT phone from users where username =\"" + name + "\"";
        Cursor cursor = MyDB.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            value = cursor.getString(0);
        }
        return value;
    }

}

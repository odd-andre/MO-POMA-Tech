/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oddandre
 */
public class Student extends User {

    Integer semester;
    //Set default values if none are provided otherwise
    public Student(){

    }
    public String getAdress(){return this.adress;}
    public String getEmail(){return this.email;}
    public Integer getId(){return this.id;}
    public String getFirstName(){return this.firstName;}
    public String getSurName(){return this.surName;}
    public Integer getZipCode(){return this.zip_code;}
    public String getBirthDate(){return this.datebirth;}
    
    public void getStudent(Integer id,PrintWriter out){
        SqlHandler sqlHdl = new SqlHandler(out);
        ResultSet rst = sqlHdl.getStudent(id);
        try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    this.adress = rst.getString("adress");
                    this.email = rst.getString("email");
                    this.semester   = rst.getInt("semester");
                    this.firstName = rst.getString("firstname");
                    this.surName = rst.getString("surname");
                    this.id = rst.getInt("user_Id");
                    this.datebirth = rst.getString("date_Of_Birth");
                    this.zip_code = rst.getInt("zip_code");
                    
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
    }
    public void buildStudentForList(String fName, String sName, String email, Integer id){
        firstName = fName;
        surName = sName;
        this.email = email;
        this.id = id;
    }
    public void createStudent(PrintWriter out, String adress, String email,String firstName, String surName, Integer semester, Integer zip, String datebirth){
        SqlHandler sqhndl = new SqlHandler(out);
        sqhndl.insertUser(adress, zip, email, this.generatePassword(adress, firstName), datebirth, firstName, surName);
    }
    public void save(PrintWriter out,Integer id,String adress, String email,String firstName, String surName, Integer semester, Integer zip, String datebirth ){
        SqlHandler sqlHdl = new SqlHandler(out);
        sqlHdl.updateStudent(id, adress, email, firstName, surName, zip, datebirth);
    }
    public String generatePassword(String address, String firstname){
        return adress+firstName;
    }
    public void updateStudent(PrintWriter out,Integer id,String adress, String email,String firstName, String surName, Integer zip, String datebirth){
        SqlHandler sqlHdl = new SqlHandler(out);
        sqlHdl.updateStudent(id, adress, email, firstName, surName, zip, datebirth);
    }
}

  

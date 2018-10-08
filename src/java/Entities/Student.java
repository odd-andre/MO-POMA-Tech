/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;
import java.io.PrintWriter;

/**
 *
 * @author oddandre
 */
public class Student extends User {

    Integer semester;
    
    public Student(String adress, String email,String firstName, String surName, Integer semester, Integer zip, String datebirth){
        this.adress = adress;
        this.email = email;
        this.firstName = firstName;
        this.surName = surName;
        this.semester = semester;
        this.zip_code = zip;
        this.datebirth = datebirth;
    }
    public String getAdress(){return this.adress;}
    public String getEmail(){return this.email;}
    public Integer getId(){return this.id;}
    public String getFirstName(){return this.firstName;}
    public String getSurName(){return this.surName;}
    
    public void save(PrintWriter out){
        SqlHandler sqhndl = new SqlHandler(out);
        sqhndl.insertUser(adress, zip_code, email, this.generatePassword(), datebirth, firstName, surName);
    }
    public String generatePassword(){
        return this.adress+this.firstName;
    }
}

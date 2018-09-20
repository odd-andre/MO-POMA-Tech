/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author oddandre
 */
public class Student extends User {

    Integer semester;
    
    public Student(String adress, String email,String firstName, String surName, Integer id, Integer semester){
        this.adress = adress;
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.semester = semester;
    }
    public String getAdress(){return this.adress;}
    public String getEmail(){return this.email;}
    public Integer getId(){return this.id;}
    public String getFirstName(){return this.firstName;}
    public String getSurName(){return this.surName;}
}

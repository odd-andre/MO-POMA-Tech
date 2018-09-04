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
public class Student {
    String adress;
    String email;
    Integer id;
    
    public Student(String adress, String email, Integer id){
        this.adress = adress;
        this.email = email;
        this.id = id;
    }
    public String getAdress(){return this.adress;}
    public String getEmail(){return this.email;}
}

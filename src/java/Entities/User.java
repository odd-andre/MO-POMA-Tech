/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author oddandre
 */
public class User {
    String firstName;
    String surName;
    Integer zip_code;
    String rights;
    String adress;
    String email;
    String datebirth;
    Integer id;
    
    public String getUserType(HttpServletRequest request){
        String accessType = "Student";
            if(request.isUserInRole("Teacher")) {
                accessType = "Teacher";
            }
            return accessType;
    }
    
}

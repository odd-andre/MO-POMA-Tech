/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;

/**
 *
 * @author ThunderCow
 */
public class Forum {
    
    Integer forum_Id;
    Integer creator_Id;
    String fName;
    
    
    public void getForum(){
        SqlHandler sqlhandl = new SqlHandler();
        sqlhandl.getForum();
    }
}
    
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
    //Constructor for thhe sake of having a constructor
    public Student(){

    }
    public void getStudent(Integer id,PrintWriter out){
        SqlHandler sqlHdl = new SqlHandler(out);
        ResultSet rst = sqlHdl.getStudent(id);
        try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    this.setadress(rst.getString("adress"));
                    this.setemail(rst.getString("email"));
                    this.semester = rst.getInt("semester");
                    this.setfirstName(rst.getString("firstname"));
                    this.setsurName(rst.getString("surname"));
                    this.setid(rst.getInt("user_Id"));
                    this.setdatebirth(rst.getString("date_Of_Birth"));
                    this.setzip_code(rst.getInt("zip_code"));
                    
                    ++rowCount;
                 }  // end while
                sqlHdl.commitAndclose();
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
    }
    public void buildStudentForList(String fName, String sName, String email, Integer id){
        this.setfirstName(fName);
        this.setsurName(sName);
        this.setemail(email);
        this.setid(id);
    }
    public void createStudent(PrintWriter out, String adress, String email,String firstName, String surName, Integer semester, Integer zip, String datebirth){
        SqlHandler sqhndl = new SqlHandler(out);
        sqhndl.insertUser(adress, zip, email, this.generatePassword(adress, firstName), datebirth, firstName, surName);
        sqhndl.commitAndclose();
    }
    public String generatePassword(String address, String firstname){
        return getadress()+getfirstName();
    }
    public void updateStudent(PrintWriter out,Integer id,String adress, String email,String firstName, String surName, Integer zip, String datebirth){
        SqlHandler sqlHdl = new SqlHandler(out);
        sqlHdl.updateStudent(id, adress, email, firstName, surName, zip, datebirth);
        sqlHdl.commitAndclose();
    }
}

  

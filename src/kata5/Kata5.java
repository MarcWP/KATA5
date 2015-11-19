/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
         System.out.println("HELLO");     
    //Class.forName("oracle.jdbc.driver.OracleDriver");
    //Connection conect = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
     Class.forName("org.sqlite.JDBC");
    Connection conect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Desktop\\DB\\PEOPLE");
    
    Statement state=conect.createStatement();
    String query="SELECT * FROM PEOPLE";
    ResultSet rs=state.executeQuery(query);
    System.out.println("query");
    while(rs.next()){
        System.out.println(rs.getInt("ID"));
        System.out.println(rs.getString("NAME"));
    }
    
    String name = "file";
    BufferedReader reader= new BufferedReader(new FileReader(new File(name)));
    String mail;
    
    while((mail= reader.readLine()) != null)   {
        
        query="INSERT INTO MAILS(Mail)VALUES('"+mail+"')";
        state.executeUpdate(query);
    rs.close();
    state.close();
    conect.close();
}

    }
}

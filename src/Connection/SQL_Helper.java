/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;

/**
 *
 * @author darshanypatel
 */
public class SQL_Helper {

    
    public static void main(String args[]) {
        try {
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//orca.csc.ncsu.edu:1521/orcl.csc.ncsu.edu", "cddashud", "Root!23");

            //step3 create the statement object  
            Statement stmt = con.createStatement();

            //step4 execute query 
            ResultSet rs = stmt.executeQuery("select * from department");
            while (rs.next()) {
                System.out.println(rs.getInt("DEPT_ID") + "  " + rs.getString("DEPT_NAME"));
            }

            //step5 close the connection object  
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpro;

import Connection.SQL_Helper;
import com.view.LoginPage;
import com.view.student.StudentHomePage;
import com.view.admin.AdminHomePage;
import com.view.admin.EnrollStudent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Yash
 */
public class DBPro {

    /**
     * @param args the command line arguments
     */
    private static JFrame login;
    private static JFrame stuPage;
    private static JFrame adminPage;
    public static void main(String[] args) throws SQLException {
        /*  try {
           SQL_Helper.connect();
          //   System.out.println(SQL_Helper.add_student(Long.parseLong(sid.getText()), fName.getText(), lName.getText(), dob.getText(), level.getText(), residency.getText(), Double.parseDouble(amount.getText()), dept.getText(), "test@test.com",999, "Drive west, Raleigh"));
        
         System.out.println(SQL_Helper.add_student(20030, "YASH", "vORA", "18-JUN-90", "Graduate", "International", 200000, "CSxx", "test@test.",1234567890, "Drive west, Raleigh"));
     
        
        } catch (SQLException ex) {
            Logger.getLogger(EnrollStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        System.out.println("Start Main");
        SQL_Helper.connect();
        LoginPage main = new LoginPage();
        login = new JFrame(); //ConfirmOrder.getFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login.add(main); // Add JPanel with components to JFrame
        login.setSize(550,500);
        login.setResizable(false);
        login.setVisible(true);  
        System.out.println("Main End");
    }
    
    
   public static void ShowStudentPage(){
       
        login.setVisible(false);
       StudentViewController.showStudentHomePage();
     }
   
   public static void ShowAdminHomePage(){       
       login.setVisible(false);
       AdminViewController.showAdminHomePage();
     }
   
  
   
   public static void ShowLoginPage(){
        LoginPage main = new LoginPage();
        login = new JFrame(); //ConfirmOrder.getFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login.add(main); // Add JPanel with components to JFrame
        login.setSize(550,500);
        login.setResizable(false);
        login.setVisible(true);  
   }
}

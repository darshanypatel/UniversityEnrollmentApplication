/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpro;

import com.view.LoginPage;
import com.view.admin.AdminHomePage;
import com.view.student.StudentHomePage;
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
    public static void main(String[] args) {
        LoginPage main = new LoginPage();
        login = new JFrame(); //ConfirmOrder.getFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.add(main); // Add JPanel with components to JFrame
        login.setSize(550,500);
        login.setResizable(false);
        login.setVisible(true);  
    }
    
    
   public static void ShowStudentPage(){
StudentHomePage home_page=new StudentHomePage();
       stuPage = new JFrame();
       stuPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stuPage.add(home_page); // Add JPanel with components to JFrame
        stuPage.setVisible(true); 
        stuPage.setSize(700,600);
        login.setVisible(false);
       stuPage.setVisible(true); 
     }
   
   public static void ShowAdminHomePage(){       
       login.setVisible(false);
       AdminViewController.showAdminHomePage();
     }
}

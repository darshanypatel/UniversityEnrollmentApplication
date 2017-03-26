/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpro;

import com.view.LoginPage;
import com.view.StudentPage;
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
    public static void main(String[] args) {
        LoginPage main = new LoginPage();
        login = new JFrame(); //ConfirmOrder.getFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.add(main); // Add JPanel with components to JFrame
        login.setSize(700,700);
        login.setResizable(false);
        login.setVisible(true);  
    }
    
    
   public static void ShowStudentPage(){
       StudentPage sp=new StudentPage();
       stuPage = new JFrame();
       stuPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stuPage.add(sp); // Add JPanel with components to JFrame
        stuPage.setSize(700,600);
        login.setVisible(false);
        stuPage.setVisible(true);
     }
}

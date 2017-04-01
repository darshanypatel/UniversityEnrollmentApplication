/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpro;

import com.view.student.*;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Jasleen
 */
public class StudentViewController {
   private static JFrame studentBillingPage;
   private static JFrame studentCoursePage;
   private static JFrame studentGradePage;
   private static JFrame studentHomePage;
   private static JFrame studentProfilePage;
   private static JFrame viewAvailableCourses;
   private static JFrame viewGrades;
   private static JFrame viewMyCourses;
   private static JFrame viewPendingCourses;
   private static JFrame dropCourse;
   
    public static void showStudentBillingPage(){
       StudentBillingPage ac=new StudentBillingPage();
       studentBillingPage = new JFrame();
       studentBillingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       studentBillingPage.add(ac); // Add JPanel with components to JFrame
       studentBillingPage.setSize(700,800);
       studentHomePage.setVisible(false);
       studentBillingPage.setVisible(true);
    }
    
    public static void showStudentGradePage(){
       StudentGradePage home_page=new StudentGradePage();
       studentGradePage = new JFrame();
       studentGradePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentGradePage.add(home_page); // Add JPanel with components to JFrame
        studentGradePage.setVisible(true); 
        studentGradePage.setSize(700,600);
        studentHomePage.setVisible(false);
       studentGradePage.setVisible(true);
    }
    
    public static void showStudentCoursePage(){
       StudentCoursePage home_page=new StudentCoursePage();
       studentCoursePage = new JFrame();
       studentCoursePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentCoursePage.add(home_page); // Add JPanel with components to JFrame
        studentCoursePage.setVisible(true); 
        studentCoursePage.setSize(700,600);
        studentHomePage.setVisible(false);
       studentCoursePage.setVisible(true);
    }
    
    public static void showStudentProfilePage(){
       StudentProfilePage home_page=new StudentProfilePage();
       studentProfilePage = new JFrame();
       studentProfilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentProfilePage.add(home_page); // Add JPanel with components to JFrame
        studentProfilePage.setVisible(true); 
        studentProfilePage.setSize(700,600);
        studentHomePage.setVisible(false);
       studentProfilePage.setVisible(true); 
    }
    
    public static void showStudentHomePage(){
     StudentHomePage home_page=new StudentHomePage();
       studentHomePage = new JFrame();
       studentHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentHomePage.add(home_page); // Add JPanel with components to JFrame
        studentHomePage.setVisible(true); 
        studentHomePage.setSize(700,600);
       studentHomePage.setVisible(true); 
    }
    
    public static void showViewAvailableCourses(){
       ViewAvailableCourses home_page=new ViewAvailableCourses();
       viewAvailableCourses = new JFrame();
       viewAvailableCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAvailableCourses.add(home_page); // Add JPanel with components to JFrame
        viewAvailableCourses.setVisible(true); 
        viewAvailableCourses.setSize(700,600);
        studentCoursePage.setVisible(false);
       viewAvailableCourses.setVisible(true); 
    }
    
    public static void showViewMyCourse(){
     ViewMyCourse home_page=new ViewMyCourse();
       viewMyCourses = new JFrame();
       viewMyCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewMyCourses.add(home_page); // Add JPanel with components to JFrame
        viewMyCourses.setVisible(true); 
        viewMyCourses.setSize(700,600);
       viewMyCourses.setVisible(true); 
    }
    
    public static void showViewGrades(){
      ViewGrades home_page=new ViewGrades();
       viewGrades = new JFrame();
       viewGrades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGrades.add(home_page); // Add JPanel with components to JFrame
        viewGrades.setVisible(true); 
        viewGrades.setSize(700,600);
       viewGrades.setVisible(true); 
    }
    
    public static void showViewPendingCourses(){
      ViewPendingCourses home_page=new ViewPendingCourses();
       viewPendingCourses = new JFrame();
       viewPendingCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPendingCourses.add(home_page); // Add JPanel with components to JFrame
        viewPendingCourses.setVisible(true); 
        viewPendingCourses.setSize(700,600);
       viewPendingCourses.setVisible(true); 
    }
    
     public static void showDropCourse(){
      DropCourse home_page=new DropCourse();
       dropCourse = new JFrame();
       dropCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dropCourse.add(home_page); // Add JPanel with components to JFrame
        dropCourse.setVisible(true); 
        dropCourse.setSize(700,600);
       dropCourse.setVisible(true); 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbpro;

import com.view.admin.*;
import javax.swing.JFrame;
/**
 *
 * @author Yash
 */
public class AdminViewController {
  /*  
   private static AddCourse addCourses;
   private static AddCourseOffering addCourseOffering;
   private static AddDropDeadline addDropDeadline;
   private static AdminHomePage adminHomePage;
   private static AdminProfile adminProfile;
   private static EnrollStudent enrollStudent;
   private static SpecialEnrollment specialEnrollment;
   private static ViewAddCourse viewAddCourse;
   private static ViewAddCourseOffering viewAddCourseOffering;
   private static ViewCourse viewCourse;
   private static ViewCourseOffering viewCourseOffering;
   private static ViewStudentDetails viewStudentDetails;
   */
   private static JFrame addCourses;
   private static JFrame addCourseOffering;
   private static JFrame addDropDeadline;
   private static JFrame adminHomePage;
   private static JFrame adminProfile;
   private static JFrame enrollStudent;
   private static JFrame specialEnrollment;
   private static JFrame viewAddCourse;
   private static JFrame viewAddCourseOffering;
   private static JFrame viewCourse;
   private static JFrame viewCourseOffering;
   private static JFrame viewStudentDetails;
   
   
   public static void showAddCourse(){
       AddCourse ac=new AddCourse();
       addCourses = new JFrame();
       addCourses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addCourses.add(ac); // Add JPanel with components to JFrame
       addCourses.setSize(700,800);
       adminHomePage.setVisible(false);
       addCourses.setVisible(true);
    }
   
    public static void showAddCourseOffering(){
       AddCourseOffering ac=new AddCourseOffering();
       addCourseOffering = new JFrame();
       addCourseOffering.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addCourseOffering.add(ac); // Add JPanel with components to JFrame
       addCourseOffering.setSize(700,700);
       adminHomePage.setVisible(false);
       addCourseOffering.setVisible(true);
    }
          
    public static void showAddDropDeadline(){
       AddDropDeadline add=new AddDropDeadline();
       addDropDeadline = new JFrame();
       addDropDeadline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       addDropDeadline.add(add); // Add JPanel with components to JFrame
       addDropDeadline.setSize(600,300);
       adminHomePage.setVisible(false);
       addDropDeadline.setVisible(true);
    }    
    
    public static void showAdminHomePage(){
       AdminHomePage ahp=new AdminHomePage();
       adminHomePage = new JFrame();
       adminHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       adminHomePage.add(ahp); // Add JPanel with components to JFrame
       adminHomePage.setSize(1100,600);  
       adminHomePage.setVisible(true);
    } 
    
     public static void showAdminProfile(){
       AdminProfile ap=new AdminProfile();
       adminProfile = new JFrame();
       adminProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       adminProfile.add(ap); // Add JPanel with components to JFrame
       adminProfile.setSize(400,500);
       adminHomePage.setVisible(false);
       adminProfile.setVisible(true);
    }  
     
     public static void showEnrollStudent(){
       EnrollStudent es=new EnrollStudent();
       enrollStudent = new JFrame();
       enrollStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       enrollStudent.add(es); // Add JPanel with components to JFrame
       enrollStudent.setSize(700,700);
       adminHomePage.setVisible(false);
       enrollStudent.setVisible(true);
    }  
     
      public static void showSpecialEnrollment(){
       SpecialEnrollment se=new SpecialEnrollment();
       specialEnrollment = new JFrame();
       specialEnrollment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       specialEnrollment.add(se); // Add JPanel with components to JFrame
       specialEnrollment.setSize(600,400);
       adminHomePage.setVisible(false);
       specialEnrollment.setVisible(true);
    } 
      
      public static void showViewAddCourse(){
       ViewAddCourse vac=new ViewAddCourse();
       viewAddCourse = new JFrame();
       viewAddCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       viewAddCourse.add(vac); // Add JPanel with components to JFrame
       viewAddCourse.setSize(500,300);
       adminHomePage.setVisible(false);
       viewAddCourse.setVisible(true);
    } 
      
      public static void showViewAddCourseOffering(){
       ViewAddCourseOffering vaco=new ViewAddCourseOffering();
       viewAddCourseOffering = new JFrame();
       viewAddCourseOffering.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       viewAddCourseOffering.add(vaco); // Add JPanel with components to JFrame
       viewAddCourseOffering.setSize(700,400);
       adminHomePage.setVisible(false);
       viewAddCourseOffering.setVisible(true);
    } 
    
      public static void showViewCourse(){
       ViewCourse vc=new ViewCourse();
       viewCourse = new JFrame();
       viewCourse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       viewCourse.add(vc); // Add JPanel with components to JFrame
       viewCourse.setSize(700,700);
       adminHomePage.setVisible(false);
       viewCourse.setVisible(true);
    }
      
      public static void showViewCourseOffering(){
       ViewCourseOffering vco=new ViewCourseOffering();
       viewCourseOffering = new JFrame();
       viewCourseOffering.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       viewCourseOffering.add(vco); // Add JPanel with components to JFrame
       viewCourseOffering.setSize(700,600);
       adminHomePage.setVisible(false);
       viewCourseOffering.setVisible(true);
    }
      
      public static void showViewStudentDetails(){
       ViewStudentDetails vsd=new ViewStudentDetails();
       viewStudentDetails = new JFrame();
       viewStudentDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       viewStudentDetails.add(vsd); // Add JPanel with components to JFrame
       viewStudentDetails.setSize(1100,750);
       adminHomePage.setVisible(false);
       viewStudentDetails.setVisible(true);
    }
      
      public static void closeAddCourse(){
          addCourses.setVisible(false);
      } 
      
      public static void closeAddCourseOffering(){
          addCourseOffering.setVisible(false);
      } 
      
      public static void closeAddDropDeadline(){
          addDropDeadline.setVisible(false);
      } 
      
      public static void closeAdminProfile(){
          adminProfile.setVisible(false);
      } 
      
       public static void closeEnrollStudent(){
          enrollStudent.setVisible(false);
      } 
       
       public static void closeSpecialEnrollment(){
          specialEnrollment.setVisible(false);
      } 
       
       public static void closeViewAddCourse(){
          viewAddCourse.setVisible(false);
      } 
       
       public static void closeViewAddCourseOffering(){
          viewAddCourseOffering.setVisible(false);
      } 
       
       public static void closeViewCourse(){
          viewCourse.setVisible(false);
      } 
       
       public static void closeViewCourseOffering(){
          viewCourseOffering.setVisible(false);
      } 
       
       public static void closeViewStudentDetails(){
          viewStudentDetails.setVisible(false);
      } 
}

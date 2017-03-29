/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import com.view.LoginPage;
import java.sql.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;

/**
 *
 * @author darshanypatel
 */
public class SQL_Helper {
    
    public static Statement stmt;
    public static Connection con;
    private static JFrame login;
    public static void get_connection() {
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //step2 create  the connection object
            con = DriverManager.getConnection(
                                              "jdbc:oracle:thin:@//orca.csc.ncsu.edu:1521/orcl.csc.ncsu.edu", "cddashud", "Root!23");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public static Statement get_statement_object() {
        Statement stmt = null;
        try {
            //step3 create the statement object
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stmt;
    }
    
    public static int close_connection() {
        try {
            //step5 close the connection object
            con.close();
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public static void main(String args[]) throws SQLException{
        connect();
        LoginPage main = new LoginPage();
        login = new JFrame(); //ConfirmOrder.getFrame();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setDefaultCloseOperation(SQL_Helper.close_connection());
        login.add(main); // Add JPanel with components to JFrame
        login.setSize(550,500);
        login.setResizable(false);
        login.setVisible(true);  
        System.out.println("Main End");
        
    }
    
    public static void connect() throws SQLException {
        get_connection();
        stmt = get_statement_object();
       
      
    }
    
    public static void disconnect() throws SQLException{
         close_connection();
    }
    
    public static boolean check_login_credentials(long id, String password,
                                                  int student_or_admin) throws SQLException {
        String table_name = student_or_admin == 1 ? "admin" : "student";
        ResultSet rs = stmt.executeQuery("select " + "password from " +
                                         table_name + " where " + table_name + "_id = " + id);
        if (rs.next()) {
            String password_digest1 = rs.getString("password");
            String password_digest2 = digest(password);
            return password_digest1.equals(password_digest2);
        } else {
            return false;
        }
    }
    
    public static String digest(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            System.out.println("original:" + password);
            System.out.println("digested(hex):" + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static ArrayList<String> get_admin_profile(long admin_id)
    throws SQLException {
        
        ResultSet rs = stmt.executeQuery("select fname, lname, dob, admin_id "
                                         + "from admin where admin_id = " + admin_id);
        
        rs.next();
        ArrayList<String> result = new ArrayList();
        result.add(rs.getString("fname"));
        result.add(rs.getString("lname"));
        result.add(rs.getDate("dob") + "");
        result.add(rs.getLong("admin_id") + "");
        
        return result;
    }
    
    // TODO add record in belongs table
    public static boolean add_student(long student_id, String fname,
                                      String lname, String dob, String CL, String RL, double bill,
                                      String dept_name, String email_id, long phone, String address)
    throws SQLException {
        
        ResultSet rs;
        int dept_id = 0, classification_id = 0, residency_id = 0;
        try {
            System.out.println("Starting......"+dept_id+"     "+dept_name);
            rs = stmt.executeQuery("select dept_id from department where dept_name = '" + dept_name+"'");
            if (rs.next()) 
                dept_id = rs.getInt("dept_id");            
    
            System.out.println("Connection.SQL_Helper.add_student():   "+dept_id+"     "+dept_name);
            rs = stmt.executeQuery("select rl_id from residency_level "
                                   + "where rl = '" + RL+"'");
            if (rs.next())
                residency_id = rs.getInt("rl_id");
            
            rs = stmt.executeQuery("select cl_id from classification_level "
                                   + "where cl = '" + CL+"'");
            if (rs.next())
                classification_id = rs.getInt("cl_id");
            
            stmt.executeQuery("insert into students (student_id, dept_id, "
                              + "fname, lname, dob, cl_id, rl_id, bill, gpa, password, "
                              + "email, phone, address) values (" + student_id + "," +
                              dept_id + ",'" + fname + "','" + lname + "','" + dob + "',"
                              + classification_id + "," + residency_id + "," + bill +
                              ", 0.0,'" + digest(student_id+"") + "','" + email_id + "'," + phone + ",'"
                              + address + "')");
            
        } catch (SQLException e) {
            System.out.println("Can't add student...student_id exists!    "+e.toString());
            
        }
        
        return true;
    }
    
    public static ArrayList<String> get_student_profile(long student_id) {
        
        int rl_id, cl_id;
        String residency = "", classification = "";
        try {
            ResultSet rs = stmt.executeQuery("select fname, lname, dob, cl_id, "
                                             + "rl_id, bill, gpa, phone, email, address from students "
                                             + "where student_id = " + student_id);
            rs.next();
            
            ArrayList<String> result = new ArrayList();
            result.add(rs.getString("fname"));
            result.add(rs.getString("lname"));
            result.add(rs.getDate("dob") + "");
            
            rl_id = rs.getInt("rl_id");
            cl_id = rs.getInt("cl_id");
            
            rs = stmt.executeQuery("select rl from residency_level "
                                   + "where rl_id = " + rl_id);
            if (rs.next())
                residency = rs.getString("rl");
            
            rs = stmt.executeQuery("select cl from classification_level "
                                   + "where cl_id = " + cl_id);
            if (rs.next())
                classification = rs.getString("cl");
            
            result.add(classification);
            result.add(residency);
            result.add(rs.getDouble("bill") + "");
            result.add(rs.getDouble("gpa") + "");
            result.add(rs.getLong("phone") + "");
            result.add(rs.getString("email"));
            result.add(rs.getString("address"));
            
            return result;
            
        } catch(SQLException e) {
            return new ArrayList();
        }
        
    }
    
    public static void update_student_grade(long student_id, double gpa)
    throws SQLException {
        stmt.executeQuery("update students set gpa = " + gpa + " where "
                          + "student_id = " + student_id);
    }
    
    public static boolean add_course(int course_id, String name, String
                                     dept_name, String level, double gpa_req, ArrayList<String>
                                     prereq_courses, ArrayList<Double> prereq_grades,
                                     String special_perm, int min_credits, int max_credits) {
        
        int classification = 0;
        int next_prereq_id, dept_id = 0;
        try {
            ResultSet rs = stmt.executeQuery("select cl_id from "
                                             + "classification_level " + "where cl = " + level);
            if (rs.next())
                classification = rs.getInt("cl_id");
            
            rs = stmt.executeQuery("select dept_id from "
                                   + "department " + "where dept_name = " + dept_name);
            if (rs.next())
                dept_id = rs.getInt("dept_id");
            
            // getting the highest prereq_id
            rs = stmt.executeQuery("select prereq_id from course_prereq where "
                                   + "rownum <= 1 order by prereq_id desc");
            if (rs.next()) {
                next_prereq_id = rs.getInt("prereq_id") + 1;
            } else {
                next_prereq_id = 1;
            }
            
            // change prereq_courses to course_id first
            for (int i = 0; i < prereq_courses.size(); i++) {
                stmt.executeQuery("insert into prereq_courses (prereq_id, "
                                  + "prereq_course_id, grade) values (" + next_prereq_id
                                  + "," + prereq_courses.get(i) + "," +
                                  prereq_grades.get(i) + ")");
            }
            
            stmt.executeQuery("insert into course_prereq (prereq_id, course_id,"
                              + " min_gpa, special_permission) values (" + next_prereq_id
                              + "," + course_id + "," + gpa_req + "," + special_perm
                              + ")");
            
            stmt.executeQuery("insert into course (course_id, title, dept_id, "
                              + "min_credits, max_credits, cl_id) values (" + course_id
                              + "," + name + "," + dept_id + "," + min_credits + ","
                              + max_credits + "," + classification + ")");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static ArrayList<String> get_course_details(int course_id)
    throws SQLException {
        String classification = "", dept_name = "", special_permission = "";
        ArrayList<String> result = new ArrayList();
        double min_gpa = 0.0;
        int prereq_id = 0, prereq_course_id;
        
        // find courses with "course_id"
        ResultSet rs = stmt.executeQuery("select * from course where course_id"
                                         + " = " + course_id);
        
        // find course_prereq from "course_id"
        ResultSet course_prereq_rs = stmt.executeQuery("select * from "
                                                       + "course_prereq where course_id = " + course_id);
        
        if (course_prereq_rs.next()) {
            min_gpa = course_prereq_rs.getDouble("min_gpa");
            special_permission = course_prereq_rs.getString("special_permission");
            prereq_id = course_prereq_rs.getInt("prereq_id");
        }
        
        int cl_id = rs.getInt("cl_id");
        int dept_id = rs.getInt("dept_id");
        int min_credits = rs.getInt("min_credits");
        int max_credits = rs.getInt("max_credits");
        
        // find classification name from "cl_id"
        ResultSet rs_temp = stmt.executeQuery("select cl from classification_level "
                                              + "where cl_id = " + cl_id);
        if (rs_temp.next())
            classification = rs_temp.getString("cl");
        
        // find department name from "dept_id"
        rs_temp = stmt.executeQuery("select dept_name from department "
                                    + "where dept_id = " + dept_id);
        if (rs_temp.next())
            dept_name = rs_temp.getString("dept_name");
        
        result.add(rs.getString("title"));
        result.add(dept_name);
        result.add(classification);
        result.add(min_gpa + "");
        
        // find prereq_courses from "prereq_id"
        ResultSet prereq_courses_rs = stmt.executeQuery("select * from "
                                                        + "prereq_courses where prereq_id = " + prereq_id);
        
        while (prereq_courses_rs.next()) {
            prereq_course_id = prereq_courses_rs.getInt("prereq_course_id");
            ResultSet prereq_course_name_rs = stmt.executeQuery("select title "
                                                                + "from course where course_id = " + prereq_course_id);
            prereq_course_name_rs.next();
            
            result.add(prereq_course_name_rs.getString("title"));
            result.add(prereq_courses_rs.getDouble("grade") + "");
        }
        
        result.add(special_permission);
        result.add(min_credits + "");
        result.add(max_credits + "");
        
        return result;
    }
    
    
    // implement methods after this point
    
    
    public static boolean add_course_offering() {
        
        try {
            stmt.executeQuery("insert into course_offering () values ()");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static ArrayList<String> get_course_offering_details(long
                                                                course_offering_id) throws SQLException {
        ArrayList<String> result = new ArrayList();
        
        
        return result;
    }
    
    public static ArrayList<ArrayList<String>> view_enrollment_requests() 
    throws SQLException {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        return result;
    }
    
    public static boolean approve_enrollment_request() {
        try {
            stmt.executeQuery("");
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    // enforce add/drop deadline
    // view student profile
    // edit student profile
    // view courses
    // enroll for a course
    // drop course
    // view pendint/rejected/waitlisted courses
    // view grades
    // view bill
    // pay bill
    
}
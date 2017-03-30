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
    
    public static Statement stmt, stmt2;
    public static Connection con, con2;
    private static long current_admin_id, current_student_id;
    private static JFrame login;
    public static void get_connection() {
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //step2 create  the connection object
            con = DriverManager.getConnection(
                                              "jdbc:oracle:thin:@//orca.csc.ncsu.edu:1521/orcl.csc.ncsu.edu", "cddashud", "Root!23");
            con2 = DriverManager.getConnection(
                                              "jdbc:oracle:thin:@//orca.csc.ncsu.edu:1521/orcl.csc.ncsu.edu", "cddashud", "Root!23");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void get_statement_object() {
        try {
            //step3 create the statement object
            stmt = con.createStatement();
            stmt2 = con2.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static int close_connection() {
        try {
            //step5 close the connection object
            con.close();
            con2.close();
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public static void main(String args[]) throws SQLException{
        connect();
//        LoginPage main = new LoginPage();
//        login = new JFrame(); //ConfirmOrder.getFrame();
//        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        login.setDefaultCloseOperation(SQL_Helper.close_connection());
//        login.add(main); // Add JPanel with components to JFrame
//        login.setSize(550,500);
//        login.setResizable(false);
//        login.setVisible(true);  
//        System.out.println("Main End");
        
//        if (check_login_credentials("xyz1", "cdrinku", 2)) {
//            System.out.println("welcome!" + current_student_id);
//        }

//        ArrayList<String> list = get_faculty_list();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        
//        if (add_faculty("Xiohui", "Gu", "CS"))
//            System.out.println("Successfully added faculty.");

//        ArrayList<String> courses = new ArrayList();
//        ArrayList<Double> grades = new ArrayList();
//        courses.add("CSC501");
//        grades.add(3.00);
//
//        if (add_course("CSC505", "ALGO", "CS", "Graduate", 3.0, courses, grades, "", 3, 3))
//            System.out.println("Course added successfully.");

//        ArrayList<String> result = get_course_details("CSC505");
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(result.get(i) + " ");
//        }

//        ArrayList<String> list = get_admin_profile(1111l);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        
//        if (add_student(200157725L, "chandu", "dash", "01-JAN-93", "Graduate", "International", 0, "CS", "cdashudu@ncsu.edu", 5108906594L, "2309 Champion Court"))
//            System.out.println("student added successfully.");
    
//        current_student_id = 200157725L;
//        if (edit_student_profile("Chandu", "Dash", "01-JAN-93", "Undergraduate", "International", "ECE", "cdashudu@ncsu.edu", 5108906594L, "2309 Champion Court", "cdrinku"))
//            System.out.println("student profile updated!");

//        update_student_grade(200157724, 4.0);

        
//        ArrayList<String> list = get_student_profile();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        } 

//        ArrayList<Integer> faculty = new ArrayList();
//        faculty.add(10002);
//
//        if (add_course_offering("CSC501", "SPRING", 2017, faculty, "TTH", "11:45", "13:00", 1, 1, "1234 EB3"))
//            System.out.println("course offering added successfully.");

//        ArrayList<String> list = get_course_offering_list();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }     

//        ArrayList<String> list = get_course_offering_details(2);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        } 


        disconnect();
        
    }
    
    public static void connect() throws SQLException {
        get_connection();
        get_statement_object();
    }
    
    public static void disconnect() throws SQLException{
         close_connection();
    }
    
    public static boolean check_login_credentials(String username, String password,
                                                  int student_or_admin) throws SQLException {
        String table_name = student_or_admin == 1 ? "admin" : "students";
        String s_or_a = student_or_admin == 1 ? "admin" : "student";
        ResultSet rs = stmt.executeQuery("select " + "password from " +
                                         table_name + " where username = '" + username + "'");
        if (rs.next()) {
            String password_digest1 = rs.getString("password");
            String password_digest2 = digest(password);
            if (password_digest1.equals(password_digest2)) {
                ResultSet rs2 = stmt2.executeQuery("select " + s_or_a + "_id from " + table_name + " where username = '" + username + "'");
                rs2.next();
                if (student_or_admin == 1) { 
                    current_admin_id = rs2.getInt(s_or_a + "_id");
                } else {
                    current_student_id = rs2.getInt(s_or_a + "_id");
                }
                return true;
            } else {
                System.out.println("password stored : " + password_digest1 + 
                        "\npassword entered : " + password_digest2);
            }
        } 
        return false;
    }
    
    public static String digest(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();           
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            System.out.println("original:" + password);
            System.out.println("digested(hex):" + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return sb.toString();
    }
    
    public static ArrayList<String> get_admin_profile()
    throws SQLException {
        
        ResultSet rs = stmt.executeQuery("select fname, lname, dob, admin_id "
                                         + "from admin where admin_id = " + current_admin_id);
        
        ArrayList<String> result = new ArrayList();
        
        if (rs.next()) {
            result.add(rs.getString("fname"));
            result.add(rs.getString("lname"));
            result.add(rs.getDate("dob") + "");
            result.add(rs.getLong("admin_id") + "");
        } else {
            System.out.println("admin not found!");
        }
        return result;
    }
    
    // TODO add record in belongs table
    public static boolean add_student(long student_id, String username, String fname,
                                      String lname, String dob, String CL, String RL, double bill,
                                      String dept_name, String email_id, long phone, String address)
    throws SQLException {
        ResultSet rs;
        int dept_id = 0, classification_id = 0, residency_id = 0;
        try {
            con.setAutoCommit(false);
            rs = stmt.executeQuery("select dept_id from department where dept_name = '" + dept_name+"'");
            if (rs.next()) 
                dept_id = rs.getInt("dept_id");            
    
            rs = stmt.executeQuery("select rl_id from residency_level "
                                   + "where rl = '" + RL+"'");
            if (rs.next())
                residency_id = rs.getInt("rl_id");
            
            rs = stmt.executeQuery("select cl_id from classification_level "
                                   + "where cl = '" + CL+"'");
            if (rs.next())
                classification_id = rs.getInt("cl_id");
            
            stmt.executeQuery("insert into students (username, student_id, dept_id, "
                              + "fname, lname, dob, cl_id, rl_id, bill, gpa, password, "
                              + "email, phone, address) values (" + username + "," + student_id + "," +
                              dept_id + ",'" + fname + "','" + lname + "','" + dob + "',"
                              + classification_id + "," + residency_id + "," + bill +
                              ", 0.0,'" + digest(student_id+"") + "','" + email_id + "'," + phone + ",'"
                              + address + "')");
            
            con.commit();
        } catch (SQLException e) {
            System.out.println("Can't add student! " + e.getMessage());   
            con.rollback();
            return false;
        }
        return true;
    }
    
    public static ArrayList<String> get_student_profile() {
        
        int rl_id, cl_id;
        String residency = "", classification = "", bill, gpa, phone, address,
                email;
        long student_id = current_student_id;
        try {
            ResultSet rs = stmt.executeQuery("select * from students "
                    + "where student_id = " + student_id);
            rs.next();
            
            ArrayList<String> result = new ArrayList();
            result.add(rs.getString("fname"));
            result.add(rs.getString("lname"));
            result.add(rs.getDate("dob") + "");
            bill = rs.getDouble("bill") + "";
            gpa = rs.getDouble("gpa") + "";
            phone = rs.getLong("phone") + "";
            email = rs.getString("email");
            
            address = rs.getString("address");
            
            rl_id = rs.getInt("rl_id");
            cl_id = rs.getInt("cl_id");
            
            rs = stmt.executeQuery("select cl from classification_level "
                                   + "where cl_id = " + cl_id);
            if (rs.next())
                classification = rs.getString("cl");
            
            result.add(classification);
            
            rs = stmt.executeQuery("select rl from residency_level "
                                   + "where rl_id = " + rl_id);
            if (rs.next())
                residency = rs.getString("rl");
            
            result.add(residency);
            
            result.add(bill);
            result.add(gpa);
            result.add(phone);
            result.add(email);
            result.add(address);
            
            return result;
            
        } catch(SQLException e) {
            // blank arraylist => error
            System.out.println("Error: " + e.getMessage());
            return new ArrayList();
        }
        
    }
    
    public static void update_student_grade(long student_id, double gpa)
    throws SQLException {
        stmt.executeQuery("update students set gpa = " + gpa + " where "
                          + "student_id = " + student_id);
    }
    
    public static boolean add_course(String id, String name, String
                                     dept_name, String level, double gpa_req, ArrayList<String>
                                     prereq_courses, ArrayList<Double> prereq_grades,
                                     String special_perm, int min_credits, int max_credits) throws SQLException {
        
        int classification = 0;
        int next_prereq_id, dept_id = 0, prereq_course_id, next_course_id;
        try {
            con.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery("select cl_id from "
                                             + "classification_level " + "where cl = '" + level + "'");
            if (rs.next())
                classification = rs.getInt("cl_id");
            
            rs = stmt.executeQuery("select dept_id from "
                                   + "department " + "where dept_name = '" + dept_name + "'");
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
            
            // getting the highest course_id
            rs = stmt.executeQuery("select course_id from course where "
                                   + "rownum <= 1 order by course_id desc");
            if (rs.next()) {
                next_course_id = rs.getInt("course_id") + 1;
            } else {
                next_course_id = 1;
            }
            
            stmt.executeQuery("insert into course (course_id, title, dept_id, "
                              + "min_credits, max_credits, cl_id, id) values (" + next_course_id
                              + ",'" + name + "'," + dept_id + "," + min_credits + ","
                              + max_credits + "," + classification + ",'" + id + "')");
            
            stmt.executeQuery("insert into course_prereq (prereq_id, course_id,"
                              + " min_gpa, special_permission) values (" + 
                        next_prereq_id + "," + next_course_id + "," + gpa_req + 
                        ",'" + special_perm + "')");
            
            // remove this insert if not going to use 'has' table!
            // insert into 'has'
            stmt.executeQuery("insert into has (prereq_id, course_id) values "
                    + "(" + next_prereq_id + "," + next_course_id + ")");
            
            // insert pre-req courses
            for (int i = 0; i < prereq_courses.size(); i++) {
                String temp_course_id = prereq_courses.get(i);
                rs = stmt.executeQuery("select course_id from course where id = '" + temp_course_id + "'");
                if (rs.next()) {
                    prereq_course_id = rs.getInt("course_id");
                } else {
                    System.out.println("Trying to add pre-req course which doesn't exist!");
                    return false;
                }
                stmt.executeQuery("insert into prereq_courses (prereq_id, "
                                  + "prereq_course_id, grade) values (" + next_prereq_id
                                  + "," + prereq_course_id + "," +
                                  prereq_grades.get(i) + ")");
            }
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
            con.rollback();
            return false;
        }
        return true;
    }
    
    public static ArrayList<String> get_course_details(String id)
    throws SQLException {
        String classification = "", dept_name = "", special_permission = "";
        ArrayList<String> result = new ArrayList();
        double min_gpa = 0.0;
        int prereq_id = 0, prereq_course_id, course_id = 0;
        
        // get course_id of 'id'
        ResultSet course_id_rs = stmt.executeQuery("select course_id from "
                + "course where id = '" + id + "'");
        if (course_id_rs.next()) {
            course_id = course_id_rs.getInt("course_id");
        } else {
            System.out.println("Course doesn't exist!");
        }
        
        // find courses with "course_id"
        ResultSet rs = stmt.executeQuery("select cl_id, dept_id, min_credits, max_credits, title from course where course_id"
                                         + " = " + course_id);
        rs.next();
        
        int cl_id = rs.getInt("cl_id");
        int dept_id = rs.getInt("dept_id");
        int min_credits = rs.getInt("min_credits");
        int max_credits = rs.getInt("max_credits");
        String title = rs.getString("title");
        
        // find course_prereq from "course_id"
        ResultSet course_prereq_rs = stmt.executeQuery("select * from "
                + "course_prereq where course_id = " + course_id);
        
        if (course_prereq_rs.next()) {
            min_gpa = course_prereq_rs.getDouble("min_gpa");
            special_permission = course_prereq_rs.getString("special_permission");
            prereq_id = course_prereq_rs.getInt("prereq_id");            
        }
        
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
        
        result.add(title);
        result.add(dept_name);
        result.add(classification);
        result.add(min_gpa + "");
        
        // find prereq_courses from "prereq_id"
        ResultSet prereq_courses_rs = stmt.executeQuery("select PREREQ_COURSE_ID, grade from "
                + "prereq_courses where prereq_id = " + prereq_id);

        double temp_grade;
        while (prereq_courses_rs.next()) {
            prereq_course_id = prereq_courses_rs.getInt("prereq_course_id");
            temp_grade = prereq_courses_rs.getDouble("grade");
            ResultSet prereq_course_name_rs = stmt2.executeQuery("select id "
                    + "from course where course_id = " + prereq_course_id);
            prereq_course_name_rs.next();
            
            result.add(prereq_course_name_rs.getString("id"));
            result.add(temp_grade + "");
        }
        
        result.add(special_permission);
        result.add(min_credits + "");
        result.add(max_credits + "");
        
        return result;
    }
    
    // implement methods after this point
    public static ArrayList<String> get_faculty_list() {
        ArrayList<String> list = new ArrayList();
        try {
        ResultSet rs = stmt.executeQuery("select * from faculty");
        while (rs.next()) {
            list.add("" + rs.getInt("faculty_id") + " " + rs.getString("fname") 
                    + " " + rs.getString("lname"));
        }
        } catch (SQLException e) {
            System.out.println("exception while retrieving faculty_list!" + e);
            return list;
        }
        return list;
    }
    
    public static boolean add_faculty(String fname, String lname, String dept_name) {
        int dept_id = 0, next_faculty_id;
        try {
            ResultSet rs = stmt.executeQuery("select dept_id from "
                                   + "department " + "where dept_name = '" + dept_name + "'");
            if (rs.next())
                dept_id = rs.getInt("dept_id");
            
            // getting the highest faculty_id
            rs = stmt.executeQuery("select faculty_id from faculty where "
                                   + "rownum <= 1 order by faculty_id desc");
            if (rs.next()) {
                next_faculty_id = rs.getInt("faculty_id") + 1;
            } else {
                next_faculty_id = 10000;
            }
            
            stmt.executeQuery("insert into faculty (faculty_id, fname, lname, "
                    + "dept_id) values (" + next_faculty_id + ",'" + fname 
                    + "','" + lname + "'," + dept_id + ")");
            
        } catch (SQLException e) {
            System.out.println("couldn't add faculty!" + e);
            return false;
        }
        return true;
    }
    
    public static boolean add_course_offering(String id, String semester, 
            int year, ArrayList<Integer> faculty_list, String days, 
            String start_time, String end_time, 
            int class_size, int max_waitlist_size, String location) 
            throws SQLException {
        
        int course_id = 0, next_semester_id, next_schedule_id
                , class_location_id;
        long next_offering_id;
        try {
            con.setAutoCommit(false);
            // getting course_id corresponding to the 'id'
            ResultSet rs = stmt.executeQuery("select course_id from course "
                    + "where id = '" + id + "'");
            if (rs.next()) {
                course_id = rs.getInt("course_id");
            } else {
                System.out.println("Course does not exist!");
            }
            
            // insert sem and year in semester table
            // see if semester already present in the table
            rs = stmt.executeQuery("select semester_id from semester where "
                    + "semester_name = '" + semester + "' and year = " + year);
            if (rs.next()) {
                // semester exists
                next_semester_id = rs.getInt("semester_id");
            } else {
                // create semester record/row
                // getting the highest semester_id
                rs = stmt.executeQuery("select semester_id from semester where "
                                     + "rownum <= 1 order by semester_id desc");
                if (rs.next()) {
                    next_semester_id = rs.getInt("semester_id") + 1;
                } else {
                    next_semester_id = 1;
                }
                stmt.executeQuery("insert into semester (semester_id, "
                        + "semester_name, year) values (" + next_semester_id 
                        + ",'" + semester + "'," + year + ")");
            }
            
            // insert days and start-end time in schedule table
            // getting the highest schedule_id
            rs = stmt.executeQuery("select schedule_id from schedule where "
                                   + "rownum <= 1 order by schedule_id desc");
            if (rs.next()) {
                next_schedule_id = rs.getInt("schedule_id") + 1;
            } else {
                next_schedule_id = 1;
            }
            stmt.executeQuery("insert into schedule (schedule_id, "
                        + "schedule_days, start_time, end_time) values (" 
                        + next_schedule_id + ",'" + days + "','" + start_time 
                        + "','" + end_time + "')");
            
            // insert location into location table or get existing location id
            rs = stmt.executeQuery("select class_location_id from "
                    + "class_location where class_location_name = '" 
                    + location + "'");
            if (rs.next()) {
                class_location_id = rs.getInt("class_location_id");
            } else {
                rs = stmt.executeQuery("select class_location_id from "
                    + "class_location where rownum <= 1 order by "
                    + "class_location_id desc");
                if (rs.next()) {
                    class_location_id = rs.getInt("class_location_id") + 1;
                } else {
                    class_location_id = 1;
                }
                stmt.executeQuery("insert into class_location ("
                        + "class_location_id, class_location_name) values (" 
                        + class_location_id + ",'" + location + "')");
            }
            
            // insert course offering 
            // getting the highest offering_id
            rs = stmt.executeQuery("select offering_id from course_offering where "
                                   + "rownum <= 1 order by offering_id desc");
            if (rs.next()) {
                next_offering_id = rs.getLong("offering_id") + 1;
            } else {
                next_offering_id = 1;
            }
            stmt.executeQuery("insert into course_offering (offering_id, "
                    + "semester_id, schedule_id, course_id, max_enrollment, "
                    + "current_enrollment, location_id, wait_list_max) values "
                    + "(" + next_offering_id +"," + next_semester_id + "," 
                    + next_schedule_id + "," + course_id + "," + class_size 
                    + "," + 0 + "," + class_location_id + "," + max_waitlist_size 
                    + ")");
            
            for (int i = 0; i < faculty_list.size(); i++) {
                // (insert faculty list into teaches table), 
                stmt.executeQuery("insert into teaches (faculty_id, "
                        + "offering_id) values (" + faculty_list.get(i) 
                        + "," + next_offering_id + ")");
            }
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
            con.rollback();
            return false;
        }
        return true;
    }
    
    public static ArrayList<String> get_course_offering_list() {
        ArrayList<String> offering_list = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery("select offering_id, course_id, semester_id from course_offering");
            while (rs.next()) {
                int course_id = rs.getInt("course_id");
                int sem_id = rs.getInt("semester_id");
                ResultSet rs2 = stmt2.executeQuery("select id from course where course_id = " + course_id);
                rs2.next();
                String id = rs2.getString("id");
                rs2 = stmt2.executeQuery("select semester_name, year from semester where semester_id = " + sem_id);
                rs2.next();
                String sem = rs2.getString("semester_name");
                int year = rs2.getInt("year");
                offering_list.add(rs.getInt("offering_id") + " " + id + " " + sem + "-" + year);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return offering_list;
    }
    
    public static ArrayList<String> get_course_offering_details(long 
            course_offering_id) throws SQLException {
        ArrayList<String> result = new ArrayList();
        
        ResultSet rs = stmt.executeQuery("select * from course_offering where offering_id = " + course_offering_id);
        rs.next();
        ResultSet rs2 = stmt2.executeQuery("select id from course where course_id = " + rs.getInt("course_id"));
        rs2.next();
        result.add(rs2.getString("id"));
        
        rs2 = stmt2.executeQuery("select semester_name from semester where semester_id = " + rs.getInt("semester_id"));
        rs2.next();
        result.add(rs2.getString("semester_name"));
        
        rs2 = stmt2.executeQuery("select faculty_id from teaches where offering_id = " + course_offering_id);
        ArrayList faculty_ids = new ArrayList();
        int count = 0;
        while (rs2.next()) {
            faculty_ids.add(rs2.getInt("faculty_id"));            
            count++;
        }
        result.add(count + "");
        for (int i = 0; i < faculty_ids.size(); i++) {
            rs2 = stmt2.executeQuery("select fname, lname from faculty where faculty_id = " + faculty_ids.get(i));
            rs2.next();
            result.add(faculty_ids.get(i) + " " + rs2.getString("fname") + " " + rs2.getString("lname"));
        }
        
        rs2 = stmt2.executeQuery("select schedule_days, start_time, end_time from schedule where schedule_id = " + rs.getInt("schedule_id"));
        rs2.next();
        result.add(rs2.getString("schedule_days"));
        result.add(rs2.getString("start_time"));
        result.add(rs2.getString("end_time"));
        
        result.add(rs.getInt("MAX_ENROLLMENT") + "");
        result.add(rs.getInt("WAIT_LIST_MAX") + "");
        result.add(rs.getInt("CURRENT_ENROLLMENT") + "");
        
        rs2 = stmt2.executeQuery("select class_location_name from class_location where class_location_id = " + rs.getInt("location_id"));
        rs2.next();
        result.add(rs2.getString("class_location_name"));
        
        return result;
    }
    
    public static boolean edit_student_profile(String fname, String lname, 
            String dob, String CL, String RL, String dept_name, String email_id,
            long phone, String address, String password) throws SQLException {
        int dept_id = 0, cl_id = 0, rl_id = 0;
        try {
            con.setAutoCommit(false);
            ResultSet rs = stmt.executeQuery("select dept_id from department where dept_name = '" + dept_name + "'");
            if (rs.next()) 
                dept_id = rs.getInt("dept_id");           
    
            rs = stmt.executeQuery("select rl_id from residency_level "
                                   + "where rl = '" + RL + "'");
            if (rs.next())
                rl_id = rs.getInt("rl_id");
            
            rs = stmt.executeQuery("select cl_id from classification_level "
                                   + "where cl = '" + CL + "'");
            if (rs.next())
                cl_id = rs.getInt("cl_id");
            
            stmt.executeQuery("update students set dept_id = " + dept_id + ", "
                    + "fname = '" + fname + "', lname = '" + lname + 
                    "', dob = '" + dob + "', cl_id = " + cl_id + ", rl_id = " 
                    + rl_id + ", email = '" + 
                    email_id + "', phone = " + phone + ", address = '" + 
                    address + "', password = '" + digest(password) + "' "
                            + "where student_id = " + current_student_id);
         
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            con.rollback();            
            return false;            
        } 
        return true;
    }
    
    
    // chandu - view courses
    public static ArrayList<String> get_courses() {
        ArrayList<String> course_list = new ArrayList();
        // can use get_course_offering_list here! or change signature of get_course_offering_list
        return course_list;
    }
    
    // chandu - enforce add/drop deadline
    
    
    
    // enroll for a course (check if classification is same as course cl_id)
    public static boolean enroll_course(long offering_id, int credits) throws SQLException {
        long student_id = current_student_id;
        int course_id, cl_id_of_current_student, cl_id_of_course, prereq_id, min_credits, max_credits;
        String special_permission;
        double min_gpa;
        try {
            con.setAutoCommit(false);
            
            ResultSet rs = stmt.executeQuery("select course_id from offering where offering_id = " + offering_id);
            rs.next();
            course_id = rs.getInt("course_id");
            
            rs = stmt.executeQuery("select min_credits, max_credits, cl_id from course where course_id = " + course_id);
            rs.next();
            min_credits = rs.getInt("min_credits");
            max_credits = rs.getInt("max_credits");
            if (credits > max_credits || credits < min_credits) {
                System.out.println("credits not in correct range!");
                return false;
            }
            cl_id_of_course = rs.getInt("cl_id");
            
            rs = stmt.executeQuery("select cl_id from students where student_id = " + student_id);
            rs.next();
            cl_id_of_current_student = rs.getInt("cl_id");
            
            if (cl_id_of_course != cl_id_of_current_student) {
                System.out.println("cl of student is not equal to cl of course");
                return false;
            }
            
            rs = stmt.executeQuery("select prereq_id, special_permission, min_gpa from course_prereq where course_id = " + course_id);
            rs.next();
            prereq_id = rs.getInt("prereq_id");
            special_permission = rs.getString("special_permission");
            min_gpa = rs.getDouble("min_gpa");
            
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            con.rollback();
            return false;
        }
        return true;
    }
    
    // chandu - drop course
    // chandu - view pending/rejected/waitlisted courses
    
    // not tested
    public static ArrayList<String> get_grades() {
        ArrayList<String> grades_list = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery("select * from enrolls where student_id = " + current_student_id + " and grade is not null");
            if (rs.next()) {
                int course_id = rs.getInt("course_id");
                ResultSet rs2 = stmt2.executeQuery("select id from course where course_id = " + course_id);
                rs2.next();
                grades_list.add(rs2.getString("id") + " " + rs.getString("grade"));
            }
            rs = stmt.executeQuery("select gpa from students where student_id = " + current_student_id);
            rs.next();
            grades_list.add(rs.getDouble("gpa") + "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return grades_list;        
    }
    
    // chandu - view bill
    
    
    // chandu - pay bill
    
    // chandu - view_enrollment_requests
    public static ArrayList<ArrayList<String>> view_enrollment_requests() 
    throws SQLException {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        return result;
    }
    
    // chandu - approve_enrollment_request
    public static boolean approve_enrollment_request() {
        try {
            stmt.executeQuery("");
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
}


// add departments manually
// add one page which adds faculty
// remove course_id from course_prereq table? or drop 'has' table (better to drop table 'has')
// trigger for after update profile of student, if CL or RL changes => bill
// get_course_offering_list can be changed to view courses of particular SemYear
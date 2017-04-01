/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

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
    private static long current_admin_id = 0, current_student_id = 0;
    
    public static void main(String args[]) throws SQLException{
        connect();
        
//        digest("cdrinku");

//        int s_or_a = 1;
//        if (check_login_credentials("alby", "hogwarts", s_or_a)) {
//            System.out.println("welcome!" + (s_or_a == 1 ? current_admin_id : current_student_id));
//        }

//        System.out.println(add_department("CN"));
//        
//        ArrayList<String> list = get_departments();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

//        System.out.println(add_faculty("Rudra", "Datta", "CN"));
//        ArrayList<String> l = get_faculty_list();
//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
//        }

//        ArrayList<String> courses = new ArrayList();
//        ArrayList<Double> grades = new ArrayList();
//        courses.add("CSC505");
//        grades.add(3.33);
//        courses.add("CSC501");
//        grades.add(3.00);
//
//        System.out.println(add_course("CSC591", "IOT", "CS", "Graduate", 0.0, courses, grades, "", 3, 3));

//        ArrayList<String> result = get_course_details("CSC540");
//        for (int i = 0; i < result.size(); i++) {
//            System.out.print(result.get(i) + " ");
//        }

//        ArrayList<String> list = get_admin_profile(1111l);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        
//        System.out.println(add_student(200157726L, "jkjabbal", "jasleen", "jabbal", "01-MAR-92", "Graduate", "International", 0, "CS", "jkjabbal@ncsu.edu", 8923047643L, "Champion Court"));            
    
//        current_student_id = 200157725L;
//        if (edit_student_profile("Chandu", "Dash", "01-JAN-93", "Undergraduate", "International", "ECE", "cdashudu@ncsu.edu", 5108906594L, "2309 Champion Court", "cdrinku"))
//            System.out.println("student profile updated!");

//        update_student_grade(200157724, 4.0);

//        current_student_id = 200157726;
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

        current_student_id = 200157725L;
        System.out.println(enroll_course(2, 3));

        disconnect();
        
    }
    
    // done
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
    
    // done
    public static void get_statement_object() {
        try {
            //step3 create the statement object
            stmt = con.createStatement();
            stmt2 = con2.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // done
    public static int close_connection() {
        try {
            //step5 close the connection object
            con.close();
            con2.close();
            return 0;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    // done
    public static void connect() throws SQLException {
        get_connection();
        get_statement_object();
    }
    
    // done
    public static void disconnect() throws SQLException{
         close_connection();
    }
    
    // done
    public static String check_login_credentials(String username, String 
            password, int student_or_admin) throws SQLException {
        String table_name = student_or_admin == 1 ? "admin" : "students";
        String s_or_a = student_or_admin == 1 ? "admin" : "student";
        
        ResultSet rs = stmt.executeQuery("select " + s_or_a + "_id from " + 
                table_name + " where username = '" + username + "' and '" + 
                digest(password) + "' = (select password from " + table_name 
                + " where username = '" + username + "')");
        if (rs.next()) {
            if (student_or_admin == 1) { 
                current_admin_id = rs.getInt(s_or_a + "_id");
            } else {
                current_student_id = rs.getInt(s_or_a + "_id");
            }
            return "Success";
        } else {
            System.out.println("cant login");            
            return "Invalid credentials!";
        }
    }
    
    // done
    public static String digest(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();           
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
//            System.out.println("original:" + password);
//            System.out.println("digested(hex):" + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return sb.toString();
    }
    
    // done
    public static ArrayList<String> get_departments() {
        ArrayList<String> departments = new ArrayList();
        
        try {
            ResultSet rs = stmt.executeQuery("select dept_name from department");
            while (rs.next()) {
                departments.add(rs.getString("dept_name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error in selecting department list! " + 
                    ex.getMessage());            
        }
        
        return departments;
    }
    
    // done
    public static String add_department(String dept_name) {        
        try {
            stmt.executeQuery("insert into department (dept_id, dept_name) values (dept_seq.nextval, '" + dept_name + "')");            
        } catch (SQLException ex) {            
            System.out.println("Error in adding department! " + ex.getMessage());
            return ex.getMessage();
        }
        return "Success";
    }
    
    // done
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
            System.out.println("Admin not found!");
        }
        return result;
    }
    
    // done
    public static String add_student(long student_id, String username, String fname,
                                      String lname, String dob, String CL, String RL, double bill,
                                      String dept_name, String email_id, long phone, String address)
    throws SQLException {
        try {
            stmt.executeQuery("insert into students (username, student_id, dept_id, fname, lname, dob, cl_id, rl_id, bill, gpa, password, email, phone, address) "
                    + "select "
                    + "'" + username + "' as username, "
                    + student_id + " as student_id, "
                    + "d.dept_id as dept_id, "
                    + "'" + fname + "' as fname, "
                    + "'" + lname + "' as lname, "
                    + "'" + dob + "' as dob, "
                    + "c.cl_id as cl_id, "
                    + "r.rl_id as rl_id, "
                    + bill + " as bill, "
                    + 0.0 + " as gpa, "
                    + "'" + digest(student_id + "") + "' as password, "
                    + "'" + email_id + "' as email, "
                    + phone + " as phone, "
                    + "'" + address + "' as address"
                    + " from department d, classification_level c, residency_level r "
                    + "where d.dept_name = '" + dept_name + "' and c.cl = '" + CL + "' and r.rl = '" + RL + "'");          
            
        } catch (SQLException e) {
            System.out.println("Can't add student! " + e.getMessage());               
            return e.getMessage();
        }
        return "Success";
    }
    
    // done
    public static ArrayList<String> get_student_profile(long id) {
        
        long student_id;
        if (id == -1) {
            student_id = current_student_id;
        } else {
            student_id = id;
        }
        try {
            
            ResultSet rs = stmt.executeQuery("select students.*, c.cl, r.rl "
                    + "from students, classification_level c, residency_level r"
                    + " where student_id = " + student_id + " and c.cl_id = "
                            + "students.cl_id and r.rl_id = students.rl_id");            
            if (rs.next()) {           
                ArrayList<String> result = new ArrayList();
                result.add(rs.getString("fname"));
                result.add(rs.getString("lname"));
                result.add(rs.getDate("dob") + "");            
                result.add(rs.getString("CL"));
                result.add(rs.getString("RL"));            
                result.add(rs.getDouble("bill") + "");
                result.add(rs.getDouble("gpa") + "");
                result.add(rs.getLong("phone") + "");
                result.add(rs.getString("email"));
                result.add(rs.getString("address"));
                return result;
            } else {
                System.out.println("Student not found!");
                return new ArrayList();
            }
        } catch(SQLException e) {
            // blank arraylist => error
            System.out.println("Error: " + e.getMessage());
            return new ArrayList();
        }
    }
    
    // done - checking of gpa should be on the UI side
    public static void update_student_grade(long student_id, double gpa)
    throws SQLException {
        stmt.executeQuery("update students set gpa = " + gpa + " where "
                          + "student_id = " + student_id);
    }
    
    // done
    public static String add_course(String id, String name, String
                                     dept_name, String level, double gpa_req, ArrayList<String>
                                     prereq_courses, ArrayList<Double> prereq_grades,
                                     String special_perm, int min_credits, int max_credits) throws SQLException {
        
        try {
            con.setAutoCommit(false);
            
            stmt.executeQuery("insert into course (course_id, title, dept_id, "
                    + "min_credits, max_credits, cl_id, id) select "
                    + "course_seq.nextval as course_id, '" + name + "' "
                    + "as title, d.dept_id as dept_id, " 
                    + min_credits + " as min_credits, " + max_credits
                    + "as max_credits, c.cl_id as cl_id, '" + id + "' as id"
                    + " from department d, classification_level c where "
                    + "c.cl = '" + level + "' and d.dept_name = '" 
                    + dept_name + "'");
                    
            stmt.executeQuery("insert into course_prereq (prereq_id, course_id,"
                    + " min_gpa, special_permission) select prereq_seq.nextval "
                    + "as prereq_id, course_seq.currval as course_id, " 
                    + gpa_req + " as min_gpa, '" + special_perm + "' as "
                            + "special_permission from dual");
            
            for (int i = 0; i < prereq_courses.size(); i++) {
                try {
                stmt.executeQuery("insert into prereq_courses (prereq_id, "
                        + "prereq_course_id, grade) select prereq_seq.currval "
                        + "as prereq_id, c.course_id as prereq_course_id, " 
                        + prereq_grades.get(i) + " as grade from course c where"
                                + " c.id = '" + prereq_courses.get(i) + "'");
                } catch (SQLException e) {
                    System.out.println("Trying to add pre-req course which doesn't exist!");
                    return "Trying to add pre-req course which doesn't exist!";
                }
            }
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
            con.rollback();
            return e.getMessage();
        }
        return "Success";
    }
    
    // done
    public static ArrayList<String> get_course_details(String id) {
        String special_permission;
        ArrayList<String> result = new ArrayList();
        int prereq_id, prereq_course_id, course_id;
        try {
            
        // get course_id of 'id'
        ResultSet course_id_rs = stmt.executeQuery("select course_id from "
                + "course where id = '" + id + "'");
        if (course_id_rs.next()) {
            course_id = course_id_rs.getInt("course_id");
        } else {
            System.out.println("Course doesn't exist!");
            result.add("Course doesn't exist!");
            return result;
        }
        
        ResultSet rs = stmt.executeQuery("select c.cl, d.dept_name, co.min_credits, co.max_credits, co.title, cp.min_gpa, cp.special_permission, cp.prereq_id from course co, course_prereq cp, department d, classification_level c where co.course_id"
                                         + " = " + course_id + " and co.course_id = cp.course_id and c.cl_id = co.cl_id and d.dept_id = co.dept_id");
        rs.next();
        
        int min_credits = rs.getInt("min_credits");
        int max_credits = rs.getInt("max_credits");        
        special_permission = rs.getString("special_permission");
        prereq_id = rs.getInt("prereq_id");        
        
        result.add(rs.getString("title"));
        result.add(rs.getString("dept_name"));
        result.add(rs.getString("cl"));
        result.add(rs.getDouble("min_gpa") + "");
        
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
        } catch (SQLException e) {
            result = new ArrayList();
            result.add(e.getMessage());
            return result;
        }
        return result;
    }
    
    // done
    public static ArrayList<String> get_faculty_list() {
        ArrayList<String> list = new ArrayList();
        try {
        ResultSet rs = stmt.executeQuery("select * from faculty");
        while (rs.next()) {
            list.add(rs.getInt("faculty_id") + " " + rs.getString("fname") 
                    + " " + rs.getString("lname"));
        }
        } catch (SQLException e) {
            System.out.println("exception while retrieving faculty_list!" + e);
            return list;
        }
        return list;
    }
    
    // done
    public static String add_faculty(String fname, String lname, String dept_name) {
        try {
            stmt.executeQuery("insert into faculty (faculty_id, fname, lname, "
                    + "dept_id) "
                    + "select faculty_seq.nextval as faculty_id,"
                    + "'" + fname + "',"
                    + "'" + lname + "',"
                    + "d.dept_id as dept_id "
                    + "from department d where d.dept_name = '" + dept_name + "'");
            
        } catch (SQLException e) {
            System.out.println("couldn't add faculty!" + e);
            return e.getMessage();
        }
        return "Success";
    }
    
    // done ... changed return type
    public static String add_course_offering(String id, String semester, 
            int year, ArrayList<Integer> faculty_list, String days, 
            String start_time, String end_time, 
            int class_size, int max_waitlist_size, String location) 
            throws SQLException {
        
        int course_id = 0, next_semester_id, next_schedule_id
                , class_location_id;
        try {
            con.setAutoCommit(false);
            // getting course_id corresponding to the 'id'
            ResultSet rs = stmt.executeQuery("select course_id from course "
                    + "where id = '" + id + "'");
            if (rs.next()) {
                course_id = rs.getInt("course_id");
            } else {
                System.out.println("Course does not exist!");
                return "Course does not exist!";
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
                stmt.executeQuery("insert into semester (semester_id, "
                        + "semester_name, year) values (semester_seq.nextval" 
                        + ",'" + semester + "'," + year + ")");
                rs = stmt.executeQuery("select semester_seq.currval from dual");
                rs.next();
                next_semester_id = rs.getInt("currval");
            }
            
            // insert in schedule table
            // see if schedule already present in the table
            rs = stmt.executeQuery("select schedule_id from schedule where "
                    + "schedule_days = '" + days + "' and start_time = '" + 
                    start_time + "' and end_time = '" + end_time + "'");
            if (rs.next()) {
                // schedule exists
                next_schedule_id = rs.getInt("semester_id");
            } else {
                // insert days and start-end time in schedule table            
                stmt.executeQuery("insert into schedule (schedule_id, "
                        + "schedule_days, start_time, end_time) values (schedule_seq.nextval" 
                        + ",'" + days + "','" + start_time 
                        + "','" + end_time + "')");
                rs = stmt.executeQuery("select schedule_seq.currval from dual");
                rs.next();
                next_schedule_id = rs.getInt("currval");
            }
            
            // insert location into location table or get existing location id
            rs = stmt.executeQuery("select class_location_id from "
                    + "class_location where class_location_name = '" 
                    + location + "'");
            if (rs.next()) {
                class_location_id = rs.getInt("class_location_id");
            } else {
                // create new location record
                stmt.executeQuery("insert into class_location ("
                        + "class_location_id, class_location_name) values "
                        + "(location_seq.nextval, '" + location + "')");
                rs = stmt.executeQuery("select location_seq.currval from dual");
                rs.next();
                class_location_id = rs.getInt("currval");
            }
            
            // insert course offering             
            stmt.executeQuery("insert into course_offering (offering_id, "
                    + "semester_id, schedule_id, course_id, max_enrollment, "
                    + "current_enrollment, location_id, wait_list_max) values "
                    + "(offering_seq.nextval," + next_semester_id + "," + next_schedule_id + "," + course_id + "," + class_size 
                    + "," + 0 + "," + class_location_id + "," + max_waitlist_size 
                    + ")");
            
            for (int i = 0; i < faculty_list.size(); i++) {
                // (insert faculty list into teaches table), 
                stmt.executeQuery("insert into teaches (faculty_id, "
                        + "offering_id) values (" + faculty_list.get(i) 
                        + ", offering_seq.currval");
            }
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e);
            con.rollback();
            return e.getMessage();
        }
        return "Success";
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
        
        rs2 = stmt2.executeQuery("select semester_name, year from semester where semester_id = " + rs.getInt("semester_id"));
        rs2.next();
        result.add(rs2.getString("semester_name"));
        String year = rs2.getInt("year") + "";        
        
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
        result.add(year);
        
        return result;
    }
    
    // changed return type
    public static String edit_student_profile(String fname, String lname, 
            String dob, String email_id,
            long phone, String address, String password) throws SQLException {
        try {
            stmt.executeQuery("update students set "
                    + "fname = '" + fname + "', lname = '" + lname + 
                    "', dob = '" + dob + "', email = '" + 
                    email_id + "', phone = " + phone + ", address = '" + 
                    address + "', password = '" + digest(password) + "' "
                            + "where student_id = " + current_student_id);         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();            
        } 
        return "Success";
    }
    
    
    // implement methods after this point
    // not tested
    // enroll for a course (check if classification is same as course cl_id)
    public static String enroll_course(long offering_id, int credits) throws SQLException {
        long student_id = current_student_id;
        int course_id, cl_id_of_current_student, cl_id_of_course, prereq_id, min_credits, max_credits, prereq_course_id;
        String special_permission, required_grade;
        double min_gpa;
        try {
            con.setAutoCommit(false);
            
            ResultSet p = stmt.executeQuery("select (case when (select MAX_ENROLLMENT + WAIT_LIST_MAX from course_offering "
                        + "where offering_id = " + offering_id + ") = (select CURRENT_ENROLLMENT "
                        + "from course_offering where offering_id = " + offering_id + ") then 'N' else 'Y' end) as possible from dual");
            p.next();
            if (p.getString("possible").equals("N")) {
                return "Can't enroll. Course is full";
            }
            
            ResultSet rs = stmt.executeQuery("select course_id from course_offering where offering_id = " + offering_id);
            rs.next();
            course_id = rs.getInt("course_id");            
            
            rs = stmt.executeQuery("select min_credits, max_credits, cl_id from course where course_id = " + course_id);
            rs.next();
            min_credits = rs.getInt("min_credits");
            max_credits = rs.getInt("max_credits");
            if (credits > max_credits || credits < min_credits) {
                return "credits not in correct range!";
            }
            cl_id_of_course = rs.getInt("cl_id");            
            
            rs = stmt.executeQuery("select cl_id from students where student_id = " + student_id);
            rs.next();
            cl_id_of_current_student = rs.getInt("cl_id");
            
            if (cl_id_of_course != cl_id_of_current_student) {
                return "cl of student is not equal to cl of course";
            }
            
            rs = stmt.executeQuery("select prereq_id, special_permission, min_gpa from course_prereq where course_id = " + course_id);
            rs.next();
            prereq_id = rs.getInt("prereq_id");
            special_permission = rs.getString("special_permission");
            min_gpa = rs.getDouble("min_gpa");
            
            if (min_gpa > get_gpa(student_id)) {
                return "Minimum gpa is more than current gpa";
            }
            
            ArrayList<String> grades_list = get_grades(student_id);
            Hashtable<Integer, String> grades = new Hashtable<>();
            String str[];
            for (int i = 0; i < grades_list.size(); i++) {
                str = grades_list.get(i).split(" ");
                grades.put(Integer.parseInt(str[0]), str[2]);
            }
            
            rs = stmt.executeQuery("select PREREQ_COURSE_ID, GRADE from prereq_courses where prereq_id = " + prereq_id);
            while (rs.next()) {
                prereq_course_id = rs.getInt("prereq_course_id");
                required_grade = rs.getString("grade");
                if (grades.containsKey(prereq_course_id)) {
                    String temp = grades.get(prereq_course_id);
                    ResultSet rs2 = stmt2.executeQuery("select (case when "
                            + "(select grade_points from grades where grade = '" + temp + "') >= "
                            + "(select grade_points from grades where grade = '" + required_grade + "' then 'T' else 'F' end) as check from dual");
                    if (rs2.getString("check").equals("F")) {
                        rs = stmt.executeQuery("select id, title from course where course_id = " + prereq_course_id);
                        return "Not enough grade pointer in - " + rs.getString("id") + " " + rs.getString("title");
                    }
                } else {
                    rs = stmt.executeQuery("select id, title from course where course_id = " + prereq_course_id);
                    return "course - " + rs.getString("id") + " " + rs.getString("title") + " is required as a prerequisite";
                }
            }
            
            String status;
            if (special_permission != null && special_permission.equals("T")) {                
                status = "P";
            } else {
                // check current enrollment count and decide E/W accordingly
                rs = stmt.executeQuery("select (case when (select MAX_ENROLLMENT from course_offering "
                        + "where offering_id = " + offering_id + ") <= (select CURRENT_ENROLLMENT "
                        + "from course_offering where offering_id = " + offering_id + ") then 'W' else 'E' end) as status from dual");
                rs.next();
                if (rs.getString("status").equals("E")) {
                    status = "E";
                } else
                    status = "W";
            }
            
            stmt.executeQuery("insert into enrolls (STUDENT_ID, OFFERING_ID, CREDITS, STATUS) values (" + student_id + "," + offering_id + "," + credits + ",'" + status + "')");
            
            con.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            con.rollback();
            return e.getMessage();
        }
        return "Success";
    }
    
    // pass -1 to get current_student grades
    // blank array if wrong student id is passed
    public static ArrayList<String> get_grades(long id) {
        long student_id;
        student_id = id == -1 ? current_student_id : id;
        
        ArrayList<String> grades_list = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery("select * from enrolls where "
                    + "student_id = " + student_id + " and "
                            + "grade is not null");
            while (rs.next()) {
                ResultSet rs2 = stmt2.executeQuery("select c.id from course c, "
                        + "course_offering co where c.course_id = co.offering_id"
                        + " and co.offering_id = " + rs.getInt("offering_id"));
                rs2.next();
                grades_list.add(rs2.getInt("course_id") + " " + rs2.getString("id") + " " + rs.getString("grade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
        return grades_list;        
    }
    
    // returning -1 if student_id is incorrect
    // pass -1 to get current_student gpa
    public static double get_gpa(long id) {
        long student_id;
        student_id = id == -1 ? current_student_id : id;
        try {
            ResultSet rs = stmt.executeQuery("select gpa from students where student_id = " + student_id);
            rs.next();
            return rs.getDouble("gpa");
        } catch (SQLException e) {
            return -1;
        }
    }
    
    // chandu - pay bill
    public static String pay_bill(float amount) {
        try {
            stmt.executeQuery("update students set bill = (select bill from students where student_id="+current_student_id+")- "+amount + " where "
                    + "student_id = " + current_student_id);
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    return "Success";
    }
    // chandu - view bill
    public static String view_bill() {
        try {
            ResultSet rs=stmt.executeQuery("select bill from students where student_id="+current_student_id);
            rs.next();
            return rs.getDouble("bill")+"";
        } catch (SQLException ex) {
            
            return ex.getMessage();
        }
        
    }
    // chandu - enforce add/drop deadline
     public static String enforce_addDrop_deadline(String semester_name, int year, String decision) {
        try {
            if(decision.equals("Yes"))
            {
                stmt.executeQuery("update semester set enforce_deadline='T' where semester_name='"+semester_name+"' and year="+year);
                
            }
            
        
        } catch (SQLException ex) {
            
            return ex.getMessage();
        }
        return "Success";
    }
    // chandu - drop course
    public static String drop_course(long offering_id) {
        try {
            stmt.executeQuery("update enrolls set status='D' where offering_id="+offering_id+" and student_id="+current_student_id);
            
            
        } catch (SQLException ex) {
            
            return ex.getMessage();
        }
        return "Success";
    }
    
    // chandu - view pending/rejected/waitlisted courses --enrolls
    
    // chandu - view courses
    
    public static ArrayList<String> get_courses() {
        ArrayList<String> course_list = new ArrayList();
        // can use get_course_offering_list here! or change signature of get_course_offering_list
        return course_list;
    }
        
     public static ArrayList<ArrayList<String>> view_enrollment_requests() {
    ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        ArrayList<String> temp;
        try {
             
            ResultSet rs=stmt.executeQuery("select s.semester_name,e.offering_id, e.STUDENT_ID, c.TITLE, c.id,s.year, st.fname, st.lname from course c, enrolls e, semester s, course_offering co, students st" +
                 "where co.offering_id=e.offering_id and co.course_id=c.course_id and co.semester_id=s.semester_id and st.student_id=e.student_id and" +
                    "e.status='P'");
            while(rs.next())
            {
                temp=new ArrayList<String>();
                temp.add(rs.getString("semester_name"));
                temp.add(rs.getInt("offering_id")+"");
                temp.add(rs.getLong("student_id")+"");
                temp.add(rs.getString("title"));
                temp.add(rs.getString("id"));
                temp.add(rs.getInt("year")+"");
                temp.add(rs.getString("fname"));
                temp.add(rs.getString("lname"));
                result.add(temp);
            }
             
        } catch (SQLException ex) {
             
            return new ArrayList<ArrayList<String>>();
        }
    return result;
    }
    
  // chandu - approve_enrollment_request
    public static String approve_reject_enrollment_request(String stuId,String offeringID,String status) {
        try {
            
            if(status.equals("approve"))
            stmt.executeQuery("update enrolls e set e.status =" +
                              "(Case when ((select c.current_enrollment from course_offering c,students s where e.OFFERING_id=c.OFFERING_id and e.student_id = s.student_id and s.student_id ="
                    + stuId +" and e.offering_id="+offeringID+") < ((select c.max_enrollment from course_offering c,students s "
                    + "where e.OFFERING_id=c.OFFERING_id and e.student_id = s.student_id and s.student_id ="+ stuId+" and e.offering_id="+offeringID+" ))) then 'E' ELSE 'W' END);");
       
                   else
                       stmt.executeQuery("update enrolls e set e.status = 'R' where e.offering_id=" +offeringID +" and e.student_id = "+stuId+";");
        } catch(SQLException e) {
            System.out.println(e);
            return e.getMessage();
        }
        return "Success";
    }
    
    public static ArrayList<ArrayList<String>> view_course_status() {
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        ArrayList<String> temp;
        try {
            
            ResultSet rs=stmt.executeQuery("select s.semester_name, s.year, e.status, c.id, c.title from "
                    + "course c, enrolls e, semester s, course_offering co "
                    + "where co.offering_id=e.offering_id and co.course_id=c.course_id and co.semester_id=s.semester_id and "
                    + "e.student_id="+current_student_id);
            while(rs.next())
            {
                temp=new ArrayList<String>();
                temp.add(rs.getString("semester_name"));
                temp.add(rs.getInt("year")+"");
                temp.add(rs.getString("status"));
                temp.add(rs.getString("id"));
                result.add(temp);
            }
            
        } catch (SQLException ex) {
            
            return new ArrayList<ArrayList<String>>();
        }
        return result;
    }
    
    public static ArrayList<ArrayList<String>> view_pending_course() {
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        ArrayList<String> temp;
        try {
            
            ResultSet rs=stmt.executeQuery("select c.id, c.title from "
                    + "course c, enrolls e, semester s, course_offering co "
                    + "where co.offering_id=e.offering_id and co.course_id=c.course_id and co.semester_id=s.semester_id and e.status='P' and "
                    + "e.student_id="+current_student_id);
            while(rs.next())
            {
                temp=new ArrayList<String>();
                temp.add(rs.getString("id"));
                temp.add(rs.getString("title"));
                result.add(temp);
            }
            
        } catch (SQLException ex) {
            
            return new ArrayList<ArrayList<String>>();
        }
        return result;
    }
    
}

// TODO 
// add record in 'belongs' table when adding a student or else drop 'belongs' table    
// create page to add a new department
// add one page which adds faculty
// remove course_id from course_prereq table? or drop 'has' table (better to drop table 'has')
// get_course_offering_list can be changed to view courses of particular SemYear

// trigger for after update profile of student, if CL or RL changes => bill
// trigger for after enroll if enrolled then change bill
// trigger for after drop if dropped then change bill
// trigget for after approving enrollment request, update current_enrollment in course_offering table

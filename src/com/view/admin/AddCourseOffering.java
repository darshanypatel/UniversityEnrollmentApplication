/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.admin;

import Connection.SQL_Helper;
import dbpro.AdminViewController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yash
 */
public class AddCourseOffering extends javax.swing.JPanel {

    /**
     * Creates new form AddCourseOffering
     */
    public AddCourseOffering() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cIDLabel = new javax.swing.JLabel();
        courseID = new javax.swing.JTextField();
        semLabel = new javax.swing.JLabel();
        sem = new javax.swing.JTextField();
        facultyLabel = new javax.swing.JLabel();
        faculty = new javax.swing.JTextField();
        dayLabel = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        cStartLabel = new javax.swing.JLabel();
        classStart = new javax.swing.JTextField();
        cEndLabel = new javax.swing.JLabel();
        classEnd = new javax.swing.JTextField();
        classSize = new javax.swing.JTextField();
        cSizeLabel = new javax.swing.JLabel();
        wlSizeLabel = new javax.swing.JLabel();
        waitlist = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        showFaculty = new javax.swing.JButton();
        locationLabel = new javax.swing.JLabel();
        location = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        cIDLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cIDLabel.setText("Course Id : ");

        courseID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        semLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        semLabel.setText("Semester :");

        sem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        facultyLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        facultyLabel.setText("Faculty ID(s) :");

        faculty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        dayLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dayLabel.setText("Days of the Week :");

        day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cStartLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cStartLabel.setText("Class Start Time :");

        classStart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cEndLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cEndLabel.setText("Class End Time :");

        classEnd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        classSize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cSizeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cSizeLabel.setText("Class Size :");

        wlSizeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wlSizeLabel.setText("Wait List Size :");

        waitlist.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("Go Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        yearLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        yearLabel.setText("Year :");

        showFaculty.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showFaculty.setText("Show faculty List");
        showFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFacultyActionPerformed(evt);
            }
        });

        locationLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        locationLabel.setText("Class Location :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Add Course Offering");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearLabel)
                                .addGap(18, 18, 18)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cStartLabel)
                                    .addComponent(cSizeLabel)
                                    .addComponent(wlSizeLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(submit)
                                        .addComponent(cEndLabel))
                                    .addComponent(locationLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(back))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(location)
                                            .addComponent(classStart)
                                            .addComponent(classEnd)
                                            .addComponent(classSize)
                                            .addComponent(waitlist, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(semLabel)
                                .addGap(23, 23, 23)
                                .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cIDLabel)
                                .addGap(18, 18, 18)
                                .addComponent(courseID, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(dayLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(day))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(facultyLabel)
                                        .addGap(29, 29, 29)
                                        .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addComponent(showFaculty))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cIDLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semLabel)
                    .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLabel)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facultyLabel)
                    .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showFaculty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayLabel)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cStartLabel)
                    .addComponent(classStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cEndLabel)
                    .addComponent(classEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cSizeLabel))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wlSizeLabel)
                    .addComponent(waitlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(back))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
       AdminViewController.closeAddCourseOffering();
        AdminViewController.showViewAddCourseOffering();
    }//GEN-LAST:event_backActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        ArrayList<Integer> facs=new ArrayList<Integer>();   
        if(faculty.getText().contains(""))
                facs=new ArrayList<Integer>();
        
        else if(faculty.getText().contains(",")){
        
        String fc[]=faculty.getText().split(",");
       
       for(int i=0;i<fc.length;i++)
                facs.add(Integer.parseInt(fc[i].trim()));
       }
        else{
            facs.add(Integer.parseInt(faculty.getText().trim()));
        }
        
        try {
            SQL_Helper.add_course_offering(courseID.getText().trim(),sem.getText().trim(),Integer.parseInt(year.getText().trim()),facs,day.getText().trim(),classStart.getText().trim(),classEnd.getText().trim(),Integer.parseInt(classSize.getText().trim()),Integer.parseInt(waitlist.getText().trim()),location.getText().trim());
        } catch (SQLException ex) {
            Logger.getLogger(AddCourseOffering.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitActionPerformed

    private void showFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFacultyActionPerformed
        // TODO add your handling code here:
        AdminViewController.showViewFaculty();
    }//GEN-LAST:event_showFacultyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel cEndLabel;
    private javax.swing.JLabel cIDLabel;
    private javax.swing.JLabel cSizeLabel;
    private javax.swing.JLabel cStartLabel;
    private javax.swing.JTextField classEnd;
    private javax.swing.JTextField classSize;
    private javax.swing.JTextField classStart;
    private javax.swing.JTextField courseID;
    private javax.swing.JTextField day;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextField faculty;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField location;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField sem;
    private javax.swing.JLabel semLabel;
    private javax.swing.JButton showFaculty;
    private javax.swing.JButton submit;
    private javax.swing.JTextField waitlist;
    private javax.swing.JLabel wlSizeLabel;
    private javax.swing.JTextField year;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.admin;

/**
 *
 * @author Yash
 */
public class AddCourse extends javax.swing.JPanel {

    /**
     * Creates new form AddCourse
     */
    public AddCourse() {
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

        deptLabel = new javax.swing.JLabel();
        dept = new javax.swing.JTextField();
        approvalLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        approval = new javax.swing.JTextField();
        level = new javax.swing.JTextField();
        creditsLabel = new javax.swing.JLabel();
        gpaLabel = new javax.swing.JLabel();
        credits = new javax.swing.JTextField();
        gpa = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        preReqLabel = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        courseIDLabel = new javax.swing.JLabel();
        courseID = new javax.swing.JTextField();
        courseNameLabel = new javax.swing.JLabel();
        courseName = new javax.swing.JTextField();
        preReq = new javax.swing.JTextField();

        deptLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deptLabel.setText("Department Name :");

        dept.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        approvalLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        approvalLabel.setText("Special Approval Required(Y/N) :");

        levelLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        levelLabel.setText("Course Level :");

        approval.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        level.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        creditsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        creditsLabel.setText("Number Of Credits :");

        gpaLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gpaLabel.setText("GPA Requirement(if any) :");

        credits.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        credits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsActionPerformed(evt);
            }
        });

        gpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        submit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        submit.setText("Submit");

        preReqLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        preReqLabel.setText("Enter prerequisite courses :");

        back.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        back.setText("Go Back");

        courseIDLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        courseIDLabel.setText("Course Id :");

        courseID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        courseNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        courseNameLabel.setText("Course Name :");

        courseName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        preReq.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(approvalLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(approval, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(preReqLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(preReq))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(gpaLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(gpa))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(levelLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(deptLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(courseNameLabel)
                                        .addComponent(courseIDLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(courseID, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courseName))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(creditsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(credits, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(submit)
                        .addGap(18, 18, 18)
                        .addComponent(back)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseIDLabel)
                    .addComponent(courseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseNameLabel)
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deptLabel)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelLabel)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gpaLabel)
                    .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preReqLabel)
                    .addComponent(preReq, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approvalLabel)
                    .addComponent(approval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditsLabel)
                    .addComponent(credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(back))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void creditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField approval;
    private javax.swing.JLabel approvalLabel;
    private javax.swing.JButton back;
    private javax.swing.JTextField courseID;
    private javax.swing.JLabel courseIDLabel;
    private javax.swing.JTextField courseName;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JTextField credits;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JTextField dept;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JTextField gpa;
    private javax.swing.JLabel gpaLabel;
    private javax.swing.JTextField level;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField preReq;
    private javax.swing.JLabel preReqLabel;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

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
public class AdminProfile extends javax.swing.JPanel {

    /**
     * Creates new form AdminProfile
     */
    public AdminProfile() {
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

        profileLabel = new javax.swing.JLabel();
        fNameabel = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        lNameabel = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        eidLabel = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        profileLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        profileLabel.setForeground(new java.awt.Color(51, 0, 153));
        profileLabel.setText("My Profile");

        fNameabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fNameabel.setForeground(new java.awt.Color(0, 0, 153));
        fNameabel.setText("First Name : ");

        fName.setEditable(false);
        fName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fName.setText("First Name");

        lNameabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lNameabel.setForeground(new java.awt.Color(0, 0, 153));
        lNameabel.setText("Last Name :");

        lName.setEditable(false);
        lName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lName.setText("Last Name");

        dobLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(0, 0, 153));
        dobLabel.setText("D.O.B :");

        dob.setEditable(false);
        dob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dob.setText("DOB");

        eidLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eidLabel.setForeground(new java.awt.Color(0, 0, 153));
        eidLabel.setText("Employee Id :");

        eid.setEditable(false);
        eid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        eid.setText("EID");

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(0, 51, 153));
        back.setText("Go Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fNameabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lNameabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2))
                                .addComponent(eidLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(back)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fNameabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNameabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(back)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField dob;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField eid;
    private javax.swing.JLabel eidLabel;
    private javax.swing.JTextField fName;
    private javax.swing.JLabel fNameabel;
    private javax.swing.JTextField lName;
    private javax.swing.JLabel lNameabel;
    private javax.swing.JLabel profileLabel;
    // End of variables declaration//GEN-END:variables
}

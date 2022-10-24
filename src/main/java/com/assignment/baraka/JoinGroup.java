
package com.assignment.baraka;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;


public class JoinGroup extends javax.swing.JFrame {
           PreparedStatement pst;
       
//           MutableComboBoxModel model = (DefaultComboBoxModel)box.getModel();
   
    public JoinGroup() {
        initComponents();
        populateComboBox();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        groupsCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose a Group");

        groupsCombo.setEditable(true);
        groupsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(groupsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(groupsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsComboActionPerformed
        JOptionPane.showMessageDialog(this, "You have selected");
          
    }//GEN-LAST:event_groupsComboActionPerformed
        
    
    public void populateComboBox (){
        try {
          String sql = "select GroupName from MemberGrps";
           Statement stm =Database.mycon().createStatement();
           ResultSet rs = stm.executeQuery(sql);
           
           while(rs.next()){
               String GrpName = rs.getString("GroupName");
//      
                 groupsCombo.addItem(GrpName);

           }
           
           
            
          }catch (Exception ex) {
              Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JoinGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> groupsCombo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

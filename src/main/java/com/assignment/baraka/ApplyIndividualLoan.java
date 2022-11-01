/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assignment.baraka;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author fiona
 */
public class ApplyIndividualLoan extends javax.swing.JInternalFrame {
    PreparedStatement pst;
    double loanInterest ;
    
    public ApplyIndividualLoan() {
        initComponents();
    }
    
    public double calculateInterest(){
        int loanAmount= Integer.parseInt(txtAmount.getText());
            int  payPeriod = Integer.parseInt(txtPayPeriod.getText()) ;

        if(payPeriod <= 36){
            loanInterest = loanAmount - (1.2 * loanAmount*payPeriod);
            return loanInterest;
        }else if(payPeriod<=48){
            loanInterest = loanAmount -(1 * loanAmount*payPeriod);
            return loanInterest;
    }else{
         loanInterest =loanAmount - (0.8 * loanAmount*payPeriod);
           return loanInterest;
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAmount = new javax.swing.JTextField();
        txtPayPeriod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Amount");

        jLabel2.setText("Payment Period");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAmount)
                            .addComponent(txtPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String amount =txtAmount.getText();
       int payDuration = Integer.parseInt(txtPayPeriod.getText());
       int LoanAmount =Integer.parseInt(amount);
       loanInterest= calculateInterest();
       Date date =  new Date();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd ");  
        String dateToString = dateFormat.format(date);
//        java.sql.Date dateDB = new java.sql.Date(dateToString)
        try{
          pst = Database.mycon().prepareStatement("insert into Loans (LoanAmount,DurationOfPayment,LoanInterest)values(?,?,?)");
          pst.setInt(1,LoanAmount );
//          pst.setString(2, dateToString);
          pst.setInt(2, payDuration);
          pst.setDouble(3,loanInterest);
          pst.executeUpdate();
          
          JOptionPane.showMessageDialog(this, "You have successfully applied for a loan");
          dispose();
      }catch(Exception ex){
        ex.printStackTrace();
    }
      
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtPayPeriod;
    // End of variables declaration//GEN-END:variables
}

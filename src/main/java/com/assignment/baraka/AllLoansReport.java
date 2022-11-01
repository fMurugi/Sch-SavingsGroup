/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.assignment.baraka;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fiona
 */
public class AllLoansReport extends javax.swing.JInternalFrame {

    /**
     * Creates new form AllLoansReport
     */
    public AllLoansReport() {
        initComponents();
        fillTable();
    }

    public  void fillTable(){
        String LoanId ;
        String LoanDate ;
        String LoanAmount ;
        String DurationOfPayment;
        String LoanStatus;
        String LoanPenalty;
        String LoanInterest;
        try{
       
          String sql = "select * from Loans";
           Statement stm =Database.mycon().createStatement();
           ResultSet rs = stm.executeQuery(sql);
           System.out.println(rs);  

        while(rs.next()){
            LoanId = rs.getString("LoanId");
            LoanDate = rs.getString("LoanDate");
            LoanAmount =  rs.getString("LoanAmount");
            DurationOfPayment = rs.getString("DurationOfPayment");
            LoanStatus = rs.getString("LoanStatus");
            LoanPenalty = rs.getString("LoanPenalty");
            LoanInterest = rs.getString("LoanInterest");
            String tbData[]= {LoanId,LoanDate,LoanAmount,};
             DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
             model.addRow(tbData);

       
        }
      }catch(Exception e){
    e.printStackTrace();
   }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("All Loans"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LoanId", "LoanDate", "LoanAmount", "DurationOfPayment", "oanStatus", "LoanPenalty", "LoanInterest"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

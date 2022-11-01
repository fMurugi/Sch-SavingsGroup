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
public class AllGroupsReport extends javax.swing.JInternalFrame {

    /**
     * Creates new form AllGroupsReport
     */
    public AllGroupsReport() {
        initComponents();
        fillTable();
    }

    public  void fillTable(){
        String GroupId ="";
        String GroupName = "";
        String RegFee ;
        try{
       
          String sql = "select * from MemberGrps";
           Statement stm =Database.mycon().createStatement();
           ResultSet rs = stm.executeQuery(sql);
           System.out.println(rs);  

        while(rs.next()){
            GroupId = rs.getString("GroupId");
            GroupName = rs.getString("GroupName");
            RegFee =  rs.getString("RegistrtionFees");
            String tbData[]= {GroupId,GroupName,RegFee};
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GroupId", "GroupName", "RegFee", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

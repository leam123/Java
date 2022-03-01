/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oop.project.applet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.oop.project.connect.DatabaseConnect;
import org.oop.project.entity.Department;
import org.oop.project.interfaces.AccountInterface;

/**
 *
 * @author Garcia
 */
public class AddDepartment extends javax.swing.JFrame implements AccountInterface{
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String query;
    
    /**
     * Creates new form AddDepartment
     * @throws java.sql.SQLException
     */
    public AddDepartment() throws SQLException{
        initComponents();
        showList();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Department> allList() throws SQLException{
        ArrayList<Department> list = new ArrayList<Department>();
        Department dept = new Department();
        query = "SELECT * FROM department";
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(query);
        
        while(result.next()){
            dept = new Department(result.getInt("id"),result.getString("departmentName"));
            list.add(dept);
        }
        
        return list;
    }
    
    /**
     *
     * @throws SQLException
     */
    @Override
    public void showList() throws SQLException{
        ArrayList<Department> arraylist = allList();
        DefaultTableModel model = (DefaultTableModel) deptTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getId();
            row[1] = arraylist.get(i).getName();
            
            model.addRow(row);
        }
    }
    
    /**
     *
     * @param f
     * @param l
     * @param m
     * @param u
     * @param p
     * @param t
     * @throws SQLException
     */
    @Override
    public void add(String f,String l,String m,String u,String p,String t) throws SQLException{
        query = "INSERT INTO department (departmentName)"
                + "VALUES (?)";
        
        ps = connect.prepareStatement(query);
        ps.setString(1,f);
        ps.execute();
        showList();
    }
    
    /**
     *
     * @throws SQLException
     */
    @Override
    public void displayTf() throws SQLException{
        int index = deptTable.getSelectedRow();
        String tableClick = (deptTable.getModel().getValueAt(index, 0).toString());
        query = "SELECT * FROM department WHERE id='"+tableClick+"' ";
        
        ps = connect.prepareStatement(query);
        result = ps.executeQuery();
        if(result.next()){
            String i = result.getString("id");
            idTf.setText(i);
            String f = result.getString("departmentName");
            deptTf.setText(f);
        }
    }
    
    /**
     *
     * @param i
     * @param f
     * @param m
     * @param l
     * @param u
     * @param p
     * @param t
     * @throws SQLException
     */
    @Override
    public void update(String i, String f,String m,String l,String u,String p,String t) throws SQLException{
        query = "UPDATE department SET departmentName = ? WHERE id = ?";
        
        ps = connect.prepareStatement(query);
        ps.setString(1,f);
        ps.setString(2,i);
        
        ps.executeUpdate();
        showList();
    }
    
    /**
     *
     * @param str
     * @throws SQLException
     */
    @Override
    public void delete(String str) throws SQLException{
        query = "DELETE FROM department WHERE departmentName=?";
        
        ps = connect.prepareStatement(query);
        ps.setString(1,str);

        ps.executeUpdate();
        showList();
    }
    
    /**
     *
     * @param u
     * @return
     * @throws SQLException
     */
    @Override
    public boolean search(String u) throws SQLException{
        boolean ok = false;
        query = "SELECT departmentName FROM department WHERE departmentName = ?";

        ps = connect.prepareStatement(query);
        ps.setString(1,u);
        result = ps.executeQuery();
        
        while(result.next()){
            ok = true;
        }
        return ok;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        departments = new javax.swing.JLabel();
        deptLabel = new javax.swing.JLabel();
        deptTf = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        deptTable = new javax.swing.JTable();
        back = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(125, 0, 0));

        departments.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        departments.setForeground(new java.awt.Color(225, 225, 0));
        departments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        departments.setText("DEPARTMENTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(departments, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(departments, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        deptLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deptLabel.setText("Department");

        add.setBackground(new java.awt.Color(51, 102, 255));
        add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(51, 102, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(51, 102, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        deptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Department_Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deptTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deptTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(deptTable);
        if (deptTable.getColumnModel().getColumnCount() > 0) {
            deptTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setText("Go Back ->");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idLabel.setText("ID");

        idTf.setEditable(false);
        idTf.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(deptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(deptTf, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 69, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deptTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deptTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deptTableMouseClicked
        try {
            displayTf();
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deptTableMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String st1 = deptTf.getText();
        try {
            if(search(st1)==true){
               JOptionPane.showMessageDialog(null,"Department already exist.");
            }else{
                add(st1,null,null,null,null,null);
                deptTf.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String st1 = deptTf.getText();
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete department: " + st1, "Delete", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            try {
                delete(st1);
                idTf.setText("");
                deptTf.setText("");
                JOptionPane.showMessageDialog(null, "Department Deleted.");
            } catch (SQLException ex) {
                Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //statement
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String st = idTf.getText();
        String st1 = deptTf.getText();
        try {
            update(st,st1,null,null,null,null,null);
            idTf.setText("");
            deptTf.setText("");
            JOptionPane.showMessageDialog(null,"Department Updated.");
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddDepartment().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddDepartment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel departments;
    private javax.swing.JLabel deptLabel;
    public static javax.swing.JTable deptTable;
    private javax.swing.JTextField deptTf;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
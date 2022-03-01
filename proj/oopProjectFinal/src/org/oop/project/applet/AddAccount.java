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
import org.oop.project.entity.Account;
import org.oop.project.interfaces.AccountInterface;

/**
 *
 * @author Garcia
 */
public class AddAccount extends javax.swing.JFrame implements AccountInterface{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String query;
    
    /**
     * Creates new form AddAccount
     * @throws java.sql.SQLException
     */
    public AddAccount() throws SQLException{
        initComponents();
        showList();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Account> allList() throws SQLException{
        ArrayList<Account> list = new ArrayList<>();
        Account acc = new Account();
        query = "SELECT * FROM account";
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(query);

        while(result.next()){
            acc = new Account(result.getInt("id"),result.getString("firstName"),result.getString("middleName"),result.getString("lastName"),result.getString("username"),result.getString("password"),result.getString("type"));
            list.add(acc);
        }
        return list;
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void showList() throws SQLException{
        ArrayList<Account> arraylist = allList();
        DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getId();
            row[1] = arraylist.get(i).getFirst_name();
            row[2] = arraylist.get(i).getMiddle_name();
            row[3] = arraylist.get(i).getLast_name();
            row[4] = arraylist.get(i).getUsername();
            row[5] = arraylist.get(i).getPassword();
            row[6] = arraylist.get(i).getType();

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
        query = "INSERT INTO account (firstName,lastName,middleName,username,password,type)"
                + "VALUES (?,?,?,?,?,?)";

        ps = connect.prepareStatement(query);
        ps.setString(1,f);
        ps.setString(2,l);
        ps.setString(3,m);
        ps.setString(4,u);
        ps.setString(5,p);
        ps.setString(6,t);

        ps.execute();
        showList();
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void displayTf() throws SQLException{
        int index = accountTable.getSelectedRow();
        String tableClick = (accountTable.getModel().getValueAt(index, 0).toString());
        query = "SELECT * FROM account WHERE id='"+tableClick+"' ";

        ps = connect.prepareStatement(query);
        result = ps.executeQuery();
        if(result.next()){
            String i = result.getString("id");
            idTf.setText(i);
            String f = result.getString("firstName");
            firstName.setText(f);
            String m = result.getString("middleName");
            middleName.setText(m);
            String l = result.getString("lastName");
            lastName.setText(l);
            String u = result.getString("username");
            userName.setText(u);
            String p = result.getString("password");
            password.setText(p);
            String type = result.getString("type");
                if(type.equalsIgnoreCase("Student")){
                    student.setSelected(true);
                    faculty.setSelected(false);
                    admin.setSelected(false);
                }else if(type.equalsIgnoreCase("Faculty")){
                    student.setSelected(false);
                    faculty.setSelected(true);
                    admin.setSelected(false);
                }else if(type.equalsIgnoreCase("Admin")){
                    student.setSelected(false);
                    faculty.setSelected(false);
                    admin.setSelected(true);
                }
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
        query = "UPDATE account SET firstName=?,middleName=?,lastName=?,username=?,password=?,type=? WHERE id=?";

        ps = connect.prepareStatement(query);
        ps.setString(1,f);
        ps.setString(2,m);
        ps.setString(3,l);
        ps.setString(4,u);
        ps.setString(5,p);
        ps.setString(6,t);

        ps.setString(7,i);

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
        query = "DELETE FROM account WHERE username=?";

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
        query = "SELECT username FROM account WHERE username = ?";

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
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        accountLabel = new javax.swing.JLabel();
        fnameLabel = new javax.swing.JLabel();
        mnameLabel = new javax.swing.JLabel();
        lnameLabel = new javax.swing.JLabel();
        unameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        middleName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        student = new javax.swing.JRadioButton();
        faculty = new javax.swing.JRadioButton();
        admin = new javax.swing.JRadioButton();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        userName = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        idTf = new javax.swing.JTextField();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Last_Name", "Password", "Username", "First_Name", "Middle_Name", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);

        jPanel3.setBackground(new java.awt.Color(125, 0, 0));

        accountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        accountLabel.setForeground(new java.awt.Color(225, 225, 0));
        accountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountLabel.setText("ACCOUNTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(accountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fnameLabel.setText("First Name");

        mnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mnameLabel.setText("Middle Name");

        lnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lnameLabel.setText("Last Name");

        unameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        unameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        passwordLabel.setText("Password");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeLabel.setText("Type");

        student.setText("Student");

        faculty.setText("Faculty");

        admin.setText("Admin");

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

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idLabel.setText("ID");

        idTf.setEditable(false);
        idTf.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(student, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(faculty, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(218, 218, 218))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(middleName))
                                        .addGap(90, 90, 90)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(158, 158, 158))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middleName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(student, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(faculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setText("Go Back ->");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       String st1 = firstName.getText();
       String st2 = lastName.getText();
       String st3 = middleName.getText();
       String st4 = userName.getText();
       String st5 = password.getText();
       String st6 = type();
        try {
            if(search(st4)==true){
               JOptionPane.showMessageDialog(null,"Account already exist.");
            }else{
                add(st1,st2,st3,st4,st5,st6);
                idTf.setText("");
                firstName.setText("");
                lastName.setText("");
                middleName.setText("");
                userName.setText("");
                password.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       String st = idTf.getText();
       String st1 = firstName.getText();
       String st2 = lastName.getText();
       String st3 = middleName.getText();
       String st4 = userName.getText();
       String st5 = password.getText();
       String st6 = type();
        try {
            update(st,st1,st3,st2,st4,st5,st6);
            idTf.setText("");
            firstName.setText("");
            lastName.setText("");
            middleName.setText("");
            userName.setText("");
            password.setText("");
            JOptionPane.showMessageDialog(null,"Account Updated.");
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
        try {
            displayTf();
        } catch (SQLException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_accountTableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       String st4 = userName.getText();
       int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete account with the username: " + st4, "Delete", JOptionPane.YES_NO_OPTION);
       if(choice == JOptionPane.YES_OPTION){
            try {
                 delete(st4);
                 idTf.setText("");
                 firstName.setText("");
                 lastName.setText("");
                 middleName.setText("");
                 userName.setText("");
                 password.setText("");
                 JOptionPane.showMessageDialog(null,"Account Deleted.");
            } catch (SQLException ex) {
                 Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           //statement
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    public String type(){
        String type = null;
        if(student.isSelected()){
            type = "Student";
        }else if(faculty.isSelected()){
            type = "Faculty";
        }else if(admin.isSelected()){
            type = "Admin";
        }
        return type;
    }
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
            java.util.logging.Logger.getLogger(AddAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddAccount().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JTable accountTable;
    private javax.swing.JButton add;
    private javax.swing.JRadioButton admin;
    private javax.swing.JLabel back;
    private javax.swing.JButton delete;
    private javax.swing.JRadioButton faculty;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel fnameLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lnameLabel;
    private javax.swing.JTextField middleName;
    private javax.swing.JLabel mnameLabel;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JRadioButton student;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel unameLabel;
    private javax.swing.JButton update;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}

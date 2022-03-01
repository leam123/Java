/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oop.project.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.oop.project.applet.Ask;
import org.oop.project.applet.Homepage;
import org.oop.project.applet.Login;
import org.oop.project.connect.DatabaseConnect;
import org.oop.project.entity.Answer;
import org.oop.project.entity.Post;
import org.oop.project.entity.Reply;
import org.oop.project.interfaces.PostInterface;

/**
 *
 * @author Garcia
 */
public class Userpage extends javax.swing.JFrame implements PostInterface{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String query;
    
    /**
     * Creates new form Userpage
     * @throws java.sql.SQLException
     */
    public Userpage() throws SQLException {
        initComponents();
        connectDatabase();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    /**
     *
     * @param f
     * @return
     * @throws SQLException
     */
    @Override
    public boolean search(String f) throws SQLException{
        boolean ok = false;
        query = "SELECT * FROM account WHERE username=?";

        ps = connect.prepareStatement(query);
        ps.setString(1,f);
        result = ps.executeQuery();
        
        while(result.next()){
            type.setText(result.getString("type"));
            id.setText(result.getString("id"));
            name.setText(result.getString("firstName") + " " + result.getString("middleName") + " " + result.getString("lastName"));
            ok = true;
        }
        return ok;
    }
    
    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Post> deptList(String id) throws SQLException{
        ArrayList<Post> list = new ArrayList<Post>();
        Post post = new Post();
        query = "SELECT *, firstName FROM post,account WHERE acc_id = ? AND account.id = post.acc_id";
        connect = new DatabaseConnect().getConnection(); 
        ps = connect.prepareStatement(query);
        ps.setString(1,id);
        result = ps.executeQuery();

        while(result.next()){
            post = new Post(result.getString("title"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"),result.getString("firstName"));
            list.add(post);
        }
        return list;
    }
   
    /**
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void showDeptList(String id) throws SQLException{
        ArrayList<Post> arraylist = deptList(id);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getTitle();
            row[1] = arraylist.get(i).getDateUploaded();
            row[2] = arraylist.get(i).getVotes();
            row[3] = arraylist.get(i).getTag();
            
            model.addRow(row);
        }
    }
    
    public void connectDatabase() throws SQLException{
        query = "SELECT title, dateUploaded, votes FROM post";
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(query);
        
        while(result.next()){
           String str = Login.userName.getText();
            if(search(str)==true){
               String s = id.getText();
               showDeptList(s);
               postCount();
           }
        }
        
        if(result!=null){
           result.close();
        }if(statement!=null){
            statement.close();
        }if(connect!=null){
            connect.close();
        }
    }
    
    
    @Override
    public ArrayList<Reply> postList() throws SQLException {
        ArrayList<Reply> list = new ArrayList<Reply>();
        Reply rep = new Reply();
        query = "SELECT * FROM reply";
        connect = new DatabaseConnect().getConnection(); 
        statement = connect.createStatement();
        result = statement.executeQuery(query);

        while(result.next()){
            rep = new Reply(result.getString("title"),result.getString("body"),result.getDate("dateReplied"));
            list.add(rep);
        }
        return list;
    }
    @Override
    public void showList() throws SQLException {
        ArrayList<Reply> arraylist = postList();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getTitle();
            row[1] = arraylist.get(i).getBody();
            row[2] = arraylist.get(i).getDateReplied();

            model.addRow(row);
        }
        table.getColumnModel().getColumn(0).setHeaderValue("Title");
        table.getColumnModel().getColumn(1).setHeaderValue("Body");
        table.getColumnModel().getColumn(2).setHeaderValue("Date Replied");
    }
    
    @Override
    public ArrayList<Answer> sortList(String query) throws SQLException {
        ArrayList<Answer> list = new ArrayList<Answer>();
        Answer ans = new Answer();
        query = "SELECT * FROM answer";
        connect = new DatabaseConnect().getConnection(); 
        statement = connect.createStatement();
        result = statement.executeQuery(query);

        while(result.next()){
            ans = new Answer(result.getString("body"),result.getDate("dateAnswered"),result.getInt("votes"));
            list.add(ans);
        }
        return list;
    }
    @Override
    public void sortDeptList(String query) throws SQLException {
        ArrayList<Answer> arraylist = sortList(null);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getBody();
            row[1] = arraylist.get(i).getDateAnswered();
            row[2] = arraylist.get(i).getVotes();

            model.addRow(row);
        }
        table.getColumnModel().getColumn(0).setHeaderValue("Body");
        table.getColumnModel().getColumn(1).setHeaderValue("Date Answered");
        table.getColumnModel().getColumn(2).setHeaderValue("Votes");
    }
    
    public void postCount() throws SQLException{
       int count = table.getRowCount();
       postCount.setText(String.valueOf(count));
       replyCount.setText("");
       answerCount.setText("");
    }
    public void replyCount() throws SQLException{
       int count = table.getRowCount();
       replyCount.setText(String.valueOf(count));
       postCount.setText("");
       answerCount.setText("");
    }
    public void answerCount() throws SQLException{
       int count = table.getRowCount();
       answerCount.setText(String.valueOf(count));
       postCount.setText("");
       replyCount.setText("");
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
        jPanel21 = new javax.swing.JPanel();
        userpage = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        ask = new javax.swing.JTextField();
        chatbot = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        accLabel = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        postLabel = new javax.swing.JLabel();
        replyLabel = new javax.swing.JLabel();
        ansLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pCount = new javax.swing.JLabel();
        postCount = new javax.swing.JTextField();
        rCount = new javax.swing.JLabel();
        replyCount = new javax.swing.JTextField();
        aCount = new javax.swing.JLabel();
        answerCount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel21.setBackground(new java.awt.Color(125, 0, 0));
        jPanel21.setForeground(new java.awt.Color(225, 225, 0));
        jPanel21.setDoubleBuffered(false);
        jPanel21.setEnabled(false);
        jPanel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        userpage.setBackground(new java.awt.Color(125, 0, 0));
        userpage.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userpage.setForeground(new java.awt.Color(225, 225, 0));
        userpage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userpage.setText("USERPAGE");
        userpage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userpage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profile", "Homepage", "Log-out" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        ask.setEditable(false);
        ask.setBackground(new java.awt.Color(125, 0, 0));
        ask.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ask.setForeground(new java.awt.Color(225, 225, 0));
        ask.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ask.setText("ASK");
        ask.setToolTipText("");
        ask.setBorder(null);
        ask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                askMouseClicked(evt);
            }
        });

        chatbot.setEditable(false);
        chatbot.setBackground(new java.awt.Color(125, 0, 0));
        chatbot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chatbot.setForeground(new java.awt.Color(225, 225, 0));
        chatbot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        chatbot.setText("CHATBOT");
        chatbot.setToolTipText("");
        chatbot.setBorder(null);
        chatbot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatbotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userpage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                .addComponent(ask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(chatbot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chatbot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userpage))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name:");

        typeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeLabel.setText("Type: ");

        edit.setBackground(new java.awt.Color(51, 102, 255));
        edit.setText("Edit Profile");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        name.setEditable(false);
        name.setBackground(new java.awt.Color(204, 204, 204));
        name.setText("    ");
        name.setBorder(null);

        id.setEditable(false);
        id.setBackground(new java.awt.Color(204, 204, 204));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setBorder(null);

        accLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accLabel.setText("Acc. ID:");

        type.setEditable(false);
        type.setBackground(new java.awt.Color(204, 204, 204));
        type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        type.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(accLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        postLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        postLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        postLabel.setText("POSTS");
        postLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postLabelMouseClicked(evt);
            }
        });

        replyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        replyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        replyLabel.setText("REPLIES");
        replyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replyLabelMouseClicked(evt);
            }
        });

        ansLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ansLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ansLabel.setText("ANSWERS");
        ansLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ansLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ansLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(replyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(ansLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Date Uploaded", "Votes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(250);
            table.getColumnModel().getColumn(2).setPreferredWidth(25);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        pCount.setText("Post count:");

        postCount.setEditable(false);
        postCount.setBackground(new java.awt.Color(204, 204, 204));
        postCount.setText("   ");

        rCount.setText("Reply count:");

        replyCount.setEditable(false);
        replyCount.setBackground(new java.awt.Color(204, 204, 204));
        replyCount.setText("   ");

        aCount.setText("Answer count:");

        answerCount.setEditable(false);
        answerCount.setBackground(new java.awt.Color(204, 204, 204));
        answerCount.setText("   ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postCount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(rCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(aCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerCount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pCount)
                    .addComponent(postCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rCount)
                    .addComponent(replyCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aCount)
                    .addComponent(answerCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        if(comboBox.getSelectedItem().equals("Homepage")){
            try {
                new Homepage().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(comboBox.getSelectedItem().equals("Profile")){
            try {
                new Userpage().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(comboBox.getSelectedItem().equals("Log-out")){
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_comboBoxActionPerformed

    private void askMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_askMouseClicked
       try {
            new Ask().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_askMouseClicked

    private void chatbotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatbotMouseClicked
        //chatbot code in here......
    }//GEN-LAST:event_chatbotMouseClicked

    private void postLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postLabelMouseClicked
        try {
            connectDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_postLabelMouseClicked

    private void replyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replyLabelMouseClicked
        try {
            showList();
            replyCount();
        } catch (SQLException ex) {
            Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_replyLabelMouseClicked

    private void ansLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ansLabelMouseClicked
        try {
            sortDeptList(null);
            answerCount();
        } catch (SQLException ex) {
            Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ansLabelMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            new Edit().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_editActionPerformed

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
            java.util.logging.Logger.getLogger(Userpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Userpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Userpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Userpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Userpage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Userpage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aCount;
    private javax.swing.JLabel accLabel;
    private javax.swing.JLabel ansLabel;
    private javax.swing.JTextField answerCount;
    private javax.swing.JTextField ask;
    private javax.swing.JTextField chatbot;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton edit;
    private javax.swing.JTextField id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel pCount;
    private javax.swing.JTextField postCount;
    private javax.swing.JLabel postLabel;
    private javax.swing.JLabel rCount;
    private javax.swing.JTextField replyCount;
    private javax.swing.JLabel replyLabel;
    private javax.swing.JTable table;
    private javax.swing.JTextField type;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel userpage;
    // End of variables declaration//GEN-END:variables

    
    
    @Override
    public void sort(String str) throws SQLException {}
    @Override
    public void postByDepartment(String dep) throws SQLException {}
    @Override
    public void postByPopular() throws SQLException {}
    @Override
    public void postByOldest() throws SQLException {}
    @Override
    public void postByNewest() throws SQLException {}

}

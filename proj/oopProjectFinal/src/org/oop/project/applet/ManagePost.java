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
import org.oop.project.entity.Post;
import org.oop.project.interfaces.PostInterface;

/**
 *
 * @author Garcia
 */
public class ManagePost extends javax.swing.JFrame implements PostInterface{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    private ResultSet result = null;
    
    private String query;
    /**
     * Creates new form ManagePost
     * @throws java.sql.SQLException
     */
    public ManagePost() throws SQLException {
        initComponents();
        showList();
    }

    @Override
    public ArrayList<Post> postList() throws SQLException{
        ArrayList<Post> list = new ArrayList<>();
        Post post = new Post();
        query = "SELECT id, title, body, dateCreated, dateUploaded, votes, tag FROM post";
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(query);
        
        while(result.next()){
            post = new Post(result.getInt("id"),result.getString("title"),result.getString("body"),result.getDate("dateCreated"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"));
            list.add(post);
        }
        
        return list;
    }
    
    /**
     *
     * @throws SQLException
     */
    @Override
    public void showList() throws SQLException{
        ArrayList<Post> arraylist = postList();
        DefaultTableModel model = (DefaultTableModel) postsTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getId();
            row[1] = arraylist.get(i).getTitle();
            row[2] = arraylist.get(i).getBody();
            row[3] = arraylist.get(i).getDateCreated();
            row[4] = arraylist.get(i).getDateUploaded();
            row[5] = arraylist.get(i).getVotes();
            row[6] = arraylist.get(i).getTag();
            
            model.addRow(row);
        }
    }
    
     public void deletePost(String str) throws SQLException{
        query = "DELETE FROM post WHERE id=?";
        ps = connect.prepareStatement(query);
        ps.setString(1, str);
        ps.executeUpdate();
        showList();
    }
    
    //sort method
    /**
     *
     * @param str
     * @throws SQLException
     */
    @Override
    public void sort(String str) throws SQLException{
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(str);
        
        while(result.next()){
           sortDeptList(str); 
        }
        //close the connection
        if(result!=null){
            result.close();
        }if(statement!=null){
            statement.close();
        }if(connect!=null){
            connect.close();
        }
    }
    
    @Override
    public ArrayList<Post> sortList(String query) throws SQLException{
        ArrayList<Post> list = new ArrayList<Post>();
        Post post = new Post();
        connect = new DatabaseConnect().getConnection(); 
        statement = connect.createStatement();
        result = statement.executeQuery(query);

        while(result.next()){
            post = new Post(result.getInt("id"),result.getString("title"),result.getString("body"),result.getDate("dateCreated"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"));
            list.add(post);
        }
        return list;
    }
    
    @Override
    public void sortDeptList(String query) throws SQLException{
        ArrayList<Post> arraylist = sortList(query);
        DefaultTableModel model = (DefaultTableModel) postsTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getId();
            row[1] = arraylist.get(i).getTitle();
            row[2] = arraylist.get(i).getBody();
            row[3] = arraylist.get(i).getDateCreated();
            row[4] = arraylist.get(i).getDateUploaded();
            row[5] = arraylist.get(i).getVotes();
            row[6] = arraylist.get(i).getTag();
            
            model.addRow(row);
        }
    }
    
    //Sort the post
    /**
     *
     * @throws SQLException
     */
   @Override
    public void postByPopular() throws SQLException{
        query = "SELECT id, title, body, dateCreated, dateUploaded, votes, tag FROM post ORDER BY votes DESC";
        sort(query);
    }
    @Override
    public void postByOldest() throws SQLException{
        query = "SELECT id, title, body, dateCreated, dateUploaded, votes, tag FROM post ORDER BY dateUploaded ASC";
        sort(query);
    }
    @Override
    public void postByNewest() throws SQLException{
        query = "SELECT id, title, body, dateCreated, dateUploaded, votes, tag FROM post ORDER BY dateUploaded DESC";
        sort(query);
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
        postsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        postLabel = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        popular = new javax.swing.JButton();
        newest = new javax.swing.JButton();
        oldest = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        postsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Body", "Date_Created", "Date_Uploaded", "Votes", "Tag/s"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        postsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(postsTable);
        if (postsTable.getColumnModel().getColumnCount() > 0) {
            postsTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            postsTable.getColumnModel().getColumn(5).setPreferredWidth(25);
        }

        jPanel3.setBackground(new java.awt.Color(125, 0, 0));

        postLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        postLabel.setForeground(new java.awt.Color(225, 225, 0));
        postLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        postLabel.setText("POSTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(postLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        delete.setBackground(new java.awt.Color(51, 102, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        popular.setBackground(new java.awt.Color(51, 102, 255));
        popular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        popular.setText("Popular");
        popular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popularActionPerformed(evt);
            }
        });

        newest.setBackground(new java.awt.Color(51, 102, 255));
        newest.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        newest.setText("Newest");
        newest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newestActionPerformed(evt);
            }
        });

        oldest.setBackground(new java.awt.Color(51, 102, 255));
        oldest.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        oldest.setText("Oldest");
        oldest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldestActionPerformed(evt);
            }
        });

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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newest, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(oldest, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oldest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
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

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) postsTable.getModel();
        int row = postsTable.getSelectedRow();
        String str = postsTable.getModel().getValueAt(row, 0).toString();
        
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete post?" + str, "Delete", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            try {
                deletePost(str);
            } catch (SQLException ex) {
                Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //statement
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void popularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popularActionPerformed
        try {
            postByPopular();
        } catch (SQLException ex) {
            Logger.getLogger(ManagePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_popularActionPerformed

    private void newestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newestActionPerformed
        try {
            postByNewest();
        } catch (SQLException ex) {
            Logger.getLogger(ManagePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newestActionPerformed

    private void oldestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldestActionPerformed
       try {
            postByOldest();
        } catch (SQLException ex) {
            Logger.getLogger(ManagePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldestActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void postsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_postsTableMouseClicked

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
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagePost().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePost.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton delete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newest;
    private javax.swing.JButton oldest;
    private javax.swing.JButton popular;
    private javax.swing.JLabel postLabel;
    private javax.swing.JTable postsTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean search(String u) throws SQLException {
        return false;
    }
    @Override
    public ArrayList<?> deptList(String dep) throws SQLException {
        return null;
    }
    @Override
    public void showDeptList(String dep) throws SQLException {}
    @Override
    public void postByDepartment(String dep) throws SQLException {}
}

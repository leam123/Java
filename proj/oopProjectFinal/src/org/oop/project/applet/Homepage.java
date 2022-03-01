package org.oop.project.applet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.oop.project.connect.DatabaseConnect;
import org.oop.project.entity.Post;
import org.oop.project.interfaces.PostInterface;
import org.oop.project.user.Userpage;

/**
 *
 * @author Garcia, Leamor T.
 * date: February 2020
 */
public final class Homepage extends javax.swing.JFrame implements PostInterface{

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement ps = null;
    private ResultSet result = null;
    private String query;
    
    /**
     * Creates new form Homepage
     * @throws java.sql.SQLException
     */
    public Homepage() throws SQLException {
        initComponents();
        connectDatabase();
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
        query = "SELECT firstname, middleName, lastName, username FROM account WHERE username = ?";

        ps = connect.prepareStatement(query);
        ps.setString(1,u);
        result = ps.executeQuery();
        
        while(result.next()){
            user.setText(result.getString("firstName") + " " + result.getString("middleName") + " " + result.getString("lastName"));
            ok = true;
        }
        return ok;
    }
    
    //for the homepage to display all post without clicking any department yet
    @Override
    public ArrayList<Post> postList() throws SQLException{
        ArrayList<Post> list = new ArrayList<>();
        Post post = new Post();
        query = "SELECT title, dateUploaded, votes, tag, firstName, lastName FROM post, account WHERE post.acc_id = account.id";
        connect = new DatabaseConnect().getConnection();
        statement = connect.createStatement();
        result = statement.executeQuery(query);

        while(result.next()){
            post = new Post(result.getString("title"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"),result.getString("firstName"));
            list.add(post);
        }
        return list;
    }
    
    @Override
    public void showList() throws SQLException{
        ArrayList<Post> arraylist = postList();
        DefaultTableModel model = (DefaultTableModel) postTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for(int i=0;i<arraylist.size();i++){
            row[0] = arraylist.get(i).getTitle();
            row[1] = arraylist.get(i).getDateUploaded();
            row[2] = arraylist.get(i).getVotes();
            row[3] = arraylist.get(i).getTag();
            row[4] = arraylist.get(i).getPostName();
            
            model.addRow(row);
        }
    }
    
    //display all post on homepage
    public void connectDatabase() throws SQLException{
        query = "SELECT title, dateUploaded, votes, tag FROM post";
        //create connection
        connect = new DatabaseConnect().getConnection();
        //create statement
        statement = connect.createStatement();
        //execute a query
        result = statement.executeQuery(query);
        
        //process the result
        while(result.next()){
            //won't run if not logged in an account
            String str = Login.userName.getText();
            if(search(str)==true){
                showList();
            }
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
   
   
    //to display posts belonging to a certain department
    /**
     *
     * @param dep
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Post> deptList(String dep) throws SQLException{
        ArrayList<Post> list = new ArrayList<Post>();
        Post post = new Post();
        query = "SELECT title, dateUploaded, votes, tag, firstName FROM post, account WHERE dept_id = ? AND post.acc_id = account.id";
        connect = new DatabaseConnect().getConnection(); 
        ps = connect.prepareStatement(query);
        ps.setString(1,dep);
        result = ps.executeQuery();

        while(result.next()){
            post = new Post(result.getString("title"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"),result.getString("firstName"));
            list.add(post);
        }
        return list;
    }
    @Override
    public void showDeptList(String dep) throws SQLException{
        ArrayList<Post> arraylist = deptList(dep);
        DefaultTableModel model = (DefaultTableModel) postTable.getModel();
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
    
    //display post by department
    /**
     *
     * @param dep
     * @throws SQLException
     */
    public void postByDepartment(String dep) throws SQLException{
        query = "SELECT title, dateUploaded, votes, tag FROM post WHERE dept_id = ?";
        connect = new DatabaseConnect().getConnection(); 
        ps = connect.prepareStatement(query);
        ps.setString(1,dep);
        result = ps.executeQuery();
        
        while(result.next()){
            showDeptList(dep);
        }
        
        //close the connection
        if(result!=null){
            result.close();
        }if(ps!=null){
            ps.close();
        }if(connect!=null){
            connect.close();
        }
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
            post = new Post(result.getString("title"),result.getDate("dateUploaded"),result.getInt("votes"),result.getString("tag"),result.getString("firstName"));
            list.add(post);
        }
        return list;
    }
    
    @Override
    public void sortDeptList(String query) throws SQLException{
        ArrayList<Post> arraylist = sortList(query);
        DefaultTableModel model = (DefaultTableModel) postTable.getModel();
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
    
    //Sort the post
    /**
     *
     * @throws SQLException
     */
   @Override
    public void postByPopular() throws SQLException{
        query = "SELECT title, dateUploaded, votes, tag, firstName FROM post, account WHERE account.id = post.acc_id ORDER BY votes DESC";
        sort(query);
    }
    @Override
    public void postByOldest() throws SQLException{
        query = "SELECT title, dateUploaded, votes, tag, firstName FROM post, account WHERE account.id = post.acc_id ORDER BY dateUploaded ASC";
        sort(query);
    }
    @Override
    public void postByNewest() throws SQLException{
        query = "SELECT title, dateUploaded, votes, tag, firstName FROM post, account WHERE account.id = post.acc_id ORDER BY dateUploaded DESC";
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

        jPanel20 = new javax.swing.JPanel();
        deptLabel = new javax.swing.JLabel();
        topQuestions = new javax.swing.JLabel();
        popular = new javax.swing.JButton();
        newest = new javax.swing.JButton();
        oldest = new javax.swing.JButton();
        civil = new javax.swing.JButton();
        mechanical = new javax.swing.JButton();
        mining = new javax.swing.JButton();
        industrial = new javax.swing.JButton();
        electrical = new javax.swing.JButton();
        electronics = new javax.swing.JButton();
        chemical = new javax.swing.JButton();
        computer = new javax.swing.JButton();
        architecture = new javax.swing.JButton();
        CS = new javax.swing.JButton();
        IT = new javax.swing.JButton();
        HRM = new javax.swing.JButton();
        business = new javax.swing.JButton();
        accountancy = new javax.swing.JButton();
        nursing = new javax.swing.JButton();
        arts = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        postTable = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        forumLabel = new javax.swing.JLabel();
        chatbot = new javax.swing.JTextField();
        ask = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        user = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deptLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deptLabel.setText("Departments with ID");

        topQuestions.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        topQuestions.setText("TOP QUESTIONS");

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

        civil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        civil.setText("  1 - Civil Engineering");
        civil.setBorder(null);
        civil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        civil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                civilActionPerformed(evt);
            }
        });

        mechanical.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mechanical.setText("  2 - Mechanical Engineering");
        mechanical.setBorder(null);
        mechanical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mechanical.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mechanical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mechanicalActionPerformed(evt);
            }
        });

        mining.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mining.setText("  3 - Mining Engineering");
        mining.setBorder(null);
        mining.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mining.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miningActionPerformed(evt);
            }
        });

        industrial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        industrial.setText("  4 - Industrial Engineering");
        industrial.setBorder(null);
        industrial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        industrial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        industrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industrialActionPerformed(evt);
            }
        });

        electrical.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        electrical.setText("  5 - Electrical Engineering");
        electrical.setBorder(null);
        electrical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        electrical.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        electrical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electricalActionPerformed(evt);
            }
        });

        electronics.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        electronics.setText("  6 - Electronics Engineering");
        electronics.setBorder(null);
        electronics.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        electronics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        electronics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electronicsActionPerformed(evt);
            }
        });

        chemical.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chemical.setText("  7 - Chemical Engineering");
        chemical.setBorder(null);
        chemical.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chemical.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chemical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemicalActionPerformed(evt);
            }
        });

        computer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        computer.setText("  8 - Computer Engineering");
        computer.setBorder(null);
        computer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        computer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerActionPerformed(evt);
            }
        });

        architecture.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        architecture.setText("  9 - Architecture");
        architecture.setBorder(null);
        architecture.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        architecture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        architecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                architectureActionPerformed(evt);
            }
        });

        CS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CS.setText("  10 - Computer Science");
        CS.setBorder(null);
        CS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CS.setFocusable(false);
        CS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSActionPerformed(evt);
            }
        });

        IT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        IT.setText("  11 - Information Technology");
        IT.setBorder(null);
        IT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        IT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITActionPerformed(evt);
            }
        });

        HRM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        HRM.setText("  12 - Hospitality Management");
        HRM.setBorder(null);
        HRM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HRM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HRMActionPerformed(evt);
            }
        });

        business.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        business.setText("  13 - Business Administration");
        business.setBorder(null);
        business.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        business.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        business.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessActionPerformed(evt);
            }
        });

        accountancy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        accountancy.setText("  14 - Accountancy");
        accountancy.setBorder(null);
        accountancy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        accountancy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        accountancy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountancyActionPerformed(evt);
            }
        });

        nursing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nursing.setText("  15 - Nursing");
        nursing.setBorder(null);
        nursing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nursing.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nursing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nursingActionPerformed(evt);
            }
        });

        arts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arts.setText("  16 - Arts, Science, Education");
        arts.setBorder(null);
        arts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        arts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        postTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        postTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "Date Uploaded", "Votes", "Tag/s", "Posted By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        postTable.setFillsViewportHeight(true);
        postTable.setGridColor(new java.awt.Color(255, 255, 255));
        postTable.setRowHeight(25);
        postTable.setSelectionBackground(new java.awt.Color(153, 0, 0));
        postTable.setShowHorizontalLines(false);
        postTable.setShowVerticalLines(false);
        postTable.getTableHeader().setResizingAllowed(false);
        postTable.getTableHeader().setReorderingAllowed(false);
        postTable.setUpdateSelectionOnSort(false);
        postTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(postTable);
        if (postTable.getColumnModel().getColumnCount() > 0) {
            postTable.getColumnModel().getColumn(0).setPreferredWidth(350);
            postTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            postTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            postTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            postTable.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(industrial, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electrical, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electronics, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chemical, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(computer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(architecture, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CS, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HRM, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(business, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountancy, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nursing, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arts, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(civil, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mining, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(deptLabel)
                        .addGap(98, 98, 98)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(topQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newest, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(oldest, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGap(27, 27, 27)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(deptLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(civil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mining, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(industrial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(electrical, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(electronics, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chemical, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(computer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(architecture, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(business, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountancy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nursing, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arts, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(popular, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oldest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(topQuestions, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(125, 0, 0));
        jPanel21.setForeground(new java.awt.Color(225, 225, 0));
        jPanel21.setDoubleBuffered(false);
        jPanel21.setEnabled(false);
        jPanel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        forumLabel.setBackground(new java.awt.Color(125, 0, 0));
        forumLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        forumLabel.setForeground(new java.awt.Color(225, 225, 0));
        forumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forumLabel.setText("F O R U M");
        forumLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        forumLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homepage", "Profile", "Log-out" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        user.setBackground(new java.awt.Color(204, 204, 204));
        user.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chatbot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(forumLabel)
                        .addComponent(ask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chatbot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popularActionPerformed
        try {
            postByPopular();
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_popularActionPerformed

    private void newestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newestActionPerformed
        try {
            postByNewest();
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newestActionPerformed

    private void oldestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldestActionPerformed
        try {
            postByOldest();
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldestActionPerformed

    private void civilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_civilActionPerformed
        try {
            postByDepartment("1");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_civilActionPerformed

    private void mechanicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mechanicalActionPerformed
        try {
            postByDepartment("2");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mechanicalActionPerformed

    private void miningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miningActionPerformed
        try {
            postByDepartment("3");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miningActionPerformed

    private void industrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industrialActionPerformed
        try {
            postByDepartment("4");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_industrialActionPerformed

    private void electricalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_electricalActionPerformed
        try {
            postByDepartment("5");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_electricalActionPerformed

    private void electronicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_electronicsActionPerformed
        try {
            postByDepartment("6");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_electronicsActionPerformed

    private void chemicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemicalActionPerformed
        try {
            postByDepartment("7");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chemicalActionPerformed

    private void computerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerActionPerformed
        try {
            postByDepartment("8");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_computerActionPerformed

    private void architectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_architectureActionPerformed
        try {
            postByDepartment("9");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_architectureActionPerformed

    private void CSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSActionPerformed
        try {
            postByDepartment("10");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CSActionPerformed

    private void ITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITActionPerformed
        try {
            postByDepartment("11");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ITActionPerformed

    private void HRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HRMActionPerformed
        try {
            postByDepartment("12");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HRMActionPerformed

    private void businessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessActionPerformed
        try {
            postByDepartment("13");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_businessActionPerformed

    private void accountancyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountancyActionPerformed
        try {
            postByDepartment("14");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_accountancyActionPerformed

    private void nursingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nursingActionPerformed
        try {
            postByDepartment("15");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nursingActionPerformed

    private void artsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artsActionPerformed
        try {
            postByDepartment("16");
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_artsActionPerformed

    private void chatbotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatbotMouseClicked
        //chatbot code in here......
    }//GEN-LAST:event_chatbotMouseClicked

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
                //JFrame for userpage in here
                new Userpage().setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(comboBox.getSelectedItem().equals("Log-out")){
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_comboBoxActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked

    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void postTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postTableMouseClicked
        // TODO add your handling code here:
        JTable source=(JTable)evt.getSource();
        int row=source.rowAtPoint(evt.getPoint());
        String title=source.getModel().getValueAt(row, 0)+"";
        PostView postView;
        try {
            postView = new PostView(title);
            postView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_postTableMouseClicked

    private void askMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_askMouseClicked
        try {
            new Ask().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_askMouseClicked

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Homepage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CS;
    private javax.swing.JButton HRM;
    private javax.swing.JButton IT;
    private javax.swing.JButton accountancy;
    private javax.swing.JButton architecture;
    private javax.swing.JButton arts;
    private javax.swing.JTextField ask;
    private javax.swing.JButton business;
    private javax.swing.JTextField chatbot;
    private javax.swing.JButton chemical;
    private javax.swing.JButton civil;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton computer;
    private javax.swing.JLabel deptLabel;
    private javax.swing.JButton electrical;
    private javax.swing.JButton electronics;
    private javax.swing.JLabel forumLabel;
    private javax.swing.JButton industrial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mechanical;
    private javax.swing.JButton mining;
    private javax.swing.JButton newest;
    private javax.swing.JButton nursing;
    private javax.swing.JButton oldest;
    private javax.swing.JButton popular;
    private javax.swing.JTable postTable;
    private javax.swing.JLabel topQuestions;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables

}

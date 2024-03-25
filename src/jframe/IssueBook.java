/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ksama
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    // to get book details from database and display it to book details panel
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from books_details where book_Id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                lbl_bookId.setText(rs.getString("book_Id"));
                lbl_bookName.setText(rs.getString("book_Name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
                
            }else{
                lbl_bookError1.setText("Invalid Book Id");
            }
            
            
            
        } catch (Exception e) {
        }
    }
    
    // to get Students details from database and display it to Student details panel
    public void getStidentsDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from student_details where student_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_Branch.setText(rs.getString("branch"));
                
            }else{
                lbl_studentError.setText("Invalid Student Id");
            }
            
            
            
        } catch (Exception e) {
        }
    }
    
    // Insert issue books details to database
    public boolean issueBook(){
        
        boolean isIssued = false;
        
       int bookId = Integer.parseInt(txt_bookId.getText());
       int studentId = Integer.parseInt(txt_studentId.getText());
       String bookName = lbl_bookName.getText();
       String studentName = lbl_studentName.getText();
       
      java.util.Date uIssueDate = date_IssueDate.getDatoFecha();
      java.util.Date uDueDate = date_DueDate.getDatoFecha();
      
      Long l1 = uIssueDate.getTime();
      Long l2 = uDueDate.getTime();
      
      java.sql.Date sIssueDate = new java.sql.Date(l1);
      java.sql.Date sDueDate = new java.sql.Date(l2);
      
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_books ( book_id, book_name, student_Id, student_name, issue_date, due_date, status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7,"pending");
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                isIssued = true;
            }else {
                isIssued = false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
    }
    
    //To update the book count
    public void updateBookCount() {
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update books_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
             int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            }else {
                JOptionPane.showMessageDialog(this, "book Count Updated Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
        
    }
    
    // Checking whethere book already allocated or not
    public boolean alreadyIssued() {
        
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_books where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
             ResultSet rs = pst.executeQuery();
             
             if(rs.next()) {
                isAlreadyIssued = true;
            }else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_bookError1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_Branch = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_IssueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel18 = new javax.swing.JLabel();
        date_DueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 39));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText(" Book Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 5));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 200, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 130, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 130, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, -1));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 200, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 200, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 200, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 130, -1));

        lbl_bookError1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 340, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 5));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 130, -1));

        lbl_Branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_Branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 200, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 150, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 130, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student Id :");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, -1));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 200, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 200, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 200, 30));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel14.setText(" Students Details");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 340, 30));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 420, 810));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText(" Issue Book");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 290, 5));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, -1, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Book Id :");
        panel_main.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, 130, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setForeground(new java.awt.Color(255, 51, 51));
        txt_bookId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        txt_bookId.setPhColor(new java.awt.Color(255, 51, 51));
        txt_bookId.setPlaceholder("Enter Book ID.....");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 270, 320, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Issue Date :");
        panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 130, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setForeground(new java.awt.Color(255, 51, 51));
        txt_studentId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        txt_studentId.setPhColor(new java.awt.Color(255, 51, 51));
        txt_studentId.setPlaceholder("Enter Student ID.....");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 340, 330, 30));

        date_IssueDate.setForeground(new java.awt.Color(255, 51, 51));
        date_IssueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_IssueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_IssueDate.setDoubleBuffered(false);
        date_IssueDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        date_IssueDate.setPlaceholder("Select Issue Date.....");
        panel_main.add(date_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 410, 330, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Student Id :");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 130, 30));

        date_DueDate.setForeground(new java.awt.Color(255, 51, 51));
        date_DueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_DueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_DueDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        date_DueDate.setPlaceholder("Select Due Date.....");
        panel_main.add(date_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 490, 330, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Due Date :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, 130, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Issue Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, 300, 60));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
      if(!txt_bookId.getText().equals("")){
          getBookDetails();
      }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
        getStidentsDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        
        if(lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not available");
        }
        else {
            if(alreadyIssued() == false){
            
          if(issueBook() == true){
            JOptionPane.showMessageDialog(this, "Book Issued Successfully");
            updateBookCount();
            

        }else {
            JOptionPane.showMessageDialog(this, "Book Issued Failed");
        }
          
        }else{
            JOptionPane.showMessageDialog(this, "This Book is already pending on this student name");
        }
        }
        
        
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_DueDate;
    private rojeru_san.componentes.RSDateChooser date_IssueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_Branch;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError1;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}

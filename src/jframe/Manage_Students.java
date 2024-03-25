/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jframe.DBConnection.con;

/**
 *
 * @author ksama
 */
public class Manage_Students extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Books
     */
    
    String studentName, course, branch;
    int studentId;
      DefaultTableModel model;
    
    public Manage_Students() {
        initComponents();
        setStudentsDetailsToTable();
    }
    //To set the book details in to the table
    public void setStudentsDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft_library","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while (rs.next()){
            int studentId = rs.getInt("Student_Id");
            String studentName = rs.getString("Name");
            String course = rs.getString("Course");
            String branch = rs.getString("Branch");
            
            Object[] obj = {studentId, studentName, course, branch};
            model =(DefaultTableModel) tbl_studentDetails.getModel();
            model.addRow(obj);
            
            
                    
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // add Student Details 
    public boolean addStudents(){
        
          boolean isAdded = false;
          studentId =Integer.parseInt(txt_studentId.getText()) ;
          studentName = txt_studentName.getText();
          course = combo_course.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
          
          try{
              Connection con = DBConnection.getConnection();
              String sql = "insert into student_details values (?, ?, ?, ?)";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, studentId);
              pst.setString(2, studentName);
              pst.setString(3, course);
              pst.setString(4, branch);
              
              int rowCount = pst.executeUpdate();
              if (rowCount>0){
                  isAdded = true;
              }else {
                  isAdded = false;
              }
              
               
              
          }catch (Exception e){
              e.printStackTrace();
          }
          return isAdded;
              
    }
    
    // To update Students details
    public boolean updateStudent(){
        boolean isUpdated = false;
          studentId =Integer.parseInt(txt_studentId.getText()) ;
          studentName = txt_studentName.getText();
          course = combo_course.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
         
          
          try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?, course = ?, branch = ? where student_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, studentName);
              pst.setString(2, course);
              pst.setString(3, branch);
              pst.setInt(4, studentId);
              
             int rowCount = pst.executeUpdate();
             if (rowCount > 0){
                 isUpdated = true;
             }else{
                 isUpdated = false;
             }
                
             
        } catch (Exception e) {
            e.printStackTrace();
        }
          return isUpdated;
    }
    
    // method to delete Student details
    public boolean deleteStudent() {
        boolean isDeleted = false;
        studentId =Integer.parseInt(txt_studentId.getText()) ;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from books_details where student_id  = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                isDeleted = true;
            }else {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return isDeleted;
    }
    
    
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_course = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
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

        jLabel10.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Student ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 110, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 50, 50));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setPhColor(new java.awt.Color(255, 255, 255));
        txt_studentId.setPlaceholder("Enter Student ID");
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
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 280, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 110, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 50, 50));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 280, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Select Course");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 110, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 110, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 50, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 204, 255));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 150, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 204, 255));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 150, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(51, 204, 255));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 150, 70));

        combo_branch.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "BM", "Design" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 290, 30));

        combo_course.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISE", "DIWE", "DIBM" }));
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 290, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1890, 10, 20, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, 20));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 960, 310));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage Students");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 420, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 830));

        setSize(new java.awt.Dimension(1724, 827));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      HomePage home = new HomePage();
      home.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteStudent() == true){
           JOptionPane.showMessageDialog(this, "Student Details Deleted Successfully");
           clearTable();
           setStudentsDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Student Details Deleted Failed");
       }
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(addStudents() == true){
           JOptionPane.showMessageDialog(this, "Student Details Added Successfully");
           clearTable();
           setStudentsDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Student Details Addition Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
     if(updateStudent() == true){
           JOptionPane.showMessageDialog(this, "Student Details Update Successfully");
           clearTable();
           setStudentsDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Student Details Update Failed");
       }
        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
       
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
        
        
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}

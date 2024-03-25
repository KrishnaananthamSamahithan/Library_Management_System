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
public class Manage_Books extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Books
     */
    
    String bookName, author;
    int bookId, quantity;
      DefaultTableModel model;
    
    public Manage_Books() {
        initComponents();
        setBookDetailsToTable();
    }
    //To set the book details in to the table
    public void setBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/esoft_library","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books_details");
            
            while (rs.next()){
            int bookId = rs.getInt("book_Id");
            String bookName = rs.getString("book_Name");
            String author = rs.getString("author");
            int quantity = rs.getInt("quantity");
            
            Object[] obj = {bookId, bookName, author, quantity};
            model =(DefaultTableModel) tbl_bookDetails.getModel();
            model.addRow(obj);
            
            
                    
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // add bood 
    public boolean addBooks(){
        
          boolean isAdded = false;
          bookId =Integer.parseInt(txt_bookId.getText()) ;
          bookName = txt_bookName.getText();
          author = txt_authorName.getText();
          quantity = Integer.parseInt(txt_quantity.getText());
          
          try{
              Connection con = DBConnection.getConnection();
              String sql = "insert into books_details values (?, ?, ?, ?)";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, bookId);
              pst.setString(2, bookName);
              pst.setString(3, author);
              pst.setInt(4, quantity);
              
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
    
    // To update book details
    public boolean updateBook(){
        boolean isUpdated = false;
          bookId =Integer.parseInt(txt_bookId.getText()) ;
          bookName = txt_bookName.getText();
          author = txt_authorName.getText();
          quantity = Integer.parseInt(txt_quantity.getText());
          
          try {
            Connection con = DBConnection.getConnection();
            String sql = "update books_details set book_Name = ?, author = ?, quantity = ? where book_Id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, bookName);
              pst.setString(2, author);
              pst.setInt(3, quantity);
              pst.setInt(4, bookId);
              
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
    
    // method to delete books details
    public boolean deleteBook() {
        boolean isDeleted = false;
        bookId =Integer.parseInt(txt_bookId.getText()) ;
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from books_details where book_id  = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
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
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
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
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_authorName = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
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
        jLabel10.setText("Book ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 110, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 50, 50));

        txt_bookId.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookId.setPhColor(new java.awt.Color(255, 255, 255));
        txt_bookId.setPlaceholder("Enter Book ID");
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
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 110, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 50, 50));

        txt_bookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_bookName.setPlaceholder("Enter Book Name");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Author Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 110, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 50, 50));

        txt_authorName.setBackground(new java.awt.Color(102, 102, 255));
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authorName.setForeground(new java.awt.Color(255, 255, 255));
        txt_authorName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_authorName.setPlaceholder("Enter Author name");
        txt_authorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authorNameFocusLost(evt);
            }
        });
        txt_authorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 110, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 50, 60));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_quantity.setPhColor(new java.awt.Color(255, 255, 255));
        txt_quantity.setPlaceholder("Enter Book Quantity");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, 40));

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

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author Name", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 960, 310));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Manage Books");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

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

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 420, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 830));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      HomePage home = new HomePage();
      home.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void txt_authorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameFocusLost

    private void txt_authorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameActionPerformed

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteBook() == true){
           JOptionPane.showMessageDialog(this, "Book Deleted Successfully");
           clearTable();
           setBookDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Book Deleted Failed");
       }
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(addBooks() == true){
           JOptionPane.showMessageDialog(this, "Book Added Successfully");
           clearTable();
           setBookDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Book Addition Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(updateBook() == true){
           JOptionPane.showMessageDialog(this, "Book Update Successfully");
           clearTable();
           setBookDetailsToTable();
           
       }else {
           JOptionPane.showMessageDialog(this, "Book Update Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
       
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
        
        
        
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(Manage_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_authorName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}

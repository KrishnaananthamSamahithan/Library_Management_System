/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static jframe.DBConnection.con;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ksama
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color (0,0,0);
    Color mouseExitColor = new Color (51,51,51);
     DefaultTableModel model;
    
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentsDetailsToTable();
        setBookDetailsToTable();
        setDataToCards();
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
    
    public void setDataToCards() {
        
        Statement st = null;
        ResultSet rs = null;
        
        long l = System.currentTimeMillis();
        Date todayDate = new Date(l);
        
        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from books_details");
            rs.last();
            rs.getRow();
            lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
            
            
            rs = st.executeQuery("select * from student_details");
            rs.last();
            rs.getRow();
            lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
            
            
             rs = st.executeQuery("select * from issue_books");
            rs.last();
            rs.getRow();
            lbl_noOFIssueBooks.setText(Integer.toString(rs.getRow()));
            
            
            rs = st.executeQuery("select * from issue_books where due_date < '"+todayDate+"' and status = '"+"pendind"+"' ");
            rs.last();
            rs.getRow();
            lbl_noOfDefaulterList.setText(Integer.toString(rs.getRow()));
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
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
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
        try {
            Connection con =DBConnection.getConnection();
            String sql = "select book_name , count(*) as issue_count from issue_books group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
            
        } catch (Exception e) {
        }
 
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPiechart.removeAll();
        panelPiechart.add(barChartPanel, BorderLayout.CENTER);
        panelPiechart.validate();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_noOFIssueBooks = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbl_noOfDefaulterList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        panelPiechart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome, Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Esoft Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1890, 10, 20, 40));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 10, 5, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1925, 70));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel7.setText("  Home Page");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 340, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel6.setText("  Dashboard");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel8.setText("  Dashboard");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel9.setText("  Dashboard");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel10.setText("  Dashboard");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 70));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Features");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, -1));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel19.setText("  Manage Books");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel18.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, -1));

        jPanel19.setBackground(new java.awt.Color(255, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel20.setText("  Home Page");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 340, 60));

        jPanel4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 340, 60));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel21.setText("  Manage Students");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, -1));

        jPanel4.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 340, 60));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel21MouseExited(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel22.setText("  Issue Books");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel4.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 340, 60));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel22MouseExited(evt);
            }
        });
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel23.setText("  Return Books");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        jPanel4.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 340, 60));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel23MouseExited(evt);
            }
        });
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel24.setText("  View Records");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel23.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, -1));

        jPanel4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 340, 60));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel24MouseExited(evt);
            }
        });
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel25.setText("  View Issued Books");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, -1));

        jPanel4.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 340, 60));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel25MouseExited(evt);
            }
        });
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel26.setText("  Defaulter List");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel25.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        jPanel4.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 340, 60));

        jPanel26.setBackground(new java.awt.Color(102, 102, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel27.setText("  Logout");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

        jPanel4.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 340, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 102, 260, 140));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel12.setText("Students Details");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 210, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel13.setText("Number of Students");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 170, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfStudents.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_noOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_noOfStudents)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 260, 140));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setText("Issued Books");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 170, -1));

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOFIssueBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lbl_noOFIssueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_noOFIssueBooks.setText("10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_noOFIssueBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_noOFIssueBooks)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 260, 140));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel17.setText("Defaulter List");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 170, -1));

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfDefaulterList.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lbl_noOfDefaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_noOfDefaulterList.setText("10");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lbl_noOfDefaulterList, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_noOfDefaulterList)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 100, 260, 140));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
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
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 820, 250));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel28.setText("Number of Books");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel29.setText("Book Detals");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 210, 30));

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
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, 820, 250));

        panelPiechart.setLayout(new java.awt.BorderLayout());
        jPanel10.add(panelPiechart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 350, 540, 450));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1590, 960));

        setSize(new java.awt.Dimension(1925, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Manage_Books mb = new Manage_Books();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        
    }//GEN-LAST:event_jLabel19MouseExited

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
       jPanel18.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        jPanel18.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        jPanel20.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
       jPanel20.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel20MouseExited

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        jPanel21.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseExited
         jPanel21.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel21MouseExited

    private void jPanel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseEntered
        jPanel22.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel22MouseEntered

    private void jPanel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel22MouseExited
        jPanel22.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel22MouseExited

    private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
        jPanel23.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel23MouseEntered

    private void jPanel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseExited
        jPanel23.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel23MouseExited

    private void jPanel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseEntered
        jPanel24.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel24MouseEntered

    private void jPanel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseExited
        jPanel24.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel24MouseExited

    private void jPanel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseEntered
        jPanel25.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel25MouseEntered

    private void jPanel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel25MouseExited
        jPanel25.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel25MouseExited

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        IssueBook book = new IssueBook();
        book.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        ReturnBook book = new ReturnBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       ViewAllRecord view = new ViewAllRecord();
       view.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jPanel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel24MouseClicked
        
    }//GEN-LAST:event_jPanel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        IssueBookDetails issue = new IssueBookDetails();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
       DefaulterList list = new DefaulterList();
       list.setVisible(true);
       dispose();;
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        Manage_Students student = new Manage_Students();
        student.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
       Signup up = new Signup();
       up.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_noOFIssueBooks;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfDefaulterList;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JPanel panelPiechart;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SHRUTI
 */
public class JFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form JFrame1
     */
    public JFrame1() {
        initComponents();
        show_table();
    }
    Connection con = null;
    PreparedStatement pst = null;
    
    
    
    private void show_table()
    {
        
        int CC;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentinfo", "root", "");
            pst = con.prepareStatement("SELECT * FROM info");
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMT = Rs.getMetaData();
            CC = RSMT.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)jTable1.getModel();
            DFT.setRowCount(0);
            while(Rs.next()){
                Vector v2 = new Vector();
                for(int i=1; i<=CC;i++)
                {
                    v2.add(Rs.getString("id"));
                    v2.add(Rs.getString("name"));
                    v2.add(Rs.getString("age"));
                    v2.add(Rs.getString("course"));
                }
                  DFT.addRow(v2);
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }        

        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Age", "Course"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("                                                       Student Management Details");

        jButton1.setText("Update");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Age");

        jLabel5.setText("Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcourse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtage))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(13, 13, 13))
                            .addComponent(txtcourse, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String id,age,name,course;  
        id = txtid.getText();    
       age = txtage.getText();
       name = txtname.getText();
       course = txtcourse.getText();
       
       if(id.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your ID");
       }
       if(age.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your age");
       }
       else if(name.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your ID");
       }
       else if(name.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your name");
       }
       else if(course.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your COURSE");
       }
       else
      {
           try {
               
                //load the mysql jdbc driver
              try 
              {
                  Class.forName("com.mysql.cj.jdbc.Driver");
              } catch(ClassNotFoundException e ){}
              //Establish a connection
           con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentinfo", "root", "");
            
            
             pst = con.prepareStatement("insert into info (Id, Name, Age, Course)values (?,?,?,?)");
              
              pst.setString(1, id);
                pst.setString(2, name);
                  pst.setString(3, age);
                    pst.setString(4, course);
                    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, ("Data entered Successfully"));
                    show_table();
                    
                    txtid.setText("");
                     txtname.setText("");
                      txtage.setText("");
                       txtcourse.setText("");
                    
          } catch (SQLException ex) {
              Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
          }
           }        // TODO add your handling code here:
    }                                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
//        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        txtid.setText(model.getValueAt(selectedIndex, 0).toString());
        txtname.setText(model.getValueAt(selectedIndex, 1).toString());
        txtage.setText(model.getValueAt(selectedIndex, 2).toString());
        txtcourse.setText(model.getValueAt(selectedIndex,3).toString());  
        
    }                                    

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
String id,age,name,course;  
        id = txtid.getText();    
       age = txtage.getText();
       name = txtname.getText();
       course = txtcourse.getText();
       
       if(id.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your ID");
       }
       if(age.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your age");
       }
       else if(name.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your ID");
       }
       else if(name.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your name");
       }
       else if(course.equals(""))
       {
           JOptionPane.showMessageDialog(null, "Please enter your COURSE");
       }
       else
       {
    try 
    {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        int id1 = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentinfo", "root", "");
        
        pst = con.prepareStatement("update info set name =?, age =?, course =? where id =?");
     
        pst.setString(1,name);
        pst.setString(2,age);
        pst.setString(3,course);
        pst.setString(4,id);

        

        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"Data updated successfully!!");
        show_table();
        
        txtid.setText("");
        txtname.setText("");
        txtage.setText("");
        txtcourse.setText("");

        
     } catch (SQLException ex)
          {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
          }
       }      
    }                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            int id1 = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentinfo", "root", "");
            pst = con.prepareStatement("Delete from info where id = ?");
            
            pst.setInt(1,id1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted");
            show_table();
            
            
        txtid.setText("");
        txtname.setText("");
        txtage.setText("");
        txtcourse.setText("");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JFrame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        
  private void txtNameActionPerformed(java.awt.event.ActionEvent evt)
  {                                        
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration                   
}


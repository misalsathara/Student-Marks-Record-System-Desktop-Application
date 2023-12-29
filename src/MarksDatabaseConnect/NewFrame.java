/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MarksDatabaseConnect;

import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
/**
 *
 * @author SD2023
 */
public class NewFrame extends javax.swing.JFrame {
PreparedStatement pst;
    ResultSet rs;
    DBConnection db=new DBConnection();
    DefaultTableModel tableModel;
    String oldStno;
    String total = null;
    String average = null;
    float avg;
    
    /**
     * Creates new form Marks
     */
    public NewFrame() {
        initComponents();
        db.MyCon();
        display();  
       // printDisplay();
    }

    void clear(){
        txtStno.setText("");
        txtTheory.setText("");
        txtPractical.setText("");
        txtAssingment.setText("");
        txtTotal.setText("");
        txtAverage.setText("");
        txtGrade.setText("");
        taDisplay.setText("");
    }
     String total(){
        float x,y,z;
        x=Float.parseFloat(txtTheory.getText());
        y=Float.parseFloat(txtPractical.getText());
        z=Float.parseFloat(txtAssingment.getText());
        
        txtTotal.setText(""+(x+y+z));
    
        
        return total;
  
    }
     String average(){
     float x,y,z;
        x=Float.parseFloat(txtTheory.getText());
        y=Float.parseFloat(txtPractical.getText());
        z=Float.parseFloat(txtAssingment.getText());
        
        txtAverage.setText(""+(x+y+z)/3);
    
        return average;
     }
   
    void display(){
        try {
            
            String msg="select * from marks";
            pst=db.con.prepareStatement(msg);
            rs=pst.executeQuery();
            tableModel=(DefaultTableModel) jTable1.getModel();

            while(rs.next()){
                String stno=rs.getString(1);
                String theoryMarks=rs.getString(2);
                String practicalmentMarks=rs.getString(3);               
                String assingmentMarks=rs.getString(4);        
        
                int x,y,z;
        x=Integer.parseInt(rs.getString(2));
        y=Integer.parseInt(rs.getString(3));
        z=Integer.parseInt(rs.getString(4));                
          String tot=(x+y+z+""); 
          
          float a,b,c;
       a=Float.parseFloat(rs.getString(2));
        b=Float.parseFloat(rs.getString(3));
        c=Float.parseFloat(rs.getString(4));       
          String av=(""+(a+b+c)/3);
          
          float avg;
          float m,n,o;
       m=Float.parseFloat(rs.getString(2));
        n=Float.parseFloat(rs.getString(3));
        o=Float.parseFloat(rs.getString(4));       
          String ave=(""+(m+n+o)/3);
    String grade=null;
    avg=Float.parseFloat(ave);
    	if(avg>75){
		String[] dataRow={stno,theoryMarks,practicalmentMarks,assingmentMarks,tot,av,"A"};
                tableModel.addRow(dataRow);
	}else if(avg>65){
		String[] dataRow={stno,theoryMarks,practicalmentMarks,assingmentMarks,tot,av,"B"};
                tableModel.addRow(dataRow);
	}else if(avg>55){
		String[] dataRow={stno,theoryMarks,practicalmentMarks,assingmentMarks,tot,av,"C"};
                tableModel.addRow(dataRow);
	}else if(avg>35){
		String[] dataRow={stno,theoryMarks,practicalmentMarks,assingmentMarks,tot,av,"S"};
                tableModel.addRow(dataRow);
	}else{
		String[] dataRow={stno,theoryMarks,practicalmentMarks,assingmentMarks,tot,av,"F"};
                tableModel.addRow(dataRow);
	}

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStno = new javax.swing.JTextField();
        txtTheory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPractical = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAssingment = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAverage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("STNO");

        txtStno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStnoActionPerformed(evt);
            }
        });

        txtTheory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTheoryActionPerformed(evt);
            }
        });
        txtTheory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTheoryKeyTyped(evt);
            }
        });

        jLabel2.setText("Theory Marks");

        txtPractical.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPracticalKeyTyped(evt);
            }
        });

        jLabel3.setText("Practical Marks");

        txtAssingment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAssingmentKeyTyped(evt);
            }
        });

        jLabel4.setText("Assingment Marks");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });

        jLabel5.setText("Total");

        txtAverage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAverageKeyTyped(evt);
            }
        });

        jLabel6.setText("Average");

        txtGrade.setEditable(false);
        txtGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGradeKeyTyped(evt);
            }
        });

        jLabel7.setText("Grade");

        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STNO", "Theory Marks", "Practical Marks", "Assingment Marks", "Total", "Average", "Grade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        taDisplay.setColumns(20);
        taDisplay.setRows(5);
        jScrollPane3.setViewportView(taDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStno, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTheory, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPractical, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAssingment, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFind))
                            .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtStno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTheory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPractical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAssingment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrint))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExport))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String msg="delete from marks where STNO=?";
            pst=db.con.prepareStatement(msg);
            pst.setString(1, txtStno.getText());
            pst.executeUpdate();

            tableModel=(DefaultTableModel) jTable1.getModel();
            int x=jTable1.getSelectedRow();
            tableModel.removeRow(x);
            
            clear();
            
        JOptionPane.showMessageDialog(this, "RECORD DELETE SUCCESSFULL");
        
        } catch (SQLException ex) {
            Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String msg="Update marks SET STNO=?, Theory=?, Practical=?, Assingment=? where marks.STNO=?";
            pst=db.con.prepareStatement(msg);
            pst.setString(1, txtStno.getText());
            pst.setString(2, txtTheory.getText());
            pst.setString(3, txtPractical.getText());
            pst.setString(4, txtAssingment.getText());
            pst.setString(5, oldStno);
            pst.executeUpdate();
            
            tableModel=(DefaultTableModel) jTable1.getModel();
            int x=jTable1.getSelectedRow();
            jTable1.setValueAt(txtStno.getText(), x, 0);
            jTable1.setValueAt(txtTheory.getText(), x, 1);
            jTable1.setValueAt(txtPractical.getText(), x, 2);
            jTable1.setValueAt(txtAssingment.getText(), x, 3);
            

            JOptionPane.showMessageDialog(this, "RECORD UPDATE SUCCESSFULL");
            
        } catch (SQLException ex) {
            Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        try {
            String msg="select * from marks where STNO=?";
            pst=db.con.prepareStatement(msg);
            pst.setString(1, txtFind.getText());
            rs=pst.executeQuery();
            if (rs.next()){
            txtStno.setText(rs.getString(1));
            txtTheory.setText(rs.getString(2));
            txtPractical.setText(rs.getString(3));
            txtAssingment.setText(rs.getString(4));
            
                            int x,y,z;
        x=Integer.parseInt(rs.getString(2));
        y=Integer.parseInt(rs.getString(3));
        z=Integer.parseInt(rs.getString(4));                
          String tot=(x+y+z+"");
        txtTotal.setText(tot);
        
                  float a,b,c;
       a=Float.parseFloat(rs.getString(2));
        b=Float.parseFloat(rs.getString(3));
        c=Float.parseFloat(rs.getString(4));       
          String av=(""+(a+b+c)/3);
        txtAverage.setText(av);
        
        float avg;
          float m,n,o;
       m=Float.parseFloat(rs.getString(2));
        n=Float.parseFloat(rs.getString(3));
        o=Float.parseFloat(rs.getString(4));       
          String ave=(""+(m+n+o)/3);
    String grade=null;
    avg=Float.parseFloat(ave);
    	if(avg>75){
		txtGrade.setText("A");
	}else if(avg>65){
		txtAverage.setText("B");
	}else if(avg>55){
		txtAverage.setText("C");
	}else if(avg>35){
		txtAverage.setText("S");
	}else{
		txtAverage.setText("F");
	}

            
        
 
            }else{
                JOptionPane.showMessageDialog(this, "THIS RECORD NOT FOUND");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    try {
        String msg="Insert marks (STNO,Theory,Practical,Assingment) values(?,?,?,?)";
        pst=db.con.prepareStatement(msg);
        pst.setString(1, txtStno.getText());
        pst.setFloat(2, Float.parseFloat(txtTheory.getText()));
        pst.setFloat(3, Float.parseFloat(txtPractical.getText()));
        pst.setFloat(4, Float.parseFloat(txtAssingment.getText()));
        
        pst.execute();
        
        String stno=txtStno.getText();
        String theoryMarks=txtTheory.getText();
        String practicalMarks=txtPractical.getText();            
        String assingmentmarks=txtAssingment.getText();    

        total();
        average();
        Grade();
        
        String tot=txtTotal.getText();
        String avg=txtAverage.getText();
        String grade=txtGrade.getText();
        
        String[] dataRow={stno,theoryMarks,practicalMarks,assingmentmarks,tot,avg,grade};
        tableModel.addRow(dataRow);
        
        
        
        
     
        
    } catch (SQLException ex) {
        Logger.getLogger(NewFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        char key=evt.getKeyChar();
        if(key==KeyEvent.VK_CAPS_LOCK){
        txtTotal.setEditable(true);
        
    }else{
            txtTotal.setEditable(false);
            
        }
    }//GEN-LAST:event_txtTotalKeyTyped

    private void txtAverageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAverageKeyTyped
        char key=evt.getKeyChar();
        if(key==KeyEvent.VK_CAPS_LOCK){
        txtAverage.setEditable(true);
        
    }else{
            txtAverage.setEditable(false);
            
        }
    }//GEN-LAST:event_txtAverageKeyTyped

    private void txtGradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGradeKeyTyped
     
    }//GEN-LAST:event_txtGradeKeyTyped

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        total();
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTheoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTheoryActionPerformed
      
    }//GEN-LAST:event_txtTheoryActionPerformed

    private void txtTheoryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTheoryKeyTyped
                char key=evt.getKeyChar();
        if(key>='0' && key<='9'||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_PERIOD){
        txtTheory.setEditable(true);
        
    }else{
            txtTheory.setEditable(false);
            
        }
    }//GEN-LAST:event_txtTheoryKeyTyped

    private void txtPracticalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPracticalKeyTyped
                    char key=evt.getKeyChar();
        if(key>='0' && key<='9'||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_PERIOD){
        txtPractical.setEditable(true);
        
    }else{
            txtPractical.setEditable(false);
            
        }
    }//GEN-LAST:event_txtPracticalKeyTyped

    private void txtAssingmentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAssingmentKeyTyped
                   char key=evt.getKeyChar();
        if(key>='0' && key<='9'||key==KeyEvent.VK_BACK_SPACE||key==KeyEvent.VK_PERIOD){
        txtAssingment.setEditable(true);
        
    }else{
            txtAssingment.setEditable(false);
            
        }
    }//GEN-LAST:event_txtAssingmentKeyTyped

    private void txtStnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStnoActionPerformed
        
    }//GEN-LAST:event_txtStnoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
tableModel=(DefaultTableModel) jTable1.getModel();
        int x=jTable1.getSelectedRow();
        txtStno.setText(tableModel.getValueAt(x,0).toString());
        txtTheory.setText(tableModel.getValueAt(x,1).toString());
        txtPractical.setText(tableModel.getValueAt(x,2).toString());
        txtAssingment.setText(tableModel.getValueAt(x,3).toString());
        txtTotal.setText(tableModel.getValueAt(x, 4).toString());
          txtAverage.setText(tableModel.getValueAt(x, 5).toString());
          txtGrade.setText(tableModel.getValueAt(x, 6).toString());
  
        printDisplay();
        oldStno=txtStno.getText();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
            try {
            taDisplay.print();
        } catch (PrinterException ex) {
            Logger.getLogger(System.class.getName()).log(Level.SEVERE, null, ex);
        
    }        
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
    
        JFileChooser exelFileChooser = new JFileChooser("C:\\Users\\misal\\Desktop");
        FileNameExtensionFilter fnex =new FileNameExtensionFilter("EXEL FILES","xls","xlsx","xlsm");
        exelFileChooser.setFileFilter(fnex);
        exelFileChooser.showSaveDialog(null);
        //FileWriter fw=new FileWriter(fnex);

   
    }//GEN-LAST:event_btnExportActionPerformed

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
            java.util.logging.Logger.getLogger(NewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFrame().setVisible(true);
            }
        });
    }
      String Grade(){
    float avg;
    String grade=null;
    avg=Float.parseFloat(txtTotal.getText())/3;
    	if(avg>80){
		txtGrade.setText("A");
	}else if(avg>65){
		txtGrade.setText("B");
	}else if(avg>55){
		txtGrade.setText("C");
	}else if(avg>35){
		txtGrade.setText("S");
	}else{
		txtGrade.setText("F");
	}
    return grade;

}
     
    void printDisplay(){
        taDisplay.setText("");
        String info;
        info="\t VTA Baddegama\n "+
                "\t Software Developer\n"+
                "==========================\n"+
                "STNO \t"+txtStno.getText()+"\n"+
                "Theory \t"+txtTheory.getText()+"\n"+
                "Practical \t"+txtPractical.getText()+"\n"+
                "Assingment \t"+txtAssingment.getText()+"\n"+
                "Total \t"+txtTotal.getText()+"\n"+
                "Average No\t"+txtAverage.getText()+"\n"+
                "Grade \t"+txtGrade.getText()+"\n"+
                "==========================\n"+
                "\nmisalsathsara@gmail.com\n"+
                "Thank You";
        taDisplay.append(info);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taDisplay;
    private javax.swing.JTextField txtAssingment;
    private javax.swing.JTextField txtAverage;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtPractical;
    private javax.swing.JTextField txtStno;
    private javax.swing.JTextField txtTheory;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rovelyn
 */
public class EditProductPanel extends javax.swing.JPanel {

    /**
     * Creates new form EditProductPanel
     */
    public EditProductPanel() {
        initComponents();
        showTableData();
    }
    
    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    //DATE AND TIME
    SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yyyy");  
    SimpleDateFormat timeToday = new SimpleDateFormat("HH:mm:ss");  
    Date date  = new Date();
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prodNAME = new javax.swing.JTextField();
        prodCATEGORY = new javax.swing.JTextField();
        prodQUANTITY = new javax.swing.JTextField();
        prodPRICE = new javax.swing.JTextField();
        prodID = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(52, 73, 94));
        setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        setMaximumSize(new java.awt.Dimension(760, 500));
        setPreferredSize(new java.awt.Dimension(760, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 243, 244));
        jLabel1.setText("QUANTITY     :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 243, 244));
        jLabel2.setText("PRODUCT ID   :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 243, 244));
        jLabel3.setText("PRODUCT NAME :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 243, 244));
        jLabel4.setText("PRICE        :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 243, 244));
        jLabel6.setText("CATEGORY     :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        prodNAME.setBackground(new java.awt.Color(52, 73, 94));
        prodNAME.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        prodNAME.setForeground(new java.awt.Color(242, 243, 244));
        prodNAME.setToolTipText("ENTER PRODUCT NAME");
        prodNAME.setCaretColor(new java.awt.Color(255, 0, 7));
        prodNAME.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(prodNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, -1));

        prodCATEGORY.setBackground(new java.awt.Color(52, 73, 94));
        prodCATEGORY.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        prodCATEGORY.setForeground(new java.awt.Color(242, 243, 244));
        prodCATEGORY.setToolTipText("ENTER PRODUCT CATEGORY");
        prodCATEGORY.setCaretColor(new java.awt.Color(255, 0, 7));
        prodCATEGORY.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(prodCATEGORY, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 170, -1));

        prodQUANTITY.setBackground(new java.awt.Color(52, 73, 94));
        prodQUANTITY.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        prodQUANTITY.setForeground(new java.awt.Color(242, 243, 244));
        prodQUANTITY.setToolTipText("ENTER QUANTITY");
        prodQUANTITY.setCaretColor(new java.awt.Color(255, 0, 7));
        prodQUANTITY.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        prodQUANTITY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodQUANTITYKeyTyped(evt);
            }
        });
        add(prodQUANTITY, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 170, -1));

        prodPRICE.setBackground(new java.awt.Color(52, 73, 94));
        prodPRICE.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        prodPRICE.setForeground(new java.awt.Color(242, 243, 244));
        prodPRICE.setToolTipText("ENTER PRODUCT PRICE");
        prodPRICE.setCaretColor(new java.awt.Color(255, 0, 7));
        prodPRICE.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        prodPRICE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodPRICEKeyTyped(evt);
            }
        });
        add(prodPRICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 170, -1));

        prodID.setBackground(new java.awt.Color(52, 73, 94));
        prodID.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        prodID.setForeground(new java.awt.Color(242, 243, 244));
        prodID.setToolTipText("ENTER PRODUCT ID");
        prodID.setCaretColor(new java.awt.Color(255, 0, 7));
        prodID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        prodID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prodIDKeyTyped(evt);
            }
        });
        add(prodID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 170, -1));

        clear.setBackground(java.awt.Color.lightGray);
        clear.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 0));
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 150, 40));

        add.setBackground(new java.awt.Color(0, 255, 203));
        add.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        add.setText("ADD PRODUCT");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        delete.setBackground(new java.awt.Color(253, 106, 74));
        delete.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 150, 40));

        update.setBackground(new java.awt.Color(30, 238, 175));
        update.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 150, 40));

        myTable.setBackground(new java.awt.Color(52, 73, 94));
        myTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        myTable.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        myTable.setForeground(new java.awt.Color(242, 243, 244));
        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "CATEGORY", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable.setToolTipText("");
        myTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myTable.setGridColor(new java.awt.Color(0, 204, 204));
        myTable.setRowHeight(20);
        myTable.setSelectionBackground(new java.awt.Color(106, 98, 107));
        myTable.setSelectionForeground(new java.awt.Color(255, 64, 226));
        myTable.getTableHeader().setResizingAllowed(false);
        myTable.getTableHeader().setReorderingAllowed(false);
        myTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable);
        if (myTable.getColumnModel().getColumnCount() > 0) {
            myTable.getColumnModel().getColumn(0).setResizable(false);
            myTable.getColumnModel().getColumn(1).setResizable(false);
            myTable.getColumnModel().getColumn(2).setResizable(false);
            myTable.getColumnModel().getColumn(3).setResizable(false);
            myTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 390, 420));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        prodID.setText("");
        prodNAME.setText("");
        prodCATEGORY.setText("");
        prodQUANTITY.setText("");
        prodPRICE.setText("");
        add.setEnabled(true);
        clear.setText("CLEAR");
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
    
        if(prodID.getText().equals("") || prodNAME.getText().equals("") || prodCATEGORY.getText().equals("")
                || prodQUANTITY.getText().equals("") || prodPRICE.getText().equals("")){
            JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
        }else{
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                statement = connect.prepareStatement("SELECT * FROM db_inventory WHERE id=?");
                statement.setString(1, prodID.getText());
                ResultSet result = statement.executeQuery();

                    if(result.next()){
                        prodID.setText("");
                        JOptionPane.showMessageDialog(null, "PRODUCT ID ALREADY EXIST!!\nIF YOU WISH, YOU CAN JUST UPDATE IT.");
                    }else{
                        String create = "INSERT INTO db_inventory (id, name, category, quantity, price) "
                               + "VALUES('"+prodID.getText()+"', '"+prodNAME.getText()+"', '"+prodCATEGORY.getText()+"', '"+prodQUANTITY.getText()+"', '"+prodPRICE.getText()+"')";
                        connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                        statement = (PreparedStatement) connect.prepareStatement(create);
                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "PRODUCT ADDED!");
                            
                            try{
                                //FOR HISTORY
                                String dateNow = dateToday.format(date);
                                String timeNow = timeToday.format(date);
                                String action = "ADDED";
                                String addHistory = "INSERT INTO history (id, name, category, quantity, price, date, time, action, user) " + "VALUES"
                                      + "('"+prodID.getText()+"', '"+prodNAME.getText()+"', '"+prodCATEGORY.getText()+"', "
                                      + "'"+prodQUANTITY.getText()+"', '"+prodPRICE.getText()+"', '"+dateNow+"', '"+timeNow+"',  '"+action+"', '"+MainFrame.welcomeUser.getText()+"')";
                                statement = (PreparedStatement) connect.prepareStatement(addHistory);
                                statement.executeUpdate();
                            }catch(Exception ez){
                                JOptionPane.showMessageDialog(null, "ERROR RECORDING HISTORY!");
                            }
                        
                        prodID.setText("");
                        prodNAME.setText("");
                        prodCATEGORY.setText("");
                        prodQUANTITY.setText("");
                        prodPRICE.setText("");
                    }

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!");
            }
         }
        showTableData();
        
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        if(prodID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
        }else{
            
            JPasswordField pwd = new JPasswordField(20);
            int act = JOptionPane.showConfirmDialog(null, pwd, "ENTER YOUR PASSWORD", JOptionPane.OK_CANCEL_OPTION);
            String pass = new String(pwd.getPassword());
            if(act < 0){
                JOptionPane.showMessageDialog(null, "ABORTED!");
            }else if(act == 2){
                JOptionPane.showMessageDialog(null, "CANCELLED!");
            }
            else{
                try{
                    connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                    statement = connect.prepareStatement("SELECT * FROM accounts WHERE username=? AND password=? ");
                    statement.setString(1, MainFrame.welcomeUser.getText());
                    statement.setString(2, pass);
                    ResultSet result = statement.executeQuery();
                    
                    if(result.next()){
                            
                        try{
                            connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                            statement = connect.prepareStatement("DELETE FROM db_inventory WHERE id=?");
                            statement.setString(1, prodID.getText());
                            int result1 = statement.executeUpdate();
                            if(result1 > 0){
                                JOptionPane.showMessageDialog(null, "PRODUCT DELETED SUCCESSFULLY!");
                            }else{
                                JOptionPane.showMessageDialog(null, "PRODUCT HISTORY DIDN'T EXIST!");
                            }
                            
                            try{
                                //FOR HISTORY
                                String dateNow = dateToday.format(date);
                                String timeNow = timeToday.format(date);
                                String action = "DELETED";
                                String addHistory = "INSERT INTO history (id, name, category, quantity, price, date, time, action, user) " + "VALUES"
                                      + "('"+prodID.getText()+"', '"+prodNAME.getText()+"', '"+prodCATEGORY.getText()+"', "
                                      + "'"+prodQUANTITY.getText()+"', '"+prodPRICE.getText()+"', '"+dateNow+"', '"+timeNow+"',  '"+action+"', '"+MainFrame.welcomeUser.getText()+"')";
                                statement = (PreparedStatement) connect.prepareStatement(addHistory);
                                statement.executeUpdate();
                            }catch(Exception ez){
                                JOptionPane.showMessageDialog(null, "ERROR RECORDING HISTORY!");
                            }
                            
                        }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!\n" + ex);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD!");
                    }
                    
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!\n" + ex);
                } 
            }
        }
        prodID.setText("");
        prodNAME.setText("");
        prodCATEGORY.setText("");
        prodQUANTITY.setText("");
        prodPRICE.setText("");
        showTableData();
        add.setEnabled(true);
        clear.setText("CLEAR");
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        if(prodID.getText().equals("") || prodNAME.getText().equals("") || prodCATEGORY.getText().equals("")
                || prodQUANTITY.getText().equals("") || prodPRICE.getText().equals("")){
            JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
        }else{
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                statement = connect.prepareStatement("UPDATE db_inventory SET name=?, category=?, quantity=?, price=? WHERE id=?");
                statement.setString(5, prodID.getText());
                statement.setString(1, prodNAME.getText());
                statement.setString(2, prodCATEGORY.getText());
                statement.setString(3, prodQUANTITY.getText());
                statement.setString(4, prodPRICE.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "PRODUCT UPDATED SUCCESSFULLY!");
                
                try{
                    //FOR HISTORY
                    String dateNow = dateToday.format(date);
                    String timeNow = timeToday.format(date);
                    String action = "UPDATED";
                    String addHistory = "INSERT INTO history (id, name, category, quantity, price, date, time, action, user) " + "VALUES"
                            + "('"+prodID.getText()+"', '"+prodNAME.getText()+"', '"+prodCATEGORY.getText()+"', "
                            + "'"+prodQUANTITY.getText()+"', '"+prodPRICE.getText()+"', '"+dateNow+"', '"+timeNow+"',  '"+action+"', '"+MainFrame.welcomeUser.getText()+"')";
                        statement = (PreparedStatement) connect.prepareStatement(addHistory);
                        statement.executeUpdate();
                    }catch(Exception ez){
                    JOptionPane.showMessageDialog(null, "ERROR RECORDING !\n" + ez);
                            }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
         }
        
        prodID.setText("");
        prodNAME.setText("");
        prodCATEGORY.setText("");
        prodQUANTITY.setText("");
        prodPRICE.setText("");
        showTableData();
        add.setEnabled(true);
        clear.setText("CLEAR");
    }//GEN-LAST:event_updateActionPerformed

    private void showTableData(){
        
        JTableHeader header = myTable.getTableHeader();
        header.setBackground(new Color(52, 73, 94));
        header.setForeground(new Color(242, 243, 244));
        header.setFont(new Font("Courier New", Font.BOLD, 15));
        
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
            statement = connect.prepareStatement("SELECT * FROM db_inventory");
            ResultSet result = statement.executeQuery();
            myTable.setModel(DbUtils.resultSetToTableModel(result));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!");
        }
    }
    
    
    private void prodIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodIDKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_prodIDKeyTyped

    private void prodQUANTITYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodQUANTITYKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_prodQUANTITYKeyTyped

    private void prodPRICEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodPRICEKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_prodPRICEKeyTyped

    private void myTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel)myTable.getModel();
        int selectedRowIndex = myTable.getSelectedRow();
        
        prodID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        prodNAME.setText(model.getValueAt(selectedRowIndex, 1).toString());
        prodCATEGORY.setText(model.getValueAt(selectedRowIndex, 2).toString());
        prodQUANTITY.setText(model.getValueAt(selectedRowIndex, 3).toString());
        prodPRICE.setText(model.getValueAt(selectedRowIndex, 4).toString());
        
        add.setEnabled(false);
        clear.setText("CANCEL");
    }//GEN-LAST:event_myTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTable;
    private javax.swing.JTextField prodCATEGORY;
    private javax.swing.JTextField prodID;
    private javax.swing.JTextField prodNAME;
    private javax.swing.JTextField prodPRICE;
    private javax.swing.JTextField prodQUANTITY;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

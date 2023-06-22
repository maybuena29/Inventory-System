/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rovelyn
 */
public class HistoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form historyPanel
     */
    public HistoryPanel() {
        initComponents();
        showTableData();
    }
    
    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        type = new javax.swing.JComboBox<>();
        wordToDelete = new javax.swing.JTextField();

        setBackground(new java.awt.Color(52, 73, 94));
        setForeground(new java.awt.Color(242, 243, 244));
        setPreferredSize(new java.awt.Dimension(760, 500));
        setLayout(null);

        historyTable.setBackground(new java.awt.Color(52, 73, 94));
        historyTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        historyTable.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        historyTable.setForeground(new java.awt.Color(242, 243, 244));
        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "CATEGORY", "QUANTITY", "PRICE", "DATE", "TIME", "ACTION", "USER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        historyTable.setToolTipText("");
        historyTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyTable.setEnabled(false);
        historyTable.setGridColor(new java.awt.Color(0, 204, 204));
        historyTable.setRowHeight(20);
        historyTable.setSelectionBackground(new java.awt.Color(106, 98, 107));
        historyTable.setSelectionForeground(new java.awt.Color(255, 64, 226));
        historyTable.getTableHeader().setResizingAllowed(false);
        historyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(historyTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 730, 390);

        jButton1.setBackground(new java.awt.Color(253, 106, 74));
        jButton1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 243, 244));
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(590, 410, 130, 40);

        type.setBackground(new java.awt.Color(52, 73, 94));
        type.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        type.setForeground(new java.awt.Color(242, 243, 244));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "CATEGORY", "QUANTITY", "PRICE", "DATE", "TIME", "ACTION", "USER" }));
        add(type);
        type.setBounds(450, 410, 130, 40);

        wordToDelete.setBackground(new java.awt.Color(52, 73, 94));
        wordToDelete.setFont(new java.awt.Font("Courier New", 1, 15)); // NOI18N
        wordToDelete.setForeground(new java.awt.Color(242, 243, 244));
        wordToDelete.setToolTipText("ENTER WORD TO FIND AND DELETE");
        wordToDelete.setCaretColor(new java.awt.Color(255, 0, 7));
        add(wordToDelete);
        wordToDelete.setBounds(310, 410, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String delType = "";
        switch(type.getSelectedItem().toString()){
            case "ID":
                delType = "ID";
                break;
            case "NAME":
                delType = "NAME";
                break;
            case "CATEGORY":
                delType = "CATEGORY";
                break;
            case "QUANTITY":
                delType = "QUANTITY";
                break;
            case "PRICE":
                delType = "PRICE";
                break;
            case "DATE":
                delType = "DATE";
                break;
            case "TIME":
                delType = "TIME";
                break;
            case "ACTION":
                delType = "ACTION";
                break;
            case "USER":
                delType = "USER";
                break;
        }
        
        if(wordToDelete.getText().equals("")){
            JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
        }else{
            
            JPasswordField pwd = new JPasswordField(20);
            int act = JOptionPane.showConfirmDialog(null, pwd, "ENTER YOUR PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            String pass = new String(pwd.getPassword());
            if(act < 0){
                JOptionPane.showMessageDialog(null, "ABORTED!");
            }else if(act == 2){
                JOptionPane.showMessageDialog(null, "CANCELLED!");
            }
            else{
                
                try{
                    
                    connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                    statement = connect.prepareStatement("SELECT * FROM history WHERE user=? AND "+delType+"=?");
                    statement.setString(1, MainFrame.welcomeUser.getText());
                    statement.setString(2, wordToDelete.getText());
                    ResultSet res = statement.executeQuery();
                    
                    if(res.next()){
                        try{
                            connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                            statement = connect.prepareStatement("SELECT * FROM accounts WHERE username=? AND password=? ");
                            statement.setString(1, MainFrame.welcomeUser.getText());
                            statement.setString(2, pass);
                            ResultSet result = statement.executeQuery();

                            if(result.next()){

                                try{
                                    connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                                    statement = connect.prepareStatement("DELETE FROM history WHERE "+delType+"=? AND user=?");
                                    statement.setString(1, wordToDelete.getText());
                                    statement.setString(2, MainFrame.welcomeUser.getText());
                                    int result1 = statement.executeUpdate();
                                    if(result1 > 0){
                                        JOptionPane.showMessageDialog(null, "PRODUCT HISTORY DELETED SUCCESSFULLY!");
                                    }else{
                                        JOptionPane.showMessageDialog(null, "PRODUCT HISTORY DIDN'T EXIST!");
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
                    }else{
                        JOptionPane.showMessageDialog(null, "YOU CAN'T DELETE OTHER USER'S HISTORY!");
                    }
                }catch(Exception ez){
                    JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG :(\n" + ez);
                }
                
            }
        }
        wordToDelete.setText("");
        type.setSelectedIndex(0);
        showTableData();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void showTableData(){
        
        JTableHeader header = historyTable.getTableHeader();
        header.setBackground(new Color(52, 73, 94));
        header.setForeground(new Color(242, 243, 244));
        header.setFont(new Font("Courier New", Font.BOLD, 15));
        
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
            statement = connect.prepareStatement("SELECT * FROM history");
            ResultSet result = statement.executeQuery();
            historyTable.setModel(DbUtils.resultSetToTableModel(result));
            
            TableColumnModel colMod = header.getColumnModel();
            TableColumn tabCol1 = colMod.getColumn(0);
            TableColumn tabCol2 = colMod.getColumn(1);
            TableColumn tabCol3 = colMod.getColumn(2);
            TableColumn tabCol4 = colMod.getColumn(3);
            TableColumn tabCol5 = colMod.getColumn(4);
            TableColumn tabCol6 = colMod.getColumn(5);
            TableColumn tabCol7 = colMod.getColumn(6);
            TableColumn tabCol8 = colMod.getColumn(7);
            TableColumn tabCol9 = colMod.getColumn(8);
            tabCol1.setHeaderValue("ID");
            tabCol2.setHeaderValue("NAME");
            tabCol3.setHeaderValue("CATEGORY");
            tabCol4.setHeaderValue("QUANTITY");
            tabCol5.setHeaderValue("PRICE");
            tabCol6.setHeaderValue("DATE");
            tabCol7.setHeaderValue("TIME");
            tabCol8.setHeaderValue("ACTION");
            tabCol9.setHeaderValue("USER");
            header.repaint();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!");
        }
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable historyTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JTextField wordToDelete;
    // End of variables declaration//GEN-END:variables
}

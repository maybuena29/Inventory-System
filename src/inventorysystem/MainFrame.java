/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import static inventorysystem.Login.user;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class MainFrame{
    public void Mainframe(){
        main();
    }
    
    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    static JLabel welcomeUser, username, fullName, age, gender, contact, email;
    static JPanel welcomePanel, panelAccount, panelProducts, panelEditProducts, panelHistory;
    
    EditProductPanel editPanel = new EditProductPanel();
    ProductsListPanel productsPanel = new ProductsListPanel();
    HistoryPanel historyPanel = new HistoryPanel();
    
    private void main(){
        
        ImageIcon img = new ImageIcon("images/icon.png");
        Image img1 = img.getImage();
        Image img2 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon userIcon = new ImageIcon(img2);
        
        Font myFont = new Font("Courier New", Font.BOLD, 16);
        Font menuFont = new Font("Copperplate Gothic Bold", Font.BOLD, 18);
        Color white = new Color(242, 243, 244);
        Color bg = new Color(52, 73, 94);
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame fr = new JFrame("BSIT");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(760, 600);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setAutoRequestFocus(true);
        fr.setLocation(290, 90);
           
        //MAIN PANEL
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(new Color(52, 73, 94));
        fr.add(mainPanel);
        
        //TITLE
        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new GridLayout());
        panelTitle.setBackground(new Color(40, 55, 71));
        panelTitle.setPreferredSize(new Dimension(760, 50));
        panelTitle.setBounds(0, 0, 760, 50);
        mainPanel.add(panelTitle);
        
            JLabel txtTitle = new JLabel("INVENTORY SYSTEM", JLabel.CENTER);
            txtTitle.setFont(new Font("Copperplate Gothic Bold", Font.HANGING_BASELINE, 27));
            txtTitle.setBounds(100, 0, 760, 50);
            txtTitle.setForeground(new Color(244, 246, 246));
            panelTitle.add(txtTitle);
        
        //MENU ITEMS
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(46, 64, 83));
        panelMenu.setLayout(null);
        panelMenu.setPreferredSize(new Dimension(760, 50));
        panelMenu.setBounds(0, 50, 760, 50);
        mainPanel.add(panelMenu);
        
            JLabel account = new JLabel("Account");
            account.setFont(menuFont);
            account.setBounds(60, 0, 150, 50);
            account.setForeground(new Color(232, 248, 245));
            panelMenu.add(account);
            
            //ACCOUNT ONCLICK FUNCTION
                account.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e){
                        account.setForeground(Color.MAGENTA);
                    }
                    @Override
                    public void mousePressed(MouseEvent e){
                        welcomePanel.setVisible(false);
                        panelAccount.setVisible(true);
                        editPanel.setVisible(false);
                        productsPanel.setVisible(false);
                        historyPanel.setVisible(false);
                        userProfile();
                        
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        account.setForeground(new Color(232, 248, 245));
                    }
                });
            
            JLabel products = new JLabel("Products");
            products.setFont(menuFont);
            products.setBounds(235, 0, 150, 50);
            products.setForeground(new Color(232, 248, 245));
            panelMenu.add(products);
            
            //PRODUCTS ONCLICK FUNCTION
                products.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e){
                        products.setForeground(Color.MAGENTA);
                    }
                    @Override
                    public void mousePressed(MouseEvent e){
                        welcomePanel.setVisible(false);
                        panelAccount.setVisible(false);
                        productsPanel.setVisible(true);
                        editPanel.setVisible(false);
                        historyPanel.setVisible(false);
                        productsPanel.showTableData();
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        products.setForeground(new Color(232, 248, 245));
                    }
                });
        
            JLabel editProducts = new JLabel("Edit Items");
            editProducts.setFont(menuFont);
            editProducts.setBounds(410, 0, 150, 50);
            editProducts.setForeground(new Color(232, 248, 245));
            panelMenu.add(editProducts);
            
            //EDIT PRODUCTS ONCLICK FUNCTION
                editProducts.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e){
                        editProducts.setForeground(Color.MAGENTA);
                    }
                    @Override
                    public void mousePressed(MouseEvent e){
                        welcomePanel.setVisible(false);
                        panelAccount.setVisible(false);
                        productsPanel.setVisible(false);
                        editPanel.setVisible(true);
                        historyPanel.setVisible(false);
                        //loadData();
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        editProducts.setForeground(new Color(232, 248, 245));
                    }
                });
            
            JLabel history = new JLabel("History");
            history.setFont(menuFont);
            history.setBounds(585, 0, 150, 50);
            history.setForeground(new Color(232, 248, 245));
            panelMenu.add(history);
            
            //HISTORY ONCLICK FUNCTION
                history.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e){
                        history.setForeground(Color.MAGENTA);
                    }
                    @Override
                    public void mousePressed(MouseEvent e){
                        welcomePanel.setVisible(false);
                        panelAccount.setVisible(false);
                        productsPanel.setVisible(false);
                        editPanel.setVisible(false);
                        historyPanel.setVisible(true);
                        historyPanel.showTableData();
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        history.setForeground(new Color(232, 248, 245));
                    }
                });
            
        JPanel panelBody = new JPanel(new CardLayout());
        panelBody.setBackground(new Color(52, 73, 94));
        panelBody.setPreferredSize(new Dimension(760, 35));
        panelBody.setBounds(0, 100, 760, 500);
        mainPanel.add(panelBody);
        
        //INSIDE PANEL BODY
        
            welcomePanel = new JPanel();
            welcomePanel.setLayout(null);
            welcomePanel.setBackground(new Color(52, 73, 94));
            welcomePanel.setPreferredSize(new Dimension(760, 35));
            welcomePanel.setBounds(0, 100, 760, 500);
            panelBody.add(welcomePanel);
                
            //WELCOME PAGE
            
                JLabel txtWelcome = new JLabel("<html>WELCOME!<br/><hr></html>", JLabel.CENTER);
                txtWelcome.setFont(new Font("Monotype Corsiva", Font.BOLD, 55));
                txtWelcome.setForeground(Color.WHITE);
                txtWelcome.setBounds(150, 50, 450, 200);
                welcomePanel.add(txtWelcome);
                
                welcomeUser = new JLabel("UNKNOWN",JLabel.CENTER);
                welcomeUser.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 38));
                welcomeUser.setForeground(Color.WHITE);
                welcomeUser.setBounds(250, 80, 250, 270);
                welcomePanel.add(welcomeUser);
                
            
            panelAccount = new JPanel();
            panelAccount.setLayout(null);
            panelAccount.setBackground(new Color(52, 73, 94));
            panelAccount.setPreferredSize(new Dimension(760, 35));
            panelAccount.setBounds(0, 100, 760, 500);
            panelBody.add(panelAccount);
            
            //START OF ACCOUNT PANEL
                JLabel icon = new JLabel("", userIcon, JLabel.CENTER);
                icon.setFont(myFont);
                icon.setBounds(60, 40, 200, 200);
                panelAccount.add(icon);
                
                username = new JLabel("UNKNOWN",JLabel.CENTER);
                username.setFont(new Font("Copperplate Gothic Bold", Font.HANGING_BASELINE, 18));
                username.setForeground(white);
                username.setBounds(60, 120, 190, 200);
                panelAccount.add(username);
                
                JLabel logout = new JLabel("LOGOUT", null, JLabel.CENTER);
                logout.setFont(new Font("Courier New", Font.BOLD, 15));
                logout.setForeground(new Color(174, 214, 241));
                logout.setBounds(85, 220, 150, 40);
                panelAccount.add(logout);    

                    logout.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e){
                            logout.setForeground(Color.MAGENTA);
                        }
                        @Override
                        public void mousePressed(MouseEvent e){
                            int reply = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU\nWANT TO LOGOUT?", 
                                    "LOGOUT", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION) {
                                fr.setVisible(false);
                                Login login = new Login();
                                login.myFrame();
                            }
                        }
                        @Override
                        public void mouseExited(MouseEvent e){
                            logout.setForeground(new Color(174, 214, 241));
                        }
                    });
            
                JLabel txtUser = new JLabel("USER PROFILE", JLabel.LEFT);
                txtUser.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
                txtUser.setForeground(white);
                txtUser.setBounds(300, 50, 200, 50);
                panelAccount.add(txtUser);
                
                JLabel txtFName = new JLabel("FULL NAME:", JLabel.LEFT);
                txtFName.setFont(myFont);
                txtFName.setForeground(white);
                txtFName.setBounds(300, 100, 200, 50);
                panelAccount.add(txtFName);
                
                fullName = new JLabel("UNKNOWN", JLabel.LEFT);
                fullName.setFont(myFont);
                fullName.setForeground(white);
                fullName.setBounds(510, 100, 200, 50);
                panelAccount.add(fullName);
                
                JLabel txtAge = new JLabel("AGE:", JLabel.LEFT);
                txtAge.setFont(myFont);
                txtAge.setForeground(white);
                txtAge.setBounds(300, 140, 200, 50);
                panelAccount.add(txtAge);
                
                age = new JLabel("UNKNOWN", JLabel.LEFT);
                age.setFont(myFont);
                age.setForeground(white);
                age.setBounds(510, 150, 200, 30);
                panelAccount.add(age);
                
                JLabel txtGender = new JLabel("GENDER:", JLabel.LEFT);
                txtGender.setFont(myFont);
                txtGender.setForeground(white);
                txtGender.setBounds(300, 180, 200, 50);
                panelAccount.add(txtGender);
                
                gender = new JLabel("UNKNOWN", JLabel.LEFT);
                gender.setFont(myFont);
                gender.setForeground(white);
                gender.setBounds(510, 190, 200, 30);
                panelAccount.add(gender);
                
                JLabel txtContact = new JLabel("CONTACT NUMBER:", JLabel.LEFT);
                txtContact.setFont(myFont);
                txtContact.setForeground(white);
                txtContact.setBounds(300, 220, 200, 50);
                panelAccount.add(txtContact);
                
                contact = new JLabel("UNKNOWN", JLabel.LEFT);
                contact.setFont(myFont);
                contact.setForeground(white);
                contact.setBounds(510, 230, 200, 30);
                panelAccount.add(contact);
                
                JLabel txtEmail = new JLabel("EMAIL:", JLabel.LEFT);
                txtEmail.setFont(myFont);
                txtEmail.setForeground(white);
                txtEmail.setBounds(300, 260, 200, 50);
                panelAccount.add(txtEmail);
                
                email = new JLabel("UNKNOWN", JLabel.LEFT);
                email.setFont(myFont);
                email.setForeground(white);
                email.setBounds(510, 270, 200, 30);
                panelAccount.add(email);
                
            //CALLING PRODUCTS LIST PANEL    
            panelBody.add(productsPanel);
            
            //CALLING EDIT PRODUCTS PANEL 
            panelBody.add(editPanel);
                    
            //CALLING HISTORY PANEL
            panelBody.add(historyPanel);
        
    }
    
    //GETTING DATA FROM ACCOUNTS IN DATABASE
    private static void userProfile(){
        Function function = new Function();
        ResultSet rs;
        
        rs = function.find(user.getText());
            try {
                
                if(rs.next()){
                    
                    username.setText(rs.getString("username"));
                    fullName.setText(rs.getString("fullname"));
                    age.setText(rs.getString("age"));
                    gender.setText(rs.getString("gender"));
                    contact.setText(rs.getString("contact"));
                    email.setText(rs.getString("email"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "LIGWAK!!");
                }
                
            } catch (SQLException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!\n" + ex.getMessage());
            }
    }
    
    
}


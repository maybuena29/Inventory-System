
package inventorysystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration {
    
    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public void register(){
        reg();
    }
    
    private void reg(){
        Font myFont = new Font("Courier New", Font.BOLD, 16);
        ImageIcon img = new ImageIcon("images/iconLogin.png");
        Image img1 = img.getImage();
        Image img2 = img1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon userIcon = new ImageIcon(img2);
        Color white = new Color(230, 230, 230);
        Color bg = new Color(52, 73, 94);
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame myFrame = new JFrame("REGISTRATION FORM");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(475, 580);
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        myFrame.setAutoRequestFocus(true);
        myFrame.setLocation(400, 100);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bg);
        myFrame.add(panel);
        
        JLabel studPic = new JLabel("", userIcon, JLabel.CENTER);
        studPic.setFont(myFont);
        studPic.setBounds(0, -35, 200, 200);
        panel.add(studPic);
        
        JLabel profile = new JLabel("<html>   PERSONAL<br/><hr>INFORMATION<html>",JLabel.CENTER);
        profile.setFont(new Font("Copperplate Gothic Bold", Font.HANGING_BASELINE, 27));
        profile.setForeground(white);
        profile.setBounds(160, -35, 250, 200);
        panel.add(profile);
        
        
        //PERSONAL INFORMATION
        JLabel txtFName = new JLabel("FULL NAME:", JLabel.LEFT);
        txtFName.setFont(myFont);
        txtFName.setForeground(white);
        txtFName.setBounds(45, 115, 200, 50);
        panel.add(txtFName);
        
        JTextField fullName = new JTextField(20);
        fullName.setToolTipText("Enter Fullname");
        fullName.setFont(myFont);
        fullName.setForeground(white);
        fullName.setBackground(bg);
        fullName.setCaretColor(Color.red);
        fullName.setBounds(215, 125, 200, 30);
        panel.add(fullName);
        
        JLabel txtAge = new JLabel("AGE:", JLabel.LEFT);
        txtAge.setFont(myFont);
        txtAge.setForeground(white);
        txtAge.setBounds(45, 150, 200, 50);
        panel.add(txtAge);
        
        JTextField age = new JTextField(20);
        age.setToolTipText("Enter Age");
        age.setFont(myFont);
        age.setBackground(bg);
        age.setCaretColor(Color.red);
        age.setForeground(white);
        age.setBounds(215, 160, 200, 30);
        panel.add(age);
        
            age.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent arg0) {
                    char enter = arg0.getKeyChar();
                    if(!(Character.isDigit(enter))){
                        arg0.consume();
                    }
                }
            });
            
            age.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent arg0) {
                    int AGE = age.getDocument().getLength();
                    if(AGE >= 3){
                        arg0.consume();
                    }
                }
            });
        
        JLabel txtGender = new JLabel("GENDER:", JLabel.LEFT);
        txtGender.setFont(myFont);
        txtGender.setBounds(45, 185, 200, 50);
        txtGender.setForeground(white);
        panel.add(txtGender);
        
        JComboBox gender = new JComboBox();
        gender.addItem("Male");
        gender.addItem("Female");
        gender.addItem("Others");
        gender.setFont(myFont);
        gender.setBackground(bg);
        gender.setForeground(white);
        gender.setToolTipText("Choose Gender");
        gender.setBounds(215, 195, 200, 30);
        panel.add(gender);
        
        JLabel txtContact = new JLabel("CONTACT NUMBER:", JLabel.LEFT);
        txtContact.setFont(myFont);
        txtContact.setForeground(white);
        txtContact.setBounds(45, 220, 200, 50);
        panel.add(txtContact);
        
        JTextField contactNum = new JTextField(20);
        contactNum.setToolTipText("Enter Contact Number");
        contactNum.setBounds(215, 230, 200, 30);
        contactNum.setFont(myFont);
        contactNum.setCaretColor(Color.red);
        contactNum.setForeground(white);
        contactNum.setBackground(bg);
        panel.add(contactNum);
        
            contactNum.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent arg0) {
                    char enter = arg0.getKeyChar();
                    if(!(Character.isDigit(enter))){
                        arg0.consume();
                    }
                }
            });
            
            contactNum.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent arg0) {
                    int contact = contactNum.getDocument().getLength();
                    if(contact >= 11){
                        arg0.consume();
                    }
                }
            });
        
        JLabel txtEmail = new JLabel("EMAIL:", JLabel.LEFT);
        txtEmail.setFont(myFont);
        txtEmail.setBounds(45, 255, 200, 50);
        txtEmail.setForeground(white);
        panel.add(txtEmail);
        
        JTextField email = new JTextField(20);
        email.setColumns(20);
        email.setFont(myFont);
        email.setCaretColor(Color.red);
        email.setBackground(bg);
        email.setForeground(white);
        email.setToolTipText("Enter Email");
        email.setBounds(215, 265, 200, 30);
        panel.add(email);
        
      
        JLabel userAcc = new JLabel("USER ACCOUNT:",JLabel.CENTER);
        userAcc.setFont(new Font("Courier New", Font.CENTER_BASELINE, 19));
        userAcc.setForeground(white);
        userAcc.setBounds(15, 295, 200, 50);
        panel.add(userAcc);
        
        //USER ACCOUNT
        JLabel txtUsername = new JLabel("USERNAME:", JLabel.LEFT);
        txtUsername.setFont(myFont);
        txtUsername.setForeground(white);
        txtUsername.setBounds(45, 335, 200, 50);
        panel.add(txtUsername);
        
        JTextField username = new JTextField(20);
        username.setColumns(20);
        username.setFont(myFont);
        username.setCaretColor(Color.red);
        username.setBackground(bg);
        username.setForeground(white);
        username.setToolTipText("Enter Username");
        username.setBounds(215, 345, 200, 30);
        panel.add(username);
        
        JLabel txtPassword = new JLabel("PASSWORD:", JLabel.LEFT);
        txtPassword.setFont(myFont);
        txtPassword.setForeground(white);
        txtPassword.setBounds(45, 370, 200, 50);
        panel.add(txtPassword);
        
        JPasswordField password = new JPasswordField(20);
        password.setColumns(20);
        password.setFont(myFont);
        password.setBackground(bg);
        password.setCaretColor(Color.red);
        password.setForeground(white);
        password.setToolTipText("Enter Password");
        password.setBounds(215, 380, 200, 30);
        panel.add(password);
        
        JLabel txtConfirmPass = new JLabel("CONFIRM PASSWORD:", JLabel.LEFT);
        txtConfirmPass.setFont(myFont);
        txtConfirmPass.setForeground(white);
        txtConfirmPass.setBounds(45, 405, 200, 50);
        panel.add(txtConfirmPass);
        
        JPasswordField confirmPass = new JPasswordField(20);
        confirmPass.setColumns(20);
        confirmPass.setFont(myFont);
        confirmPass.setBackground(bg);
        confirmPass.setCaretColor(Color.red);
        confirmPass.setForeground(white);
        confirmPass.setToolTipText("Re-type Password");
        confirmPass.setBounds(215, 415, 200, 30);
        panel.add(confirmPass);
        
        JCheckBox showPass = new JCheckBox("SHOW PASSWORD");
        showPass.setToolTipText("Show Password");
        showPass.setForeground(white);
        showPass.setBackground(bg);
        showPass.setBounds(215, 450, 200, 30);
        panel.add(showPass);
        
            showPass.addActionListener((e) -> {
            if(showPass.isSelected()){
                password.setEchoChar((char)0);
                confirmPass.setEchoChar((char)0);
            }else{
                password.setEchoChar('•');
                confirmPass.setEchoChar('•');
            }
            });
        
        JButton clear = new JButton("Clear");
        clear.setFont(myFont);
        clear.setBackground(Color.LIGHT_GRAY);
        clear.setBounds(140, 490, 95, 40);
        clear.setToolTipText("Clear All");
        panel.add(clear);
        
            clear.addActionListener((ActionEvent e) -> {
                fullName.setText("");
                age.setText("");
                gender.setSelectedItem("Male");
                contactNum.setText("");
                email.setText("");
                username.setText("");
                password.setText("");
                confirmPass.setText("");
            });
        
        JButton submit = new JButton("Submit");
        submit.setFont(myFont);
        submit.setBackground(new Color(12, 237, 215));
        submit.setToolTipText("Submit");
        submit.setBounds(255, 490, 95, 40);
        panel.add(submit);
            
            submit.addActionListener((ActionEvent e) -> {
                
                String strFname = fullName.getText();
                String strAge = age.getText();
                String strGender = gender.getSelectedItem().toString();
                String strContact = contactNum.getText();
                String strEmail = email.getText();
                String strUsername = username.getText();
                String strPassword = password.getText();
                String strConfirmPass = confirmPass.getText();
                
                if(fullName.getText().equals("") || age.getText().equals("") || contactNum.getText().equals("") 
                        || strEmail.equals("") || strUsername.equals("") || strPassword.equals("") || strConfirmPass.equals("")){
                    JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
                }else if(!strPassword.equals(strConfirmPass)){
                    password.setText("");
                    confirmPass.setText("");
                    JOptionPane.showMessageDialog(null, "PASSWORD DIDN'T MATCH!");
                }
                else{

                    try{
                        connect = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                        statement = connect.prepareStatement("SELECT * FROM accounts WHERE username=?");
                        statement.setString(1, strUsername);
                        ResultSet result = statement.executeQuery();
                        
                        if(result.next()){
                            username.setText("");
                            JOptionPane.showMessageDialog(null, "USERNAME ALREADY EXIST!!");
                        }else{
                            String create = "INSERT INTO accounts (fullname, age, gender, contact, email, username, password) "
                                    + "VALUES('"+strFname+"', '"+strAge+"', '"+strGender+"', '"+strContact+"', '"+strEmail+"', '"+strUsername+"', '"+strPassword+"')";
                            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                            statement = (PreparedStatement) connect.prepareStatement(create);
                            statement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "ACCOUNT CREATED!");
                            
                            myFrame.setVisible(false);
                            Login loginForm = new Login();
                            loginForm.myFrame();
                        }
                        
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                
            });
            
        JLabel back = new JLabel("<< Back", null, JLabel.CENTER);
        back.setFont(new Font("Courier New", Font.BOLD, 15));
        back.setForeground(new Color(167, 221, 254));
        back.setBounds(-9, 495, 150, 40);
        panel.add(back);    
        
        back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e){
                    back.setForeground(Color.MAGENTA);
                }
                @Override
                public void mousePressed(MouseEvent e){
                    myFrame.setVisible(false);
                    Login login = new Login();
                    login.myFrame();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    back.setForeground(new Color(154, 211, 245));
                }
            });
            
    }
}

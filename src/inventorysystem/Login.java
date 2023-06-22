
package inventorysystem;

import static inventorysystem.MainFrame.welcomeUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    public static void myFrame(){
      login();
    }
    
    static JFrame fr;
    static JTextField user;
    static JPasswordField pass;
    
    private static void login(){
        Font myFont = new Font("Courier New", Font.BOLD, 16);
        ImageIcon img = new ImageIcon("images/iconLogin.png");
        Image img1 = img.getImage();
        Image img2 = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon userIcon = new ImageIcon(img2);
        Color white = new Color(230, 230, 230);
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        fr = new JFrame("INVENTORY SYSTEM");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400, 490);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setAutoRequestFocus(true);
        fr.setLocation(450, 100);
           
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(52, 73, 94));
        fr.add(panel);
        
        JLabel userPic = new JLabel("", userIcon, JLabel.CENTER);
        userPic.setFont(myFont);
        userPic.setBounds(110, 10, 190, 190);
        panel.add(userPic);
        
        JLabel txtUser = new JLabel("USERNAME", JLabel.CENTER);
        txtUser.setFont(myFont);
        txtUser.setForeground(white);
        txtUser.setBounds(100, 190, 200, 50);
        panel.add(txtUser);
        
        user = new JTextField(20);
        user.setToolTipText("Enter Username");
        user.setCaretColor(Color.red);
        user.setFont(myFont);
        user.setForeground(white);
        user.setBackground(new Color(52, 73, 94));
        user.setBounds(100, 230, 200, 30);
        panel.add(user);
        
        JLabel txtPass = new JLabel("PASSWORD", JLabel.CENTER);
        txtPass.setFont(myFont);
        txtPass.setForeground(white);
        txtPass.setBounds(100, 255, 200, 50);
        panel.add(txtPass);
        
        pass = new JPasswordField(20);
        pass.setToolTipText("Enter Password");
        pass.setForeground(white);
        pass.setCaretColor(Color.red);
        pass.setFont(myFont);
        pass.setBackground(new Color(52, 73, 94));
        pass.setBounds(100, 295, 200, 30);
        panel.add(pass);
        
        JCheckBox showPass = new JCheckBox("SHOW PASSWORD");
        showPass.setToolTipText("Show Password");
        showPass.setBackground(new Color(52, 73, 94));
        showPass.setBounds(100, 330, 200, 30);
        showPass.setForeground(white);
        panel.add(showPass);
        
        showPass.addActionListener((e) -> {
            if(showPass.isSelected()){
                pass.setEchoChar((char)0);
            }else{
                pass.setEchoChar('•');
            }
        });
         
        JButton clear = new JButton("Clear");
        clear.setFont(myFont);
        clear.setBackground(Color.LIGHT_GRAY);
        clear.setBounds(100, 365, 90, 40);
        clear.setToolTipText("Clear Textfields");
        panel.add(clear);
            clear.addActionListener((ActionEvent e) -> {
                user.setText("");
                pass.setText("");
            });
        
        JButton login = new JButton("Login");
        login.setFont(myFont);
        login.setBackground(new Color(12, 237, 215));
        login.setBounds(210, 365, 90, 40);
        panel.add(login);
        
            login.addActionListener((ActionEvent e) -> {
                 loginFunction();
            });
        
        JLabel register = new JLabel("Create an Account", null, JLabel.CENTER);
        register.setFont(new Font("Courier New", Font.BOLD, 13));
        register.setBounds(100, 400, 150, 40);
        register.setForeground(new Color(154, 211, 245));
        panel.add(register);
        
            register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e){
                    register.setForeground(Color.MAGENTA);
                }
                @Override
                public void mousePressed(MouseEvent e){
                    fr.setVisible(false);
                    Registration reg = new Registration();
                    reg.register();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    register.setForeground(new Color(154, 211, 245));
                }
            });
               
    }
    
    private static void loginFunction(){
        Connection connection;
        PreparedStatement ps;
                
            if(user.getText().equals("") || pass.getText().equals("")){
                JOptionPane.showMessageDialog(null, "DATA REQUIRED!");
            }else{
                try {
                
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/inventory_system_java", "root", "");
                    ps = connection.prepareStatement("SELECT * FROM accounts WHERE username=? AND password=? ");
                    ps.setString(1, user.getText());
                    ps.setString(2, pass.getText());
                    ResultSet result = ps.executeQuery();
                    
                    if(result.next()){
                            
                        JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY!");
                            
                        fr.setVisible(false);
                        MainFrame mainForm = new MainFrame();
                        mainForm.Mainframe();
                        userProfile();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD!");
                    }
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!\n" + ex);
                } 
            }
    }
    
    private static void userProfile(){
        Function function = new Function();
        ResultSet rs;
        
        rs = function.find(user.getText());
            try {
                
                if(rs.next()){
                    
                    welcomeUser.setText(rs.getString("username"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "USERNAME NOT FOUND!!!");
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR IN DATABASE!\n" + ex);
            } 
    }
        
}

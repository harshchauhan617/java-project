import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame{
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l1 = new JLabel("Welcome");
    JLabel l2 = new JLabel("Username");
    JLabel l3 = new JLabel("Password");
  //  JLabel l4 = new JLabel("if not registered please sign up!");
    JTextField t1 = new JTextField();
    JTextField  pass =new JTextField();
    JRadioButton btn2 = new JRadioButton("I'm not a robot");
    //ImageIcon img = new ImageIcon("C:\\Users\\Aman raj\\Downloads\\download (2).png");
    JButton btn1 = new JButton("Signin");
    JButton btn3 = new JButton("Signup");
    Login(){
this.setSize(1300, 800);
this.setVisible(true);
this.setDefaultCloseOperation(EXIT_ON_CLOSE);
this.add(p1);
this.add(p2);

p2.add(l1);
p2.add(l2);
p2.add(t1);
p2.add(l3);
p2.add(pass);
p2.add(btn1);
p2.add(btn2);
//p2.add(l4);
p2.add(btn3);

p2.setLayout(null);
p1.setLayout(null);
l1.setForeground(Color.white);
l1.setBackground(Color.white);
l1.setBounds(118, 70, 250, 40);
l2.setBackground(Color.white);
l2.setForeground(Color.white);
l2.setBounds(40, 300, 150, 25);
l3.setBackground(Color.white);
l3.setForeground(Color.white);
l3.setBounds(40, 345, 150, 25);
//l4.setBackground(Color.white);
//l4.setForeground(Color.white);
//l4.setBounds(80, 400, 200, 35);

t1.setBounds(180, 300, 150, 25);

pass.setBounds(180, 345, 150, 25);
btn2.setBounds(110, 415, 180, 25);
btn1.setBounds(115, 455, 180, 25);
btn3.setBounds(115,495 , 180, 25);
btn2.setBackground(Color.black);
btn2.setForeground(Color.white);
btn1.setBackground(Color.red);
btn1.setForeground(Color.white);
btn3.setBackground(Color.blue);
btn3.setForeground(Color.white);
btn1.setFocusable(false);
btn3.setFocusable(false);



btn3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new Student().setVisible(true);
dispose();
}
});

btn1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
check();
dispose();
}
});


this.setLayout(null);
p1.setBounds(0, 0, 900, 800);
p2.setBounds(900, 0, 400, 800);
p1.setBackground(Color.GRAY);
p2.setBackground(Color.black);
l1.setFont(new Font("Georgia", Font.PLAIN, 35));
l2.setFont(new Font("Georgia", Font.PLAIN, 22));
l3.setFont(new Font("Georgia", Font.PLAIN, 22));
btn1.setFont(new Font("Georgia", Font.PLAIN, 19));
btn2.setFont(new Font("Georgia", Font.PLAIN, 22));
btn3.setFont(new Font("Georgia", Font.PLAIN, 19));
    }

    void check(){
        String str1 = t1.getText();
        String str2 = pass.getText();
        String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "3001";
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
  
        // Create a connection to the database
        Connection conn = DriverManager.getConnection(url, user, password);
  
        // Create the users table if it does not exist
        Statement createStmt = conn.createStatement();
        createStmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, username VARCHAR(50), password VARCHAR(50), PRIMARY KEY (id))");
  
        // Create a statement to execute the SQL query
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
  
        // Set the parameters for the query
        
        stmt.setString(1, str1);
        stmt.setString(2,str2);
  
        // Execute the query and check the result
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            
    new signin();
          } else {
           
    JOptionPane.showMessageDialog(null, "Invalid");
          }
    
          // Close the database connection
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Login();
    }
    
}

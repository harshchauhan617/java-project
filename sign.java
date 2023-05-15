import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.IOException;

import javax.swing.*;
class sign extends JFrame
{
	//JPanel p1 = new JPanel();

	JLabel l1=new JLabel("ADMIT OR DELETE STUDENTS ");
    JLabel l2=new JLabel("Username");
	JLabel l3=new JLabel("Sphone_number");
	JLabel l4=new JLabel("Saddress");
	JLabel l5=new JLabel("CourseId");
	JLabel l6=new JLabel("Email");
    
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();

	JRadioButton btn1 = new JRadioButton("I have rechecked all the filled information");

	JButton btn2 = new JButton("Submit");



	
	sign()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		l1.setBounds(250,20,1000,45);this.add(l1);
		l1.setBackground(Color.black);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Georgia", Font.PLAIN, 35));

		l2.setBounds(70,250,600,30);this.add(l2);
		l2.setBackground(Color.black);
		l2.setForeground(Color.black);
		l2.setFont(new Font("Georgia", Font.PLAIN, 25));

		l3.setBounds(70,300,600,30);this.add(l3);
		l3.setBackground(Color.black);
		l3.setForeground(Color.black);
		l3.setFont(new Font("Georgia", Font.PLAIN, 25));

		l4.setBounds(70,350,600,30);this.add(l4);
		l4.setBackground(Color.black);
		l4.setForeground(Color.black);
		l4.setFont(new Font("Georgia", Font.PLAIN, 25));

		l5.setBounds(70,400,600,30);this.add(l5);
		l5.setBackground(Color.black);
		l5.setForeground(Color.black);
		l5.setFont(new Font("Georgia", Font.PLAIN, 25));

		l6.setBounds(70,450,600,30);this.add(l6);
		l6.setBackground(Color.black);
		l6.setForeground(Color.black);
		l6.setFont(new Font("Georgia", Font.PLAIN, 25));

		// set bound for textfields 
		t1.setBounds(350,250,600,30);this.add(t1);
		t2.setBounds(350,300,600,30);this.add(t2);
		t3.setBounds(350,350,600,30);this.add(t3);
		t4.setBounds(350,400,600,30);this.add(t4);
		t5.setBounds(350,450,600,30);this.add(t5);
		
        // set bound for buttons 
		btn1.setBounds(20,700,1000,30);this.add(btn1);
		btn2.setBounds(1100,700,150,30);this.add(btn2);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				createTableIfNotExists();
			save();
                dispose();
            }
        });
	}
		
	public void save() {
		String username= t1.getText();
		String phoneNumber= t2.getText();
		String address = t3.getText();
		String courseId = t4.getText();
		
		String email = t5.getText();		// Initialize database credentials
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "3001";
	
		try {
		  // Load the MySQL JDBC driver
		  Class.forName("com.mysql.jdbc.Driver");
	
		  // Create a connection to the database
		  Connection conn = DriverManager.getConnection(url, user, password);
	
		  // Create a prepared statement to execute the SQL query
		  String query = "INSERT INTO s (username, phone_number, address, course_id, email) VALUES (?, ?, ?, ?, ?)";
		  PreparedStatement stmt = conn.prepareStatement(query);
	
		  // Set the parameters for the query
		  stmt.setString(1, username);
		  stmt.setString(2, phoneNumber);
		  stmt.setString(3, address);
          stmt.setString(4, courseId);
          stmt.setString(5, email);

      // Execute the query
      stmt.executeUpdate();

      // Close the database connection
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void createTableIfNotExists() {
    // Initialize database credentials
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "3001";

    try
	{
      // Load the MySQL JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Create a connection to the database
      Connection conn = DriverManager.getConnection(url, user, password);

      // Create a statement to execute the SQL query
      Statement stmt = conn.createStatement();

	  String query = "CREATE TABLE IF NOT EXISTS s (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), phone_number VARCHAR(20), address VARCHAR(255), course_id VARCHAR(255), email VARCHAR(255))";
      stmt.executeUpdate(query);

      // Close the database connection
      conn.close();
    } catch (Exception e) 
	{
      e.printStackTrace();
    }
}

	public static void main(String args[]) throws IOException  
    {
		new sign();
        
	}
}

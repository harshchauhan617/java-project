import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.IOException;

import javax.swing.*;
class Student extends JFrame
{
	//JPanel p1 = new JPanel();

	JLabel l1=new JLabel("             ADMIN REGISTRATION   ");
  
	JLabel l3=new JLabel("username");
	JLabel l4=new JLabel("Password");
	JLabel l5=new JLabel("confirm_password");
	
    

	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	

	JRadioButton btn1 = new JRadioButton("I have rechecked all the filled information");

	JButton btn2 = new JButton("Submit");



	
	Student()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		//this.setBackground(Color.PINK);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1.setBounds(250,20,1000,45);this.add(l1);
		l1.setBackground(Color.black);
		l1.setForeground(Color.black);
		l1.setFont(new Font("Georgia", Font.PLAIN, 35));


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

		// set bound for textfields 
		
		t2.setBounds(350,300,600,30);this.add(t2);
		t3.setBounds(350,350,600,30);this.add(t3);
		t4.setBounds(350,400,600,30);this.add(t4);
		
        // set bound for buttons 
		btn1.setBounds(20,700,1000,30);this.add(btn1);
		btn2.setBounds(1100,700,150,30);this.add(btn2);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				createTableIfNotExists();
				
	  
			sa();
            dispose();
            }
        });
	}
		
	public void sa() {
	
		String username= t2.getText();
		String Password = t3.getText();
		String confirm_password = t4.getText();
		
				// Initialize database credentials
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "3001";
	
		try {
		  // Load the MySQL JDBC driver
		  Class.forName("com.mysql.jdbc.Driver");
	
		  // Create a connection to the database
		  Connection conn = DriverManager.getConnection(url, user, password);
	
		  // Create a prepared statement to execute the SQL query
		  String query = "INSERT INTO users (id INT NOT NULL AUTO_INCREMENT, username VARCHAR(50) NOT NULL, Password VARCHAR(50)NOT NULL,confirm_password VARCHAR(50)NOT NULL, PRIMARY KEY (id)) VALUES (?, ?, ?, ?)";
		  PreparedStatement stmt = conn.prepareStatement(query);
	
		  // Set the parameters for the query
		  
		  stmt.setString(2, username);
		  stmt.setString(3, Password);
          stmt.setString(4, confirm_password);
         

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

	  String query = "CREATE TABLE IF NOT EXISTS users(id INT NOT NULL AUTO_INCREMENT, username VARCHAR(50) NOT NULL, Password VARCHAR(50) NOT NULL,confirm_password VARCHAR(50) NOT NULL, PRIMARY KEY (id))";
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
		new Student();
        
	}
}

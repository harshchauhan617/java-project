import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.IOException;

import javax.swing.*;
class sig extends JFrame
{
	//JPanel p1 = new JPanel();

	JLabel l1=new JLabel(" ADD NEW COURSES TO YOUR DATABASE ");
    JLabel l2=new JLabel("Courseid");
	JLabel l3=new JLabel("Coursename");
	JLabel l4=new JLabel("CourseFaculty");
	JLabel l5=new JLabel("Teaching_hour");
	JLabel l6=new JLabel("Course_credit");
    
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();

	JRadioButton btn1 = new JRadioButton("I have rechecked all the filled information");

	JButton btn2 = new JButton("Submit");



	
	sig()
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
			sav();
                dispose();
            }
        });
	}
		
	public void sav() {
		String Courseid= t1.getText();
		String Coursename= t2.getText();
		String CourseFaculty = t3.getText();
		String Teaching_hour = t4.getText();		
		String Course_credit = t5.getText();		
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
		  String query = "INSERT INTO course (Courseid,Coursename,CourseFaculty, Teaching_hour, Course_credit) VALUES (?, ?, ?, ?, ?)";
		  PreparedStatement stmt = conn.prepareStatement(query);
	
		  // Set the parameters for the query
		  stmt.setString(1, Courseid);
		  stmt.setString(2, Coursename);
		  stmt.setString(3, CourseFaculty);
          stmt.setString(4, Teaching_hour);
          stmt.setString(5, Course_credit);

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

	  String query = "CREATE TABLE IF NOT EXISTS course (id INT AUTO_INCREMENT PRIMARY KEY, Courseid VARCHAR(255), Coursename VARCHAR(20), CourseFaculty VARCHAR(255), Teaching_hour VARCHAR(255),Course_credit VARCHAR(255))";
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
		new sig();
        
	}
}

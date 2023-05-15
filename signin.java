import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
class signin extends JFrame
{
	JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
	JLabel l1=new JLabel(" MAIN WINDOW ");
	JButton btn1 =new JButton("Student ");
	JButton btn2 =new JButton("Instructor ");
	JButton btn3 =new JButton("Add_Courses ");
	JButton btn4 =new JButton("ContactUs ");
	JButton btn5 =new JButton("Logout ");

    


	Button b1=new Button("Add");
	signin()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(p1);
		this.add(p2);
		p2.add(l1);
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		p2.add(btn5);
		


		// set layout
		p1.setLayout(null);
		p1.setBackground(Color.gray);
	    p1.setBounds(0, 0, 900, 800);
        p2.setLayout(null);
		p2.setBackground(Color.black);
        p2.setBounds(900, 0, 400, 800);
        
		l1.setBounds(50,50,400,30);
		l1.setBackground(Color.white);
		l1.setForeground(Color.white);
		l1.setFont(new Font("Georgia", Font.PLAIN, 35));
		btn1.setBounds(120,200,150,30);
		btn2.setBounds(120,300,150,30);
		btn3.setBounds(120,400,150,30);
		btn4.setBounds(120,500,150,30);
		btn5.setBounds(120,600,150,30);

btn1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new sign().setVisible(true);
}
});
btn2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new Instructor().setVisible(true);
}
});
btn3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new sig().setVisible(true);
}
});
btn4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new Contact_Us().setVisible(true);
}
});
btn5.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
new Logout().setVisible(true);
}
});
	}
	public static void main(String args[]) throws IOException  
    {
		new signin();
        
	}
}
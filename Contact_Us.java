import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
class Contact_Us extends JFrame
{
   
	JLabel l1=new JLabel("Contact_Us");
	JPanel p1=new JPanel();
	//JPanel p2=new JPanel();
    JButton b1 = new JButton("NAME");
    JButton b2 = new JButton("REG.NUMBER");
    JButton b3 = new JButton("EMAIL");
	JTextField t1=new JTextField("Aman Raj");
	JTextField t2=new JTextField("Harsh Kumar");
	JTextField t3=new JTextField("Shivani Singh");
	JTextField t4=new JTextField("12106020");
	JTextField t5=new JTextField("12105841");
	JTextField t6=new JTextField("12108334");
	JTextField t7=new JTextField("itsmeaman26266@gmail.com");
	JTextField t8=new JTextField("harshchouhanmsd4007@gmail.com");
	JTextField t9=new JTextField("s.singh331515@gmail.com");
	

	JButton b4=new JButton("Thank You");
    
	Contact_Us()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(p1);
		p1.add(l1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b4);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		p1.add(t8);
		p1.add(t9);
		
        l1.setBounds(550,20,250,35);
        b1.setBounds(250,325,250,35);
		t1.setBounds(250,360,250,35);
        t2.setBounds(250,395,250,35);
        t3.setBounds(250,430,250,35);
        b2.setBounds(500,325,250,35);
        t4.setBounds(500,360,250,35);
        t5.setBounds(500,395,250,35);
        t6.setBounds(500,430,250,35);
        b3.setBounds(750,325,250,35);
        t7.setBounds(750,360,250,35);
        t8.setBounds(750,395,250,35);
        t9.setBounds(750,430,250,35);
        b4.setBounds(950,600,200,35);
		b1.setFocusable(false);
		b2.setFocusable(false);
		b3.setFocusable(false);
		b4.setFocusable(false);

        p1.setSize(1300,800);
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);

		l1.setFont(new Font("Georgia", Font.PLAIN, 35));

		b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
		
	}
	public static void main(String args[]) throws IOException  
    {
		new Contact_Us();
        
	}
}
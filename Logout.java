import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
class Logout extends JFrame
{
   
	JLabel l1=new JLabel("Logout");
	JLabel l2=new JLabel("Thank you for visiting !");
	Button b1=new Button("Logout");
	JPanel p1=new JPanel();
	Logout()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(p1);
        p1.add(l1);
        p1.add(l2);
        p1.add(b1);
		p1.setSize(1300,800);
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);
        l1.setBounds(550,20,400,45);
		l2.setFont(new Font("Georgia", Font.PLAIN, 25));
		l2.setBounds(500,350,400,45);
		l1.setFont(new Font("Georgia", Font.PLAIN, 35));
        b1.setBounds(525,400,200,35);
		b1.setFocusable(false);

		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
                dispose();
            }
        });

		
	}
	public static void main(String args[]) throws IOException  
    {

		new Logout();
        
	}
}
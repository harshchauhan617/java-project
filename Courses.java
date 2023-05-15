import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
class Courses extends JFrame
{
   
	JLabel l1=new JLabel(" Courses");
	JPanel p1 = new JPanel();
	Button exit =new Button("Exit ");
	Courses()
	{
		this.setVisible(true);
		this.setSize(1300,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(p1);
        p1.add(l1);
        p1.add(exit);
		p1.setSize(1300,800);
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);
        l1.setBounds(500,20,500,45);
        exit.setBounds(1000,700,200,35);
		
		l1.setFont(new Font("Georgia", Font.PLAIN,45 ));


		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
	}
	public static void main(String args[]) throws IOException  
    {
		new Courses();
        
	}
}
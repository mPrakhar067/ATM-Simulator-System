package simulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4;
	JRadioButton r1,r2,r3,r4,r5;
	JButton b;
	JComboBox c1,c2,c3;
	
	Random rn = new Random();
	long numb = (rn.nextLong() % 9000L) + 1000L;
	long first = Math.abs(numb);
	
	Signup(){
		super("APPLICATION FORM FOR A NEW ACCOUNT");
		
		l1 = new JLabel("APPLICATION FORM NUMBER "+first);
		l1.setFont(new Font("",Font.BOLD,30));
		
		l2 = new JLabel("Personal Details");
		l2.setFont(new Font("",Font.BOLD,24));
		
		l3 = new JLabel("Name ");
		l3.setFont(new Font("",Font.BOLD,20));
		
		l4 = new JLabel("Father's Name ");
		l4.setFont(new Font("",Font.BOLD,20));
		
		l5 = new JLabel("D.O.B. ");
		l5.setFont(new Font("",Font.BOLD,20));
		
		l6 = new JLabel("Gender ");
		l6.setFont(new Font("",Font.BOLD,20));
		
		l7 = new JLabel("Email Address ");
		l7.setFont(new Font("",Font.BOLD,20));
		
		l8 = new JLabel("Marital Address ");
		l8.setFont(new Font("",Font.BOLD,20));
		
		l9 = new JLabel("Address ");
		l9.setFont(new Font("",Font.BOLD,20));
		
		t1 = new JTextField();
		t1.setFont(new Font("",Font.BOLD,14));
		
		t2 = new JTextField();
		t2.setFont(new Font("",Font.BOLD,14));
		
		t3 = new JTextField();
		t3.setFont(new Font("",Font.BOLD,14));
		
		t4 = new JTextField();
		t4.setFont(new Font("",Font.BOLD,14));
		
		b = new JButton("Click Next");
		b.setFont(new Font("", Font.BOLD,8));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("",Font.BOLD,14));
		r1.setBackground(Color.WHITE);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("",Font.BOLD,14));
		r2.setBackground(Color.WHITE);
		
		r3 = new JRadioButton("Married");
		r3.setFont(new Font("",Font.BOLD,14));
		r3.setBackground(Color.WHITE);
		
		r4 = new JRadioButton("UnMarried");
		r4.setFont(new Font("",Font.BOLD,14));
		r4.setBackground(Color.WHITE);
		
		r5 = new JRadioButton("Other");
		r5.setFont(new Font("",Font.BOLD,14));
		r5.setBackground(Color.WHITE);
		
		String date[] = {"1","2","3","4","5","6","7","8","9"};
		c1 = new JComboBox(date);
		c1.setBackground(Color.WHITE);
		
		String month[] = {"jan","feb","mar","apr","may","jun","july","aug","sept","oct","nov","dec"};
		c2 = new JComboBox(month);
		c2.setBackground(Color.WHITE);
		
		String year[] = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};
		c3 = new JComboBox(year);
		c3.setBackground(Color.WHITE);
		
		setLayout(null);
		l1.setBounds(140,20,600,40);
		add(l1);
		
		l2.setBounds(290,70,600,30);
		add(l2);
		
		l3.setBounds(100,140,100,30);
		add(l3);
		
		l4.setBounds(100,190,200,30);
		add(l4);
		
		l5.setBounds(100,240,200,30);
		add(l5);
		
		l6.setBounds(100,290,200,30);
		add(l6);
		
		l7.setBounds(100,340,200,30);
		add(l7);
		
		l8.setBounds(100,390,200,30);
		add(l8);
		
		l9.setBounds(100,440,200,30);
		add(l9);
		
		t1.setBounds(300,140,400,30);
		add(t1);
		
		t2.setBounds(300,190,400,30);
		add(t2);
		
		t3.setBounds(300,340,400,30);
		add(t3);
		
		t4.setBounds(300,440,400,30);
		add(t4);
		
		r1.setBounds(300,290,60,30);
		add(r1);
		
		r2.setBounds(450,290,80,30);
		add(r2);
		
		r3.setBounds(300,390,100,30);
		add(r3);
		
		r4.setBounds(450,390,100,30);
		add(r4);
		
		r5.setBounds(635,390,100,30);
		add(r5);
		
		b.setBounds(620,660,80,30);
		add(b);
		b.addActionListener(this);
		
		c1.setBounds(340,240,60,30);
		add(c1);
		
		c2.setBounds(460,240,100,30);
		add(c2);
		
		c3.setBounds(610,240,90,30);
		add(c3);
		
		setSize(850,850);
		setLocation(500,90);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String a = t1.getText();
		String b = t2.getText();
		String ac = (String)c1.getSelectedItem();
		String bc = (String)c2.getSelectedItem();
		String cc = (String)c3.getSelectedItem();
		
		String d = null;
		if(r1.isSelected()) {
			d = "Male";
		}else if(r2.isSelected()) {
			d = "Female";
		}
		String e = t3.getText();
		String f = null;
		if(r3.isSelected()) {
			f = "Married";
		}else if(r4.isSelected()) {
			f = "UnMarried";
		}else if(r5.isSelected()) {
			f = "other";
		}
		String g = t4.getText();
		
		try {
			if(t4.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "fill the required fields");
			}else {
				connection c1 = new connection();
				String q1 = "insert into signup values('"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+f+"','"+g+"','"+first+"')";
				c1.s.executeUpdate(q1);
				
				new Signup2().setVisible(true);
				setVisible(false);
			}
			
		}catch(Exception ea) {
			ea.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Signup().setVisible(true);
	}
}

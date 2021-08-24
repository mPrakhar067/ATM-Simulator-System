package simulatorSystem;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	login(){
		super("Banking Page");
		
		l1 = new JLabel("Welcome to the Bank");
		l1.setFont(new Font("", Font.BOLD,40));
		
		l2 = new JLabel("ATM Card Number");
		l2.setFont(new Font("",Font.BOLD,20));
		
		l3 = new JLabel("Pin");
		l3.setFont(new Font("",Font.BOLD,26));
		
		t1 = new JTextField();
		
		t2 = new JTextField();
		
		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.GREEN);
		b1.setForeground(Color.BLACK);
		
		b2 = new JButton("SIGN UP");
		b2.setBackground(Color.RED);
		b2.setForeground(Color.BLACK);
		
		b3 = new JButton("CLEAR");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(175,50,450,200);
		add(l1);
		
		l2.setBounds(125,150,375,200);
		add(l2);
		
		l3.setBounds(125,225,375,200);
		add(l3);
		
		t1.setFont(new Font("",Font.BOLD,16));
		t1.setBounds(300,235,230,30);
		add(t1);
		
		t2.setFont(new Font("",Font.BOLD,16));
		t2.setBounds(300,315,230,30);
		add(t2);
		
		b1.setFont(new Font("",Font.BOLD,16));
		b1.setBounds(300,400,230,30);
		add(b1);
		
		b2.setFont(new Font("",Font.BOLD,16));
		b2.setBounds(300,450,100,30);
		add(b2);
		
		b3.setFont(new Font("",Font.BOLD,16));
		b3.setBounds(450,450,100,30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setSize(750,750);
		setLocation(300,150);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			connection c1 = new connection();
			String a = t1.getText();
			String b = t2.getText();
			String q = "select * from login where cardno ='"+a+"' and Pin = '"+b+"'";
			ResultSet rs = c1.s.executeQuery(q);
			
			if(ae.getSource()==b1) {
				if(rs.next()) {
					new Transactions().setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect ATM Card Number or PIN");
				}
			}else if(ae.getSource()==b2){
					new Signup().setVisible(true);
					setVisible(false);
				}else if(ae.getSource()==b3) {
				t1.setText("");
				t2.setText("");
			
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error "+e);
	}
}
	public static void main(String[] args) {
		new login().setVisible(true);
	}
}

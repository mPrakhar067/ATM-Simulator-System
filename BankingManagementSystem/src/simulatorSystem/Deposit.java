package simulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
	JTextField t1,t2;
	JButton b1,b2,b3;
	JLabel l1,l2;
	
	Deposit(){
		super("Deposit");
		
		l1 = new JLabel("Enter the Amount");
		l1.setFont(new Font("",Font.BOLD,38));
		
		l2 = new JLabel("Pin");
		l2.setFont(new Font("",Font.BOLD,38));
		
		t1 = new JTextField();
		t1.setFont(new Font("",Font.BOLD,12));
		
		t2 = new JTextField();
		t2.setFont(new Font("",Font.BOLD,12));
		
		b1 = new JButton("Deposit");
		b1.setFont(new Font("", Font.BOLD,18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Back");
		b2.setFont(new Font("", Font.BOLD,18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("Exit");
		b3.setFont(new Font("", Font.BOLD,18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l2.setBounds(620,10,80,30);
		add(l2);
		
		t2.setBounds(700,10,40,30);
		add(t2);
		
		l1.setBounds(150,150,800,60);
		add(l1);
		
		t1.setBounds(250,300,300,50);
		add(t1);
		
		b1.setBounds(260,380,125,50);
		add(b1);
		b1.addActionListener(this);
		
		b2.setBounds(415,380,125,50);
		add(b2);
		b2.addActionListener(this);
		
		b3.setBounds(300,550,200,50);
		add(b3);
		b3.addActionListener(this);
		
		setSize(800,800);
		setLocation(500,90);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			String a = t1.getText();
			String b = t2.getText();
			
			if(ae.getSource()==b1) {
				if(t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"please enter the amount");
				}else {
					connection c1 = new connection();
					
					ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+b+"'");
					
					double balance = 0;
					if(rs.next()) {
						String pin = rs.getString("pin");
						
						balance = rs.getDouble("balance");
						
						double d = Double.parseDouble(a);
						balance+=d;
						String q1 = "insert into bank (pin,deposit,withdraw,balance) values('"+pin+"','"+d+"',null,'"+balance+"')";
						
						c1.s.executeUpdate(q1);
					}
					JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited successfully");
					
					new Transactions().setVisible(true);
					setVisible(false);
					
				}
			}else if(ae.getSource()==b2) {
				new Transactions().setVisible(true);
				setVisible(false);
			}else if(ae.getSource()==b3) {
				System.exit(0);
			}
		}catch(Exception ee) {
			ee.printStackTrace();
			System.out.println("error"+ee);
		}
	}
	public static void main(String[] args) {
		new Deposit().setVisible(true);
	}
}

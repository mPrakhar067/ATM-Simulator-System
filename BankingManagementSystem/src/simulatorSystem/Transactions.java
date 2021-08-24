package simulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{
	
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7;

	Transactions(){
		super("Transactions");
		l1 = new JLabel("please select your transaction");
		l1.setFont(new Font("",Font.BOLD,38));
		
		b1 = new JButton("Deposit");
		b1.setFont(new Font("", Font.BOLD,18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Cash Withdrawl");
		b2.setFont(new Font("", Font.BOLD,18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("Mini Statement");
		b3.setFont(new Font("", Font.BOLD,18));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		b4 = new JButton("Pin Change");
		b4.setFont(new Font("", Font.BOLD,18));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		
		b5 = new JButton("Balance");
		b5.setFont(new Font("", Font.BOLD,18));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		
		b6 = new JButton("Cancel");
		b6.setFont(new Font("", Font.BOLD,18));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(100,100,700,40);
		add(l1);
		
		b1.setBounds(40,250,300,60);
		add(b1);
		b1.addActionListener(this);
		
		b2.setBounds(440,250,300,60);
		add(b2);
		b2.addActionListener(this);
		
		b3.setBounds(40,360,300,60);
		add(b3);
		b3.addActionListener(this);
		
		b4.setBounds(440,360,300,60);
		add(b4);
		b4.addActionListener(this);
		
		b5.setBounds(40,470,300,60);
		add(b5);
		b5.addActionListener(this);
		
		b6.setBounds(240,600,300,60);
		add(b6);
		b6.addActionListener(this);
		
		setSize(800,800);
		setLocation(500,90);
		setVisible(true);
		
	}
		public void actionPerformed(ActionEvent ae) {
			 if(ae.getSource()==b1){
				new Deposit().setVisible(true);
				setVisible(false);
			}else if(ae.getSource()==b2){
				new Withdrawl().setVisible(true);
				setVisible(false);
			}else if(ae.getSource()==b3){
				new login().setVisible(true);
				setVisible(false);
			}else if(ae.getSource()==b4){
				new Pin().setVisible(true);
				setVisible(false);
			}else if(ae.getSource()==b5){
				String pinn = JOptionPane.showInputDialog("Enter pin");
				connection c1 = new connection();
				try {
					ResultSet rs = c1.s.executeQuery(" SELECT balance FROM bank ORDER BY pin ='"+pinn+"' DESC LIMIT 1");
					if(rs.next()) {
						String balance = rs.getString("balance");
						JOptionPane.showMessageDialog(null,"your ac balance is "+balance);
					}
				}catch(Exception ed){
					ed.printStackTrace();
				}
			}else if(ae.getSource()==b6){
				System.exit(0);
			}
		}
		public static void main(String[] args) {
			new Transactions().setVisible(true);
		}
	}

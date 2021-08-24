package simulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Pin extends JFrame implements ActionListener {
	JTextField t1,t2,t3;
	JButton b1,b2;
	JLabel l1,l2,l3,l4;
	
	Pin(){
		super("PIN CHANGE");
		
		l1 = new JLabel("Change your pin");
		l1.setFont(new Font("",Font.BOLD,22));
		
		l2 = new JLabel("Current pin");
		l2.setFont(new Font("",Font.BOLD,18));
		
		l3 = new JLabel("New Pin");
		l3.setFont(new Font("",Font.BOLD,18));
		
		l4 = new JLabel("Re enter");
		l4.setFont(new Font("",Font.BOLD,18));
		
		t1 = new JTextField();
		t1.setFont(new Font("",Font.BOLD,14));
		
		t2 = new JTextField();
		t2.setFont(new Font("",Font.BOLD,14));
		
		t3 = new JTextField();
		t3.setFont(new Font("",Font.BOLD,14));
		
		b1 = new JButton("Save");
		b1.setFont(new Font("", Font.BOLD,18));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Back");
		b2.setFont(new Font("", Font.BOLD,18));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(100,130,800,60);
		add(l1);
		
		l2.setBounds(100,240,150,40);
		add(l2);
		
		l3.setBounds(100,300,150,40);
		add(l3);
		
		l4.setBounds(100,360,200,40);
		add(l4);
		
		t1.setBounds(310,240,360,40);
		add(t1);
		
		t2.setBounds(310,300,360,40);
		add(t2);
		
		t3.setBounds(310,360,360,40);
		add(t3);
		
		b1.setBounds(220,460,160,50);
		add(b1);
		b1.addActionListener(this);
		
		b2.setBounds(400,460,160,50);
		add(b2);
		b2.addActionListener(this);
		
		setSize(800,800);
		setLocation(500,90);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae) {
			try {
				String a = t1.getText();
				String b = t2.getText();
				String c = t3.getText();
				
				if(ae.getSource()==b1) {
					if(t1.getText().contentEquals("")) {
						JOptionPane.showMessageDialog(null,"please enter current pin");
					}
					if(t2.getText().contentEquals("")) {
						JOptionPane.showMessageDialog(null,"please enter new pin");
					}
					if(t3.getText().contentEquals("")) {
						JOptionPane.showMessageDialog(null,"please Reenter new pin");
					}
					if(t2.getText().contentEquals(t3.getText())) {
						
						if(t2.getText()=="") {
							JOptionPane.showMessageDialog(null,"please enter new pin");
						}
						connection c1 = new connection();
						String q1 = "Update bank set pin = '"+b+"' where pin = '"+a+"'";
						String q2 = "Update login set pin = '"+b+"' where pin = '"+a+"'";
						String q3 = "Update signup3 set pin = '"+b+"' where pin = '"+a+"'";
						
						c1.s.executeUpdate(q1);
						c1.s.executeUpdate(q2);
						c1.s.executeUpdate(q3);
						
						JOptionPane.showMessageDialog(null,"Pin changed");
						
						new Transactions().setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,"Pin doesn't match");
					}
				}else if(ae.getSource()==b2) {
					new Transactions().setVisible(true);
					setVisible(false);
				}
			}catch(Exception ef) {
				ef.printStackTrace();
				System.out.println("error "+ef);
			}
		}
		public static void main(String[] args) {
			new Pin().setVisible(true);
		}
	
}

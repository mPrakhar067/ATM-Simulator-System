package simulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup2 extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b;
	JRadioButton r1,r2,r3,r4;
	JTextField t1,t2,t3;
	JComboBox c1,c2,c3,c4,c5;
	
	Signup2(){
		super("NEW ACCOUNT REGISTRATION PAGE2");
		
		l1 = new JLabel("Additional Details");
		l1.setFont(new Font("",Font.BOLD,22));
		
		l2 = new JLabel("Religion ");
		l2.setFont(new Font("",Font.BOLD,18));
		
		l3 = new JLabel("Category  ");
		l3.setFont(new Font("",Font.BOLD,18));
		
		l4 = new JLabel("Income ");
		l4.setFont(new Font("",Font.BOLD,18));
		
		l5 = new JLabel("Educational ");
		l5.setFont(new Font("",Font.BOLD,18));
		
		l6 = new JLabel("Qualification ");
		l6.setFont(new Font("",Font.BOLD,18));
		
		l7 = new JLabel("Occupation ");
		l7.setFont(new Font("",Font.BOLD,18));
		
		l8 = new JLabel("Pan Number ");
		l8.setFont(new Font("",Font.BOLD,18));
		
		l9 = new JLabel("Aadhar No ");
		l9.setFont(new Font("",Font.BOLD,20));
		
		l10 = new JLabel("Senior Citizen ");
		l10.setFont(new Font("",Font.BOLD,16));
		
		l11 = new JLabel("Existing account ");
		l11.setFont(new Font("",Font.BOLD,16));
		
		l12 = new JLabel("Form no ");
		l12.setFont(new Font("",Font.BOLD,12));
		
		b = new JButton("Click Next");
		b.setFont(new Font("", Font.BOLD,12));
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		
		t1 = new JTextField();
		t1.setFont(new Font("",Font.BOLD,14));
		
		t2 = new JTextField();
		t2.setFont(new Font("",Font.BOLD,14));
		
		t3 = new JTextField();
		t3.setFont(new Font("",Font.BOLD,14));
		
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("",Font.BOLD,14));
		r1.setBackground(Color.WHITE);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("",Font.BOLD,14));
		r2.setBackground(Color.WHITE);
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("",Font.BOLD,14));
		r3.setBackground(Color.WHITE);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("",Font.BOLD,14));
		r4.setBackground(Color.WHITE);
		
		String religion[] = {"Hindu","Muslim","Sikh","CHristian","Other"};
		c1 = new JComboBox(religion);
		c1.setBackground(Color.WHITE);
		
		String category[] = {"General","OBC","SC","ST","Other"};
		c2 = new JComboBox(category);
		c2.setBackground(Color.WHITE);
		
		String income[] = {"<1lc","<5lc",">5lc"};
		c3 = new JComboBox(income);
		c3.setBackground(Color.WHITE);
		
		String education[] = {"non graduate","graduate","post graduate","others"};
		c4 = new JComboBox(education);
		c4.setBackground(Color.WHITE);
		
		String occupation[] = {"Salaried","Self employed","Business","Student","Retired","others"};
		c5 = new JComboBox(occupation);
		c5.setBackground(Color.WHITE);
		
		setLayout(null);
		l12.setBounds(700,10,60,30);
		add(l12);
		
		t3.setBounds(760,10,60,30);
		add(t3);
		
		l1.setBounds(280,30,600,40);
		add(l1);
		
		l2.setBounds(100,120,100,30);
		add(l2);
		
		c1.setBounds(350,120,320,30);
		add(c1);
		
		l3.setBounds(100,170,100,30);
		add(l3);
		
		c2.setBounds(350,170,320,30);
		add(c2);
		
		l4.setBounds(100,220,100,30);
		add(l4);
		
		c3.setBounds(350,220,320,30);
		add(c3);
		
		l5.setBounds(100,270,150,30);
		add(l5);
		
		c4.setBounds(350,280,320,30);
		add(c4);
		
		l6.setBounds(100,290,150,30);
		add(l6);
		
		c5.setBounds(350,340,320,30);
		add(c5);
		
		l7.setBounds(100,340,150,30);
		add(l7);
		
		t1.setBounds(350,390,320,30);
		add(t1);
		
		l8.setBounds(100,390,180,30);
		add(l8);
		
		t2.setBounds(350,440,320,30);
		add(t2);
		
		l9.setBounds(100,440,150,30);
		add(l9);
		
		r1.setBounds(350,490,100,30);
		add(r1);
		
		r2.setBounds(460,490,100,30);
		add(r2);
		
		l10.setBounds(100,490,180,30);
		add(l10);
		
		l11.setBounds(100,540,150,30);
		add(l11);
		
		r3.setBounds(350,540,100,30);
		add(r3);
		
		r4.setBounds(460,540,100,30);
		add(r4);
		
		b.setBounds(570,600,100,30);
		add(b);
		b.addActionListener(this);
		
		setSize(850,850);
		setLocation(500,90);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String a = (String)c1.getSelectedItem();
		String b = (String)c2.getSelectedItem();
		String c = (String)c3.getSelectedItem();
		String d = (String)c4.getSelectedItem();
		String e = (String)c5.getSelectedItem();
		String f = t1.getText();
		String g = t2.getText();
		
		String h = "";
		if(r1.isSelected()) {
			h = "Yes";
		}else if(r2.isSelected()) {
			h = "No";
		}
		String i = "";
		if(r3.isSelected()) {
			i = "Yes";
		}else if(r4.isSelected()) {
			i = "No";
		}
		String j = t3.getText();
	try {
		if(t2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "fill the required fields");
		}else {
			connection c1 = new connection();
			String q1 = "insert into signup2 values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
			c1.s.executeUpdate(q1);
			
			new Signup3().setVisible(true);
			setVisible(false);
		}
		
	}catch(Exception eb) {
		eb.printStackTrace();
	}
}
public static void main(String[] args) {
	new Signup2().setVisible(true);
}

}

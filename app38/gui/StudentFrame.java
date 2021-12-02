package com.marina.app38.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.marina.app38.action.StudentAction;

public class StudentFrame extends Frame implements ActionListener {
	Label l1, l2, l3;
	TextField tf1, tf2, tf3;
	Button b;
	String status = "";
	StudentAction studentAction;
	
	public StudentFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Student Frame");
		this.setBackground(Color.green);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		l1 = new Label("Student Id       ");
		l2 = new Label("Student Name     ");
		l3 = new Label("Student Address  ");
		
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf3 = new TextField(20);
		
		b = new Button("ADD");
		b.addActionListener(this);
		
		Font font = new Font("arial", Font.BOLD, 20);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		tf1.setFont(font);
		tf2.setFont(font);
		tf3.setFont(font);
		b.setFont(font);
		
		this.add(l1); this.add(tf1);
		this.add(l2); this.add(tf2);
		this.add(l3); this.add(tf3);
		this.add(b);
		studentAction = new StudentAction();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String sid = tf1.getText();
		String sname = tf2.getText();
		String saddr = tf3.getText();
		status = studentAction.add(sid, sname, saddr);
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		Font font = new Font("arial", Font.BOLD, 30);
		g.setFont(font);
		g.drawString("Status   : "+status, 50, 300);
	}

}
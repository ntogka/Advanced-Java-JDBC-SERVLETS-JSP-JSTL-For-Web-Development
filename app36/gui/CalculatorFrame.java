package com.marina.app36.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorFrame extends Frame implements ActionListener {
	
	Label l1, l2, l3;
	TextField tf1, tf2, tf3;
	Button b1,b2,b3;
	
	public CalculatorFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Calculator Frame");
		this.setBackground(Color.pink);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		l1 = new Label("First Value   ");
		l2 = new Label("Second Value  ");
		l3 = new Label("Result        ");
		
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf3 = new TextField(20);
		
		b1 = new Button("ADD");
		b2 = new Button("SUB");
		b3 = new Button("MUL");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		Font font = new Font("consolas", Font.BOLD, 20);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		tf1.setFont(font);
		tf2.setFont(font);
		tf3.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);		
		
		this.add(l1); this.add(tf1);
		this.add(l2); this.add(tf2);
		this.add(l3); this.add(tf3);
		this.add(b1); this.add(b2); this.add(b3);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			
			int val1 = Integer.parseInt(tf1.getText());
			int val2 = Integer.parseInt(tf2.getText());
			
			int result = 0;
			String label = ae.getActionCommand();
			if(label.equalsIgnoreCase("ADD")) {
				result = val1 + val2;
			}
			if(label.equalsIgnoreCase("SUB")) {
				result = val1 - val2;
			}
			if(label.equalsIgnoreCase("MUL")) {
				result = val1 * val2;
			}
			
			tf3.setText(""+result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

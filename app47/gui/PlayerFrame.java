package com.marina.app47.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.marina.app47.action.PlayerAction;
import com.marina.app47.beans.Employee;

public class PlayerFrame extends Frame implements ActionListener {

	Button b1, b2, b3, b4;
	PlayerAction playerAction = null;
	Employee emp = null;

	public PlayerFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Player Frame");
		this.setLayout(null);
		this.setBackground(Color.pink);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b1 = new Button("First");
		b2 = new Button("Next");
		b3 = new Button("Previous");
		b4 = new Button("Last");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		Font font = new Font("arial", Font.BOLD, 20);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		b1.setBounds(50, 400, 100, 35);
		this.add(b1);		
		b2.setBounds(150, 400, 100, 35);
		this.add(b2);
		b3.setBounds(250, 400, 100, 35);
		this.add(b3);
		b4.setBounds(350, 400, 100, 35);
		this.add(b4);
		
		playerAction = new PlayerAction();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String buttonLabel = ae.getActionCommand();
		emp = playerAction.getEmployee(buttonLabel);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("consolas", Font.BOLD, 35);
		g.setFont(font);
		if (emp != null) {
			g.drawString("ENO    : " + emp.getEno(), 100, 150);
			g.drawString("ENAME  : " + emp.getEname(), 100, 200);
			g.drawString("ESAL   : " + emp.getEsal(), 100, 250);
			g.drawString("EADDR  : " + emp.getEaddr(), 100, 300);
		}else {
			g.drawString("No Employee Found", 100, 250);
		}
	}
}
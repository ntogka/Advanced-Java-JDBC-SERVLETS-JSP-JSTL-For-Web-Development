package com.marina.app35.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CalculatorFrame extends Frame {
	public CalculatorFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Calculator Frame");
		this.setBackground(Color.green);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
}
package com.marina.app34.gui;

import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class LogoFrame extends Frame {
	public LogoFrame() {
		this.setVisible(true);
		this.setTitle("LogoFrame");
		this.setSize(700, 300);
		this.setBackground(Color.pink);
	}
	public void paint (Graphics g) {
		Font font = new Font ("arial", Font.BOLD, 30);
		g.setFont(font);
		this.setForeground(Color.white);
		g.drawString("Marina", 100, 100);
	}

}

package com.marina.app39.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.marina.app39.action.SQLEditorAction;

public class SQLEditorFrame extends Frame implements ActionListener {

	Label l;
	TextArea ta;
	Button b;
	SQLEditorAction sqlEditorAction;
	boolean type;
	
	public SQLEditorFrame() {
		this.setVisible(true);
		this.setSize(700, 700);
		this.setTitle("SQL Editor Frame");
		this.setBackground(Color.pink);
		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		l = new Label("Enter SQL Query");
		ta = new TextArea(5, 40);
		b = new Button("Execute");
		b.addActionListener(this);
		
		Font font = new Font("arial", Font.BOLD, 20);
		l.setFont(font);
		ta.setFont(font);
		b.setFont(font);
		
		this.add(l);
		this.add(ta);
		this.add(b);
		sqlEditorAction = new SQLEditorAction();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String query = ta.getText();
		type = sqlEditorAction.executeQuery(query);
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		try {
			Font font = new Font("arial",Font.BOLD,30);
			g.setFont(font);
			if(type == true) {
				ResultSet rs = sqlEditorAction.getResultSet();
				ResultSetMetaData md = rs.getMetaData();
				int columnCount = md.getColumnCount();
				int x = 50;
				int y = 300;
				for(int colIndex = 1; colIndex <= columnCount; colIndex++ ) {
					g.drawString(md.getColumnName(colIndex), x, y);
					x = x + 150;
				}
				x = 50;
				y = 350;
				g.drawString("-------------------------------------------------------------------", x, y);
				x = 50;
				y = 400;
				while(rs.next()) {
					for(int colIndex = 1; colIndex <= columnCount; colIndex++) {
						g.drawString(rs.getString(colIndex), x, y);
						x = x + 150;
					}
					x = 50;
					y = y + 50;
				}
			}else {
				int rowCount = sqlEditorAction.getRowCount();
				g.drawString("Records Manipulated  : "+rowCount, 50, 400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
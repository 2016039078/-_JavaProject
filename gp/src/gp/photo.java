package gp;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class photo extends JFrame {
	JScrollPane scroll;
	ImageIcon icon;
	
	public photo() {
		icon = new ImageIcon("C:\\Users\\qhddb\\git\\soboksobok_JavaProJ\\gp\\src\\gp\\b.l.t.jpg");
		
		JPanel back = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		JButton button = new JButton("¹öÆ°");
		back.add(button);
		scroll = new JScrollPane(back);
		setContentPane(scroll);
	}
	public static void main(String[] args) {
		photo frame = new photo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(430,280);
		frame.setVisible(true);
	}
}

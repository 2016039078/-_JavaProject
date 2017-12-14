package order;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Frame extends JFrame {
    public Frame() {
        setTitle("Difference between Exit and Dispose First Frame");
        setSize(430, 110);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JButton btnDispose = new JButton("Dispose");
        btnDispose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnDispose.setBounds(10, 10, 100, 50);
        getContentPane().add(btnDispose);
         
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnExit.setBounds(120, 10, 100, 50);
        getContentPane().add(btnExit);
         
        JButton btnShow = new JButton("Show Another Frame");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AnotherFrame();
            }
        });
        btnShow.setBounds(230, 10, 170, 50);
        getContentPane().add(btnShow);
 
        setVisible(true);
    }
    public static void main(String args[]) {
    	Frame F = new Frame();
    }
}
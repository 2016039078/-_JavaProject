package order;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import order.Start.MyPanel;

public class AnotherFrame extends JFrame{
	BufferedImage img=null;
    public AnotherFrame() {
        setTitle("주문 완료");
        setSize(450, 400);
        setLocation(0, 120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        try {
            img = ImageIO.read(new File("C:\\Users\\qhddb\\git\\soboksobok_JavaProJ\\order\\src\\order\\sub.png"));
     } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
      }

     add(new MyPanel());
     pack();
         
        setVisible(true);
    }
    class MyPanel extends JPanel {

        public void paint(Graphics g) {
               g.drawImage(img, 0, 0, null);
        }

        public Dimension getPreferredSize() {
               if (img == null) {
                      return new Dimension(100, 100);
               } else {
                      return new Dimension(img.getWidth(null), img.getHeight(null));
               }
        }
  }
}
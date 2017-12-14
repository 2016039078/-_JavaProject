package order;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

class MyFrame extends JFrame implements ActionListener{
	private JPanel menu; //menu panel
	private JPanel plus; //plus menu panel
	private JPanel bread; //bread panel
	private JPanel sauce; //sauce panel
	private JPanel curr; //current price panel
	
	JLabel label;
	int result = 0;
	Font font;
	
	JCheckBox m1,m2,m3; //menu box
	JCheckBox p1,p2,p3,p4,p5; //plus menu box
	JCheckBox b1,b2,b3; //bread box
	JCheckBox s1,s2,s3; //sauce box
	
	ButtonGroup Menu = new ButtonGroup();
	ButtonGroup Plus = new ButtonGroup();
	ButtonGroup Bread = new ButtonGroup();
	ButtonGroup Sauce = new ButtonGroup();
	
	JButton button = new JButton();
	
	public MyFrame() {
		setTitle("Subway customizing");
		this.setSize(450, 400);
		//getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border bmenu = BorderFactory.createTitledBorder("�޴�");
		menu = new JPanel();
		m1 = new JCheckBox("���׸���");
		m2 = new JCheckBox("B.L.T");
		m3 = new JCheckBox("��Ű");
		Menu.add(m1);
		Menu.add(m2);
		Menu.add(m3);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		add(menu, BorderLayout.NORTH);
		menu.setBorder(bmenu);
		
		GridLayout gplus = new GridLayout(5,1);
		Border bplus = BorderFactory.createTitledBorder("�߰� ����");
		plus = new JPanel();
		plus.setLayout(gplus);
		p1 = new JCheckBox("�ƺ�ī��");
		p2 = new JCheckBox("�����Ʈ");
		p3 = new JCheckBox("����ġ��");
		p4 = new JCheckBox("������");
		p5 = new JCheckBox("���");
		Plus.add(p1);
		Plus.add(p2);
		Plus.add(p3);
		Plus.add(p4);
		Plus.add(p5);
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		p4.addActionListener(this);
		p5.addActionListener(this);
		plus.add(p1);
		plus.add(p2);
		plus.add(p3);
		plus.add(p4);
		plus.add(p5);
		add(plus, BorderLayout.WEST);
		plus.setBorder(bplus);
		
		GridLayout gbread = new GridLayout(3,1);
		Border bbread = BorderFactory.createTitledBorder("��");
		bread = new JPanel();
		bread.setLayout(gbread);
		b1 = new JCheckBox("ȭ��Ʈ");
		b2 = new JCheckBox("�÷�");
		b3 = new JCheckBox("�ĸ���");
		Bread.add(b1);
		Bread.add(b2);
		Bread.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		bread.add(b1);
		bread.add(b2);
		bread.add(b3);
		add(bread, BorderLayout.CENTER);
		bread.setBorder(bbread);
		
		GridLayout gsauce = new GridLayout(3,1);
		Border bsauce = BorderFactory.createTitledBorder("�ҽ�");
		sauce = new JPanel();
		sauce.setLayout(gsauce);
		s1 = new JCheckBox("����� ���Ϸ���");
		s2 = new JCheckBox("����Ʈ ĥ��");
		s3 = new JCheckBox("��ġ �巹��");
		Sauce.add(s1);
		Sauce.add(s2);
		Sauce.add(s3);
		s1.addActionListener(this);
		s2.addActionListener(this);
		s3.addActionListener(this);
		sauce.add(s1);
		sauce.add(s2);
		sauce.add(s3);
		add(sauce, BorderLayout.EAST);
		sauce.setBorder(bsauce);
		
		curr = new JPanel();
		font = new Font("Dialog", Font.BOLD|Font.ITALIC,20);
		label = new JLabel("��������� �ݾ��� "+result+"�� �Դϴ�.");
		label.setFont(font);
		curr.add(label);
		button = new JButton("�ֹ�");
		button.addActionListener(this);
		curr.add(button);
		add(curr, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == m1) {
			result += 4300;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == m2) {
			result += 4700;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == m3) {
			result += 4700;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == p1) {
			result += 1500;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == p2) {
			result += 900;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == p3) {
			result += 700;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == p4) {
			result += 900;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource() == p5) {
			result += 700;
			label.setText("��������� �ݾ��� "+result+"�� �Դϴ�.");
		}
		if(e.getSource()==button) {
			AnotherFrame af = new AnotherFrame();
		}
	}
}

public  class Employee{
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}
}

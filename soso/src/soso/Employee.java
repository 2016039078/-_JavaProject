package soso;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class MyFrame extends JFrame implements ActionListener{

	private JPanel order_M; //�ֹ� �ȳ� �г�
	private JPanel menu; //�޴� �г�
	private JPanel plus; //�߰� �г�
	private JPanel bread; //�� �г�
	private JPanel source; //�ҽ� �г�
	private JPanel Curr; //���� ���� �г�
	JLabel label;
	JCheckBox b1,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	int result=0;
	Font font;
	
	//private JPanel topPanel;
	ButtonGroup Menu = new ButtonGroup();
	ButtonGroup Plus = new ButtonGroup();
	ButtonGroup Bread = new ButtonGroup();
	ButtonGroup Source = new ButtonGroup();
	
	JButton button = new JButton("�ֹ� �Ϸ�");
	
	public MyFrame() {
		setTitle("Subway customizing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		
		order_M=new JPanel();
		JLabel lab = new JLabel("�ֹ��Ͻðڽ��ϱ�?");
		order_M.add(lab);
		add(order_M, BorderLayout.PAGE_START);
		
		Border bmenu=BorderFactory.createTitledBorder("�޴�");
		menu=new JPanel();
		b1=new JCheckBox("���׸���");
		b3=new JCheckBox("BLT");
		b4=new JCheckBox("��Ű");
		
		Menu.add(b1);
		Menu.add(b3);
		Menu.add(b4);	
		b1.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		menu.add(b1);
		menu.add(b3);
		menu.add(b4);
		//menu.setLayout(null);
		add(menu, BorderLayout.LINE_START);
		//menu.setBounds(20,5,95,30);
		menu.setBorder(bmenu);
		
		Border bplus=BorderFactory.createTitledBorder("�߰� ����");
		plus=new JPanel();
		b5= new JCheckBox("�ƺ�ī��");
		b6= new JCheckBox("�����Ʈ");
		b7=new JCheckBox("����ġ��");
		b8= new JCheckBox("������");
		b9=new JCheckBox("���");
		
		Plus.add(b5);
		Plus.add(b6);
		Plus.add(b7);
		Plus.add(b8);
		Plus.add(b9);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		plus.add(b5);
		plus.add(b6);
		plus.add(b7);
		plus.add(b8);
		plus.add(b9);
		add(plus, BorderLayout.CENTER);
		plus.setBorder(bplus);
		
		Border bbread=BorderFactory.createTitledBorder("��");
		bread=new JPanel();
		b10= new JCheckBox("ȭ��Ʈ");
		b11=new JCheckBox("�÷�");
		b12= new JCheckBox("�ĸ���");
		
		Bread.add(b10);
		Bread.add(b11);
		Bread.add(b12);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		bread.add(b10);
		bread.add(b11);
		bread.add(b12);
		add(bread, BorderLayout.LINE_END);
		bread.setBorder(bbread);
		
		Border bsource=BorderFactory.createTitledBorder("�ҽ�");
		source=new JPanel();
		b13=new JCheckBox("����� ���Ϸ���");
		b14= new JCheckBox("����Ʈ ĥ��");
		b15=new JCheckBox("��ġ �巹��");
		
		Source.add(b13);
		Source.add(b14);
		Source.add(b15);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		source.add(b13);
		source.add(b14);
		source.add(b15);
		add(source, BorderLayout.PAGE_END);
		source.setBorder(bsource);
		
		Curr=new JPanel();
		font = new Font("Dialog",Font.BOLD|Font.ITALIC,20);
		
		label = new JLabel("��������� ������" +result+"�� �Դϴ�.");
		label.setFont(font);
		Curr.add(label);
		Curr.add(button);
		add(Curr, BorderLayout.SOUTH);

		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1)
		{
			result+=4300;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if (e.getSource()==b3)
		{
			result+=4700;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if (e.getSource()==b4)
		{
			result+=4700;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if (e.getSource()==b5)
		{
			result+=1500;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if(e.getSource()==b6) {
				result+=900;
				label.setText("��������� ������ "+result+"�� �Դϴ�.");
			}
		if(e.getSource()==b7) {
			result+=700;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if(e.getSource()==b8) {
			result+=900;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		if(e.getSource()==b9) {
			result+=700;
			label.setText("��������� ������ "+result+"�� �Դϴ�.");
		}
		
	}
}
public class Employee{
	public static void main(String[] args) {
		MyFrame t= new MyFrame();
	}
}

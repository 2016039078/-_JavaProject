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

	private JPanel order_M; //주문 안내 패널
	private JPanel menu; //메뉴 패널
	private JPanel plus; //추가 패널
	private JPanel bread; //빵 패널
	private JPanel source; //소스 패널
	private JPanel Curr; //현재 가격 패널
	JLabel label;
	JCheckBox b1,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	int result=0;
	Font font;
	
	//private JPanel topPanel;
	ButtonGroup Menu = new ButtonGroup();
	ButtonGroup Plus = new ButtonGroup();
	ButtonGroup Bread = new ButtonGroup();
	ButtonGroup Source = new ButtonGroup();
	
	JButton button = new JButton("주문 완료");
	
	public MyFrame() {
		setTitle("Subway customizing");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		
		order_M=new JPanel();
		JLabel lab = new JLabel("주문하시겠습니까?");
		order_M.add(lab);
		add(order_M, BorderLayout.PAGE_START);
		
		Border bmenu=BorderFactory.createTitledBorder("메뉴");
		menu=new JPanel();
		b1=new JCheckBox("에그마요");
		b3=new JCheckBox("BLT");
		b4=new JCheckBox("터키");
		
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
		
		Border bplus=BorderFactory.createTitledBorder("추가 토핑");
		plus=new JPanel();
		b5= new JCheckBox("아보카도");
		b6= new JCheckBox("더블미트");
		b7=new JCheckBox("더블치즈");
		b8= new JCheckBox("베이컨");
		b9=new JCheckBox("계란");
		
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
		
		Border bbread=BorderFactory.createTitledBorder("빵");
		bread=new JPanel();
		b10= new JCheckBox("화이트");
		b11=new JCheckBox("플랫");
		b12= new JCheckBox("파마산");
		
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
		
		Border bsource=BorderFactory.createTitledBorder("소스");
		source=new JPanel();
		b13=new JCheckBox("사우전 아일랜드");
		b14= new JCheckBox("스위트 칠리");
		b15=new JCheckBox("렌치 드레싱");
		
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
		
		label = new JLabel("현재까지의 가격은" +result+"원 입니다.");
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
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if (e.getSource()==b3)
		{
			result+=4700;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if (e.getSource()==b4)
		{
			result+=4700;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if (e.getSource()==b5)
		{
			result+=1500;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if(e.getSource()==b6) {
				result+=900;
				label.setText("현재까지의 가격은 "+result+"원 입니다.");
			}
		if(e.getSource()==b7) {
			result+=700;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if(e.getSource()==b8) {
			result+=900;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		if(e.getSource()==b9) {
			result+=700;
			label.setText("현재까지의 가격은 "+result+"원 입니다.");
		}
		
	}
}
public class Employee{
	public static void main(String[] args) {
		MyFrame t= new MyFrame();
	}
}

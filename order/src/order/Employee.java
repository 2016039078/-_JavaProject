package order;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

class Employee extends JFrame implements ActionListener{
	public static Connection makeConnection() { //database connection function
		String url = "jdbc:mysql://localhost/subway";
		String id = "root";
		String password = "111111";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 적재");
			conn = DriverManager.getConnection(url,id,password);
			System.out.println("데이터베이스 연결");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 X");
		}catch(SQLException e) {
			System.out.println("연결 실패");
		}
		return conn;
	}
	private JPanel menu; //menu panel
	private JPanel plus; //plus menu panel
	private JPanel bread; //bread panel
	private JPanel sauce; //sauce panel
	private JPanel curr; //current price panel
	
	JLabel label;
	String costom = null;
	int result = 0;
	Font font;
	
	JCheckBox m1,m2,m3,m4,m5; //menu box
	JCheckBox p1,p2,p3,p4,p5; //plus menu box
	JCheckBox b1,b2,b3,b4,b5,b6; //bread box
	JCheckBox s1,s2,s3,s4,s5; //sauce box
	
	ButtonGroup Menu = new ButtonGroup();
	ButtonGroup Plus = new ButtonGroup();
	ButtonGroup Bread = new ButtonGroup();
	ButtonGroup Sauce = new ButtonGroup();
	
	JButton button = new JButton();
	
	public Employee() {
		setTitle("Subway customizing");
		this.setSize(465, 457);
		this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x click -> exit
		
		Border bmenu = BorderFactory.createTitledBorder("메뉴");
		menu = new JPanel();
		m1 = new JCheckBox("에그마요"); //specific name of menu
		m2 = new JCheckBox("B.L.T");
		m3 = new JCheckBox("터키");
		m4 = new JCheckBox("미트볼");
		m5 = new JCheckBox("로스트치킨");
		Menu.add(m1); //add to buttongroup
		Menu.add(m2);
		Menu.add(m3);
		Menu.add(m4);
		Menu.add(m5);
		m1.addActionListener(this); //detect click
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		menu.add(m1); //add to menu panel
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		menu.add(m5);
		add(menu, BorderLayout.NORTH); //select location of menu panel
		menu.setBorder(bmenu);
		
		GridLayout gplus = new GridLayout(5,1);
		Border bplus = BorderFactory.createTitledBorder("추가 토핑");
		plus = new JPanel();
		plus.setLayout(gplus);
		p1 = new JCheckBox("아보카도"); //add sub ingredient
		p2 = new JCheckBox("더블미트");
		p3 = new JCheckBox("더블치즈");
		p4 = new JCheckBox("베이컨");
		p5 = new JCheckBox("계란");
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
		
		GridLayout gbread = new GridLayout(3,2);
		Border bbread = BorderFactory.createTitledBorder("빵");
		bread = new JPanel();
		bread.setLayout(gbread);
		b1 = new JCheckBox("화이트"); //bread
		b2 = new JCheckBox("플랫");
		b3 = new JCheckBox("파마산");
		b4 = new JCheckBox("허니오트");
		b5 = new JCheckBox("위트");
		b6 = new JCheckBox("하티");
		Bread.add(b1);
		Bread.add(b2);
		Bread.add(b3);
		Bread.add(b4);
		Bread.add(b5);
		Bread.add(b6);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		bread.add(b1);
		bread.add(b2);
		bread.add(b3);
		bread.add(b4);
		bread.add(b5);
		bread.add(b6);
		add(bread, BorderLayout.CENTER);
		bread.setBorder(bbread);
		
		GridLayout gsauce = new GridLayout(5,1);
		Border bsauce = BorderFactory.createTitledBorder("소스");
		sauce = new JPanel();
		sauce.setLayout(gsauce);
		s1 = new JCheckBox("사우전 아일랜드"); //sauce
		s2 = new JCheckBox("스위트 칠리");
		s3 = new JCheckBox("렌치 드레싱");
		s4 = new JCheckBox("스위트 어니언");
		s5 = new JCheckBox("마요네즈");
		Sauce.add(s1);
		Sauce.add(s2);
		Sauce.add(s3);
		Sauce.add(s4);
		Sauce.add(s5);
		s1.addActionListener(this);
		s2.addActionListener(this);
		s3.addActionListener(this);
		s4.addActionListener(this);
		s5.addActionListener(this);
		sauce.add(s1);
		sauce.add(s2);
		sauce.add(s3);
		sauce.add(s4);
		sauce.add(s5);
		add(sauce, BorderLayout.EAST);
		sauce.setBorder(bsauce);
		
		curr = new JPanel();
		font = new Font("Dialog", Font.BOLD|Font.ITALIC,20);
		label = new JLabel("현재까지의 금액은 "+result+"원 입니다."); //current price
		label.setFont(font);
		curr.add(label);
		button = new JButton("주문");
		button.addActionListener(this);
		curr.add(button);
		add(curr, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private static void addOrder(String menu,int price) { //datadase add fuction
		Connection conn = makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String s = "insert into `order` (`menu`, `price`) values ";
			s+="('"+menu+"','"+price+"')";
			int i = stmt.executeUpdate(s);
			if(i==1) {
				System.out.println("레코드 추가");
			}
			else {
				System.out.println("레코드 실패");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //when click button, occur event
		if(e.getSource() == m1) {
			costom = "에그마요";
			result += 4300;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == m2) {
			costom = "B.L.T";
			result += 4700;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == m3) {
			costom = "터키";
			result += 4700;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == m4) {
			costom = "미트볼";
			result += 4700;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == m5) {
			costom = "로스트치킨";
			result += 5300;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == p1) {
			result += 1500;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == p2) {
			result += 900;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == p3) {
			result += 700;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == p4) {
			result += 900;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource() == p5) {
			result += 700;
			label.setText("현재까지의 금액은 "+result+"원 입니다.");
		}
		if(e.getSource()==button) {
			addOrder(costom,result);
			AnotherFrame af = new AnotherFrame(); //custom complete!
			costom=null;
			result=0;
		}
	}
}
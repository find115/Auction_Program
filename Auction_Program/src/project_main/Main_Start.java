package project_main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import network.Client_Function;
import network.Item;

class Main_Start extends JFrame implements Runnable{
	
	private List<Item> itemList;
	private Date server_Time;
	
	private boolean flag = true;
	
	//새로고침
	public void run() {
		Client_Function function  = new Client_Function();
		InetAddress inet = null;
		int port = 50000;
		Socket socket = null;
		try {
			inet = InetAddress.getByName("localhost");
		}catch(Exception e) {
			e.printStackTrace();
		}
		socket = function.socket_Creation(inet, port);
		function = function.refresh_Client(socket);
		if(function.getItemList()==null) {
			System.out.println("새로고침해서 받은 데이터가 null입니다.");
		}
		else {
//			System.out.println(function.getItemList().size());
//			System.out.println(function.getItemList().get(0).getId());
		}
//		System.out.println(function.getItemList().size());
//		System.out.println(function.getItemList().get(0).getTitle());
//		itemList = function.getItemList();
//		server_Time = function.getReceiveDate();
		setItemList(function.getItemList());
		setServer_Time(function.getReceiveDate());
//		System.out.println(itemList.get(0).getTitle());
	}

	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


	public Date getServer_Time() {
		return server_Time;
	}

	public void setServer_Time(Date server_Time) {
		this.server_Time = server_Time;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private Container con = this.getContentPane();
	private JPanel	panel = new JPanel();
	private Font font = new Font("굴림",Font.PLAIN, 25);
	private JLabel hello_Auction = new JLabel("        Hellow Auction~!");
	private JLabel id = new JLabel("ID 입력 ");
	private JLabel pw = new JLabel("PW 입력");
	private JTextField id_Input = new JTextField();
	private JPasswordField pw_Input = new JPasswordField();
	
	private JButton logIn = new JButton("LogIn");
	private JButton join_Membership = new JButton("회원가입");
	
	public Main_Start() {
		this.event();
		this.display();
		this.setTitle("Auction_Client");
		this.setSize(400, 600);
		this.setLocationByPlatform(true);
		this.setResizable(false);
	}
	
	private void display() {
		panel.setLayout(null);
		
		panel.setBounds(0, 0, 384, 561);
		hello_Auction.setBounds(34, 38, 305, 49);
		hello_Auction.setFont(font);
		id.setBounds(33, 157, 88, 49);
		pw.setBounds(33, 267, 88, 49);
		id_Input.setBounds(133, 157, 238, 49);
		pw_Input.setBounds(133, 267, 239, 49);
		logIn.setBounds(58, 361, 260, 61);
		join_Membership.setBounds(58, 461, 260, 61);
		
		panel.add(hello_Auction);
		
		panel.add(id);
		panel.add(pw);
		
		panel.add(id_Input);
		panel.add(pw_Input);
		
		panel.add(logIn);
		panel.add(join_Membership);
		
		con.add(panel);
	}
	

//	버튼을 클릭할때 이벤트
	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		con.add(logIn);
		this.add(logIn);
		logIn.addActionListener(e->{
			if(e.getSource()==logIn) {
//				수정 후
				Client_Function function = new Client_Function();
				InetAddress inet = null;
				 try {
					 inet = InetAddress.getByName("localhost"); //자기 자신
				 }catch(Exception ee) {
					 ee.printStackTrace();
				 }
				 int port = 50000;
				
				Socket socket = function.socket_Creation(inet, port);
				boolean check = function.login(socket, String.valueOf(id_Input.getText()), String.valueOf(pw_Input.getPassword()));
				if(check) {
					Menu menu;
					try {
						menu = new Menu(getItemList(), getServer_Time());
						menu.setVisible(true);
						this.setVisible(false);//로그인 성공하면 창안보이게 설정
					} catch (Exception err) {

					}
				} else {
					JOptionPane.showMessageDialog(Main_Start.this, "로그인 정보가 일치하지 않습니다.", "경고",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		
		join_Membership.addActionListener(e->{
			if(e.getSource()==join_Membership) {
				Join_Member join = new Join_Member();
				join.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Runnable win = new Main_Start();
		Thread t = new Thread(win);
		t.setDaemon(true);
		t.start();
				
		((Component) win).setVisible(true);
	}
}


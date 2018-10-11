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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import network.Client_Function;
import network.Item;

class Main_Start extends JFrame implements Runnable{
	
	private List<Item> itemList;
	private Date server_Time;
	
	private boolean flag = true;
	
	//���ΰ�ħ
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
			System.out.println("���ΰ�ħ�ؼ� ���� �����Ͱ� null�Դϴ�.");
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
	private Font font = new Font("����",Font.PLAIN, 25);
	private JLabel hello_Auction = new JLabel("        Hellow Auction~!");
	private JLabel id = new JLabel("ID �Է� ");
	private JLabel pw = new JLabel("PW �Է�");
	private JTextField id_Input = new JTextField();
	private JPasswordField pw_Input = new JPasswordField();
	
	private JButton logIn = new JButton("LogIn");
	private JButton join_Membership = new JButton("ȸ������");
	
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
	

//	��ư�� Ŭ���Ҷ� �̺�Ʈ
	private void event() {
//		con.add(logIn);
		this.add(logIn);
		logIn.addActionListener(e->{
			if(e.getSource()==logIn) {
//				���⼭ Menu�� �����ҋ� �����۸���Ʈ�� �����ð��� ���� �Ѱ��ָ鼭 �����մϴ�.
//				������ ���� itemList�� server_Time�� ������ ���� ��ٷȴٰ� Menu�� �����մϴ�.
				Runnable wait = new Runnable() {
					@Override
					public void run() {
						while(getItemList()==null && getServer_Time()==null) {
						}
					}
				};
				Thread t = new Thread(wait);
				t.setDaemon(true);
				t.start();
				Menu menu;
				try {
					menu = new Menu(getItemList(), getServer_Time());
					menu.setVisible(true);
				}catch(Exception err) {
					try {
						while(flag) {
							Thread.sleep(100);//��ü�� �� ������ ���� 0.1�ʽ� ��� �����.
							if(getItemList()!=null && getServer_Time()!=null)break;
						}
						setFlag(false);
						menu = new Menu(getItemList(), getServer_Time());
						menu.setVisible(true);
					} catch (InterruptedException e1) {
						setFlag(false);
						menu = new Menu(getItemList(), getServer_Time());
						menu.setVisible(true);
					}
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
		Runnable win = new Main_Start();
		Thread t = new Thread(win);
		t.setDaemon(true);
		t.start();
				
		((Component) win).setVisible(true);
	}
}


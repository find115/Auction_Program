package project_main;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import network.Client_Function;
import network.Item;

class Main_Start extends JFrame implements Runnable{

//	private List<Item> itemList = new ArrayList<>();
//	private Date server_Time = new Date();
	
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
	private JButton start = new JButton("Start");
	
	public Main_Start() {
		this.menu();
		this.setTitle("Mini Project");
		this.setSize(800, 600);
		this.setLocationByPlatform(true);
		this.setResizable(false);
	}

//	버튼을 클릭할때 이벤트
	private void menu() {
		con.add(start);
		this.add(start);
		start.addActionListener(e->{
			if(e.getSource()==start) {
//				여기서 Menu를 선언할떄 아이템리스트와 서버시간을 같이 넘겨주면서 생성합니다.
//				서버로 부터 itemList와 server_Time을 받을때 까지 기다렸다가 Menu를 실행합니다.
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
							Thread.sleep(100);//객체를 다 받을때 까지 0.1초식 계속 대기함.
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
	}
	
	public static void main(String[] args) {
		Runnable win = new Main_Start();
		Thread t = new Thread(win);
		t.setDaemon(true);
		t.start();
				
		((Component) win).setVisible(true);
	}
}


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

	private List<Item> itemList = new ArrayList<>();
	private Date server_Time = new Date();
	
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
			System.out.println("받은 거null");
		}
		else {
			System.out.println(function.getItemList().size());
			System.out.println(function.getItemList().get(0).getId());
		}
		System.out.println(function.getItemList().size());
		System.out.println(function.getItemList().get(0).getTitle());
		itemList = function.getItemList();
		server_Time = function.getReceiveDate();
		setItemList(function.getItemList());
		setServer_Time(function.getReceiveDate());
		System.out.println(itemList.get(0).getTitle());
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
				Menu menu = new Menu(getItemList(), getServer_Time());
				menu.setVisible(true);
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


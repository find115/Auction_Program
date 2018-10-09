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
			System.out.println("���� ��null");
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

//	��ư�� Ŭ���Ҷ� �̺�Ʈ
	private void menu() {
		con.add(start);
		this.add(start);
		start.addActionListener(e->{
			if(e.getSource()==start) {
//				���⼭ Menu�� �����ҋ� �����۸���Ʈ�� �����ð��� ���� �Ѱ��ָ鼭 �����մϴ�.
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


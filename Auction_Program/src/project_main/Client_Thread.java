package project_main;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.List;

import network.Client_Function;
import network.Item;

public class Client_Thread extends Thread{
	private List<Item> itemList;
	private Date server_Time;
	
	
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
		
		setItemList(function.getItemList());
		setServer_Time(function.getReceiveDate());
		
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
	
}

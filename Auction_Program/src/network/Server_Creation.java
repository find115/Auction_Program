package network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 서버생성을 위한 클래스
 * 서버 시작 메소드
 * 서버 종료 메소드
 * 입출력 스트림
 * @author 김준선
 */
public class Server_Creation{
	
	private List<Connection> list = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean flag = true;
	private String c_Address =  "초기값";//접속한 클라이언트 아이피주소
	
	ExecutorService executorService = Executors.newFixedThreadPool(1);
	
	Server_Function function = new Server_Function();
	
	Item item = new Item();
	
	FileIo file = new FileIo();
	
	private List<Item> itemList = new ArrayList<>();//아이템을 받을 리스트
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public int itemInfo() {
		return itemList.size();
		
	}
	
	public String getC_Address() {
		return c_Address;
	}
	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}
	
	public List<Connection> getList() {
		return list;
	}

	public void setList(List<Connection> list) {
		this.list = list;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public boolean notFlag() {
		flag = false;
		return flag;
	}
	
	public boolean getFalg() {
		return flag;
	}
//	서버시작 메소드
	public void startServer() {
		Runnable runServer = new Runnable() {
			@Override
			public void run() {
				while(flag) {
					Socket socket;
					try {
						socket = serverSocket.accept();
					
						Connection cn = new Connection();
						cn.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
						cn.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						cn.setDaemon(true);
						cn.start();
						list.add(cn);
						setC_Address("[클라이언트 접속] : "+socket.getRemoteSocketAddress());
//						System.out.println(getC_Address());
						
//						접속해제한 클라이언트를 확인하는 기능 이부분 다시확인
//						if(cn.in.readLine().equals("종료")) {
//							System.out.println(socket.getRemoteSocketAddress()+"님 퇴장");
//							list.remove(cn);
//						}
						
//						object를 입력받는 스트림
						InputStream is = socket.getInputStream();
					    ObjectInputStream ois = new ObjectInputStream(is);
					    item = (Item)ois.readObject();
					    itemList.add(item);
					    
					    file.fileWriter(itemList);
					    
//					    돌려보내는 test코드
					    itemList = file.fileReader(itemList);
					    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					    oos.writeObject(itemList);
					    oos.flush();
					    
					}
					catch (/*IOException*/Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(runServer);
	}
	
//	//	서버 종료 메소드
//	public void stopServer() {
//		try {
//			for(int i=0; i<list.size(); i++) {
//				list.get(i).socket.close();
//				list.remove(i);
//			}
//			serverSocket.close();
//			notFlag();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	서버 종료 메소드
	public void stopServer() {
		try {
			for(int i=0; i<list.size(); i++) {
				list.get(i).socket.close();
				list.remove(i);
			}
			if(serverSocket != null && serverSocket.isClosed()) {
				serverSocket.close();
			}
			if(executorService != null && executorService.isShutdown()) {
				executorService.shutdown();
			}
			notFlag();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	생성자
	public Server_Creation() {
		try {
			serverSocket = new ServerSocket(50000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	커넥션 클래스
	private class Connection extends Thread{
		Socket socket;
		PrintWriter out;
		BufferedReader in;
		
		public void send(String text) {
			out.println(text);
			out.flush();
		}
		
		public void broadcast(String text) {
			for(Connection cn : list) {
				cn.send(text);
			}
		}
		
		@Override
		public void run() {
			try {
				while(true) {
//					String line = in.readLine();
//					if(line.equals("10")) {
						//10 = 상품등록
//						itemList.add(function.addItem(serverSocket, socket));
//					}	
				
				     
//					socket = serverSocket.accept();
//				    InputStream is = socket.getInputStream();
//				    ObjectInputStream ois = new ObjectInputStream(is);
//				    item = (Item)ois.readObject();
//				    itemList.add(item);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

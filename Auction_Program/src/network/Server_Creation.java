package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 서버를 생성시키는 클래스
 * 종료 메소드가 있음.
 * @author 김준선
 */
public class Server_Creation {
	private static Object lock = new Object();//동기화를 위해 생성함.
	
	private List<Connection> list = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean flag = true;
	private String c_Address =  "초기값";//접속한 클라이언트 아이피주소
//	접속자수 테스트
	ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	Server_Function function = new Server_Function();
	
//	Item item = new Item();
	
	FileIo file = new FileIo();
	
//	Bids bids = new Bids();
	
//	Member mb = new Member();
		
	private List<Item> itemList = new ArrayList<>();//아이템을 받을 리스트
	
	private List<Member> memberList = new ArrayList<>();//회원정보 리스트
	//이거랑 이밑에 is는 synck를 위해서 만듬.
	private boolean isRegistration;
	
//	서버시작 메소드
	public void startServer() {
		Runnable runServer = new Runnable() {
			@Override
			public void run() {
				while(flag) {
					Socket socket;
					try {
						socket = serverSocket.accept();
						
						System.out.println("스타트 서버 런어블 실행됨");
						
						Connection cn = new Connection();
						cn.out = new ObjectOutputStream(socket.getOutputStream());
						cn.in = new ObjectInputStream(socket.getInputStream());
						cn.setDaemon(true);
						cn.start();
						list.add(cn);
						setC_Address("[클라이언트 접속] : "+socket.getRemoteSocketAddress());
						
//					 	member.list파일에서 memberList를 읽어온다.
//						만약 member.list에 아무것도 저장되있지 않으면 ArrayList를 생성해서 저장한다.
						memberList = file.fileReader_Member(memberList);
						if(memberList == null) {
							memberList = new ArrayList<>();
							file.fileWriter_Member(memberList);
						}
//						item.list파일에서 ItemList를 읽어 온다.
//						만약 item.list에 아무것도 저장되어있지 않으면 ArrayList를 생성해서 저장한다.
						itemList = file.fileReader(itemList);
						if(itemList == null) {
							itemList = new ArrayList<>();
							file.fileWriter(itemList);
						}
						
//						클라이언트가 접속하면 클라이언트에서 보내는 작업넘버를 받고
//						해당하는 작업을 수행해주고 연결을 끊어버린다.
						int work_Number = (int) cn.in.readObject();
						if(work_Number!=function.BID) {
							function.work(work_Number, socket, itemList, cn.in, cn.out, memberList, list);
							System.out.println(work_Number);
							socket.close();
						}
						else {
							synchronized(lock) {
								itemList = file.fileReader(itemList);
								function.bid(work_Number, socket, itemList, cn.in, cn.out, memberList, list);
								System.out.println("입찰완료"+work_Number);
								socket.close();
							}
						}
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(runServer);
	}
	
//	서버 종료 메소드
	public void stopServer() {
		try {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).socket != null) {
					list.get(i).socket.close();
					list.remove(i);
				}
				else list.remove(i);
			}
			if(serverSocket != null && serverSocket.isClosed()) {
				serverSocket.close();
			}
			if(executorService != null && executorService.isShutdown()) {
				executorService.shutdown();
			}
			setFlag(false);
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
//	getter, setter
	public boolean isRegistration() {
		return isRegistration;
	}
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

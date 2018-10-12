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
 * ������ ������Ű�� Ŭ����
 * ���� �޼ҵ尡 ����.
 * @author ���ؼ�
 */
public class Server_Creation {
	private static Object lock = new Object();//����ȭ�� ���� ������.
	
	private List<Connection> list = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean flag = true;
	private String c_Address =  "�ʱⰪ";//������ Ŭ���̾�Ʈ �������ּ�
//	�����ڼ� �׽�Ʈ
	ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	Server_Function function = new Server_Function();
	
//	Item item = new Item();
	
	FileIo file = new FileIo();
	
//	Bids bids = new Bids();
	
//	Member mb = new Member();
		
	private List<Item> itemList = new ArrayList<>();//�������� ���� ����Ʈ
	
	private List<Member> memberList = new ArrayList<>();//ȸ������ ����Ʈ
	//�̰Ŷ� �̹ؿ� is�� synck�� ���ؼ� ����.
	private boolean isRegistration;
	
//	�������� �޼ҵ�
	public void startServer() {
		Runnable runServer = new Runnable() {
			@Override
			public void run() {
				while(flag) {
					Socket socket;
					try {
						socket = serverSocket.accept();
						
						System.out.println("��ŸƮ ���� ����� �����");
						
						Connection cn = new Connection();
						cn.out = new ObjectOutputStream(socket.getOutputStream());
						cn.in = new ObjectInputStream(socket.getInputStream());
						cn.setDaemon(true);
						cn.start();
						list.add(cn);
						setC_Address("[Ŭ���̾�Ʈ ����] : "+socket.getRemoteSocketAddress());
						
//					 	member.list���Ͽ��� memberList�� �о�´�.
//						���� member.list�� �ƹ��͵� ��������� ������ ArrayList�� �����ؼ� �����Ѵ�.
						memberList = file.fileReader_Member(memberList);
						if(memberList == null) {
							memberList = new ArrayList<>();
							file.fileWriter_Member(memberList);
						}
//						item.list���Ͽ��� ItemList�� �о� �´�.
//						���� item.list�� �ƹ��͵� ����Ǿ����� ������ ArrayList�� �����ؼ� �����Ѵ�.
						itemList = file.fileReader(itemList);
						if(itemList == null) {
							itemList = new ArrayList<>();
							file.fileWriter(itemList);
						}
						
//						Ŭ���̾�Ʈ�� �����ϸ� Ŭ���̾�Ʈ���� ������ �۾��ѹ��� �ް�
//						�ش��ϴ� �۾��� �������ְ� ������ ���������.
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
								System.out.println("�����Ϸ�"+work_Number);
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
	
//	���� ���� �޼ҵ�
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
//	������
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

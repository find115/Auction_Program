package network;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TestServer {
	public static void main(String[] args) {
		int port = 50000;
		
		Item item = new Item();
		Server_Function function = new Server_Function();
		
		List<Item> itemList = new ArrayList<>();
		
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println(port+"�� ���� �غ� �Ϸ�");
			
			Socket socket = server.accept();//���� ���
			System.out.println(socket);
			
			 InputStream is = socket.getInputStream();
		     //InputStream�� ���� ������ Object�� �������ݴϴ�.
		     ObjectInputStream ois = new ObjectInputStream(is);
		     
		     item = (Item)ois.readObject();
		     itemList.add(item);
		     System.out.println(itemList);
		     System.out.println(itemList.get(0).getPrice());
		     
			socket.close();//���� ����
			server.close();//���� ����
			System.out.println("���� ����");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

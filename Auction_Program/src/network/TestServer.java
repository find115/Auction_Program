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
			System.out.println(port+"번 서버 준비 완료");
			
			Socket socket = server.accept();//연결 대기
			System.out.println(socket);
			
			 InputStream is = socket.getInputStream();
		     //InputStream의 최종 형식을 Object로 설정해줍니다.
		     ObjectInputStream ois = new ObjectInputStream(is);
		     
		     item = (Item)ois.readObject();
		     itemList.add(item);
		     System.out.println(itemList);
		     System.out.println(itemList.get(0).getPrice());
		     
			socket.close();//연결 종료
			server.close();//서버 종료
			System.out.println("서버 종료");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

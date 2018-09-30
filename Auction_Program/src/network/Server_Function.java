package network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JTextArea;

public class Server_Function {
	Item item = new Item();
	
//	서버 로그를 찍는 메소드
	public void addLog(String log, JTextArea area)
	{
		area.append(log + "\n");  // 로그 내용을 JTextArea 위에 붙여주고
//		area.setCaretPosition(area.getDocument().getLength());  // 맨아래로 스크롤한다.
	}
	
//	상품 등록 메소드
	public Item addItem(ServerSocket sock, Socket so) {
		try {
		 Socket socket = sock.accept();
	     //Socket로부터 받게 되는 InputStream을 설정합니다.
	     InputStream is = socket.getInputStream();
	     //InputStream의 최종 형식을 Object로 설정해줍니다.
	     ObjectInputStream ois = new ObjectInputStream(is);
	     item = (Item)ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return item;
	}
}

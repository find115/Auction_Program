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
	
//	���� �α׸� ��� �޼ҵ�
	public void addLog(String log, JTextArea area)
	{
		area.append(log + "\n");  // �α� ������ JTextArea ���� �ٿ��ְ�
//		area.setCaretPosition(area.getDocument().getLength());  // �ǾƷ��� ��ũ���Ѵ�.
	}
	
//	��ǰ ��� �޼ҵ�
	public Item addItem(ServerSocket sock, Socket so) {
		try {
		 Socket socket = sock.accept();
	     //Socket�κ��� �ް� �Ǵ� InputStream�� �����մϴ�.
	     InputStream is = socket.getInputStream();
	     //InputStream�� ���� ������ Object�� �������ݴϴ�.
	     ObjectInputStream ois = new ObjectInputStream(is);
	     item = (Item)ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return item;
	}
}

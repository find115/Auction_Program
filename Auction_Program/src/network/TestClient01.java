package network;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class TestClient01 extends JFrame implements Runnable {
	private Container con = this.getContentPane();
	
	private JTextArea area = new JTextArea();
	private JScrollPane pane = new JScrollPane();
	JLabel label = new JLabel();
		
	public TestClient01() {
		this.display();
		this.setTitle("스윙 예제");
		this.setSize(500, 400);
		this.setLocationByPlatform(true);//운영체제가 창의 위치설정
	}
	
	private void display() {
		con.add(label, BorderLayout.NORTH);
		con.add(pane, BorderLayout.CENTER);
		pane.setViewportView(area);
		
//			area의 줄바꿈 설정 후 가로 스크롤을 안생기게 처리
		area.setLineWrap(true);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InetAddress inet = null;
		 try {
			 inet = InetAddress.getByName("localhost"); //자기 자신
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 int port = 50000;
		
		Socket socket = null;
		try {
		// TODO Auto-generated method stub
		socket = new Socket(inet,port);//연결 시도(소켓 생성)
		System.out.println(socket);
		
		Date test  = new Date();
//		File image = new File("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		ImageIcon image = new ImageIcon("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		
		Item item = new Item("나이키모자", "깨끗합니다.", "모자", test, 500, image);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    oos.writeObject(item);
	    
	    oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
// 		서버에서 보낸 List<Item>을 Object 형식으로 받고 List<Item>에 넣어주는 기능
	    Item items = new Item();
	    List<Item> itemList = new ArrayList<>();
	    try {
		    InputStream is = socket.getInputStream();
		    ObjectInputStream ois = new ObjectInputStream(is);
		    itemList = (List<Item>)ois.readObject();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
//	  	List<Item>에서 ImageIcon을 꺼내와서 JLabel에 찍어보는 기능
//		ImageIcon뿐만 아니라 다른 정보도 다 꺼낼 수 있음.
	    for(int i=0; i<itemList.size(); i++) {
	    		ImageIcon images = itemList.get(i).getImage();
	    		label.setIcon(images);
	    }
	    

	}
	
	public static void main(String[] args)  {
		Runnable frame = new TestClient01();
		Thread t = new Thread(frame);
		t.setDaemon(true);
		t.start();
		
		((Component) frame).setVisible(true);
		
//		다시돌려받는 test코드 이부분 다시
//		
//		try {
//			Socket socket = new Socket("localhost",50000);//연결 시도(소켓 생성)
//				
//			PrintWriter pw = new PrintWriter(new BufferedWriter(
//					new OutputStreamWriter(socket.getOutputStream())));
//			while(true) {
//				pw.println("100");
//				pw.flush();
//				Thread.sleep(100);
//			}
//		}catch(Exception e) {
//				e.printStackTrace();
//		}
		
		System.out.println("윈도우 runnable 스레드 시작");
		
	}

	
}

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
		this.setTitle("���� ����");
		this.setSize(500, 400);
		this.setLocationByPlatform(true);//�ü���� â�� ��ġ����
	}
	
	private void display() {
		con.add(label, BorderLayout.NORTH);
		con.add(pane, BorderLayout.CENTER);
		pane.setViewportView(area);
		
//			area�� �ٹٲ� ���� �� ���� ��ũ���� �Ȼ���� ó��
		area.setLineWrap(true);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InetAddress inet = null;
		 try {
			 inet = InetAddress.getByName("localhost"); //�ڱ� �ڽ�
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 int port = 50000;
		
		Socket socket = null;
		try {
		// TODO Auto-generated method stub
		socket = new Socket(inet,port);//���� �õ�(���� ����)
		System.out.println(socket);
		
		Date test  = new Date();
//		File image = new File("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		ImageIcon image = new ImageIcon("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		
		Item item = new Item("����Ű����", "�����մϴ�.", "����", test, 500, image);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    oos.writeObject(item);
	    
	    oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
// 		�������� ���� List<Item>�� Object �������� �ް� List<Item>�� �־��ִ� ���
	    Item items = new Item();
	    List<Item> itemList = new ArrayList<>();
	    try {
		    InputStream is = socket.getInputStream();
		    ObjectInputStream ois = new ObjectInputStream(is);
		    itemList = (List<Item>)ois.readObject();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
//	  	List<Item>���� ImageIcon�� �����ͼ� JLabel�� ���� ���
//		ImageIcon�Ӹ� �ƴ϶� �ٸ� ������ �� ���� �� ����.
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
		
//		�ٽõ����޴� test�ڵ� �̺κ� �ٽ�
//		
//		try {
//			Socket socket = new Socket("localhost",50000);//���� �õ�(���� ����)
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
		
		System.out.println("������ runnable ������ ����");
		
	}

	
}

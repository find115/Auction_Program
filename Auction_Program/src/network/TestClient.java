package network;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestClient extends JFrame{
	private Container con = this.getContentPane();
	
	private JTextArea area = new JTextArea();
	private JScrollPane pane = new JScrollPane();
	 JLabel label = new JLabel();
	
	public TestClient() {
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
	
	Runnable run = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static void main(String[] args) throws IOException {
		InetAddress inet = InetAddress.getByName("localhost"); //�ڱ� �ڽ�
		
		int port = 50000;
		
		Socket socket = new Socket(inet,port);//���� �õ�(���� ����)
		System.out.println(socket);
		
		Date test  = new Date();
//		File image = new File("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		ImageIcon image = new ImageIcon("D:\\KG\\Nomarl_Java\\worksapce\\Auction_Test\\Client\\nike.JPG");
		
		Item item = new Item("����Ű����", "�����մϴ�.", "����", test, 500, image);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    oos.writeObject(item);
	    
	    oos.flush();
	    
	    
//		�ٽõ����޴� test�ڵ�
	    Item items = new Item();
	    List<Item> itemList = new ArrayList<>();
	    try {
		    InputStream is = socket.getInputStream();
		    ObjectInputStream ois = new ObjectInputStream(is);
		    itemList = (List<Item>)ois.readObject();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
	    
	    
	    for(int i=0; i<itemList.size(); i++) {
	    		
	    }
	    

		
	}
}

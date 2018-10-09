package network;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestClient03 extends JFrame implements Runnable{
	
	private Container con = this.getContentPane();
	
	private JTextArea area = new JTextArea();
	private JScrollPane pane = new JScrollPane();
	JLabel label = new JLabel();
	
	Client_Function function = new Client_Function();
	private Item item = new Item();
	private List<Item> itemList;
	private Date serverTime;
	
	FileIo file = new FileIo();//���⼭�� test�� �����δ� �Ⱦ���.
	
//	Member mb = new Member();
		
	public TestClient03() {
		this.display();
		this.setTitle("���� ����");
		this.setSize(500, 400);
		this.setLocationByPlatform(true);//�ü���� â�� ��ġ����
	}
	
	private void display() {
		con.add(label, BorderLayout.NORTH);
		con.add(pane, BorderLayout.CENTER);
		pane.setViewportView(area);
		
//		area�� �ٹٲ� ���� �� ���� ��ũ���� �Ȼ���� ó��
		area.setLineWrap(true);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("������ runnable ������ ����");
		
		InetAddress inet = null;
		 try {
			 inet = InetAddress.getByName("localhost"); //�ڱ� �ڽ�
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 int port = 50000;
		
		Socket socket = null;
		
		try {
			socket = new Socket(inet,port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		���� �õ�(���� ����)
		System.out.println(socket);
		
//		��ǰ ���		

//		Date start  = new Date();
//		Date finish = new Date();
//		Format n = new SimpleDateFormat("y-MM-dd E HH:mm:ss");
//		try {
//			finish = (Date) n.parseObject("2020-10-01 �� 01:41:30");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"\\Client\\nike.JPG");
//		Item send = new Item("�г���", "����Ű����", "���", "����", start, finish, 500, image);
//
//		boolean result = function.product_Registration(socket, send);
//		
//		System.out.println("��ǰ��� ���: "+result);
		
		
		
//		���ΰ�ħ
//			socket = function.socket_Creation(inet, port);
			function = function.refresh_Client(socket);
			itemList = function.getItemList();
			serverTime = function.getReceiveDate();
			Format format = new SimpleDateFormat("y-MM-dd E HH:mm:ss");
			System.out.println("�����ð� = "+format.format(serverTime));
			try {
				socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
//	  	List<Item>���� ImageIcon�� �����ͼ� JLabel�� ���� ���
//		ImageIcon�Ӹ� �ƴ϶� �ٸ� ������ �� ���� �� ����.
	   	ImageIcon images = itemList.get(itemList.size()-1).getImage();
	    label.setIcon(images);
	    
	    
		
		
//		����
//		itemList = file.fileReader(itemList);
		
//	    socket = function.socket_Creation(inet, port); //�ּ�
		
//	    boolean result = function.bidding(socket, 90005, itemList.get(0));
//	    result = function.bidding(socket, 1, 8600, itemList);
		
//	    System.out.println("������� : "+result);
	    
	    
//	   	���̵� �ߺ�Ȯ��
//	    String id = "xodid1234";
//	    boolean result = function.duplicate_Confirmation(socket, id);//���̵�
//	    boolean result = function.n_Duplicate_Confirmation(socket, id);//�г���
	    
//	    System.out.println(result);

//		ȸ������
//		Date now = new Date();
//		boolean[] test = new boolean[] {true, true};
//	    Member mb = new Member("���̵�", "�г���", "123456", "01012341234", "123@naver.com", "19850124",now);
//	    boolean result = function.join_Membership(socket, test, mb);
//	    System.out.println(result);
	    
//	   	�α���
//	    boolean result = function.login(socket, "���̵�", "123456");
//	    System.out.println(result);

	}
	
	public static void main(String[] args)  {
		Runnable frame = new TestClient03();
		Thread t = new Thread(frame);
		t.setDaemon(true);
		t.start();
		((Component) frame).setVisible(true);
		
	}
}

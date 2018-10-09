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
	
	FileIo file = new FileIo();//여기서는 test용 실제로는 안쓴다.
	
//	Member mb = new Member();
		
	public TestClient03() {
		this.display();
		this.setTitle("스윙 예제");
		this.setSize(500, 400);
		this.setLocationByPlatform(true);//운영체제가 창의 위치설정
	}
	
	private void display() {
		con.add(label, BorderLayout.NORTH);
		con.add(pane, BorderLayout.CENTER);
		pane.setViewportView(area);
		
//		area의 줄바꿈 설정 후 가로 스크롤을 안생기게 처리
		area.setLineWrap(true);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("윈도우 runnable 스레드 시작");
		
		InetAddress inet = null;
		 try {
			 inet = InetAddress.getByName("localhost"); //자기 자신
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
//		연결 시도(소켓 생성)
		System.out.println(socket);
		
//		상품 등록		

//		Date start  = new Date();
//		Date finish = new Date();
//		Format n = new SimpleDateFormat("y-MM-dd E HH:mm:ss");
//		try {
//			finish = (Date) n.parseObject("2020-10-01 월 01:41:30");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		ImageIcon image = new ImageIcon(System.getProperty("user.dir")+"\\Client\\nike.JPG");
//		Item send = new Item("닉네임", "나이키모자", "깔끔", "모자", start, finish, 500, image);
//
//		boolean result = function.product_Registration(socket, send);
//		
//		System.out.println("상품등록 결과: "+result);
		
		
		
//		새로고침
//			socket = function.socket_Creation(inet, port);
			function = function.refresh_Client(socket);
			itemList = function.getItemList();
			serverTime = function.getReceiveDate();
			Format format = new SimpleDateFormat("y-MM-dd E HH:mm:ss");
			System.out.println("서버시간 = "+format.format(serverTime));
			try {
				socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
//	  	List<Item>에서 ImageIcon을 꺼내와서 JLabel에 찍어보는 기능
//		ImageIcon뿐만 아니라 다른 정보도 다 꺼낼 수 있음.
	   	ImageIcon images = itemList.get(itemList.size()-1).getImage();
	    label.setIcon(images);
	    
	    
		
		
//		입찰
//		itemList = file.fileReader(itemList);
		
//	    socket = function.socket_Creation(inet, port); //주석
		
//	    boolean result = function.bidding(socket, 90005, itemList.get(0));
//	    result = function.bidding(socket, 1, 8600, itemList);
		
//	    System.out.println("입찰결과 : "+result);
	    
	    
//	   	아이디 중복확인
//	    String id = "xodid1234";
//	    boolean result = function.duplicate_Confirmation(socket, id);//아이디
//	    boolean result = function.n_Duplicate_Confirmation(socket, id);//닉네임
	    
//	    System.out.println(result);

//		회원가입
//		Date now = new Date();
//		boolean[] test = new boolean[] {true, true};
//	    Member mb = new Member("아이디", "닉네임", "123456", "01012341234", "123@naver.com", "19850124",now);
//	    boolean result = function.join_Membership(socket, test, mb);
//	    System.out.println(result);
	    
//	   	로그인
//	    boolean result = function.login(socket, "아이디", "123456");
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

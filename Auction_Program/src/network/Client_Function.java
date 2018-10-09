package network;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 클라이언트 기능 클래스
 * 클라이언트에서 사용할 기능들을 만들어 둠.
 * @author 김준선
 */
public class Client_Function implements Serializable{
	public static final int BID = 1;					//입찰
	public static final int BID_CANCEL = 2;				//입찰취소
	public static final int PRODUCT_REGISTRATION = 3;	//등록
	public static final int DELETE_PRODUCT = 4;			//상품삭제
	public static final int REFRESH = 5;				//새로고침
	public static final int DUPLICATE_CONFIRMATION = 6; //중복확인
	public static final int JOIN_MEMBERSHIP = 7;		//회원가입
	public static final int MEMBERSHIP_WITHDRAWAL = 8;	//회원탈퇴
	public static final int MODIFY_MEMBER = 9;			//회원정보 수정
	public static final int LOGIN = 10;
	public static final int N_DUPLICATE_CONFIRMATION = 11; // 닉네임 중복확인
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date receiveDate;
	Item items = new Item();
	Bids bids = new Bids();
	private List<Item> itemList = new ArrayList<>();
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	
	
	
	public ObjectOutputStream getOut() {
		return out;
	}
	public ObjectInputStream getIn() {
		return in;
	}

	
	
	
	
	public Date getReceiveDate() {
		return receiveDate;
	}

	public Item getItems() {
		return items;
	}

	public Bids getBids() {
		return bids;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public Client_Function() {
		super();
	}
	
	public Client_Function(Date receiveDate, List<Item> itemList) {
		super();
		this.receiveDate = receiveDate;
		this.itemList = itemList;
	}
//	아웃풋스트림 오픈
	public ObjectOutputStream setOut(ObjectOutputStream out, Socket socket) {
		try {
			return this.out = new ObjectOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	인풋 스트림 오픈
	public ObjectInputStream setIn(ObjectInputStream in, Socket socket) {
		try {
			return this.in = new ObjectInputStream(socket.getInputStream());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	소켓을 종료시키는 메소드
	public void terminate_Socket(Socket socket, ObjectInputStream in, ObjectOutputStream out) {
		try {
			in.close();
			out.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	서버에게 object를 보내는 메소드
	public void sendObject(Object obj, ObjectOutputStream out) {
		try {
			out.writeObject(obj);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	서버에게 String값을 보내는 메소드
	public void sendString(String str, ObjectOutputStream out) {
		try {
			out.writeObject(str);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	서버에게 어떤 일을 할지 알려주는 메소드
	public void sendWork(int work_Number, ObjectOutputStream out) {
		try {
			out.writeObject(work_Number);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	서버에게 Item item을 Object형식으로 보내는 메소드
	public void sendItem(Item item, ObjectOutputStream out) {
		try {
		    out.writeObject(item);
		    out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	서버에게 bid데이터를 objectstream을 이용해 보내는 메소드
	public void sendBid(int data1,int data2, ObjectOutputStream out) {
		try {
		    out.writeInt(data1);
		    out.flush();
		    out.writeInt(data2);
		    out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	서버로 부터 성공여부를 받는 메소드
	public boolean receive(ObjectInputStream in) {
		try {
		    boolean check = (boolean)in.readObject();
		    return check;
		}catch(Exception e) {
			return false;
		}
	}
	
//	소켓 생성 메소드
	public Socket socket_Creation(InetAddress inet, int port) {
		try {
			Socket socket = new Socket(inet,port);
			return socket;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	------------------------------------------------------메인 기능--------------------------------------------------------

//	String을 date형식으로 바꾸고 return 하는 메소드
//	단, 문자열의 형식은 아래와 같아야 함.
//	String oldstring = "2018-12-18 00:00";
	public Date stIsDate(String inputDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
//	새로고침 메소드
//	클라이언트를 시작시 실행되어야 함.
//	서버로 부터 Date와 ItemList를 받아서 return.
	@SuppressWarnings("unchecked")
	public Client_Function refresh_Client(Socket socket) {
		out = setOut(getOut(), socket);
		in = setIn(getIn(), socket);
		
		Client_Function cf;
		
		sendWork(REFRESH, out);
		try {
//			서버로 부터 ItemList를 입력받음.
//			서버로 부터 서버시간을 입력받음.
		    itemList = (List<Item>)in.readObject();
		    Date serverTime = (Date)in.readObject();
		    
		    cf = new Client_Function(serverTime, itemList);
		    
		    terminate_Socket(socket, in, out);
		    
		    return cf;
		}catch(Exception e) {
			terminate_Socket(socket, in, out);
			return null;
		}
	}
	
//	상품을 등록시키는 메소드
//	매개변수 : Socket, Item
	public boolean product_Registration(Socket socket,Item item) {
		out = setOut(getOut(), socket);
		in = setIn(getIn(), socket);
		
		sendWork(PRODUCT_REGISTRATION, out);
		sendItem(item, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check; 
	}
	
//	입찰하는 메소드
//	매개변수 : Socket, 입찰금액(int), Item
	public boolean bidding(Socket socket, int bid, Item item) {
		out = setOut(getOut(), socket);
		in = setIn(getIn(), socket);
		
		sendWork(BID, out);
		boolean check;
//		int target=0;
//		for(int i=0; i<itemList.size(); i++) {
//			if(itemList.get(i).getItemNumber()==item_Num) {
//				target = i;
//				break;
//			}
//		}
		
		List<Bids> bidsList = item.getBidsList();
		
		System.out.println("보내기전");
		
//		List<Bids> bidsList = itemList.get(target).getBidsList();
		
		if(bidsList.size()==0 || bid>bidsList.get(bidsList.size()-1).getBid()) {
//			sendBid(item_Num, bid, out);
			sendBid(item.getItemNumber(), bid, out);
			check = receive(in);
			System.out.println("클라이언트 부분 성공");
			terminate_Socket(socket, in, out);
			return check;
		}
		else {
//			sendBid(item_Num, -1, out);
			sendBid(item.getItemNumber(), bid, out);
			check = receive(in);
			terminate_Socket(socket, in, out);
			return false;
		}
	}
	
//	아이디 중복확인 메소드 
	public boolean duplicate_Confirmation(Socket socket, String id) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(DUPLICATE_CONFIRMATION, out);
		sendString(id, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check;
	}
	
//	닉네임 중복확인 메소드
	public boolean n_Duplicate_Confirmation(Socket socket, String nick) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(N_DUPLICATE_CONFIRMATION, out);
		sendString(nick, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check;
	}
	
//	회원가입 메소드
	public boolean join_Membership(Socket socket, boolean[] judgment, Member mb) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(JOIN_MEMBERSHIP, out);
		sendObject(judgment, out);
		boolean isStart = receive(in);
		if(isStart) {
			try {
				out.writeObject(mb);
				out.flush();
				boolean check = receive(in);
				terminate_Socket(socket, in, out);
				return check;
			}catch(Exception e) {
				terminate_Socket(socket, in, out);
				return false;
			}
		}
		else {
			terminate_Socket(socket, in, out);
			return false;
		}
	}
	
//	로그인 메소드
	public boolean login(Socket socket, String id, String pw) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(LOGIN, out);
		sendString(id, out);
		sendString(pw, out);
		try {
			boolean check = receive(in);
			terminate_Socket(socket, in, out);
			return check;
		}catch(Exception e) {
			terminate_Socket(socket, in, out);
			return false;
		}
	}

	
//	검색 메소드
//	검색어에 따라 정렬
// 	오름차순 정렬(퀵 정렬)
//	매개변수 : 검색어, ItemList
	public List<Item> search_Sort(String input, List<Item> itemList){
		String str = input;
		List<Item> searched_ItemList = new ArrayList<>();
		
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getTitle().contains(input)) {
				searched_ItemList.add(itemList.get(i));
			}
		}
		 
		if (searched_ItemList.size() < 2) {
			return searched_ItemList;
		} 
		Item pivot = searched_ItemList.get(0);
		
		List<Item> lowerList = new ArrayList<>();
		List<Item> higherList = new ArrayList<>(); 
		for (int i = 1; i < searched_ItemList.size(); i++) {//
			Item number = searched_ItemList.get(i);
			if (number.getTitle().indexOf(input) < pivot.getTitle().indexOf(input)) {
				lowerList.add(number);
			} 
			else {
				higherList.add(number);
				}
		} 
		List<Item> sortedList = search_Sort(str, lowerList);	
		sortedList.add(pivot);
		sortedList.addAll(search_Sort(str, higherList));
		return sortedList;		
	}
		
	
}

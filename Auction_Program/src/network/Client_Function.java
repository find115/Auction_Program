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
import java.util.regex.Pattern;

/**
 * Å¬¶óÀÌ¾ğÆ® ±â´É Å¬·¡½º
 * Å¬¶óÀÌ¾ğÆ®¿¡¼­ »ç¿ëÇÒ ±â´ÉµéÀ» ¸¸µé¾î µÒ.
 * @author ±èÁØ¼±
 */
public class Client_Function implements Serializable{
	public static final int BID = 1;					//ÀÔÂû
	public static final int BID_CANCEL = 2;				//ÀÔÂûÃë¼Ò
	public static final int PRODUCT_REGISTRATION = 3;	//µî·Ï
	public static final int DELETE_PRODUCT = 4;			//»óÇ°»èÁ¦
	public static final int REFRESH = 5;				//»õ·Î°íÄ§
	public static final int DUPLICATE_CONFIRMATION = 6; //Áßº¹È®ÀÎ
	public static final int JOIN_MEMBERSHIP = 7;		//È¸¿ø°¡ÀÔ
	public static final int MEMBERSHIP_WITHDRAWAL = 8;	//È¸¿øÅ»Åğ
	public static final int MODIFY_MEMBER = 9;			//È¸¿øÁ¤º¸ ¼öÁ¤
	public static final int LOGIN = 10;
	public static final int N_DUPLICATE_CONFIRMATION = 11; // ´Ğ³×ÀÓ Áßº¹È®ÀÎ
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
//	¾Æ¿ôÇ²½ºÆ®¸² ¿ÀÇÂ
	public ObjectOutputStream setOut(ObjectOutputStream out, Socket socket) {
		try {
			return this.out = new ObjectOutputStream(socket.getOutputStream());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	ÀÎÇ² ½ºÆ®¸² ¿ÀÇÂ
	public ObjectInputStream setIn(ObjectInputStream in, Socket socket) {
		try {
			return this.in = new ObjectInputStream(socket.getInputStream());
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	¼ÒÄÏÀ» Á¾·á½ÃÅ°´Â ¸Ş¼Òµå
	public void terminate_Socket(Socket socket, ObjectInputStream in, ObjectOutputStream out) {
		try {
			in.close();
			out.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	¼­¹ö¿¡°Ô object¸¦ º¸³»´Â ¸Ş¼Òµå
	public void sendObject(Object obj, ObjectOutputStream out) {
		try {
			out.writeObject(obj);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	¼­¹ö¿¡°Ô String°ªÀ» º¸³»´Â ¸Ş¼Òµå
	public void sendString(String str, ObjectOutputStream out) {
		try {
			out.writeObject(str);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	¼­¹ö¿¡°Ô ¾î¶² ÀÏÀ» ÇÒÁö ¾Ë·ÁÁÖ´Â ¸Ş¼Òµå
	public void sendWork(int work_Number, ObjectOutputStream out) {
		try {
			out.writeObject(work_Number);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	¼­¹ö¿¡°Ô Item itemÀ» ObjectÇü½ÄÀ¸·Î º¸³»´Â ¸Ş¼Òµå
	public void sendItem(Item item, ObjectOutputStream out) {
		try {
		    out.writeObject(item);
		    out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	¼­¹ö¿¡°Ô bidµ¥ÀÌÅÍ¸¦ objectstreamÀ» ÀÌ¿ëÇØ º¸³»´Â ¸Ş¼Òµå
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
	
//	¼­¹ö·Î ºÎÅÍ ¼º°ø¿©ºÎ¸¦ ¹Ş´Â ¸Ş¼Òµå
	public boolean receive(ObjectInputStream in) {
		try {
		    boolean check = (boolean)in.readObject();
		    return check;
		}catch(Exception e) {
			return false;
		}
	}
	
//	¼ÒÄÏ »ı¼º ¸Ş¼Òµå
	public Socket socket_Creation(InetAddress inet, int port) {
		try {
			Socket socket = new Socket(inet,port);
			return socket;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	------------------------------------------------------¸ŞÀÎ ±â´É--------------------------------------------------------

//	StringÀ» dateÇü½ÄÀ¸·Î ¹Ù²Ù°í return ÇÏ´Â ¸Ş¼Òµå
//	´Ü, ¹®ÀÚ¿­ÀÇ Çü½ÄÀº ¾Æ·¡¿Í °°¾Æ¾ß ÇÔ.
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
	
	public Date stIsBirth(String inputDate) {
		Date date = null;
		try{
			date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
		}catch(Exception e) {
			date = null;
		}
		return date;
	}
	
//	»õ·Î°íÄ§ ¸Ş¼Òµå
//	Å¬¶óÀÌ¾ğÆ®¸¦ ½ÃÀÛ½Ã ½ÇÇàµÇ¾î¾ß ÇÔ.
//	¼­¹ö·Î ºÎÅÍ Date¿Í ItemList¸¦ ¹Ş¾Æ¼­ return.
	@SuppressWarnings("unchecked")
	public Client_Function refresh_Client(Socket socket) {
		out = setOut(getOut(), socket);
		in = setIn(getIn(), socket);
		
		Client_Function cf;
		
		sendWork(REFRESH, out);
		try {
//			¼­¹ö·Î ºÎÅÍ ItemList¸¦ ÀÔ·Â¹ŞÀ½.
//			¼­¹ö·Î ºÎÅÍ ¼­¹ö½Ã°£À» ÀÔ·Â¹ŞÀ½.
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
	
//	»óÇ°À» µî·Ï½ÃÅ°´Â ¸Ş¼Òµå
//	¸Å°³º¯¼ö : Socket, Item
	public boolean product_Registration(Socket socket,Item item) {
		out = setOut(getOut(), socket);
		in = setIn(getIn(), socket);
		
		sendWork(PRODUCT_REGISTRATION, out);
		sendItem(item, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check; 
	}
	
//	ÀÔÂûÇÏ´Â ¸Ş¼Òµå
//	¸Å°³º¯¼ö : Socket, ÀÔÂû±İ¾×(int), Item
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
		
		System.out.println("º¸³»±âÀü");
		
//		List<Bids> bidsList = itemList.get(target).getBidsList();
		
		if(bidsList.size()==0 || bid>bidsList.get(bidsList.size()-1).getBid()) {
//			sendBid(item_Num, bid, out);
			sendBid(item.getItemNumber(), bid, out);
			check = receive(in);
			System.out.println("Å¬¶óÀÌ¾ğÆ® ºÎºĞ ¼º°ø");
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
	
//	¾ÆÀÌµğ Áßº¹È®ÀÎ ¸Ş¼Òµå 
	public boolean duplicate_Confirmation(Socket socket, String id) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(DUPLICATE_CONFIRMATION, out);
		sendString(id, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check;
	}
	
//	´Ğ³×ÀÓ Áßº¹È®ÀÎ ¸Ş¼Òµå
	public boolean n_Duplicate_Confirmation(Socket socket, String nick) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(N_DUPLICATE_CONFIRMATION, out);
		sendString(nick, out);
		boolean check = receive(in);
		terminate_Socket(socket, in, out);
		return check;
	}
	
//	È¸¿ø°¡ÀÔ Çü½Ä°Ë»ç ¸Ş¼Òµå 
	public boolean type_Test(Member mb) {
		boolean[] pattern = new boolean[] {false,false,false,false,false};
		boolean check = false;
		//id ¼ıÀÚ, ¾ËÆÄºª¼Ò¹®ÀÚ 8~15ÀÚ
		String regex0 = "^[0-9a-z]{8,15}$";
		pattern[0] = Pattern.matches(regex0, mb.getId());
		//´Ğ³×ÀÓ  ÇÑ±Û 2~10±ÛÀÚ
		String regex1 = "^[°¡-ÆR]{2,10}$";
		pattern[1] = Pattern.matches(regex1, mb.getNickName());
		//pw ¼ıÀÚ, ¾ËÆÄºª¼Ò¹®ÀÚ,´ë¹®ÀÚ 8~20ÀÚ
		String regex2 = "^[0-9A-Za-z!@#$]{8,20}$";
		pattern[2] = Pattern.matches(regex2, mb.getPassword());
		//ÇÚµåÆù ¹øÈ£ : 01(0,1,6,7,8,9) - 4ÀÚ¸® - 4ÀÚ¸®
		String regex3 = "^01[016-9]-?[0-9]{4}-?[0-9]{4}$";
		pattern[3] = Pattern.matches(regex3, mb.getPhoneNumber());
//		- @¸¦ ±âÁØÀ¸·Î ¾ÕÂÊÀº ¾ËÆÄºª,¼ıÀÚ,-,_¸¦ 8~20ÀÚ ÀÌ³»
//		- @¸¦ ±âÁØÀ¸·Î µÚÂÊÀº ¾Æ·¡¿Í °°ÀÌ °Ë»ç
//			3±ÛÀÚ ÀÌ»ó 10±ÛÀÚ ÀÌ³»ÀÇ ¿µ¹®+¼ıÀÚ ÀÌÈÄ¿¡ ¾Æ·¡Ã³·³ ±¸ÇöµÈ °æ¿ì¸¸ Çã¿ë
//			**********.com
//			**********.co.kr
//			**********.net
//			**********.go.kr
//			**********.ac.kr
		String regex4 = "^[a-z][a-z\\d-_]{7,19}@[a-z][a-z\\d]{2,9}(\\.co\\.kr|\\.com|\\.net|\\.ac\\.kr|\\.go\\.kr)$";
		pattern[4] = Pattern.matches(regex4, mb.getEmail());
		int count = 0;
		for(int i =0; i<pattern.length; i++) {
			if(pattern[i]==true)count++;
		}
		if(count==4) check = true;
		else check = false;
		return check;
	}
	
//	È¸¿ø°¡ÀÔ ¸Ş¼Òµå
	public boolean join_Membership(Socket socket, boolean[] judgment, Member mb) {
		out = setOut(out, socket);
		in = setIn(in, socket);
		sendWork(JOIN_MEMBERSHIP, out);
		sendObject(judgment, out);
		boolean isStart = receive(in);
		if (isStart) {
			try {
				out.writeObject(mb);
				out.flush();
				boolean check = receive(in);
				terminate_Socket(socket, in, out);
				return check;
			} catch (Exception e) {
				terminate_Socket(socket, in, out);
				return false;
			}
		} else {
			terminate_Socket(socket, in, out);
			return false;
		}
	}
	
//	·Î±×ÀÎ ¸Ş¼Òµå
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

	
//	°Ë»ö ¸Ş¼Òµå
//	°Ë»ö¾î¿¡ µû¶ó Á¤·Ä
// 	¿À¸§Â÷¼ø Á¤·Ä(Äü Á¤·Ä)
//	¸Å°³º¯¼ö : °Ë»ö¾î, ItemList
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
		for (int i = 1; i < searched_ItemList.size(); i++) {
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

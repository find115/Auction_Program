package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 서버 기능 클래스
 * 서버에서 사용할 기능들을 메소드로 만들어둠.
 * @author 준선
 */
public class Server_Function {
	public static final int BID = 1; // 입찰
	public static final int BID_CANCEL = 2; // 입찰취소
	public static final int PRODUCT_REGISTRATION = 3; // 등록
	public static final int DELETE_PRODUCT = 4; // 상품삭제
	public static final int REFRESH = 5; // 새로고침
	public static final int DUPLICATE_CONFIRMATION = 6; // 아이디 중복확인
	public static final int JOIN_MEMBERSHIP = 7; // 회원가입
	public static final int MEMBERSHIP_WITHDRAWAL = 8; // 회원탈퇴
	public static final int MODIFY_MEMBER = 9; // 회원정보 수정
	public static final int LOGIN = 10;	 //로그 인
	public static final int N_DUPLICATE_CONFIRMATION = 11; // 닉네임 중복확인
	
	Item item = new Item();
	FileIo file = new FileIo();
	Member mb = new Member();
	
	private StringBuffer serverLog;//서버에 접속한 클라이언트의 활동내역을 저장하는 변수
	private int activity = 0;//
	
	public int getActivity() {//
		return activity;
	}
	public void setActivity(int activity) {//
		this.activity = activity;
	}

	public StringBuffer resetServerLog() {//
		return serverLog = new StringBuffer();
	}
	public StringBuffer getServerLog() {//
		return serverLog;
	}
	
	private boolean isRegistration;

	public boolean isRegistration() {
		return isRegistration;
	}
	
	public void setServerLog(StringBuffer serverLog) {
		this.serverLog = serverLog;
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
	
//	기능수행이 잘되었는지 클라이언트에게 알려주는 메소드
	public void check(Socket socket, boolean isRegistration, ObjectOutputStream out) {
		try {
			out.writeObject(isRegistration);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	회원가입시 서버가 보낸 아이디 중복확인과 닉네임 중복확인 boolean[2]을 클라이언트로 부터 받음
	public boolean[] membership_Qualification(Socket socket, ObjectInputStream in) {
		boolean[] judgment = new boolean[] {false,false};
		try {
			return judgment = (boolean[])in.readObject();
		}catch(Exception e) {
			return judgment;
		}
	}
	
//	입찰 취소 메소드
//	싱크를 위해 입찰만 따로 메소드 만듬
//	클라이언트로 부터 회원정보와 입찰금액을 받아온다.
//	회원가입 기능을 만든 후에 수정해야함
//	받은 회원정보와 입찰한 회원정보가 일치하고 입찰기간이 끈나지 않았으면 입찰했던 기록을 지워줌
	public void bid_Cancel(int work_Number, Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out
										,List<Member> memberList, List<Connection>list) {
		
	}
	
//	입찰하는 메소드
	public void bid(int work_Number, Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out,
			List<Member> memberList, List<Connection> list) {
		int item_Num = 0;
		int bid = 0;

		try {
			item_Num = in.readInt();
			bid = in.readInt();
			System.out.println("받는거 까지 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int target = 0;

		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemNumber() == item_Num) {
				target = i;
				break;
			}
		}
//		값비교를 위해서 count 인덱스에 있는 item에서 bidList를 가져옴
		List<Bids> compare = itemList.get(target).getBidsList();
		Date now = new Date();

		if (now.compareTo(itemList.get(target).getFinishDate()) == -1
				&& (compare.size() == 0 || compare.get(compare.size() - 1).getBid() < bid)) {
			Bids addbid = new Bids(bid, socket.getRemoteSocketAddress() + "", now);
			itemList.get(target).getBidsList().add(addbid);// 이부분 test해봐야함.

//			여기서 클라이언트에게 입찰성공여부를 true로 보내줌
			isRegistration = true;
			check(socket, isRegistration, out);

			file.fileWriter(itemList);
			terminate_Socket(socket, in, out);

			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("에서 입찰 하였습니다.\n");//
			serverLog.append("[상품번호] : ");//
			serverLog.append(itemList.get(target).getItemNumber());// 고유번호
			serverLog.append("번");
			serverLog.append("  [상품이름] : ");//
			serverLog.append(itemList.get(target).getTitle());// 상품이름
			serverLog.append("  [입찰금액] : ");
			serverLog.append(bid);// 상품이름
			serverLog.append("원");// 상품이름
			setActivity(activity + 1);//

		} else {
//			여기서 클라이언트에게 false를 보내줌
			isRegistration = false;
			check(socket, isRegistration, out);
			terminate_Socket(socket, in, out);
		}
	}
	
	
//	상품 등록 메소드
	public void product_registration(Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out,
			List<Member> memberList) {
		try {
			item = (Item) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("상품 정보 받는거 까지 성공");

		try {
			if (itemList.size() == 0) {
				item.setItemNumber(0);
			} else {
				item.setItemNumber(itemList.get(itemList.size() - 1).getItemNumber() + 1);
			}

			itemList.add(item);

			file.fileWriter(itemList);

			System.out.println("불린 전까지 성공 = "+item);

			isRegistration = true;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out); //이거 풀면 현재 에러남
		} catch (Exception e1) {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
	}
	
//	상품삭제 메소드
	public void delete_Product() {
		
	}
	
//	새로고침 메소드
	public void refresh(Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out) {
		try {
			itemList = file.fileReader(itemList);
			if (itemList == null) {
				itemList = new ArrayList<>();
			}
			out.writeObject(itemList);
			out.flush();

			Date serverTime = new Date();
			out.writeObject(serverTime);
			out.flush();
			
			terminate_Socket(socket, in, out);
		} catch (Exception e) {
			terminate_Socket(socket, in, out);
		}
	}
	
//	아이디 중복 확인
	public void duplicate_Confirmation(Socket socket, List<Member> memberList, ObjectInputStream in, ObjectOutputStream out) {
		memberList = file.fileReader_Member(memberList);
		String id = null;
		int count = 0;
		
		try {
			id = (String) in.readObject();
		} catch (Exception e) {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
		
		if (memberList.size() == 0 || memberList == null) {
			isRegistration = true;
			check(socket, isRegistration(), out);
		} 
		else {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(id)) {
					count++;
					break;
				}
			}
			if (count == 0) {
				isRegistration = true;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
			else {
				isRegistration = false;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
		}
		terminate_Socket(socket, in, out);
	}
	
//	닉네임 중복확인
	public void n_Duplicate_Confirmation(Socket socket, List<Member> memberList, ObjectInputStream in, ObjectOutputStream out) {
		memberList = file.fileReader_Member(memberList);
		String nick = null;
		int count = 0;
		
		try {
			nick = (String) in.readObject();
		} catch (Exception e) {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
		
		if (memberList.size() == 0 || memberList == null) {
			isRegistration = true;
			check(socket, isRegistration(), out);
		} 
		else {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getNickName().equals(nick)) {
					count++;
					break;
				}
			}
			if (count == 0) {
				isRegistration = true;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
			else {
				isRegistration = false;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
		}
		terminate_Socket(socket, in, out);
	}
	
//	회원가입
	public void join_Membership(Socket socket, List<Member> memberList, ObjectInputStream in, ObjectOutputStream out) {
//		아이디와 닉네임 중복이 없는지 받아옴
		boolean[] judgment = membership_Qualification(socket, in);
		boolean start = true;
		if(judgment[0] == true && judgment[1] == true) {
			try {
				out.writeObject(start);
				out.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				mb = (Member)in.readObject();//이걸 처음에 받는게 더 안정적일듯
				memberList.add(mb);
				file.fileWriter_Member(memberList);
				
				isRegistration = true;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}catch(Exception e) {
				isRegistration = false;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
		}
		else {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
	}
	
//	로그인
	public void login(Socket socket, ObjectInputStream in, ObjectOutputStream out, List<Member> memberList) {
		String id = null;
		String pw = null;
		int target = -1;
		try {
			id = (String)in.readObject();
			pw = (String)in.readObject();
			memberList = file.fileReader_Member(memberList);
			for(int i=0; i<memberList.size(); i++) {
				if(memberList.get(i).getId().equals(id)) {
					target = i;
					break;
				}
			}
			System.out.println("target = "+target);
			if(target == -1) {
				isRegistration = false;
				check(socket, isRegistration(), out);
				terminate_Socket(socket, in, out);
			}
			else {
				if(memberList.get(target).getPassword().equals(pw)) {
					isRegistration = true;
					check(socket, isRegistration(), out);
					
					resetServerLog();//
					serverLog.append(id);
					serverLog.append("님이 ");
					
					terminate_Socket(socket, in, out);
				}
				else {
					isRegistration = false;
					check(socket, isRegistration(), out);
					terminate_Socket(socket, in, out);
				}
			}
		}catch(Exception e) {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
	}
	
	public void work(int work_Number, Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out,
			List<Member> memberList, List<Connection> list) {
		// TODO Auto-generated method stub
		System.out.println("work 실행됨");

		switch (work_Number) {
		case PRODUCT_REGISTRATION: // 상품등록
			product_registration(socket, itemList, in, out, memberList);
			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("에서 [상품등록] 하였습니다.");//
			setActivity(activity+1);//
			break;
		case REFRESH: // 새로고침
			refresh(socket, itemList, in, out);
			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("에서 [새로고침] 하였습니다.");//
			setActivity(activity+1);//
			break;
		case DELETE_PRODUCT: // 상품삭제
			break;
		case DUPLICATE_CONFIRMATION:// 아이디 중복확인
			duplicate_Confirmation(socket, memberList, in, out);
			break;
		case N_DUPLICATE_CONFIRMATION://닉네임 중복확인
			n_Duplicate_Confirmation(socket, memberList, in, out);
			break;
		case JOIN_MEMBERSHIP: // 회원가입
			join_Membership(socket, memberList, in, out);
			break;
		case LOGIN:	// 로그인	
			login(socket, in, out, memberList);
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("에서 로그인 하였습니다.");//
			setActivity(activity+1);//
			break;
		case MEMBERSHIP_WITHDRAWAL: // 회원탈퇴
			break;
		case MODIFY_MEMBER: // 회원정보 수정
			break;
		default:
			break;
		}
	}
	
}

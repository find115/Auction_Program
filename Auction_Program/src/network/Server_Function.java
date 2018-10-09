package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * ���� ��� Ŭ����
 * �������� ����� ��ɵ��� �޼ҵ�� ������.
 * @author �ؼ�
 */
public class Server_Function {
	public static final int BID = 1; // ����
	public static final int BID_CANCEL = 2; // �������
	public static final int PRODUCT_REGISTRATION = 3; // ���
	public static final int DELETE_PRODUCT = 4; // ��ǰ����
	public static final int REFRESH = 5; // ���ΰ�ħ
	public static final int DUPLICATE_CONFIRMATION = 6; // ���̵� �ߺ�Ȯ��
	public static final int JOIN_MEMBERSHIP = 7; // ȸ������
	public static final int MEMBERSHIP_WITHDRAWAL = 8; // ȸ��Ż��
	public static final int MODIFY_MEMBER = 9; // ȸ������ ����
	public static final int LOGIN = 10;	 //�α� ��
	public static final int N_DUPLICATE_CONFIRMATION = 11; // �г��� �ߺ�Ȯ��
	
	Item item = new Item();
	FileIo file = new FileIo();
	Member mb = new Member();
	
	private StringBuffer serverLog;//������ ������ Ŭ���̾�Ʈ�� Ȱ�������� �����ϴ� ����
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

//	������ �����Ű�� �޼ҵ�
	public void terminate_Socket(Socket socket, ObjectInputStream in, ObjectOutputStream out) {
		try {
			in.close();
			out.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	��ɼ����� �ߵǾ����� Ŭ���̾�Ʈ���� �˷��ִ� �޼ҵ�
	public void check(Socket socket, boolean isRegistration, ObjectOutputStream out) {
		try {
			out.writeObject(isRegistration);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	ȸ�����Խ� ������ ���� ���̵� �ߺ�Ȯ�ΰ� �г��� �ߺ�Ȯ�� boolean[2]�� Ŭ���̾�Ʈ�� ���� ����
	public boolean[] membership_Qualification(Socket socket, ObjectInputStream in) {
		boolean[] judgment = new boolean[] {false,false};
		try {
			return judgment = (boolean[])in.readObject();
		}catch(Exception e) {
			return judgment;
		}
	}
	
//	���� ��� �޼ҵ�
//	��ũ�� ���� ������ ���� �޼ҵ� ����
//	Ŭ���̾�Ʈ�� ���� ȸ�������� �����ݾ��� �޾ƿ´�.
//	ȸ������ ����� ���� �Ŀ� �����ؾ���
//	���� ȸ�������� ������ ȸ�������� ��ġ�ϰ� �����Ⱓ�� ������ �ʾ����� �����ߴ� ����� ������
	public void bid_Cancel(int work_Number, Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out
										,List<Member> memberList, List<Connection>list) {
		
	}
	
//	�����ϴ� �޼ҵ�
	public void bid(int work_Number, Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out,
			List<Member> memberList, List<Connection> list) {
		int item_Num = 0;
		int bid = 0;

		try {
			item_Num = in.readInt();
			bid = in.readInt();
			System.out.println("�޴°� ���� ����");
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
//		���񱳸� ���ؼ� count �ε����� �ִ� item���� bidList�� ������
		List<Bids> compare = itemList.get(target).getBidsList();
		Date now = new Date();

		if (now.compareTo(itemList.get(target).getFinishDate()) == -1
				&& (compare.size() == 0 || compare.get(compare.size() - 1).getBid() < bid)) {
			Bids addbid = new Bids(bid, socket.getRemoteSocketAddress() + "", now);
			itemList.get(target).getBidsList().add(addbid);// �̺κ� test�غ�����.

//			���⼭ Ŭ���̾�Ʈ���� �����������θ� true�� ������
			isRegistration = true;
			check(socket, isRegistration, out);

			file.fileWriter(itemList);
			terminate_Socket(socket, in, out);

			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("���� ���� �Ͽ����ϴ�.\n");//
			serverLog.append("[��ǰ��ȣ] : ");//
			serverLog.append(itemList.get(target).getItemNumber());// ������ȣ
			serverLog.append("��");
			serverLog.append("  [��ǰ�̸�] : ");//
			serverLog.append(itemList.get(target).getTitle());// ��ǰ�̸�
			serverLog.append("  [�����ݾ�] : ");
			serverLog.append(bid);// ��ǰ�̸�
			serverLog.append("��");// ��ǰ�̸�
			setActivity(activity + 1);//

		} else {
//			���⼭ Ŭ���̾�Ʈ���� false�� ������
			isRegistration = false;
			check(socket, isRegistration, out);
			terminate_Socket(socket, in, out);
		}
	}
	
	
//	��ǰ ��� �޼ҵ�
	public void product_registration(Socket socket, List<Item> itemList, ObjectInputStream in, ObjectOutputStream out,
			List<Member> memberList) {
		try {
			item = (Item) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��ǰ ���� �޴°� ���� ����");

		try {
			if (itemList.size() == 0) {
				item.setItemNumber(0);
			} else {
				item.setItemNumber(itemList.get(itemList.size() - 1).getItemNumber() + 1);
			}

			itemList.add(item);

			file.fileWriter(itemList);

			System.out.println("�Ҹ� ������ ���� = "+item);

			isRegistration = true;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out); //�̰� Ǯ�� ���� ������
		} catch (Exception e1) {
			isRegistration = false;
			check(socket, isRegistration(), out);
			terminate_Socket(socket, in, out);
		}
	}
	
//	��ǰ���� �޼ҵ�
	public void delete_Product() {
		
	}
	
//	���ΰ�ħ �޼ҵ�
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
	
//	���̵� �ߺ� Ȯ��
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
	
//	�г��� �ߺ�Ȯ��
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
	
//	ȸ������
	public void join_Membership(Socket socket, List<Member> memberList, ObjectInputStream in, ObjectOutputStream out) {
//		���̵�� �г��� �ߺ��� ������ �޾ƿ�
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
				mb = (Member)in.readObject();//�̰� ó���� �޴°� �� �������ϵ�
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
	
//	�α���
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
					serverLog.append("���� ");
					
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
		System.out.println("work �����");

		switch (work_Number) {
		case PRODUCT_REGISTRATION: // ��ǰ���
			product_registration(socket, itemList, in, out, memberList);
			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("���� [��ǰ���] �Ͽ����ϴ�.");//
			setActivity(activity+1);//
			break;
		case REFRESH: // ���ΰ�ħ
			refresh(socket, itemList, in, out);
			resetServerLog();//
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("���� [���ΰ�ħ] �Ͽ����ϴ�.");//
			setActivity(activity+1);//
			break;
		case DELETE_PRODUCT: // ��ǰ����
			break;
		case DUPLICATE_CONFIRMATION:// ���̵� �ߺ�Ȯ��
			duplicate_Confirmation(socket, memberList, in, out);
			break;
		case N_DUPLICATE_CONFIRMATION://�г��� �ߺ�Ȯ��
			n_Duplicate_Confirmation(socket, memberList, in, out);
			break;
		case JOIN_MEMBERSHIP: // ȸ������
			join_Membership(socket, memberList, in, out);
			break;
		case LOGIN:	// �α���	
			login(socket, in, out, memberList);
			serverLog.append(socket.getRemoteSocketAddress());//
			serverLog.append("���� �α��� �Ͽ����ϴ�.");//
			setActivity(activity+1);//
			break;
		case MEMBERSHIP_WITHDRAWAL: // ȸ��Ż��
			break;
		case MODIFY_MEMBER: // ȸ������ ����
			break;
		default:
			break;
		}
	}
	
}

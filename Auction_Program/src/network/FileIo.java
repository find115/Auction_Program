package network;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * ���� ����� Ŭ����
 * ���� �޼ҵ�
 * �Է� �޼ҵ�
 * @author ���ؼ�
 */
public class FileIo {
	Item item = new Item();
	Member mb = new Member();
//	������ ������ ���� �޼ҵ�
	public void fileWriter(List<Item> itemList) {
		
//		File target = new File("Item_Db","item.list");
		File target = new File(System.getProperty("user.dir")+"\\Server_Db\\Item_Db\\item.list");
//		File target = new File("D:\\KimJunSeon\\worksapce\\Auction_Program\\Server_Db\\Item_Db\\item.list");
		
		ObjectOutputStream object;
		try {
			object = new ObjectOutputStream
					(new BufferedOutputStream(new FileOutputStream(target)));
			object.writeObject(itemList);
			object.flush();
			object.close();
		}catch(IOException e) {
			System.out.println("������ ���� �߻�");
			e.printStackTrace();
		}
	}
//	������ ������ �о���� �޼ҵ�
	@SuppressWarnings("unchecked")
	public List<Item> fileReader(List<Item> itemList) {
		
//		File target = new File("Item_Db","item.list");
		File target = new File(System.getProperty("user.dir")+"\\Server_Db\\Item_Db\\item.list");
//		File target = new File("D:\\KimJunSeon\\worksapce\\Auction_Program\\Server_Db\\Item_Db\\item.list");
		
//		List<Item> itemList = new ArrayList<>();
		
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			itemList = (List<Item>) object.readObject();//ĳ���� �ʿ�
			object.close();
			return itemList;
		}catch(Exception e1) {
			try {
				System.out.println("�����д��� �����߻��Ͽ� null�� return");
				return null;
			}catch(Exception e2) {
				e2.printStackTrace();
				return null;
			}
		}
	}
	
//	ȸ�� ������ ���� �޼ҵ�
	public void fileWriter_Member(List<Member> memberList) {
		
		File target = new File(System.getProperty("user.dir")+"\\Server_Db\\Member_Db\\member.list");
		
		ObjectOutputStream object;
		try {
			object = new ObjectOutputStream
					(new BufferedOutputStream(new FileOutputStream(target)));
			object.writeObject(memberList);
			object.flush();
			object.close();
		}catch(IOException e) {
			System.out.println("ȸ�� ������ ���� �߻�");
			e.printStackTrace();
		}
	}
	
//	ȸ�� ������ �о���� �޼ҵ�
	@SuppressWarnings("unchecked")
	public List<Member> fileReader_Member(List<Member> memberList) {
		
		File target = new File(System.getProperty("user.dir")+"\\Server_Db\\Member_Db\\member.list");
		
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			memberList = (List<Member>) object.readObject();//ĳ���� �ʿ�
			object.close();
			return memberList;
		}catch(Exception e) {
			System.out.println("ȸ�� ���� �д� �� ���� �߻�");
			return null;
		}
	}
	
//	�����ּ� ������ ���� �޼ҵ�
	public void fileWriter_ServerAddress(String address) {
		
		File target = new File(System.getProperty("user.dir")+"\\Client\\server.Address");
		
		ObjectOutputStream object;
		try {
			object = new ObjectOutputStream
					(new BufferedOutputStream(new FileOutputStream(target)));
			object.writeObject(address);
			object.flush();
			object.close();
		}catch(IOException e) {
			System.out.println("ȸ�� ������ ���� �߻�");
			e.printStackTrace();
		}
	}
	
//	���� �ּҸ� �о���� �޼ҵ�
	@SuppressWarnings("unchecked")
	public String fileReader_ServerAddress() {
		
		File target = new File(System.getProperty("user.dir")+"\\Client\\server.Address");
		String address;
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			address = (String) object.readObject();//ĳ���� �ʿ�
			object.close();
			return address;
		}catch(Exception e) {
			System.out.println("���� ���� �д� �� ���� �߻�");
			return null;
		}
	}
	
}

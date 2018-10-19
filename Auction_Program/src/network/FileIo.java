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
 * 파일 입출력 클래스
 * 쓰기 메소드
 * 입력 메소드
 * @author 김준선
 */
public class FileIo {
	Item item = new Item();
	Member mb = new Member();
//	아이템 정보를 쓰는 메소드
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
			System.out.println("저장중 오류 발생");
			e.printStackTrace();
		}
	}
//	아이템 정보를 읽어오는 메소드
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
			itemList = (List<Item>) object.readObject();//캐스팅 필요
			object.close();
			return itemList;
		}catch(Exception e1) {
			try {
				System.out.println("파일읽는중 오류발생하여 null값 return");
				return null;
			}catch(Exception e2) {
				e2.printStackTrace();
				return null;
			}
		}
	}
	
//	회원 정보를 쓰는 메소드
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
			System.out.println("회원 저장중 예외 발생");
			e.printStackTrace();
		}
	}
	
//	회원 정보를 읽어오는 메소드
	@SuppressWarnings("unchecked")
	public List<Member> fileReader_Member(List<Member> memberList) {
		
		File target = new File(System.getProperty("user.dir")+"\\Server_Db\\Member_Db\\member.list");
		
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			memberList = (List<Member>) object.readObject();//캐스팅 필요
			object.close();
			return memberList;
		}catch(Exception e) {
			System.out.println("회원 파일 읽는 중 예외 발생");
			return null;
		}
	}
	
//	서버주소 정보를 쓰는 메소드
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
			System.out.println("회원 저장중 예외 발생");
			e.printStackTrace();
		}
	}
	
//	서버 주소를 읽어오는 메소드
	@SuppressWarnings("unchecked")
	public String fileReader_ServerAddress() {
		
		File target = new File(System.getProperty("user.dir")+"\\Client\\server.Address");
		String address;
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			address = (String) object.readObject();//캐스팅 필요
			object.close();
			return address;
		}catch(Exception e) {
			System.out.println("서버 파일 읽는 중 예외 발생");
			return null;
		}
	}
	
}

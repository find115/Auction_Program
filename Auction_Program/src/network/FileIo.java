package network;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
/**
 * 파일 입출력 클래스
 * 쓰기 메소드
 * 입력 메소드
 * @author 김준선
 */
public class FileIo {
	Item item = new Item();
	
	public void fileWriter(List<Item> itemList) {
		
		File target = new File("Item_Db","item.list");
		
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
	
	@SuppressWarnings("unchecked")
	public List<Item> fileReader(List<Item> itemList) {
		
		File target = new File("Item_Db","item.list");
		
		ObjectInputStream object;
		try {
			object = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(target)));
			itemList = (List<Item>) object.readObject();//캐스팅 필요
			object.close();
		}catch(Exception e) {
			System.out.println("파일 읽는 중 오류 발생");
			e.printStackTrace();
		}
		return itemList;
	}
}

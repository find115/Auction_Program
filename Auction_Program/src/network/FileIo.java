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
 * ���� ����� Ŭ����
 * ���� �޼ҵ�
 * �Է� �޼ҵ�
 * @author ���ؼ�
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
			System.out.println("������ ���� �߻�");
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
			itemList = (List<Item>) object.readObject();//ĳ���� �ʿ�
			object.close();
		}catch(Exception e) {
			System.out.println("���� �д� �� ���� �߻�");
			e.printStackTrace();
		}
		return itemList;
	}
}

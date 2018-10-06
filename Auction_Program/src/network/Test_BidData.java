package network;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test_BidData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Item item = new Item();
		FileIo file = new FileIo();
		
		List<Item> itemList = new ArrayList<>();
		
		itemList = file.fileReader(itemList);
		Date finish = itemList.get(0).getFinishDate();
		Format fm = new SimpleDateFormat("y-MM-dd E HH:mm");
		
		
		Member mb = new Member();
		List<Member> mbList = new ArrayList<>();
		
//		System.out.println(fm.format(finish));
		System.out.println(itemList.get(0).getFinishDate());
		System.out.println(itemList.get(0).getCategory());
		
		System.out.println(itemList.get(0).getItemNumber());
		System.out.println(itemList.get(0).getBidsList().size());
//		System.out.println(itemList.get(0).getBidsList().get(0).getIpAdd());
//		System.out.println(itemList.get(0).getBidsList().get(0).getBid());
//		System.out.println(itemList.get(0).getBidsList().get(0).getBidTime());
		
//		int size = itemList.get(0).getBidsList().size();
//		System.out.println(itemList.get(0).getBidsList().get(size-1).getBid());
		
		
		System.out.println(itemList.size());
		System.out.println(itemList.get(itemList.size()-1).getId());
		
		
		
		System.out.println("아이템 넘버 테스트");
		for(int i=0; i<itemList.size(); i++) {
			System.out.println(itemList.get(i).getItemNumber());
		}
		
		
		System.out.println("회원 테스트");
		mbList = file.fileReader_Member(mbList);
		for(int i=0; i<mbList.size(); i++) {
			System.out.println(mbList.get(i).getId());
			System.out.println(mbList.get(i).getNickName());
			System.out.println(mbList.get(i).getPassword());
			System.out.println(mbList.get(i).getEmail());
		}
		
		
	}
}

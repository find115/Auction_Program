package network;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * 상품 객체를 만들기 위한 아이템 클래스
 * @author 김준선
 */

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;			//지금은 회원가입 구현이 되지 않아서 id를 닉네임을 사용
//	private String nick;		//닉네임
	private String title;		//제목
	private String explanation;	//설명
	private String category;	//카테고리
	private Date startDate;		//시작일
	private Date finishDate;	//종료일
	private int price;			//시작가격
	private ImageIcon image;	//제품 이미지
	
	Bids bids = new Bids();
	List<Bids> bidsList = new ArrayList<>();
	
	private int itemNumber;		//아이템의 고유번호
	
	
	public String getId() {
		return id;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public Bids getBids() {
		return bids;
	}
	public void setBids(Bids bids) {
		this.bids = bids;
	}
	
	public List<Bids> getBidsList() {
		return bidsList;
	}
	public void setBidsList(List<Bids> bidsList) {
		this.bidsList = bidsList;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public Item() {
		super();
	}
	//아이템 넘버, List<Bids>가 없는 생성자
	public Item(String id, String title, String explanation, String category, Date startDate, Date finishDate, int price,
			ImageIcon image) {
		super();
		this.id = id;
		this.title = title;
		this.explanation = explanation;
		this.category = category;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.price = price;
		this.image = image;
	}
	//아이템 넘버 빼고 다있는 생성자
	public Item(String id, String title, String explanation, String category, Date startDate, Date finishDate , int price, ImageIcon image, List<Bids> bidsList) {
		super();
		this.id = id;
		this.title = title;
		this.explanation = explanation;
		this.category = category;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.price = price;
		this.image = image;
		this.bidsList = bidsList;
	}
	//모든 멤버가 다있는 생성자
	public Item(String id, String title, String explanation, String category, Date startDate, Date finishDate, int price,
			ImageIcon image, List<Bids> bidsList, int itemNumber) {
		super();
		this.id = id;
		this.title = title;
		this.explanation = explanation;
		this.category = category;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.price = price;
		this.image = image;
		this.bidsList = bidsList;
		this.itemNumber = itemNumber;
	}
	
	
	
}

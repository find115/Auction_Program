package network;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * ��ǰ ��ü�� ����� ���� ������ Ŭ����
 * @author ���ؼ�
 */

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;			//������ ȸ������ ������ ���� �ʾƼ� id�� �г����� ���
//	private String nick;		//�г���
	private String title;		//����
	private String explanation;	//����
	private String category;	//ī�װ�
	private Date startDate;		//������
	private Date finishDate;	//������
	private int price;			//���۰���
	private ImageIcon image;	//��ǰ �̹���
	
	Bids bids = new Bids();
	List<Bids> bidsList = new ArrayList<>();
	
	private int itemNumber;		//�������� ������ȣ
	
	
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
	//������ �ѹ�, List<Bids>�� ���� ������
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
	//������ �ѹ� ���� ���ִ� ������
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
	//��� ����� ���ִ� ������
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

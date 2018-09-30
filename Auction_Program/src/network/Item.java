package network;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

/**
 * 리스트<아이템>을 만들기 위한 아이템 클래스
 * @author 김준선
 */

public class Item implements Serializable{

	private String title;		//제목
	private String explanation;	//설명
	private String category;	//카테고리
	private Date date;			//종료일
	private int price;			//시작가격
	private ImageIcon image;	//제품 이미지

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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public Item() {
		super();
	}
	
	public Item(String title, String explanation, String category, Date date, int price, ImageIcon image) {
		super();
		this.title = title;
		this.explanation = explanation;
		this.category = category;
		this.date = date;
		this.price = price;
		this.image = image;
	}
	
	
}

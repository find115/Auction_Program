package network;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

/**
 * ����Ʈ<������>�� ����� ���� ������ Ŭ����
 * @author ���ؼ�
 */

public class Item implements Serializable{

	private String title;		//����
	private String explanation;	//����
	private String category;	//ī�װ�
	private Date date;			//������
	private int price;			//���۰���
	private ImageIcon image;	//��ǰ �̹���

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

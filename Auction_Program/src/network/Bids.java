package network;
import java.io.Serializable;
import java.util.Date;

public class Bids implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bid;		//���� �ݾ�
	private String ipAdd;	//������ ����� ip
	private Date bidTime;	//������ �ð�
//	private String id;		//������ ����� id (����� id�� �����Ƿ� ip�� ���)
//	private String nick;	//������ ����� nickName
	
	public Bids() {
		super();
	}
	
	
	public Bids(int bid, String ipAdd, Date bidTime) {
		super();
		this.bid = bid;
		this.ipAdd = ipAdd;
		this.bidTime = bidTime;
	}
	
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getIpAdd() {
		return ipAdd;
	}
	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}
}

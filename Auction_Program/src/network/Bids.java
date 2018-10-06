package network;
import java.io.Serializable;
import java.util.Date;

public class Bids implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bid;		//입찰 금액
	private String ipAdd;	//입찰한 사람의 ip
	private Date bidTime;	//입찰한 시간
//	private String id;		//입찰한 사람의 id (현재는 id가 없으므로 ip로 대신)
//	private String nick;	//입찰한 사람의 nickName
	
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

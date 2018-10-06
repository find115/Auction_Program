package network;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nickName;
	private String password;
	private String phoneNumber;
	private String email;
	private String birth;
	
	private Date join;	//가입한 날짜
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getJoin() {
		return join;
	}
	public void setJoin(Date join) {
		this.join = join;
	}
	
	public Member() {
		super();
	}
	public Member(String id, String nickName, String password, String phoneNumber, String email, String birth,
			Date join) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birth = birth;
		this.join = join;
	}
	
	
}

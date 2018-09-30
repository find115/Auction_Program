package network;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client_Function {
		
//	String을 date형식으로 바꾸고 return 하는 메소드
//	단, 문자열의 형식은 아래와 같아야 함.
//	String oldstring = "2018-12-18 00:00";
	public Date stIsDate(String inputDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
}

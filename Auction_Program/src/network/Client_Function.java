package network;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client_Function {
		
//	String�� date�������� �ٲٰ� return �ϴ� �޼ҵ�
//	��, ���ڿ��� ������ �Ʒ��� ���ƾ� ��.
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

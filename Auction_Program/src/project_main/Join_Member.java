package project_main;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Join_Member extends JFrame{
	private Container con = this.getContentPane();
	
	private JPanel panel = new JPanel();
	
	private JLabel join = new JLabel("회원가입");
	
	private JLabel id= new JLabel("ID 입력");
	private JLabel nick= new JLabel("닉네임 입력");
	private JLabel pw= new JLabel("PW 입력");
	private JLabel pw_Check= new JLabel("PW 재입력");
	private JLabel phoneNumber= new JLabel("휴대폰 번호 입력");
	private JLabel email= new JLabel("이메일 입력");
	private JLabel birth= new JLabel("생년월일 입력");
	
	private JTextField input_Id = new JTextField();
	private JTextField input_Nick = new JTextField();
	private JTextField input_Phone = new JTextField();
	private JTextField input_Email = new JTextField();
	private JTextField input_Birth = new JTextField();
	
	private JPasswordField input_Pw = new JPasswordField();
	private JPasswordField input_Pw_Check = new JPasswordField();
	
	private JButton check_Id = new JButton("중복확인");
	private JButton check_Nick = new JButton("중복확인");
	
	private JButton check = new JButton("확인");
	private JButton cancel = new JButton("취소");
	
	public Join_Member() {
		this.event();
		this.display();
		this.setTitle("회원 가입");
		this.setSize(421, 717);
		this.setLocationByPlatform(true);
		this.setResizable(false);
	}

	private void display() {
		panel.setLayout(null);
		panel.setBounds(0, 0, 405, 678);
		
		join.setBounds(75, 32, 244, 61);
		
		id.setBounds(44, 137, 116, 30);
		nick.setBounds(44, 192, 116, 30);
		pw.setBounds(44, 248, 116, 30);
		pw_Check.setBounds(44, 316, 116, 30);
		phoneNumber.setBounds(44, 373, 116, 30);
		email.setBounds(44, 442, 116, 30);
		birth.setBounds(44, 504, 116, 30);
		
		input_Id.setBounds(172, 142, 147, 25);
		input_Nick.setBounds(172, 197, 147, 25);
		input_Phone.setBounds(172, 378, 184, 25);
		input_Email.setBounds(172, 447, 184, 25);
		input_Birth.setBounds(172, 509, 184, 25);
		
		input_Pw.setBounds(172, 249, 184, 29);
		input_Pw_Check.setBounds(172, 316, 184, 29);
		
		check_Id.setBounds(331, 142, 61, 25);
		check_Nick.setBounds(331, 196, 61, 25);
		
		check.setBounds(34, 570, 136, 52);
		cancel.setBounds(220, 570, 136, 52);
		
		panel.add(join);
		panel.add(id);
		panel.add(nick);
		panel.add(pw);
		panel.add(pw_Check);
		panel.add(phoneNumber);
		panel.add(email);
		panel.add(birth);
		panel.add(input_Id);
		panel.add(input_Nick);
		panel.add(input_Phone);
		panel.add(input_Email);
		panel.add(input_Birth);
		panel.add(input_Pw);
		panel.add(input_Pw_Check);
		panel.add(check_Id);
		panel.add(check_Nick);
		panel.add(check);
		panel.add(cancel);
		
		con.add(panel);
	}

	private void event() {
		// TODO Auto-generated method stub
		
	}

	
	
}

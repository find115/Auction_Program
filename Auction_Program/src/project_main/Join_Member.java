package project_main;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import network.Client_Function;
import network.Item;
import network.Member;


public class Join_Member extends JDialog{
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
	
//	------------------------------------------------------------------
	
	private boolean[] judgment = new boolean[] {false,false};
	private String password = new String();
	private String password_Check = new String();
	
	private Client_Function function = new Client_Function();
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword_Check() {
		return password_Check;
	}
	public void setPassword_Check(String password_Check) {
		this.password_Check = password_Check;
	}

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
		check_Id.addActionListener(e->{
			Runnable run_e = new Runnable() {
				@Override
				public void run() {
					// 전송 port, socket, inet 설정
					InetAddress inet = null;
					try {
						inet = InetAddress.getByName("localhost");
					} catch (UnknownHostException e2) {
						e2.printStackTrace();
					}
					int port = 50000;
					Socket socket = null;
					socket = function.socket_Creation(inet, port);
					judgment[0] = function.duplicate_Confirmation(socket, input_Id.getText());
					if(judgment[0]) {
						JOptionPane.showMessageDialog(Join_Member.this, "사용가능한 아이디 입니다.", "알림",
							JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(Join_Member.this, "사용 불가능한 아이디 입니다.", "경고", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
			Thread t = new Thread(run_e);
			t.setDaemon(true);
			t.start();
		});
		
		check_Nick.addActionListener(e->{
			Runnable run_e = new Runnable() {
				@Override
				public void run() {
					// 전송 port, socket, inet 설정
					InetAddress inet = null;
					try {
						inet = InetAddress.getByName("localhost");
					} catch (UnknownHostException e2) {
						e2.printStackTrace();
					}
					int port = 50000;
					Socket socket = null;
					socket = function.socket_Creation(inet, port);
					judgment[1] = function.n_Duplicate_Confirmation(socket, input_Nick.getText());
					if(judgment[1]) {
						JOptionPane.showMessageDialog(Join_Member.this, "사용가능한 닉네임 입니다.", "알림",
							JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(Join_Member.this, "사용 불가능한 닉네임 입니다.", "경고", JOptionPane.WARNING_MESSAGE);
					}
				}
			};
			Thread t = new Thread(run_e);
			t.setDaemon(true);
			t.start();
		});
		
		check.addActionListener(e->{
			setPassword(String.valueOf(input_Pw.getPassword()));
			setPassword_Check(String.valueOf(input_Pw_Check.getPassword()));
			
			Date birth = function.stIsBirth(input_Birth.getText());
			Member mb =new Member(input_Id.getText(), input_Nick.getText(), getPassword()
					, input_Phone.getText(), input_Email.getText(), birth);
			boolean type = function.type_Test(mb);
			
			if(type) {
				JOptionPane.showMessageDialog(Join_Member.this, "형식 불일치", "경고", JOptionPane.WARNING_MESSAGE);
			}
			else if(!judgment[0] || !judgment[1]) {
				JOptionPane.showMessageDialog(Join_Member.this, "ID,닉네임을 중복확인 하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			}
			else if(!getPassword().equals(getPassword_Check())) {
				JOptionPane.showMessageDialog(Join_Member.this, "패스워드와 패스워드 재입력이 일치하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			}
			else if(birth == null) {
				JOptionPane.showMessageDialog(Join_Member.this, "생년월일을 다시입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Runnable run = new Runnable() {
					@Override
					public void run() {
						// 전송 port, socket, inet 설정
						InetAddress inet = null;
						try {
							inet = InetAddress.getByName("localhost");
						} catch (UnknownHostException e2) {
							e2.printStackTrace();
						}
						int port = 50000;
						Socket socket = null;
						socket = function.socket_Creation(inet, port);
						Date birth = function.stIsBirth(input_Birth.getText());
						Member mb =new Member(input_Id.getText(), input_Nick.getText(), getPassword()
								, input_Phone.getText(), input_Email.getText(), birth);
						boolean result = function.join_Membership(socket, judgment, mb);
						if(result) {
							JOptionPane.showMessageDialog(Join_Member.this, "회원가입을 완료하였습니다.", "알림",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(Join_Member.this, "회원가입을 실패하였습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						}
					}
				};
				Thread t = new Thread(run);
				t.setDaemon(true);
				t.start();
				this.setVisible(false);
				this.dispose();
			}
		});
	}
}

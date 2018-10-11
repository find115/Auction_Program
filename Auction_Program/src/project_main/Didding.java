package project_main;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Didding extends JDialog{
	
	private Container con = this.getContentPane();
	
	private JPanel max_Bidding_Panel = new JPanel();	//현재 최고 입찰가 패널
	private JPanel price_Panel = new JPanel();
	private JPanel title_1 = new JPanel(); 		//현재 입찰 :
	private JPanel title_2 = new JPanel();		//원
	private JPanel title_3 = new JPanel();
	private JPanel title_4 = new JPanel();
	
	private JLabel server_Max_Bidding;
	
	private JPanel execution_Button_Panel = new JPanel();					//입찰 하기 버튼 패널 생성
	private JButton execution_Button = new JButton("입찰 하기");	//입찰 하기 버튼 생성
	
	private JPanel cancel_Button_Panel = new JPanel();					//입찰 취소 버튼 패널 생성
	private JButton cancel_Button = new JButton("입찰 취소");	//입찰 취소 버튼 생성

	private JTextField price;	//입찰 할 금액 입력 필드

	public Didding() {
		this.display();
		this.setTitle("입찰");
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		con.setLayout(null);
	}
	
	private void display() {
		//서버에서 현재 입찰가 정보 출력 
		server_Max_Bidding = new JLabel("",JLabel.CENTER);
		max_Bidding_Panel.setBounds(113, 27, 99, 27);
		con.add(max_Bidding_Panel);
		max_Bidding_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		max_Bidding_Panel.add(server_Max_Bidding);
		
		//금액 입력 필드
		price = new JTextField();
		price_Panel.setBounds(12, 101, 200, 27);
		con.add(price_Panel);
		price_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		price_Panel.add(price);
		
		//서버로 전송 여부
		execution_Button_Panel.setBounds(12, 150, 126, 52);
		con.add(execution_Button_Panel);
		execution_Button_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		execution_Button_Panel.add(execution_Button);
		execution_Button.addActionListener(event->{
			int choice = JOptionPane.showConfirmDialog(this, "입찰 하시겠습니까 ?", "확인", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(choice == 0) {
				JOptionPane.showMessageDialog(this, "상품 등록 되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				// price 값 서버로 전송
			}
		});
		
		cancel_Button_Panel.setBounds(150, 150, 122, 52);
		con.add(cancel_Button_Panel);
		cancel_Button_Panel.setLayout(new GridLayout(1, 0, 0, 0));
		cancel_Button_Panel.add(cancel_Button);
		cancel_Button.addActionListener(event->{
			int choice = JOptionPane.showConfirmDialog(this, "취소 하시겠습니까 ?", "취소", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);	//(위치, 텍스트, 제목, JOptionPane.(OPTION)상수)
			if(choice == 0) {
				this.setVisible(false);
			}
		});
		
		//타이틀 패널 4개
		title_1.setBounds(12, 27, 89, 27);
		con.add(title_1);
		title_1.setLayout(new GridLayout(1, 0, 0, 0));
		title_1.add(new JLabel("현재 입찰가 : "));
				
		title_2.setBounds(224, 27, 48, 27);
		con.add(title_2);
		title_2.setLayout(new GridLayout(1, 0, 0, 0));
		title_2.add(new JLabel("원"));
		
		title_3.setBounds(12, 64, 200, 27);
		con.add(title_3);
		title_3.setLayout(new GridLayout(1, 0, 0, 0));
		title_3.add(new JLabel("입찰 금액 입력"));
		
		title_4.setBounds(224, 101, 48, 27);
		con.add(title_4);
		title_4.setLayout(new GridLayout(1, 0, 0, 0));
		title_4.add(new JLabel("원"));
	}
	//액션 클래스로 사용해도 무관 
//	@Override
//	public void actionPerformed(ActionEvent event) {
//		if(event.getSource() == btnNewButton) {
//			int choice = JOptionPane.showConfirmDialog(this, "입찰 하시겠습니까 ?", "확인", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
//			if(choice == 0) {
//				System.out.println("입찰 되었습니다.");
//				//입찰 금액 데이터 버퍼로 보내기
//			}
//		}else if(event.getSource() == btnNewButton){
//			int choice = JOptionPane.showConfirmDialog(this, "취소 하시겠습니까 ?", "취소", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);	//(위치, 텍스트, 제목, JOptionPane.(OPTION)상수)
//			if(choice == 0) {
//				System.exit(0);
//			}
//		}
//	}
}

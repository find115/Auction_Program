package project_main;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import network.Item;

public class Menu extends JFrame implements ActionListener{
	
	//	컴포넌트 배치용 공간
	Enrollment enr = new Enrollment();
	Thedetails det = new Thedetails();
//	Rightdisplay right = new Rightdisplay();
	
	private List<Item> itemList = new ArrayList<>();
	private Date server_Time = new Date();
	
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Date getServer_Time() {
		return server_Time;
	}
	public void setServer_Time(Date server_Time) {
		this.server_Time = server_Time;
	}

	private Container con = this.getContentPane();
	private JTextField textField = new JTextField();
	private int search_count;
	private int count_page;
	private int count_max;
	private int count_least=1;
	
	
	private List<Integer> dataSize = new ArrayList<Integer>();					//데이터 크기
	private int end_data;			//마지막 데이터 값
	private int page_number = 1;	//페이지 번호 값
	private int page;				//페이지 값
	private int total_page;			//총 페이지 값
	private int start_page;			//시작 페이지 값
	private int center_page;		//중간 페이지 값
	private int end_page;			//마지막 페이지 값
	
//	private JPanel main_Board = new JPanel();
	
	private Border border = BorderFactory.createTitledBorder("");
	private Font font_1 = new Font("맑은 고딕", Font.BOLD, 25);
	private Font font_2 = new Font("맑은 고딕", Font.PLAIN, 15);
	
	private JTextArea result = new JTextArea();
	
	private JPanel board_Page = new JPanel();	//데이터 패널
	private JPanel previous_Page = new JPanel(); 				//이전 페이지
	private JButton previous_Button = new JButton("이전 페이지"); 	//이전페이지 버튼
	private JPanel next_Page = new JPanel();					//다음 페이지
	private JButton next_Button = new JButton("다음 페이지");		//다음페이지 버튼
	private JPanel main_Board = new JPanel();
	
	private JPanel[] panel_3 = new JPanel[5];	//main_Board에 패널 생성 크기
	
	//카테고리 버튼 생성
	private JButton button_1 = new JButton("모자");
	private JButton button_2 = new JButton("상의");
	private JButton button_3 = new JButton("하의");
	private JButton button_4 = new JButton("신발");
	private JButton button_5 = new JButton("외투");
	
	//데이터 패널에 들어가는 라벨 값
	private JLabel lblNewLabel_1 = null;
	private JLabel lblNewLabel_2 = null;
	private JLabel lblNewLabel_3 = null;
	private JLabel lblNewLabel_4 = null;
	private JLabel lblNewLabel_5 = null;
	private JLabel lblNewLabel_6 = null;
	private JLabel lblNewLabel_7 = null;
	private JLabel lblNewLabel_8 = null;
	private JLabel lblNewLabel_9 = null;
	private JButton details = null;
	
	//페이지 버튼
	private JButton a = null;
	private	JButton b = null;
	private JButton c = null;
	private JButton d = null;
	private JButton e = null;
	
	public Menu(List<Item> itemList, Date server_Time) {
//		Main_Start에서 선언할때 받아온 itemList와 server_Time을 this로 선언해줍니다.
		this.itemList = itemList;
		this.server_Time = server_Time;
		
		this.topdisplay();
		this.leftdisplay();
		this.rightdisplay();
		this.event();
		this.menu();
		this.setTitle("Mini Project");
		this.setSize(1280, 980);
		this.setLocationByPlatform(true);
		this.setResizable(false);
	}

	private void menu() {
		
	}

	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	private void topdisplay() {
		this.getContentPane().setLayout(null);
		 	//타이틀 border 생성
		
		for(int i=0; i<getItemList().size(); i++) {
			dataSize.add(i);
		}
		JPanel panel = new JPanel();
		con.add(panel);//
		JLabel search = new JLabel("검색 : ");
		JButton enrollment = new JButton("상품 등록");
		JButton button_6 = new JButton("상품 취소");
	
		panel.setBounds(0, 0, 1264, 101);
		panel.setBorder(border); 
		this.getContentPane().add(panel);
		panel.setLayout(null);

		search.setBounds(361, 37, 57, 15);
		panel.add(search, JLabel.CENTER);
		
		textField = new JTextField();
		textField.setBounds(412, 34, 276, 21);
		panel.add(textField);
		textField.setColumns(20);
		
		JButton lookup = new JButton("조회");
		lookup.setBounds(712, 33, 97, 23);
		panel.add(lookup, JButton.CENTER);
		
		//검색 조회 서버에 저장되어 있는 해당 list 값
		lookup.addActionListener(e->{
			List<String> list = new ArrayList<>();
			search_count = 0;
			for(int i=0; i < list.size(); i++) {
				if(list.get(i).equals(textField.getText())) {
					search_count++;
				}
			}
			Descending descending = new Descending();
			Collections.sort(list, descending);
			for (String index : list) {
	            System.out.print(index + " ");
	        }
		});
		enrollment.setBounds(967, 10, 97, 81);
		panel.add(enrollment);
		
		enrollment.addActionListener(e->{
			enr.setVisible(true);
		});
		
		button_6.setBounds(1089, 10, 97, 81);
		panel.add(button_6);
	}
	
	
	private class Descending implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	 
	}
	
	private void leftdisplay() {

		JPanel panel_contents = new JPanel();
		panel_contents.setBounds(0, 100, 206, 842);
		panel_contents.setBorder(border); 
		this.getContentPane().add(panel_contents);
		panel_contents.setLayout(null);
		
		JLabel contents = new JLabel("목 차",JLabel.CENTER);
		contents.setFont(font_1);
		contents.setBounds(31, 30, 143, 30);
		panel_contents.add(contents);
		
		button_1.setBounds(31, 102, 143, 45);
		panel_contents.add(button_1);
		
		button_2.setBounds(31, 249, 143, 45);
		panel_contents.add(button_2);
		
		button_3.setBounds(31, 396, 143, 45);
		panel_contents.add(button_3);
		
		button_4.setBounds(31, 543, 143, 45);
		panel_contents.add(button_4);
		
		button_5.setBounds(31, 690, 143, 45);
		panel_contents.add(button_5);
		
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		
		//버튼 font
		button_1.setFont(font_2);
		button_2.setFont(font_2);
		button_3.setFont(font_2);
		button_4.setFont(font_2);
		button_5.setFont(font_2);
	}
	
	public void rightdisplay() {
		
		main_Board.setBounds(205, 100, 1059, 727);	//삭제
		main_Board.setBorder(border);				//삭제			
		this.getContentPane().add(main_Board);						//삭제
		main_Board.setLayout(null);					//삭제
		result.setText("검색 결과 : " + getItemList().size()+"개가 확인 되었습니다.");
		result.setBounds(290, 0, 367, 37);
		result.setEditable(false);
		main_Board.add(result);						//this
		
		board_Page.setBorder(border);
		board_Page.setBounds(470, 886, 377, 46);
		this.getContentPane().add(board_Page);
		board_Page.setLayout(new GridLayout(1, 5, 0, 0));
		
		a = new JButton(Integer.toString(page_number)); //Integer.toString(++page_end) - 페이지 사이즈 값 지정
		b = new JButton("2");
		c = new JButton("3");
		d = new JButton("4");
		e = new JButton("5");
		
		
		
		int w = 2118, h = 1454;
		
		board_Page.add(a);
		a.addActionListener(e_a->{
			int size = 0;						//데이터 패널 이동 초기값
			JPanel[] panel_3 = null;
			panel_3 = new JPanel[5];
			for(int i=0; i<5; i++) {
				panel_3[i] = new JPanel();
				main_Board.removeAll();					
				main_Board.revalidate();				
				main_Board.repaint();				
				main_Board.add(panel_3[i]);				
			}
			for(int i=0; i<5; i++) {	
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				main_Board.setBounds(205, 100, w, h);		
				size += 130;
				main_Board.add(panel_3[i]);					
				this.getContentPane().add(main_Board);		
			}
			for(int i=0; i<5; i++) {
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("제목 : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("시작한 가격 : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("현재 최대 입찰가 : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("카테고리 : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("시작일 : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("종료일 : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("입찰 횟수 : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("상세 보기");
				details.setBounds(847, 70, 143, 35);
				panel_3[i].add(details);
				
			}
		});
		
		board_Page.add(b);
		b.addActionListener(e_b->{
			int size = 0;
			JPanel[] panel_3 = null;
			panel_3 = new JPanel[5];
			for(int i=0; i<5; i++) {
				panel_3[i] = new JPanel();
				main_Board.removeAll();					
				main_Board.revalidate();				
				main_Board.repaint();					
				main_Board.add(panel_3[i]);				
			}
			for(int i=0; i<5; i++) {	 
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				main_Board.setBounds(205, 100, w, h);		
				size += 130;
				main_Board.add(panel_3[i]);						
				this.getContentPane().add(main_Board);				
			}
			for(int i=0; i<5; i++) {
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("제목 : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("시작한 가격 : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("현재 최대 입찰가 : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("카테고리 : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("시작일 : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("종료일 : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("입찰 횟수 : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("상세 보기");
				details.setBounds(847, 70, 143, 35);
				panel_3[i].add(details);
			}
		});
		
		board_Page.add(c);
		c.addActionListener(e_c->{
			int size = 0;
			JPanel[] panel_3 = null;
			panel_3 = new JPanel[5];
			for(int i=0; i<5; i++) {
				panel_3[i] = new JPanel();
				main_Board.removeAll();					
				main_Board.revalidate();				
				main_Board.repaint();					
				main_Board.add(panel_3[i]);				
			}
			for(int i=0; i<5; i++) {	
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				main_Board.setBounds(205, 100, w, h);		
				size += 130;
				main_Board.add(panel_3[i]);						
				this.getContentPane().add(main_Board);				
			}
			for(int i=0; i<5; i++) {
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("제목 : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("시작한 가격 : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("현재 최대 입찰가 : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("카테고리 : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("시작일 : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("종료일 : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("입찰 횟수 : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("상세 보기");
				details.setBounds(847, 70, 143, 35);
				panel_3[i].add(details);
			}
		});
		
		board_Page.add(d);
		d.addActionListener(e_d->{
			int size = 0;
			JPanel[] panel_3 = null;
			panel_3 = new JPanel[5];
			for(int i=0; i<5; i++) {
				panel_3[i] = new JPanel();
				main_Board.removeAll();					
				main_Board.revalidate();				
				main_Board.repaint();					
				main_Board.add(panel_3[i]);				
			}
			for(int i=0; i<5; i++) {	
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				main_Board.setBounds(205, 100, w, h);		
				size += 130;
				main_Board.add(panel_3[i]);						
				this.getContentPane().add(main_Board);			
			}
			for(int i=0; i<5; i++) {
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("제목 : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("시작한 가격 : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("현재 최대 입찰가 : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("카테고리 : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("시작일 : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("종료일 : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("입찰 횟수 : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("상세 보기");
				details.setBounds(847, 70, 143, 35);
				panel_3[i].add(details);
			}
		});
		
		board_Page.add(e);
		e.addActionListener(e_e->{
			int size = 0;
			JPanel[] panel_3 = null;
			panel_3 = new JPanel[5];
			for(int i=0; i<5; i++) {
				panel_3[i] = new JPanel();
				main_Board.removeAll();					
				main_Board.revalidate();				
				main_Board.repaint();					
				main_Board.add(panel_3[i]);	
			}
			
			for(int i=0; i<5; i++) {
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				main_Board.setBounds(205, 100, w, h);		
				size += 130;
				main_Board.add(panel_3[i]);						
				this.getContentPane().add(main_Board);			
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("제목 : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("시작한 가격 : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("현재 최대 입찰가 : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("카테고리 : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("시작일 : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("종료일 : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("입찰 횟수 : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("상세 보기");
				details.setBounds(847, 70, 143, 35);
				details.addActionListener(event->{
					det.setVisible(true);
				});
				panel_3[i].add(details);
				
			}
		});
		
		
		
		// 이전페이지 버튼
		previous_Page.setBorder(border);
		previous_Page.setBounds(261, 886, 145, 46);
		this.add(previous_Page);
		previous_Page.setLayout(new GridLayout(1, 0, 0, 0));

		previous_Page.add(previous_Button);
		previous_Button.addActionListener(event -> {
			int number = 5;
			a.setEnabled(true);
			b.setEnabled(true);
			c.setEnabled(true);
			d.setEnabled(true);
			e.setEnabled(true);
			if(event.getSource() == previous_Button) {
				if(total_page + 5 >= start_page) {
					total_page = start_page;
				}else {
					total_page += 5;
				}
				count_page--;
				if(count_page >= count_least) {
					a.setText(null); b.setText(null); 
					c.setText(null); d.setText(null); 
					e.setText(null); 
					page_number = (count_page * number) - 4; // 1페이지 - 6페이지 - 11페이지 ...
					a.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 3; // 2페이지 - 7페이지 - 12페이지 ...
					b.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 2; // 3페이지 - 8페이지 - 13페이지 ...
					c.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 1; // 4페이지 - 9페이지 - 14페이지 ...
					d.setText(Integer.toString(page_number));
					page_number = (count_page * number); // 5페이지 - 10페이지 - 15페이지 ...
					e.setText(Integer.toString(page_number));
				}else if(count_page < count_least) {
					JOptionPane.showMessageDialog(null, "더 이상 페이지가 없습니다.", "경고 !", JOptionPane.WARNING_MESSAGE);
					count_page++;
				}
			}
		});

		next_Page.setBorder(border);
		next_Page.setBounds(914, 886, 145, 46);
		this.add(next_Page);
		next_Page.setLayout(new GridLayout(1, 0, 0, 0));

		next_Page.add(next_Button);
		next_Button.addActionListener(event -> {
			int number = 5;
			if (event.getSource() == next_Button) {

				if (total_page - 5 < 0) {
					total_page = 0;
				} else {
					total_page -= 5;
				}

				if (end_page > 0) {
					count_max = center_page + 1;
				} else {
					count_max = center_page;
				}
				count_page++;
				// 중간 페이지 값 구하기
				if (count_page < count_max || (end_page == 0 && count_page == count_max)) { // center
					page_number = (count_page * number) - 4; // 1페이지 - 6페이지 - 11페이지 ...
					a.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 3; // 2페이지 - 7페이지 - 12페이지 ...
					b.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 2; // 3페이지 - 8페이지 - 13페이지 ...
					c.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 1; // 4페이지 - 9페이지 - 14페이지 ...
					d.setText(Integer.toString(page_number));
					page_number = (count_page * number); // 5페이지 - 10페이지 - 15페이지 ...
					e.setText(Integer.toString(page_number));

				} else if (count_page > count_max) { //맥시멈 카운터보다 카운터가 높으면 경고 메세지 + 페이지 카운트 -1 감소
					JOptionPane.showMessageDialog(null, "더 이상 페이지가 없습니다.", "경고 !", JOptionPane.WARNING_MESSAGE);
					count_page--;
				}
				if (count_page == count_max) { // 카운트 최대 값
					for (int i = 0; i < end_page; i++) { // 마지막 페이지 값 계산 (마지막 페이지 번호 버튼 생성)
						switch (i) {
						case 0:
							page_number = (count_page * number) - 4; // 1페이지 - 6페이지 - 11페이지 ...
							a.setText(Integer.toString(page_number));
							b.setText(null);
							b.setEnabled(false);
							c.setText(null);
							c.setEnabled(false);
							d.setText(null);
							d.setEnabled(false);
							e.setText(null);
							e.setEnabled(false);
							break;
						case 1:
							page_number = (count_page * number) - 3; // 2페이지 - 7페이지 - 12페이지 ...
							b.setEnabled(true);
							b.setText(Integer.toString(page_number));
							c.setText(null);
							c.setEnabled(false);
							d.setText(null);
							d.setEnabled(false);
							e.setText(null);
							e.setEnabled(false);
							break;
						case 2:
							page_number = (count_page * number) - 2; // 3페이지 - 8페이지 - 13페이지 ...
							c.setEnabled(true);
							c.setText(Integer.toString(page_number));
							d.setText(null);
							d.setEnabled(false);
							e.setText(null);
							e.setEnabled(false);
							break;
						case 3:
							page_number = (count_page * number) - 1; // 4페이지 - 9페이지 - 14페이지 ...
							d.setEnabled(true);
							d.setText(Integer.toString(page_number));
							e.setText(null);
							e.setEnabled(false);
							break;
						case 4:
							page_number = (count_page * number); // 5페이지 - 10페이지 - 15페이지 ...
							e.setEnabled(true);
							e.setText(Integer.toString(page_number));
							break;
						}
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int number = 5;						//페이지 계산 고정 값
		
		if (event.getSource() == button_1 || event.getSource() == button_2 || event.getSource() == button_3
				|| event.getSource() == button_4 || event.getSource() == button_5) {
			a.setText(null); a.setEnabled(true);
			b.setText(null); b.setEnabled(true);
			c.setText(null); c.setEnabled(true);
			d.setText(null); d.setEnabled(true);
			e.setText(null); e.setEnabled(true);
			
			//현재 데이터 값 = 26
			page = (dataSize.size()/5);			//페이지 값
			start_page = 0;						//첫 페이지 초기값
			center_page = 0;					//중간 페이지 초기값
			end_page = 0;						//마지막 페이지 초기값
			end_data = dataSize.size()%5;		//마지막 페이지 데이터 값

			//페이지 값
			if(end_data > 0) {					//마지막 페이지 값의 데이터 존재 참 거짓 판별
				total_page = page + 1;			//페이지 값 + 1 = 총페이지 값;
				start_page = total_page;		//첫 페이지 설정 값
				center_page = total_page/5;     //중간 페이지 설정 값
				end_page = total_page%5;		//마지막 페이지 설정 값
			}else {
				total_page = page;
				start_page = total_page;		
				center_page = total_page/5;
				end_page = total_page%5;
			}
			//첫 페이지 값 5페이지 이하의 값인지 구분 
			if(start_page <= 0) {
				JOptionPane.showMessageDialog(null, "페이지가 없습니다.", 
						"경고 !", JOptionPane.WARNING_MESSAGE);
				a.setText(null); a.setEnabled(false);
				b.setText(null); b.setEnabled(false);
				c.setText(null); c.setEnabled(false);
				d.setText(null); d.setEnabled(false);
				e.setText(null); e.setEnabled(false);
			}else if(start_page <= 5) {
				//첫 페이지 값 계산
				count_page=1;
				for(int i=1; i<=start_page; i++) {
					switch(i) {
					case 1 : page_number=(count_page*number)-4;		//1페이지 - 6페이지 - 11페이지 ...
					a.setText(Integer.toString(page_number));
					b.setText(null); b.setEnabled(false);
					c.setText(null); c.setEnabled(false);
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 2 : page_number=(count_page*number)-3;		//2페이지 - 7페이지 - 12페이지 ...
					b.setEnabled(true);
					b.setText(Integer.toString(page_number));
					c.setText(null); c.setEnabled(false);
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 3 : page_number=(count_page*number)-2;		//3페이지 - 8페이지 - 13페이지 ...
					c.setEnabled(true);
					c.setText(Integer.toString(page_number));
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 4 : page_number=(count_page*number)-1;		//4페이지 - 9페이지 - 14페이지 ...
					d.setEnabled(true);
					d.setText(Integer.toString(page_number));
					e.setText(null); e.setEnabled(false);
					break;
					case 5 : page_number=(count_page*number);		//5페이지 - 10페이지 - 15페이지 ...
					e.setEnabled(true);
					e.setText(Integer.toString(page_number));
					break;
					}
				}
//				start_page -= 5;
			}else{
				//start_page 값이 6이상의 값일때
				//다음 페이지 액션 이벤트
				count_page=1;
				page_number=(count_page*number)-4;		//1페이지 - 6페이지 - 11페이지 ...
				a.setText(Integer.toString(page_number));
				page_number=(count_page*number)-3;		//2페이지 - 7페이지 - 12페이지 ...
				b.setText(Integer.toString(page_number));
				page_number=(count_page*number)-2;		//3페이지 - 8페이지 - 13페이지 ...
				c.setText(Integer.toString(page_number));
				page_number=(count_page*number)-1;		//4페이지 - 9페이지 - 14페이지 ...
				d.setText(Integer.toString(page_number));
				page_number=(count_page*number);		//5페이지 - 10페이지 - 15페이지 ...
				e.setText(Integer.toString(page_number));
			}
		}
	}

	
}

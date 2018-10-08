package project_main;


import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Enrollment extends JDialog{
	private String path = "";
	private String name = "";
	
	private JTextField textField = new JTextField();
	private JTextArea textField_1 = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textField_1);
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField("ex)2018-12-31 23:59");
	
	private ImageIcon icon = new ImageIcon(path);
	private JPanel panel = new JPanel();
	private JLabel image = new JLabel();
	private JLabel title = new JLabel("제목 : ");
	private JLabel explanation = new JLabel("설명 : ");
	private JLabel price = new JLabel("가격 : ");
	private JLabel day = new JLabel("기간 : ");
	private JLabel category = new JLabel("목록 : ");
	private JLabel money = new JLabel(" 원");
	
	private String menu[] = {"모 자", "상 의", "하 의", "신 발", "외 투"};
	private JComboBox comboBox = new JComboBox(menu);
	
	private JButton open = new JButton("이미지 등록");
	private FileDialog file = new FileDialog(this, "열기할 파일을 선택하세요", FileDialog.LOAD);
	
	private JButton product = new JButton("상품 등록");
	
	private Font font = new Font("맑은 고딕", Font.BOLD, 20);
	
	public Enrollment() {
		enrollment_Event();
		setTitle("상품 등록");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		// 이미지
		panel.setBounds(0, 0, 417, 562);
		getContentPane().add(panel);
		panel.setLayout(null);

		// 제목
		title.setBounds(429, 16, 57, 15);
		getContentPane().add(title);
		textField.setBounds(471, 10, 301, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		// 설명
		explanation.setBounds(429, 51, 57, 15);
		getContentPane().add(explanation);
		textField_1.setLineWrap(true);
		scroll.setBounds(471, 48, 301, 338);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scroll);

		// 기간
		day.setBounds(429, 415, 57, 15);
		getContentPane().add(day);
		textField_3.setBounds(471, 412, 132, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addFocusListener (new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(textField_3.getText() == null || textField_3.getText() == "") {
					textField_3.setText("ex)2018-12-31 23:59");
				}else if(textField_3.getText() != null || textField_3.getText() != "") {
					//text field 값 저장
				}
			}
		});

		// 가격
		price.setBounds(429, 456, 57, 15);
		getContentPane().add(price);
		textField_2.setBounds(471, 453, 191, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		money.setBounds(662, 456, 57, 15);
		getContentPane().add(money);

		// 목록
		category.setBounds(605, 415, 57, 15);
		getContentPane().add(category);
		comboBox.setBounds(651, 408, 121, 28);
		getContentPane().add(comboBox);
	}
	
	private void enrollment_Event() {
		//상품 등록 버튼
		product.setBounds(614, 484, 158, 68);
		getContentPane().add(product);
		product.setFont(font);
		
		//상품 버튼 이벤트
		product.addActionListener(e->{
			
		});
		
		//이미지 등록 버튼
		open.setBounds(429, 484, 158, 68);
		getContentPane().add(open);
		open.setFont(font);
		
		//이미지 버튼 이벤트
		open.addActionListener(e->{
			String str = e.getActionCommand();
			if(str.equals("이미지 등록")) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					path = chooser.getSelectedFile().getPath();	//이미지 경로 + 이름
//					name = chooser.getSelectedFile().getName();	//이미지 이름
				}
//				System.out.println(path);						//경로 확인
				image = new JLabel(new ImageIcon(path));
				image.setBounds(12, 10, 393, 542);
				panel.add(image);
			}
//			file.setVisible(true);
//			file.setFilenameFilter("그림 파일 (*.jpg, *.gif, *.bmp)");
//			if(file.getFile() == null) return;

		});
	}
}

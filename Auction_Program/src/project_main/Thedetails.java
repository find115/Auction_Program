package project_main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Thedetails extends JDialog{
	
	Didding ding = new Didding();
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JPanel panel_8 = new JPanel();
	private JPanel panel_9 = new JPanel();
	private JTextField textField = new JTextField("제목 : ");
	private JTextField txtStartDay = new JTextField("경매 시작 날짜");
	private JTextField textField_1 = new JTextField("경매 끝나는 날짜");
	private JTextField textField_3 = new JTextField("입찰 정보");
	private JTextField textField_4 = new JTextField("sotmfvma_123");
	private JLabel lblNewLabel = new JLabel("이미지 넣는 곳");
	private JLabel lblNewLabel_1 = new JLabel("ID : ");
	
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea_1 = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
	
	private JButton btnNewButton = new JButton("입 찰");
	
	public Thedetails(){
		this.display();
		this.setTitle("상세 보기");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
	}
	
	private void display() {
		panel.setBounds(57, 10, 356, 26);
		this.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.add(textField);
		
		panel_1.setBounds(12, 46, 445, 299);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.add(lblNewLabel);
		
		panel_3.setBounds(57, 514, 160, 26);
		this.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(txtStartDay);
		txtStartDay.setColumns(10);
		
		panel_4.setBounds(253, 514, 160, 26);
		this.getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		panel_5.setBounds(565, 10, 141, 26);
		this.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		panel_7.setBounds(647, 490, 110, 50);
		this.getContentPane().add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		panel_7.add(btnNewButton);
		btnNewButton.addActionListener(event->{
			ding.setVisible(true);
		});
		
		panel_8.setBounds(587, 355, 170, 26);
		this.getContentPane().add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		panel_8.add(textField_4);
		textField_4.setColumns(10);
		
		panel_9.setBounds(505, 355, 70, 26);
		this.getContentPane().add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		panel_9.add(lblNewLabel_1);
		
		panel_2.setBounds(12, 355, 445, 144);
		this.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		textArea.setLineWrap(true);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane);
		
		panel_6.setBounds(505, 46, 267, 299);
		this.getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		textArea_1.setLineWrap(true);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel_6.add(scrollPane_1);
	}
}

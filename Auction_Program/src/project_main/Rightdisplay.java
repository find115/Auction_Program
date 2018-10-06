package project_main;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Rightdisplay extends JPanel{
	
	private JTextArea result = new JTextArea();
	
	private JPanel board_Page = new JPanel();	//������ �г�
	private Border border = BorderFactory.createTitledBorder("");
	private JPanel previous_Page = new JPanel(); 				//���� ������
	private JButton previous_Button = new JButton("���� ������"); 	//���������� ��ư
	private JPanel next_Page = new JPanel();					//���� ������
	private JButton next_Button = new JButton("���� ������");		//���������� ��ư
	private int count;
	private JPanel main_Board = new JPanel();
	
	private int size = 0; //������ �г� �̵� �ʱⰪ
	private JPanel[] panel_3 = new JPanel[5];	//main_Board�� �г� ���� ũ��
	
	//������ �гο� ���� �� ��
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
	
	//������ ��ư
	private JButton a = null;
	private	JButton b = null;
	private JButton c = null;
	private JButton d = null;
	private JButton e = null;
	
	public Rightdisplay() {
		
//		main_Board.setBounds(205, 100, 1059, 727);	//����
//		main_Board.setBorder(border);				//����			
//		this.add(main_Board);						//����
//		main_Board.setLayout(null);					//����
		
		result.setEditable(false);
		result.setText("�˻� ��� : " + count);
		result.setBounds(290, 0, 367, 37);
		result.setEditable(false);
		this.add(result);						//this
		
		board_Page.setBorder(border);
		board_Page.setBounds(470, 886, 377, 46);
		this.add(board_Page);
		board_Page.setLayout(new GridLayout(1, 5, 0, 0));
		
		a = new JButton("1"); //Integer.toString(++page_end) - ������ ������ �� ����
		b = new JButton("2");
		c = new JButton("3");
		d = new JButton("4");
		e = new JButton("5");
		
		for(int i=0; i<5; i++) {
			panel_3[i] = new JPanel();
			main_Board.removeAll();					//this
			main_Board.add(panel_3[i]);				//this
			main_Board.revalidate();				//this
			main_Board.repaint();					//this
		}
		board_Page.add(a);
		a.addActionListener(e_a->{
			for(int i=0; i<5; i++) {	// 1~5 
				panel_3[i].setLayout(null);
				panel_3[i].setBorder(border);
				panel_3[i].setBounds(0, (70+size), 1059, 115);
				this.setBounds(205, 100, 2118, 1454);		//this
				size += 130;
				main_Board.add(panel_3[i]);						//this
				this.getRootPane().add(main_Board);				//����
			}
			for(int i=0; i<5; i++) {
				lblNewLabel_1 = new JLabel(new ImageIcon("testImage/Bluejeans.jpg"));
				lblNewLabel_1.setBounds(0, 0, 341, 115);
				panel_3[i].add(lblNewLabel_1);

				lblNewLabel_2 = new JLabel("���� : ");
				lblNewLabel_2.setBounds(353, 1, 293, 35);
				panel_3[i].add(lblNewLabel_2);
				
				lblNewLabel_3 = new JLabel("������ ���� : ");
				lblNewLabel_3.setBounds(353, 46, 254, 24);
				panel_3[i].add(lblNewLabel_3);
				
				lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
				lblNewLabel_4.setBounds(353, 83, 254, 24);
				panel_3[i].add(lblNewLabel_4);
				
				lblNewLabel_5 = new JLabel("ī�װ� : ");
				lblNewLabel_5.setBounds(658, 21, 116, 15);
				panel_3[i].add(lblNewLabel_5);
				
				lblNewLabel_6 = new JLabel("������ : ");
				lblNewLabel_6.setBounds(619, 46, 155, 24);
				panel_3[i].add(lblNewLabel_6);
				
				lblNewLabel_7 = new JLabel("������ : ");
				lblNewLabel_7.setBounds(619, 83, 155, 24);
				panel_3[i].add(lblNewLabel_7);
				
				lblNewLabel_8 = new JLabel("ID : ");
				lblNewLabel_8.setBounds(847, 6, 200, 24);
				panel_3[i].add(lblNewLabel_8);
				
				lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
				lblNewLabel_9.setBounds(847, 36, 143, 24);
				panel_3[i].add(lblNewLabel_9);
				
				details = new JButton("�� ����");
				details.setBounds(847, 70, 143, 35);
				panel_3[i].add(details);
				
			}
		});
		
		board_Page.add(b);
		board_Page.add(c);
		board_Page.add(d);
		board_Page.add(e);
		
		// ���������� ��ư
		previous_Page.setBorder(border);
		previous_Page.setBounds(261, 886, 145, 46);
		this.add(previous_Page);
		previous_Page.setLayout(new GridLayout(1, 0, 0, 0));

		previous_Page.add(previous_Button);
		previous_Button.addActionListener(e1 -> {
			// ���� ������ ��ư �׼�
		});

		next_Page.setBorder(border);
		next_Page.setBounds(914, 886, 145, 46);
		this.add(next_Page);
		next_Page.setLayout(new GridLayout(1, 0, 0, 0));

		next_Page.add(next_Button);
		next_Button.addActionListener(e2 -> {

		});
		
	}
	void page() {
		
	}
}

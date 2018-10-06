package project_main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JTextPane;

public class Menu extends JFrame{
	//	������Ʈ ��ġ�� ����
	Enrollment enr = new Enrollment();
//	Rightdisplay right = new Rightdisplay();
	private Container con;
	private JTextField textField = new JTextField();
	private int count;
	
	private int pageSize = 200;					//������ ũ��
	private int save_page = pageSize;			//������ �����
	private int page_end;						//������ ������
	
//	private JPanel main_Board = new JPanel();
	
	private Border border = BorderFactory.createTitledBorder("");
	private Font font_1 = new Font("���� ���", Font.BOLD, 25);
	private Font font_2 = new Font("���� ���", Font.PLAIN, 15);
	
	private JTextArea result = new JTextArea();
	
	private JPanel board_Page = new JPanel();	//������ �г�
	private JPanel previous_Page = new JPanel(); 				//���� ������
	private JButton previous_Button = new JButton("���� ������"); 	//���������� ��ư
	private JPanel next_Page = new JPanel();					//���� ������
	private JButton next_Button = new JButton("���� ������");		//���������� ��ư
	private JPanel main_Board = new JPanel();
	
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
	
	public Menu() {
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
		 	//Ÿ��Ʋ border ����
		
		
		JPanel panel = new JPanel();
		JLabel search = new JLabel("�˻� : ");
		JButton enrollment = new JButton("��ǰ ���");
		JButton button_6 = new JButton("��ǰ ���");
	
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
		
		JButton lookup = new JButton("��ȸ");
		lookup.setBounds(712, 33, 97, 23);
		panel.add(lookup, JButton.CENTER);
		
		//�˻� ��ȸ ������ ����Ǿ� �ִ� �ش� list ��
		lookup.addActionListener(e->{
			List<String> list = new ArrayList<>();
			count = 0;
			for(int i=0; i < list.size(); i++) {
				if(list.get(i).equals(textField.getText())) {
					count++;
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
		
		JLabel contents = new JLabel("�� ��",JLabel.CENTER);
		contents.setFont(font_1);
		contents.setBounds(31, 30, 143, 30);
		panel_contents.add(contents);
		
		JButton button_1 = new JButton("����");
		button_1.setBounds(31, 102, 143, 45);
		panel_contents.add(button_1);
		
		JButton button_2 = new JButton("����");
		button_2.setBounds(31, 249, 143, 45);
		panel_contents.add(button_2);
		
		JButton button_3 = new JButton("����");
		button_3.setBounds(31, 396, 143, 45);
		panel_contents.add(button_3);
		
		JButton button_4 = new JButton("�Ź�");
		button_4.setBounds(31, 543, 143, 45);
		panel_contents.add(button_4);
		
		JButton button_5 = new JButton("����");
		button_5.setBounds(31, 690, 143, 45);
		panel_contents.add(button_5);
		
		//��ư font
		button_1.setFont(font_2);
		button_2.setFont(font_2);
		button_3.setFont(font_2);
		button_4.setFont(font_2);
		button_5.setFont(font_2);
	}
	
	private void rightdisplay() {
		
		main_Board.setBounds(205, 100, 1059, 727);	//����
		main_Board.setBorder(border);				//����			
		this.getContentPane().add(main_Board);						//����
		main_Board.setLayout(null);					//����
		
		result.setText("�˻� ��� : " + count);
		result.setBounds(290, 0, 367, 37);
		result.setEditable(false);
		main_Board.add(result);						//this
		
		board_Page.setBorder(border);
		board_Page.setBounds(470, 886, 377, 46);
		this.getContentPane().add(board_Page);
		board_Page.setLayout(new GridLayout(1, 5, 0, 0));
		
		a = new JButton("1"); //Integer.toString(++page_end) - ������ ������ �� ����
		b = new JButton("2");
		c = new JButton("3");
		d = new JButton("4");
		e = new JButton("5");
		
		
		
		int w = 2118, h = 1454;
		
		board_Page.add(a);
		a.addActionListener(e_a->{
			int size = 0;						//������ �г� �̵� �ʱⰪ
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
			int next_sum = 5;
			double sum = ((((double)save_page)/25)-(save_page/25));
				if(save_page > 25) {
					if((int) Math.round((save_page/25)+0.5) > 2) {
					for(int z = 1; z <= 5; z++) {			
						page_end++;
						String next = Integer.toString(page_end);
						if(Integer.parseInt(a.getText())+next_sum == page_end) {	
							a.setText(next);
						}if(Integer.parseInt(b.getText())+next_sum == page_end) {
							b.setText(next);
						}if(Integer.parseInt(c.getText())+next_sum == page_end) {
							c.setText(next);
						}if(Integer.parseInt(d.getText())+next_sum == page_end) {
							d.setText(next);
						}if(Integer.parseInt(e.getText())+next_sum == page_end) {
							e.setText(next);
						}
					}
					//���� �������� 5������ ������ ���� ������ ��� (�� : 1������ or 1~2������ or 1~3������ or 1~4������)
				}else if(sum*100/100.0 >= 0.04 && sum*100/100.0 < 0.8) {
						int gut = (int) Math.round(((sum*10)+0.1));
						for(int z = 1; z <= (int) Math.round(gut/2+0.5); z++) {	
							page_end++;
							String next = Integer.toString(page_end);
							switch(z) {
							case 1 : a.setText(next);
							b.setText(""); b.setEnabled(false);
							c.setText(""); c.setEnabled(false);
							d.setText(""); d.setEnabled(false);
							e.setText(""); e.setEnabled(false);
							break;
							case 2 : b.setText(next);
							c.setText(""); c.setEnabled(false);
							d.setText(""); d.setEnabled(false);
							e.setText(""); e.setEnabled(false);
							break;
							case 3 : c.setText(next);
							d.setText(""); d.setEnabled(false);
							e.setText(""); e.setEnabled(false);
							break;
							case 4 : d.setText(next);
							e.setText(""); e.setEnabled(false);
							break;
							}
						}
					}
				}
				else if(25 >= save_page && pageSize > 25){
					System.out.println("�������������߰� && �����Ͱ� 21 ~ 25 ���� �϶�");
					if(sum*100/100.0 >= 0.8 && sum <= 1) {
						for(int z = 1; z <= 5; z++) {			
							page_end++;
							String next = Integer.toString(page_end);
							if(Integer.parseInt(a.getText())+next_sum == page_end) {	
								a.setText(next);
							}if(Integer.parseInt(b.getText())+next_sum == page_end) {
								b.setText(next);
							}if(Integer.parseInt(c.getText())+next_sum == page_end) {
								c.setText(next);
							}if(Integer.parseInt(d.getText())+next_sum == page_end) {
								d.setText(next);
							}if(Integer.parseInt(e.getText())+next_sum == page_end) {
								e.setText(next);
							}
						}
					}
				}
			
			save_page -= 25;
			if(save_page <= 0){
				JOptionPane.showMessageDialog(null, "�� �̻� �������� �����ϴ�.", 
						"��� !", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
}

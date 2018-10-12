package project_main;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	
	//	������Ʈ ��ġ�� ����
	Enrollment enr = new Enrollment();
	
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
//	private int itemList.size();
	private int count_page;
	private int count_max;
	private int count_least=1;
	
	private int end_data;			//������ ������ ��
	private int page_number = 1;	//������ ��ȣ ��
	private int page;				//������ ��
	private int total_page;			//�� ������ ��
	private int start_page;			//���� ������ ��
	private int center_page;		//�߰� ������ ��
	private int end_page;			//������ ������ ��
	
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
	
	private JPanel[] panel_3 = new JPanel[itemList.size()];	//main_Board�� �г� ���� ũ��
//	private JButton[] details_2 = new JButton[itemList.size()];
	
	//ī�װ� ��ư ����
	private JButton button_1 = new JButton("����");
	private JButton button_2 = new JButton("����");
	private JButton button_3 = new JButton("����");
	private JButton button_4 = new JButton("�Ź�");
	private JButton button_5 = new JButton("����");
	
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
	
	//������ ��ư
	private JButton a = null;
	private	JButton b = null;
	private JButton c = null;
	private JButton d = null;
	private JButton e = null;
	
	public Menu(List<Item> itemList, Date server_Time) {
//		Main_Start���� �����Ҷ� �޾ƿ� itemList�� server_Time�� this�� �������ݴϴ�.
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
		con.setLayout(null);
		 	//Ÿ��Ʋ border ����
		
		JPanel panel = new JPanel();
		con.add(panel);//
		JLabel search = new JLabel("�˻� : ");
		JButton enrollment = new JButton("��ǰ ���");
		JButton button_6 = new JButton("��ǰ ���");
	
		panel.setBounds(0, 0, 1264, 101);
		panel.setBorder(border); 
		con.add(panel);
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
//			itemList.size() = 0;
			for(int i=0; i < itemList.size(); i++) {
				if(itemList.get(i).equals(textField.getText())) {
//					itemList.size()++;
				}
			}
			for (Item index : itemList) {
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
		con.add(panel_contents);
		panel_contents.setLayout(null);
		
		JLabel contents = new JLabel("�� ��",JLabel.CENTER);
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
		
		//��ư font
		button_1.setFont(font_2);
		button_2.setFont(font_2);
		button_3.setFont(font_2);
		button_4.setFont(font_2);
		button_5.setFont(font_2);
	}
	
	public void rightdisplay() {
		
		main_Board.setBounds(205, 100, 1059, 727);	
		main_Board.setBorder(border);							
		con.add(main_Board);						
		main_Board.setLayout(null);					
		result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
		result.setBounds(290, 0, 367, 37);
		result.setEditable(false);
		main_Board.add(result);						//this
		
		board_Page.setBorder(border);
		board_Page.setBounds(470, 886, 377, 46);
		con.add(board_Page);
		board_Page.setLayout(new GridLayout(1, 5, 0, 0));
		
		a = new JButton(Integer.toString(page_number)); //Integer.toString(++page_end) - ������ ������ �� ����
		b = new JButton("2");
		c = new JButton("3");
		d = new JButton("4");
		e = new JButton("5");
		
		int start_size = 0;
	      
	      page = (itemList.size()/5);         //������ ��
	      start_page = 0;                  //ù ������ �ʱⰪ
	      center_page = 0;               //�߰� ������ �ʱⰪ
	      end_page = 0;                  //������ ������ �ʱⰪ
	      end_data = itemList.size()%5;      //������ ������ ������ ��

	      //������ ��
	      if(end_data > 0) {               //������ ������ ���� ������ ���� �� ���� �Ǻ�
	         total_page = page + 1;         //������ �� + 1 = �������� ��;
	         start_page = total_page;      //ù ������ ���� ��
	         center_page = total_page/5;     //�߰� ������ ���� ��
	         end_page = total_page%5;      //������ ������ ���� ��
	      }else {
	         total_page = page;
	         start_page = total_page;      
	         center_page = total_page/5;
	         end_page = total_page%5;
	      }
	      //ù ������ �� 5������ ������ ������ ���� 
	      if(start_page <= 0) {
	         JOptionPane.showMessageDialog(null, "�������� �����ϴ�.", 
	               "��� !", JOptionPane.WARNING_MESSAGE);
	         a.setText(null); a.setEnabled(false);
	         b.setText(null); b.setEnabled(false);
	         c.setText(null); c.setEnabled(false);
	         d.setText(null); d.setEnabled(false);
	         e.setText(null); e.setEnabled(false);
	      }else if(start_page <= 5) {
	         //ù ������ �� ���
	         count_page=1;
	         for(int i=1; i<=start_page; i++) {
	            switch(i) {
	            case 1 : page_number=(count_page*start_size)+1;      //1������ - 6������ - 11������ ...
	            a.setText(Integer.toString(page_number));
	            b.setText(null); b.setEnabled(false);
	            c.setText(null); c.setEnabled(false);
	            d.setText(null); d.setEnabled(false);
	            e.setText(null); e.setEnabled(false);
	            break;
	            case 2 : page_number=(count_page*start_size)+2;      //2������ - 7������ - 12������ ...
	            b.setEnabled(true);
	            b.setText(Integer.toString(page_number));
	            c.setText(null); c.setEnabled(false);
	            d.setText(null); d.setEnabled(false);
	            e.setText(null); e.setEnabled(false);
	            break;
	            case 3 : page_number=(count_page*start_size)+3;      //3������ - 8������ - 13������ ...
	            c.setEnabled(true);
	            c.setText(Integer.toString(page_number));
	            d.setText(null); d.setEnabled(false);
	            e.setText(null); e.setEnabled(false);
	            break;
	            case 4 : page_number=(count_page*start_size)+4;      //4������ - 9������ - 14������ ...
	            d.setEnabled(true);
	            d.setText(Integer.toString(page_number));
	            e.setText(null); e.setEnabled(false);
	            break;
	            case 5 : page_number=(count_page*start_size)+5;      //5������ - 10������ - 15������ ...
	            e.setEnabled(true);
	            e.setText(Integer.toString(page_number));
	            break;
	            }
	         }
//	         start_page -= 5;
	      }else{
	         //start_page ���� 6�̻��� ���϶�
	         //���� ������ �׼� �̺�Ʈ
	         count_page=1;
	         page_number=(count_page*start_size)-4;      //1������ - 6������ - 11������ ...
	         a.setText(Integer.toString(page_number));
	         page_number=(count_page*start_size)-3;      //2������ - 7������ - 12������ ...
	         b.setText(Integer.toString(page_number));
	         page_number=(count_page*start_size)-2;      //3������ - 8������ - 13������ ...
	         c.setText(Integer.toString(page_number));
	         page_number=(count_page*start_size)-1;      //4������ - 9������ - 14������ ...
	         d.setText(Integer.toString(page_number));
	         page_number=(count_page*start_size);      //5������ - 10������ - 15������ ...
	         e.setText(Integer.toString(page_number));
	      }
	      
	      int panel_size = 0;               //������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
	      if(1*5-4 <= itemList.size() && 1*5 > itemList.size()){
	         panel_3 = null;                     //������ �гο� ��� �ִ� �� �ʱ�ȭ
	         panel_3 = new JPanel[itemList.size()];   //������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
	         //���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
	         //-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
	         for(int i=1*5-5; i<itemList.size(); i++) {
	            panel_3[i] = new JPanel();      //���ο� �г��� �г� �迭 ���� ��� ����
	            main_Board.removeAll();         //���� �гο� �ִ� �� ����   
	            main_Board.revalidate();      //���� �г� ������      
	            main_Board.repaint();         //���� �г� �� ����
	            main_Board.setLayout(null);
	         }
	         //-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
	         //-> �����̳� �гο� ���� �г� �߰�
	         for(int i=1*5-5; i<itemList.size(); i++) {
	            panel_3[i].setLayout(null);      //������ �г� ��ġ, ũ�� �����̹Ƿ� null
	            panel_3[i].setBorder(border);   //������ �г� �׵θ� ����
	            panel_3[i].setBounds(0, (70+panel_size), 1059, 115);   //��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
	            panel_3[i].setName(Integer.toString(i));
	            result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
	            result.setBounds(290, 0, 367, 37);
	            result.setEditable(false);
	            result.setBorder(border);
	            main_Board.add(result);
	            main_Board.setBounds(205, 100, 2118, 1454);      //���� �г� ��ġ, ũ�� ����
	            panel_size += 130;            //��ġ �̵��ϱ� ���� 130�� ���� �� ����
	            main_Board.add(panel_3[i]);      //�̵��� ������ �г��� ���� �гο� ����      
	            con.add(main_Board);         //�����̳ʿ� ���� �г� ����
	            main_Board.setVisible(false);
	         }
	         //-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
	         for(int i=1*5-5; i<itemList.size(); i++) {
	            //�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
	            //-> ������ �г� �迭�� ���Ӱ� ����
	            //-> a,b,c,d,e ��ư �׼��� ��� ����
	            ImageIcon imic = new ImageIcon();
	            imic = itemList.get(i).getImage();
	            lblNewLabel_1 = new JLabel(imic);
	            lblNewLabel_1.setBounds(0, 0, 341, 115);
	            panel_3[i].add(lblNewLabel_1);

	            lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
	            lblNewLabel_2.setBounds(353, 1, 293, 35);
	            panel_3[i].add(lblNewLabel_2);
	            
	            lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
	            lblNewLabel_3.setBounds(353, 46, 254, 24);
	            panel_3[i].add(lblNewLabel_3);
	            
	            lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
	            lblNewLabel_4.setBounds(353, 83, 254, 24);
	            panel_3[i].add(lblNewLabel_4);
	            
	            lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
	            lblNewLabel_5.setBounds(658, 21, 116, 15);
	            panel_3[i].add(lblNewLabel_5);
	            
	            lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
	            lblNewLabel_6.setBounds(619, 46, 155, 24);
	            panel_3[i].add(lblNewLabel_6);
	            
	            lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
	            lblNewLabel_7.setBounds(619, 83, 155, 24);
	            panel_3[i].add(lblNewLabel_7);
	            
	            lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
	            lblNewLabel_8.setBounds(847, 6, 200, 24);
	            panel_3[i].add(lblNewLabel_8);
	            
	            lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
	            lblNewLabel_9.setBounds(847, 36, 143, 24);
	            panel_3[i].add(lblNewLabel_9);
	            
	            JButton details = new JButton("�� ����");
	            details.setName(Integer.toString(i));
	            details.setBounds(847, 70, 143, 35);
	            panel_3[i].add(details);
	            details.addActionListener(e->{
//	            if (panel_3[taget].getName().equals(String.valueOf(taget))) {
//	               Thedetails det = new Thedetails(getItemList(), taget);
	               if(1*5-5 == Integer.parseInt(details.getName())) {
	                  Thedetails det = new Thedetails(getItemList(), 1*5-5);
	                  det.setVisible(true);
	               }else if(1*5-4 == Integer.parseInt(details.getName())) {
	                  Thedetails det = new Thedetails(getItemList(), 1*5-4);
	                  det.setVisible(true);
	               }else if(1*5-3 == Integer.parseInt(details.getName())) {
	                  Thedetails det = new Thedetails(getItemList(), 1*5-3);
	                  det.setVisible(true);
	               }else if(1*5-2 == Integer.parseInt(details.getName())) {
	                  Thedetails det = new Thedetails(getItemList(), 1*5-2);
	                  det.setVisible(true);
	               }else if(1*5-1 == Integer.parseInt(details.getName())) {
	                  Thedetails det = new Thedetails(getItemList(), 1*5-1);
	                  det.setVisible(true);
	               }
//	               }
	            });
	         }
	      }else{
	         panel_3 = null;   //������ �гο� ��� �ִ� �� �ʱ�ȭ
	         panel_3 = new JPanel[itemList.size()];   //������ �г� ������ ����
	         previous_Page.setVisible(true);
	         next_Page.setVisible(true);
	         for (int i = 1 * 5-5; i <= 1 * 5-1; i++) {
	            panel_3[i] = new JPanel();
	            main_Board.removeAll();
	            main_Board.revalidate();
	            main_Board.repaint();
	            main_Board.setLayout(null);
	         }
	         for (int i = 1 * 5-5; i <= 1 * 5-1; i++) {
	            panel_3[i].setLayout(null);
	            panel_3[i].setBounds(0, (70 + panel_size), 1059, 115);
	            panel_3[i].setName(Integer.toString(i));
	            result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
	            result.setBounds(290, 0, 367, 37);
	            result.setEditable(false);
	            result.setBorder(border);
	            main_Board.add(result);
	            main_Board.setBounds(205, 100, 2118, 1454);
	            panel_3[i].setBorder(border);
	            panel_size += 130;
	            main_Board.add(panel_3[i]);
	            con.add(main_Board);
	            main_Board.setVisible(false);
	         }
	         for(int i=1 * 5-5; i <= 1 * 5-1; i++) {
	            ImageIcon imic = new ImageIcon();
	            imic = itemList.get(i).getImage();
	            lblNewLabel_1 = new JLabel(imic);
	            lblNewLabel_1.setBounds(0, 0, 341, 115);
	            panel_3[i].add(lblNewLabel_1);

	            lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
	            lblNewLabel_2.setBounds(353, 1, 293, 35);
	            panel_3[i].add(lblNewLabel_2);
	            
	            lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
	            lblNewLabel_3.setBounds(353, 46, 254, 24);
	            panel_3[i].add(lblNewLabel_3);
	            
	            lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
	            lblNewLabel_4.setBounds(353, 83, 254, 24);
	            panel_3[i].add(lblNewLabel_4);
	            
	            lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
	            lblNewLabel_5.setBounds(658, 21, 116, 15);
	            panel_3[i].add(lblNewLabel_5);
	            
	            lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
	            lblNewLabel_6.setBounds(619, 46, 155, 24);
	            panel_3[i].add(lblNewLabel_6);
	            
	            lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
	            lblNewLabel_7.setBounds(619, 83, 155, 24);
	            panel_3[i].add(lblNewLabel_7);
	            
	            lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
	            lblNewLabel_8.setBounds(847, 6, 200, 24);
	            panel_3[i].add(lblNewLabel_8);
	            
	            lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
	            lblNewLabel_9.setBounds(847, 36, 143, 24);
	            panel_3[i].add(lblNewLabel_9);
	            
	            JButton details = new JButton("�� ����");
	            details.setName(String.valueOf(i));
	            details.setBounds(847, 70, 143, 35);
	            panel_3[i].add(details);
	            details.addActionListener(e->{
	            if (1 * 5 - 5 == Integer.parseInt(details.getName())) {
	               Thedetails det = new Thedetails(getItemList(), 1 * 5 - 5);
	               det.setVisible(true);
	            } else if (1 * 5 - 4 == Integer.parseInt(details.getName())) {
	               Thedetails det = new Thedetails(getItemList(), 1 * 5 - 4);
	               det.setVisible(true);
	            } else if (1 * 5 - 3 == Integer.parseInt(details.getName())) {
	               Thedetails det = new Thedetails(getItemList(), 1 * 5 - 3);
	               det.setVisible(true);
	            } else if (1 * 5 - 2 == Integer.parseInt(details.getName())) {
	               Thedetails det = new Thedetails(getItemList(), 1 * 5 - 2);
	               det.setVisible(true);
	            } else if (1 * 5 - 1 == Integer.parseInt(details.getName())) {
	               Thedetails det = new Thedetails(getItemList(), 1 * 5 - 1);
	               det.setVisible(true);
	            }
	            });
	         }
	      }
	      main_Board.setVisible(true);
		
		board_Page.add(a);
		a.addActionListener(e_a->{
				int size = 0;					//������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
				if(itemList.size() <= 0) {		
					JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�.", "��� !", JOptionPane.WARNING_MESSAGE);
				}	
				//������ ����Ʈ ���� 5������ ���� ���� �� ���
				else if(Integer.parseInt(a.getText())*5-4 <= itemList.size() && Integer.parseInt(a.getText())*5 > itemList.size()){
					panel_3 = null;							//������ �гο� ��� �ִ� �� �ʱ�ȭ
					panel_3 = new JPanel[itemList.size()];	//������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
					//���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
					//-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
					for(int i=Integer.parseInt(a.getText())*5-5; i<itemList.size(); i++) {
						panel_3[i] = new JPanel();		//���ο� �г��� �г� �迭 ���� ��� ����
						main_Board.removeAll();			//���� �гο� �ִ� �� ����	
						main_Board.revalidate();		//���� �г� ������		
						main_Board.repaint();			//���� �г� �� ����
						main_Board.setLayout(null);
					}
					//-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
					//-> �����̳� �гο� ���� �г� �߰�
					for(int i=Integer.parseInt(a.getText())*5-5; i<itemList.size(); i++) {
						panel_3[i].setLayout(null);		//������ �г� ��ġ, ũ�� �����̹Ƿ� null
						panel_3[i].setBorder(border);	//������ �г� �׵θ� ����
						panel_3[i].setBounds(0, (70+size), 1059, 115);	//��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
						panel_3[i].setName(Integer.toString(i));
						result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
						result.setBounds(290, 0, 367, 37);
						result.setEditable(false);
						result.setBorder(border);
						main_Board.add(result);
						main_Board.setBounds(205, 100, 2118, 1454);		//���� �г� ��ġ, ũ�� ����
						size += 130;					//��ġ �̵��ϱ� ���� 130�� ���� �� ����
						main_Board.add(panel_3[i]);		//�̵��� ������ �г��� ���� �гο� ����		
						con.add(main_Board);			//�����̳ʿ� ���� �г� ����
						main_Board.setVisible(false);
					}
					//-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
					for(int i=Integer.parseInt(a.getText())*5-5; i<itemList.size(); i++) {
						//�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
						//-> ������ �г� �迭�� ���Ӱ� ����
						//-> a,b,c,d,e ��ư �׼��� ��� ����
						ImageIcon imic = new ImageIcon();
						imic = itemList.get(i).getImage();
						lblNewLabel_1 = new JLabel(imic);
						lblNewLabel_1.setBounds(0, 0, 341, 115);
						panel_3[i].add(lblNewLabel_1);

						lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
						lblNewLabel_2.setBounds(353, 1, 293, 35);
						panel_3[i].add(lblNewLabel_2);
						
						lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
						lblNewLabel_3.setBounds(353, 46, 254, 24);
						panel_3[i].add(lblNewLabel_3);
						
						lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
						lblNewLabel_4.setBounds(353, 83, 254, 24);
						panel_3[i].add(lblNewLabel_4);
						
						lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
						lblNewLabel_5.setBounds(658, 21, 116, 15);
						panel_3[i].add(lblNewLabel_5);
						
						lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
						lblNewLabel_6.setBounds(619, 46, 155, 24);
						panel_3[i].add(lblNewLabel_6);
						
						lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
						lblNewLabel_7.setBounds(619, 83, 155, 24);
						panel_3[i].add(lblNewLabel_7);
						
						lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
						lblNewLabel_8.setBounds(847, 6, 200, 24);
						panel_3[i].add(lblNewLabel_8);
						
						lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
						lblNewLabel_9.setBounds(847, 36, 143, 24);
						panel_3[i].add(lblNewLabel_9);
						
						JButton details = new JButton("�� ����");
						details.setName(Integer.toString(i));
						details.setBounds(847, 70, 143, 35);
						panel_3[i].add(details);
						details.addActionListener(e->{
//						if (panel_3[taget].getName().equals(String.valueOf(taget))) {
//							Thedetails det = new Thedetails(getItemList(), taget);
							if(Integer.parseInt(a.getText())*5-5 == Integer.parseInt(details.getName())) {
								Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText())*5-5);
								det.setVisible(true);
							}else if(Integer.parseInt(a.getText())*5-4 == Integer.parseInt(details.getName())) {
								Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText())*5-4);
								det.setVisible(true);
							}else if(Integer.parseInt(a.getText())*5-3 == Integer.parseInt(details.getName())) {
								Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText())*5-3);
								det.setVisible(true);
							}else if(Integer.parseInt(a.getText())*5-2 == Integer.parseInt(details.getName())) {
								Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText())*5-2);
								det.setVisible(true);
							}else if(Integer.parseInt(a.getText())*5-1 == Integer.parseInt(details.getName())) {
								Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText())*5-1);
								det.setVisible(true);
							}
//							}
						});
					}
				}else{
					panel_3 = null;	//������ �гο� ��� �ִ� �� �ʱ�ȭ
					panel_3 = new JPanel[itemList.size()];	//������ �г� ������ ����
					for (int i = Integer.parseInt(a.getText()) * 5-5; i <= Integer.parseInt(a.getText()) * 5-1; i++) {
						panel_3[i] = new JPanel();
						main_Board.removeAll();
						main_Board.revalidate();
						main_Board.repaint();
						main_Board.setLayout(null);
					}
					for (int i = Integer.parseInt(a.getText()) * 5-5; i <= Integer.parseInt(a.getText()) * 5-1; i++) {
						panel_3[i].setLayout(null);
						panel_3[i].setBounds(0, (70 + size), 1059, 115);
						panel_3[i].setName(Integer.toString(i));
						result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
						result.setBounds(290, 0, 367, 37);
						result.setEditable(false);
						result.setBorder(border);
						main_Board.add(result);
						main_Board.setBounds(205, 100, 2118, 1454);
						panel_3[i].setBorder(border);
						size += 130;
						main_Board.add(panel_3[i]);
						con.add(main_Board);
						main_Board.setVisible(false);
					}
					for(int i=Integer.parseInt(a.getText()) * 5-5; i <= Integer.parseInt(a.getText()) * 5-1; i++) {
						ImageIcon imic = new ImageIcon();
						imic = itemList.get(i).getImage();
						lblNewLabel_1 = new JLabel(imic);
						lblNewLabel_1.setBounds(0, 0, 341, 115);
						panel_3[i].add(lblNewLabel_1);

						lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
						lblNewLabel_2.setBounds(353, 1, 293, 35);
						panel_3[i].add(lblNewLabel_2);
						
						lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
						lblNewLabel_3.setBounds(353, 46, 254, 24);
						panel_3[i].add(lblNewLabel_3);
						
						lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
						lblNewLabel_4.setBounds(353, 83, 254, 24);
						panel_3[i].add(lblNewLabel_4);
						
						lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
						lblNewLabel_5.setBounds(658, 21, 116, 15);
						panel_3[i].add(lblNewLabel_5);
						
						lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
						lblNewLabel_6.setBounds(619, 46, 155, 24);
						panel_3[i].add(lblNewLabel_6);
						
						lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
						lblNewLabel_7.setBounds(619, 83, 155, 24);
						panel_3[i].add(lblNewLabel_7);
						
						lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
						lblNewLabel_8.setBounds(847, 6, 200, 24);
						panel_3[i].add(lblNewLabel_8);
						
						lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
						lblNewLabel_9.setBounds(847, 36, 143, 24);
						panel_3[i].add(lblNewLabel_9);
						
						JButton details = new JButton("�� ����");
						details.setName(String.valueOf(i));
						details.setBounds(847, 70, 143, 35);
						panel_3[i].add(details);
						details.addActionListener(e->{
						if (Integer.parseInt(a.getText()) * 5 - 5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText()) * 5 - 5);
							det.setVisible(true);
						} else if (Integer.parseInt(a.getText()) * 5 - 4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText()) * 5 - 4);
							det.setVisible(true);
						} else if (Integer.parseInt(a.getText()) * 5 - 3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText()) * 5 - 3);
							det.setVisible(true);
						} else if (Integer.parseInt(a.getText()) * 5 - 2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText()) * 5 - 2);
							det.setVisible(true);
						} else if (Integer.parseInt(a.getText()) * 5 - 1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(a.getText()) * 5 - 1);
							det.setVisible(true);
						}
						});
					}
				}
				main_Board.setVisible(true);
		});
		
		board_Page.add(b);
		b.addActionListener(e_b->{
			int size = 0;					//������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
			if(Integer.parseInt(b.getText())*5-4 <= itemList.size() && Integer.parseInt(b.getText())*5 > itemList.size()){
				panel_3 = null;							//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
				//���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
				//-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
				for(int i=Integer.parseInt(b.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i] = new JPanel();		//���ο� �г��� �г� �迭 ���� ��� ����
					main_Board.removeAll();			//���� �гο� �ִ� �� ����	
					main_Board.revalidate();		//���� �г� ������		
					main_Board.repaint();			//���� �г� �� ����
					main_Board.setLayout(null);
				}
				//-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
				//-> �����̳� �гο� ���� �г� �߰�
				for(int i=Integer.parseInt(b.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i].setLayout(null);		//������ �г� ��ġ, ũ�� �����̹Ƿ� null
					panel_3[i].setBorder(border);	//������ �г� �׵θ� ����
					panel_3[i].setBounds(0, (70+size), 1059, 115);	//��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);		//���� �г� ��ġ, ũ�� ����
					size += 130;					//��ġ �̵��ϱ� ���� 130�� ���� �� ����
					main_Board.add(panel_3[i]);		//�̵��� ������ �г��� ���� �гο� ����		
					con.add(main_Board);			//�����̳ʿ� ���� �г� ����
					main_Board.setVisible(false);
				}
				//-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
				for(int i=Integer.parseInt(b.getText())*5-5; i<itemList.size(); i++) {
					//�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
					//-> ������ �г� �迭�� ���Ӱ� ����
					//-> a,b,c,d,e ��ư �׼��� ��� ����
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(b.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}else{
				panel_3 = null;	//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� ������ ����
				for (int i = Integer.parseInt(b.getText()) * 5-5; i <= Integer.parseInt(b.getText()) * 5-1; i++) {
					panel_3[i] = new JPanel();
					main_Board.removeAll();
					main_Board.revalidate();
					main_Board.repaint();
					main_Board.setLayout(null);
				}
				for (int i = Integer.parseInt(b.getText()) * 5-5; i <= Integer.parseInt(b.getText()) * 5-1; i++) {
					panel_3[i].setLayout(null);
					panel_3[i].setBorder(border);
					panel_3[i].setBounds(0, (70 + size), 1059, 115);
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);
					size += 130;
					main_Board.add(panel_3[i]);
					con.add(main_Board);
					main_Board.setVisible(false);
				}
				for(int i=Integer.parseInt(b.getText()) * 5-5; i <= Integer.parseInt(b.getText()) * 5-1; i++) {
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(b.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(b.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(b.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}
			main_Board.setVisible(true);
		});
		
		board_Page.add(c);
		c.addActionListener(e_c->{
			int size = 0;					//������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
			if(Integer.parseInt(c.getText())*5-4 <= itemList.size() && Integer.parseInt(c.getText())*5 > itemList.size()){
				panel_3 = null;							//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
				//���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
				//-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
				for(int i=Integer.parseInt(c.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i] = new JPanel();		//���ο� �г��� �г� �迭 ���� ��� ����
					main_Board.removeAll();			//���� �гο� �ִ� �� ����	
					main_Board.revalidate();		//���� �г� ������		
					main_Board.repaint();			//���� �г� �� ����
					main_Board.setLayout(null);
				}
				//-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
				//-> �����̳� �гο� ���� �г� �߰�
				for(int i=Integer.parseInt(c.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i].setLayout(null);		//������ �г� ��ġ, ũ�� �����̹Ƿ� null
					panel_3[i].setBorder(border);	//������ �г� �׵θ� ����
					panel_3[i].setBounds(0, (70+size), 1059, 115);	//��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);		//���� �г� ��ġ, ũ�� ����
					size += 130;					//��ġ �̵��ϱ� ���� 130�� ���� �� ����
					main_Board.add(panel_3[i]);		//�̵��� ������ �г��� ���� �гο� ����		
					con.add(main_Board);			//�����̳ʿ� ���� �г� ����
					main_Board.setVisible(false);
				}
				//-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
				for(int i=Integer.parseInt(c.getText())*5-5; i<itemList.size(); i++) {
					//�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
					//-> ������ �г� �迭�� ���Ӱ� ����
					//-> a,b,c,d,e ��ư �׼��� ��� ����
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(c.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}else{
				panel_3 = null;	//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� ������ ����
				for (int i = Integer.parseInt(c.getText()) * 5-5; i <= Integer.parseInt(c.getText()) * 5-1; i++) {
					panel_3[i] = new JPanel();
					main_Board.removeAll();
					main_Board.revalidate();
					main_Board.repaint();
					main_Board.setLayout(null);
				}
				for (int i = Integer.parseInt(c.getText()) * 5-5; i <= Integer.parseInt(c.getText()) * 5-1; i++) {
					panel_3[i].setLayout(null);
					panel_3[i].setBorder(border);
					panel_3[i].setBounds(0, (70 + size), 1059, 115);
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);
					size += 130;
					main_Board.add(panel_3[i]);
					con.add(main_Board);
					main_Board.setVisible(false);
				}
				for(int i=Integer.parseInt(c.getText()) * 5-5; i <= Integer.parseInt(c.getText()) * 5-1; i++) {
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(c.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(c.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(c.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}
			main_Board.setVisible(true);
		});
		
		board_Page.add(d);
		d.addActionListener(e_d->{
			int size = 0;					//������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
			if(Integer.parseInt(d.getText())*5-4 <= itemList.size() && Integer.parseInt(d.getText())*5 > itemList.size()){
				panel_3 = null;							//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
				//���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
				//-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
				for(int i=Integer.parseInt(d.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i] = new JPanel();		//���ο� �г��� �г� �迭 ���� ��� ����
					main_Board.removeAll();			//���� �гο� �ִ� �� ����	
					main_Board.revalidate();		//���� �г� ������		
					main_Board.repaint();			//���� �г� �� ����
					main_Board.setLayout(null);
				}
				//-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
				//-> �����̳� �гο� ���� �г� �߰�
				for(int i=Integer.parseInt(d.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i].setLayout(null);		//������ �г� ��ġ, ũ�� �����̹Ƿ� null
					panel_3[i].setBorder(border);	//������ �г� �׵θ� ����
					panel_3[i].setBounds(0, (70+size), 1059, 115);	//��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);		//���� �г� ��ġ, ũ�� ����
					size += 130;					//��ġ �̵��ϱ� ���� 130�� ���� �� ����
					main_Board.add(panel_3[i]);		//�̵��� ������ �г��� ���� �гο� ����		
					con.add(main_Board);			//�����̳ʿ� ���� �г� ����
					main_Board.setVisible(false);
				}
				//-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
				for(int i=Integer.parseInt(d.getText())*5-5; i<itemList.size(); i++) {
					//�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
					//-> ������ �г� �迭�� ���Ӱ� ����
					//-> a,b,c,d,e ��ư �׼��� ��� ����
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(d.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}else{
				panel_3 = null;	//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� ������ ����
				for (int i = Integer.parseInt(d.getText()) * 5-5; i <= Integer.parseInt(d.getText()) * 5-1; i++) {
					panel_3[i] = new JPanel();
					main_Board.removeAll();
					main_Board.revalidate();
					main_Board.repaint();
					main_Board.setLayout(null);
				}
				for (int i = Integer.parseInt(d.getText()) * 5-5; i <= Integer.parseInt(d.getText()) * 5-1; i++) {
					panel_3[i].setLayout(null);
					panel_3[i].setBorder(border);
					panel_3[i].setBounds(0, (70 + size), 1059, 115);
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);
					size += 130;
					main_Board.add(panel_3[i]);
					con.add(main_Board);
					main_Board.setVisible(false);
				}
				for(int i=Integer.parseInt(d.getText()) * 5-5; i <= Integer.parseInt(d.getText()) * 5-1; i++) {
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(e->{
						if(Integer.parseInt(d.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(d.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(d.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}
			main_Board.setVisible(true);
		});
		
		board_Page.add(e);
		e.addActionListener(e_e->{
			int size = 0;					//������ �г�(����Ʈ�� ��ǰ ��ϵǾ� �ִ� ��ǰ �г�)�̵� �� �ʱ�ȭ
			if(Integer.parseInt(e.getText())*5-4 <= itemList.size() && Integer.parseInt(e.getText())*5 > itemList.size()){
				panel_3 = null;							//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� 5 ������ ����(������ 5�� ���� �ؾ��ϹǷ�)
				//���� a��ư ���� �����Ͽ� ���� �� �����ͷ��� 5���� �̹Ƿ� ����Ʈ ũ�� ��ŭ �ݺ���
				//-> ���ο� �г� �迭 ����, ������ ���� �г� �ʱ�ȭ
				for(int i=Integer.parseInt(e.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i] = new JPanel();		//���ο� �г��� �г� �迭 ���� ��� ����
					main_Board.removeAll();			//���� �гο� �ִ� �� ����	
					main_Board.revalidate();		//���� �г� ������		
					main_Board.repaint();			//���� �г� �� ����
					main_Board.setLayout(null);
				}
				//-> ������ �г� �� �ʱ�ȭ, ������ �г� �׵θ� ����, ������ �г� �̵� ��, ���� �гο� ������ �г� �߰�
				//-> �����̳� �гο� ���� �г� �߰�
				for(int i=Integer.parseInt(e.getText())*5-5; i<itemList.size(); i++) {
					panel_3[i].setLayout(null);		//������ �г� ��ġ, ũ�� �����̹Ƿ� null
					panel_3[i].setBorder(border);	//������ �г� �׵θ� ����
					panel_3[i].setBounds(0, (70+size), 1059, 115);	//��ġ, ũ�� ����(���⼭ size�� 1���� ���� �Ʒ��� ��� ���� ��)
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);		//���� �г� ��ġ, ũ�� ����
					size += 130;					//��ġ �̵��ϱ� ���� 130�� ���� �� ����
					main_Board.add(panel_3[i]);		//�̵��� ������ �г��� ���� �гο� ����		
					con.add(main_Board);			//�����̳ʿ� ���� �г� ����
					main_Board.setVisible(false);
				}
				//-> ������ ����Ʈ ���� �ִ� �����͵��� �ϳ��� ������ �гξȿ� �߰�
				for(int i=Integer.parseInt(e.getText())*5-5; i<itemList.size(); i++) {
					//�̹���, ���� ��, ������ ���� ��, ���� �ִ� ������ �� ���... 
					//-> ������ �г� �迭�� ���Ӱ� ����
					//-> a,b,c,d,e ��ư �׼��� ��� ����
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(el->{
						if(Integer.parseInt(e.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}else{
				panel_3 = null;	//������ �гο� ��� �ִ� �� �ʱ�ȭ
				panel_3 = new JPanel[itemList.size()];	//������ �г� ������ ����
				for (int i = Integer.parseInt(e.getText()) * 5-5; i <= Integer.parseInt(e.getText()) * 5-1; i++) {
					panel_3[i] = new JPanel();
					main_Board.removeAll();
					main_Board.revalidate();
					main_Board.repaint();
					main_Board.setLayout(null);
				}
				for (int i = Integer.parseInt(e.getText()) * 5-5; i <= Integer.parseInt(e.getText()) * 5-1; i++) {
					panel_3[i].setLayout(null);
					panel_3[i].setBorder(border);
					panel_3[i].setBounds(0, (70 + size), 1059, 115);
					panel_3[i].setName(Integer.toString(i));
					result.setText("�˻� ��� : " + itemList.size()+"���� Ȯ�� �Ǿ����ϴ�.");
					result.setBounds(290, 0, 367, 37);
					result.setEditable(false);
					result.setBorder(border);
					main_Board.add(result);
					main_Board.setBounds(205, 100, 2118, 1454);
					size += 130;
					main_Board.add(panel_3[i]);
					con.add(main_Board);
					main_Board.setVisible(false);
				}
				for(int i=Integer.parseInt(e.getText()) * 5-5; i <= Integer.parseInt(e.getText()) * 5-1; i++) {
					ImageIcon imic = new ImageIcon();
					imic = itemList.get(i).getImage();
					lblNewLabel_1 = new JLabel(imic);
					lblNewLabel_1.setBounds(0, 0, 341, 115);
					panel_3[i].add(lblNewLabel_1);

					lblNewLabel_2 = new JLabel("���� : " + itemList.get(i).getTitle());
					lblNewLabel_2.setBounds(353, 1, 293, 35);
					panel_3[i].add(lblNewLabel_2);
					
					lblNewLabel_3 = new JLabel("������ ���� : " + itemList.get(i).getPrice());
					lblNewLabel_3.setBounds(353, 46, 254, 24);
					panel_3[i].add(lblNewLabel_3);
					
					lblNewLabel_4 = new JLabel("���� �ִ� ������ : ");
					lblNewLabel_4.setBounds(353, 83, 254, 24);
					panel_3[i].add(lblNewLabel_4);
					
					lblNewLabel_5 = new JLabel("ī�װ� : " + itemList.get(i).getCategory());
					lblNewLabel_5.setBounds(658, 21, 116, 15);
					panel_3[i].add(lblNewLabel_5);
					
					lblNewLabel_6 = new JLabel("������ : " + itemList.get(i).getStartDate());
					lblNewLabel_6.setBounds(619, 46, 155, 24);
					panel_3[i].add(lblNewLabel_6);
					
					lblNewLabel_7 = new JLabel("������ : " + itemList.get(i).getFinishDate());
					lblNewLabel_7.setBounds(619, 83, 155, 24);
					panel_3[i].add(lblNewLabel_7);
					
					lblNewLabel_8 = new JLabel("ID : " + itemList.get(i).getId());
					lblNewLabel_8.setBounds(847, 6, 200, 24);
					panel_3[i].add(lblNewLabel_8);
					
					lblNewLabel_9 = new JLabel("���� Ƚ�� : ");
					lblNewLabel_9.setBounds(847, 36, 143, 24);
					panel_3[i].add(lblNewLabel_9);
					
					JButton details = new JButton("�� ����");
					details.setName(String.valueOf(i));
					details.setBounds(847, 70, 143, 35);
					panel_3[i].add(details);
					details.addActionListener(el->{
						if(Integer.parseInt(e.getText())*5-5 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-5);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-4 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-4);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-3 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-3);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-2 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-2);
							det.setVisible(true);
						}else if(Integer.parseInt(e.getText())*5-1 == Integer.parseInt(details.getName())) {
							Thedetails det = new Thedetails(getItemList(), Integer.parseInt(e.getText())*5-1);
							det.setVisible(true);
						}
					});
				}
			}
			main_Board.setVisible(true);
		});
		
		
		
		// ���������� ��ư
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
					page_number = (count_page * number) - 4; // 1������ - 6������ - 11������ ...
					a.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 3; // 2������ - 7������ - 12������ ...
					b.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 2; // 3������ - 8������ - 13������ ...
					c.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 1; // 4������ - 9������ - 14������ ...
					d.setText(Integer.toString(page_number));
					page_number = (count_page * number); // 5������ - 10������ - 15������ ...
					e.setText(Integer.toString(page_number));
				}else if(count_page < count_least) {
					JOptionPane.showMessageDialog(null, "�� �̻� �������� �����ϴ�.", "��� !", JOptionPane.WARNING_MESSAGE);
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
				// �߰� ������ �� ���ϱ�
				if (count_page < count_max || (end_page == 0 && count_page == count_max)) { // center
					page_number = (count_page * number) - 4; // 1������ - 6������ - 11������ ...
					a.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 3; // 2������ - 7������ - 12������ ...
					b.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 2; // 3������ - 8������ - 13������ ...
					c.setText(Integer.toString(page_number));
					page_number = (count_page * number) - 1; // 4������ - 9������ - 14������ ...
					d.setText(Integer.toString(page_number));
					page_number = (count_page * number); // 5������ - 10������ - 15������ ...
					e.setText(Integer.toString(page_number));

				} else if (count_page > count_max) { //�ƽø� ī���ͺ��� ī���Ͱ� ������ ��� �޼��� + ������ ī��Ʈ -1 ����
					JOptionPane.showMessageDialog(null, "�� �̻� �������� �����ϴ�.", "��� !", JOptionPane.WARNING_MESSAGE);
					count_page--;
				}
				if (count_page == count_max) { // ī��Ʈ �ִ� ��
					for (int i = 0; i < end_page; i++) { // ������ ������ �� ��� (������ ������ ��ȣ ��ư ����)
						switch (i) {
						case 0:
							page_number = (count_page * number) - 4; // 1������ - 6������ - 11������ ...
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
							page_number = (count_page * number) - 3; // 2������ - 7������ - 12������ ...
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
							page_number = (count_page * number) - 2; // 3������ - 8������ - 13������ ...
							c.setEnabled(true);
							c.setText(Integer.toString(page_number));
							d.setText(null);
							d.setEnabled(false);
							e.setText(null);
							e.setEnabled(false);
							break;
						case 3:
							page_number = (count_page * number) - 1; // 4������ - 9������ - 14������ ...
							d.setEnabled(true);
							d.setText(Integer.toString(page_number));
							e.setText(null);
							e.setEnabled(false);
							break;
						case 4:
							page_number = (count_page * number); // 5������ - 10������ - 15������ ...
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
		int number = 5;						//������ ��� ���� ��
		
		if (event.getSource() == button_1 || event.getSource() == button_2 || event.getSource() == button_3
				|| event.getSource() == button_4 || event.getSource() == button_5) {
			a.setText(null); a.setEnabled(true);
			b.setText(null); b.setEnabled(true);
			c.setText(null); c.setEnabled(true);
			d.setText(null); d.setEnabled(true);
			e.setText(null); e.setEnabled(true);
			
			//���� ������ �� = 26
			page = (itemList.size()/5);			//������ ��
			start_page = 0;						//ù ������ �ʱⰪ
			center_page = 0;					//�߰� ������ �ʱⰪ
			end_page = 0;						//������ ������ �ʱⰪ
			end_data = itemList.size()%5;		//������ ������ ������ ��

			//������ ��
			if(end_data > 0) {					//������ ������ ���� ������ ���� �� ���� �Ǻ�
				total_page = page + 1;			//������ �� + 1 = �������� ��;
				start_page = total_page;		//ù ������ ���� ��
				center_page = total_page/5;     //�߰� ������ ���� ��
				end_page = total_page%5;		//������ ������ ���� ��
			}else {
				total_page = page;
				start_page = total_page;		
				center_page = total_page/5;
				end_page = total_page%5;
			}
			//ù ������ �� 5������ ������ ������ ���� 
			if(start_page <= 0) {
				JOptionPane.showMessageDialog(null, "�������� �����ϴ�.", 
						"��� !", JOptionPane.WARNING_MESSAGE);
				a.setText(null); a.setEnabled(false);
				b.setText(null); b.setEnabled(false);
				c.setText(null); c.setEnabled(false);
				d.setText(null); d.setEnabled(false);
				e.setText(null); e.setEnabled(false);
			}else if(start_page <= 5) {
				//ù ������ �� ���
				count_page=1;
				for(int i=1; i<=start_page; i++) {
					switch(i) {
					case 1 : page_number=(count_page*number)-4;		//1������ - 6������ - 11������ ...
					a.setText(Integer.toString(page_number));
					b.setText(null); b.setEnabled(false);
					c.setText(null); c.setEnabled(false);
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 2 : page_number=(count_page*number)-3;		//2������ - 7������ - 12������ ...
					b.setEnabled(true);
					b.setText(Integer.toString(page_number));
					c.setText(null); c.setEnabled(false);
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 3 : page_number=(count_page*number)-2;		//3������ - 8������ - 13������ ...
					c.setEnabled(true);
					c.setText(Integer.toString(page_number));
					d.setText(null); d.setEnabled(false);
					e.setText(null); e.setEnabled(false);
					break;
					case 4 : page_number=(count_page*number)-1;		//4������ - 9������ - 14������ ...
					d.setEnabled(true);
					d.setText(Integer.toString(page_number));
					e.setText(null); e.setEnabled(false);
					break;
					case 5 : page_number=(count_page*number);		//5������ - 10������ - 15������ ...
					e.setEnabled(true);
					e.setText(Integer.toString(page_number));
					break;
					}
				}
//				start_page -= 5;
			}else{
				//start_page ���� 6�̻��� ���϶�
				//���� ������ �׼� �̺�Ʈ
				count_page=1;
				page_number=(count_page*number)-4;		//1������ - 6������ - 11������ ...
				a.setText(Integer.toString(page_number));
				page_number=(count_page*number)-3;		//2������ - 7������ - 12������ ...
				b.setText(Integer.toString(page_number));
				page_number=(count_page*number)-2;		//3������ - 8������ - 13������ ...
				c.setText(Integer.toString(page_number));
				page_number=(count_page*number)-1;		//4������ - 9������ - 14������ ...
				d.setText(Integer.toString(page_number));
				page_number=(count_page*number);		//5������ - 10������ - 15������ ...
				e.setText(Integer.toString(page_number));
			}
		}
	}
}

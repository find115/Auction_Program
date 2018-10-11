package project_main;


import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import network.Client_Function;
import network.Item;

public class Enrollment extends JDialog{
	
	private Container con = this.getContentPane();
	private List<Item> itemList = new ArrayList<>();
	private Date server_Time = new Date();
	Client_Function function = new Client_Function();
	
	private String path = "";
	
	private JTextField textField = new JTextField();
	private JTextArea textField_1 = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textField_1);
	private JTextField textField_2 = new JTextField();
	private JTextField textField_3 = new JTextField("ex)2018-12-31 23:59");
	
	private JPanel panel = new JPanel();
	private JLabel image = new JLabel();
	private JLabel title = new JLabel("���� : ");
	private JLabel explanation = new JLabel("���� : ");
	private JLabel price = new JLabel("���� : ");
	private JLabel day = new JLabel("�Ⱓ : ");
	private JLabel category = new JLabel("��� : ");
	private JLabel money = new JLabel(" ��");
	
	private Date startDate = new Date();
	private Date finshDate = new Date();
	
	private String menu[] = {"�� ��", "�� ��", "�� ��", "�� ��", "�� ��"};
	private JComboBox comboBox = new JComboBox(menu);
	private String combo;
	
	private JButton open = new JButton("�̹��� ���");
	private FileDialog file = new FileDialog(this, "������ ������ �����ϼ���", FileDialog.LOAD);
	
	private JButton product = new JButton("��ǰ ���");
	
	private int price_int = 0;
	
	private Font font = new Font("���� ���", Font.BOLD, 20);
	
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
	
	public Enrollment() {
		this.itemList = itemList;
		this.server_Time = server_Time;
		this.enrollment_Event();
		this.setTitle("��ǰ ���");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		con.setLayout(null);
		
		// �̹���
		panel.setBounds(0, 0, 417, 562);
		con.add(panel);
		panel.setLayout(null);

		// ����
		title.setBounds(429, 16, 57, 15);
		con.add(title);
		textField.setBounds(471, 10, 301, 28);
		con.add(textField);
		textField.setColumns(10);

		// ����
		explanation.setBounds(429, 51, 57, 15);
		con.add(explanation);
		textField_1.setLineWrap(true);
		scroll.setBounds(471, 48, 301, 338);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		con.add(scroll);

		// �Ⱓ
		day.setBounds(429, 415, 57, 15);
		con.add(day);
		textField_3.setBounds(471, 412, 132, 21);
		con.add(textField_3);
		textField_3.setColumns(10);
		
		//��¥ Ȯ�� 
		textField_3.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(textField_3.getText() == null || textField_3.getText() == "") {
					textField_3.setText("ex)2018-12-31 23:59");
				}else {
					textField_3.getText();
				}
			}
		});

		// ����
		price.setBounds(429, 456, 57, 15);
		con.add(price);
		textField_2.setBounds(471, 453, 191, 21);
		con.add(textField_2);
		textField_2.setColumns(10);
		money.setBounds(662, 456, 57, 15);
		con.add(money);
		
		// ���
		category.setBounds(605, 415, 57, 15);
		con.add(category);
		comboBox.setBounds(651, 408, 121, 28);
		con.add(comboBox);
		comboBox.addActionListener(e->{
			combo = comboBox.getSelectedItem().toString();
			System.out.println(combo);
		});
	}
	public class ComboItem{
		private String name;
		
		public ComboItem(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public String toString() {
			return name;
		}
	}
	
	private void enrollment_Event() {

		//��ǰ ��� ��ư
		product.setBounds(614, 484, 158, 68);
		getContentPane().add(product);
		product.setFont(font);
		
		//��ǰ ��ư �̺�Ʈ
		product.addActionListener(e->{
			int choice = JOptionPane.showConfirmDialog(this, "��ǰ ��� �Ͻðڽ��ϱ� ?", "Ȯ��", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			Runnable run_e = new Runnable() {
				@Override
				public void run() {
					if(choice == 0) {
						try {
							//String �� -> Date ���·� ��ȯ
							SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm");
							finshDate = format.parse(textField_3.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						//���� port, socket, inet ����
						InetAddress inet = null;
						try {
							inet = InetAddress.getByName("");
						} catch (UnknownHostException e2) {
							e2.printStackTrace();
						}
						int port = 50000;
						Socket socket = null;
						socket = function.socket_Creation(inet, port);
						price_int = Integer.parseInt(textField_2.getText());
						ImageIcon image = new ImageIcon(path);
						Item send = new Item("��ɲ��", textField.getText(), textField_1.getText(), combo, startDate, finshDate, price_int, image);
						boolean result = function.product_Registration(socket, send);
						JOptionPane.showMessageDialog(Enrollment.this, "��ǰ ��� �Ǿ����ϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			};
			Thread t = new Thread(run_e);
			t.setDaemon(true);
			t.start();
		});
		//�̹��� ��� ��ư
		open.setBounds(429, 484, 158, 68);
		getContentPane().add(open);
		open.setFont(font);
		
		//�̹��� ��ư �̺�Ʈ
		open.addActionListener(e->{
			String str = e.getActionCommand();
			if(str.equals("�̹��� ���")) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					path = chooser.getSelectedFile().getPath();	//�̹��� ��� + �̸�
				}
				image = new JLabel(new ImageIcon(path));
				image.setBounds(12, 10, 393, 542);
				panel.add(image);
			}
		});
	}
}

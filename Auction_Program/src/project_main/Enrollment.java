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
	private JLabel title = new JLabel("���� : ");
	private JLabel explanation = new JLabel("���� : ");
	private JLabel price = new JLabel("���� : ");
	private JLabel day = new JLabel("�Ⱓ : ");
	private JLabel category = new JLabel("��� : ");
	private JLabel money = new JLabel(" ��");
	
	private String menu[] = {"�� ��", "�� ��", "�� ��", "�� ��", "�� ��"};
	private JComboBox comboBox = new JComboBox(menu);
	
	private JButton open = new JButton("�̹��� ���");
	private FileDialog file = new FileDialog(this, "������ ������ �����ϼ���", FileDialog.LOAD);
	
	private JButton product = new JButton("��ǰ ���");
	
	private Font font = new Font("���� ���", Font.BOLD, 20);
	
	public Enrollment() {
		enrollment_Event();
		setTitle("��ǰ ���");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		// �̹���
		panel.setBounds(0, 0, 417, 562);
		getContentPane().add(panel);
		panel.setLayout(null);

		// ����
		title.setBounds(429, 16, 57, 15);
		getContentPane().add(title);
		textField.setBounds(471, 10, 301, 28);
		getContentPane().add(textField);
		textField.setColumns(10);

		// ����
		explanation.setBounds(429, 51, 57, 15);
		getContentPane().add(explanation);
		textField_1.setLineWrap(true);
		scroll.setBounds(471, 48, 301, 338);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scroll);

		// �Ⱓ
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
					//text field �� ����
				}
			}
		});

		// ����
		price.setBounds(429, 456, 57, 15);
		getContentPane().add(price);
		textField_2.setBounds(471, 453, 191, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		money.setBounds(662, 456, 57, 15);
		getContentPane().add(money);

		// ���
		category.setBounds(605, 415, 57, 15);
		getContentPane().add(category);
		comboBox.setBounds(651, 408, 121, 28);
		getContentPane().add(comboBox);
	}
	
	private void enrollment_Event() {
		//��ǰ ��� ��ư
		product.setBounds(614, 484, 158, 68);
		getContentPane().add(product);
		product.setFont(font);
		
		//��ǰ ��ư �̺�Ʈ
		product.addActionListener(e->{
			
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
//					name = chooser.getSelectedFile().getName();	//�̹��� �̸�
				}
//				System.out.println(path);						//��� Ȯ��
				image = new JLabel(new ImageIcon(path));
				image.setBounds(12, 10, 393, 542);
				panel.add(image);
			}
//			file.setVisible(true);
//			file.setFilenameFilter("�׸� ���� (*.jpg, *.gif, *.bmp)");
//			if(file.getFile() == null) return;

		});
	}
}

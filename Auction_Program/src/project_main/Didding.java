package project_main;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Didding extends JDialog{
	
	private JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	
	JLabel lblNewLabel = new JLabel("���� ������ : ");
	JLabel lblNewLabel_2 = new JLabel("��");
	
	JPanel panel_5 = new JPanel();
	JLabel lblNewLabel_3 = new JLabel("���� �ݾ� �Է�");
	JPanel panel_6 = new JPanel();
	private JTextField textField = new JTextField();
	JPanel panel_7 = new JPanel();
	
	private JPanel panel_3 = new JPanel();
	private JButton btnNewButton = new JButton("���� �ϱ�");
	
	private JPanel panel_4 = new JPanel();
	private JButton btnNewButton_1 = new JButton("���� ���");

	public Didding() {
		display();
		setTitle("����");
		setSize(300, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}
	
	private void display() {
		panel.setBounds(113, 27, 99, 27);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("999,999,999");
		panel.add(lblNewLabel_1);
		
		
		panel_1.setBounds(12, 27, 89, 27);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		panel_1.add(lblNewLabel);
		
		
		panel_2.setBounds(224, 27, 48, 27);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		panel_2.add(lblNewLabel_2);
		
		panel_3.setBounds(12, 150, 126, 52);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(event->{
			int choice = JOptionPane.showConfirmDialog(this, "���� �Ͻðڽ��ϱ� ?", "Ȯ��", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
			if(choice == 0) {
				System.out.println("���� �Ǿ����ϴ�.");
				//���� �ݾ� ������ ���۷� ������
			}
		});
		
		panel_4.setBounds(150, 150, 122, 52);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		panel_4.add(btnNewButton_1);
		btnNewButton_1.addActionListener(event->{
			int choice = JOptionPane.showConfirmDialog(this, "��� �Ͻðڽ��ϱ� ?", "���", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);	//(��ġ, �ؽ�Ʈ, ����, JOptionPane.(OPTION)���)
			if(choice == 0) {
				setVisible(false);
			}
		});
		
		
		panel_5.setBounds(12, 64, 200, 27);
		getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_5.add(lblNewLabel_3);
		
		panel_6.setBounds(12, 101, 200, 27);
		getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_6.add(textField);
		textField.setColumns(10);
		
		panel_7.setBounds(224, 101, 48, 27);
		getContentPane().add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel label = new JLabel("��");
		panel_7.add(label);
	}

//	@Override
//	public void actionPerformed(ActionEvent event) {
//		if(event.getSource() == btnNewButton) {
//			int choice = JOptionPane.showConfirmDialog(this, "���� �Ͻðڽ��ϱ� ?", "Ȯ��", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
//			if(choice == 0) {
//				System.out.println("���� �Ǿ����ϴ�.");
//				//���� �ݾ� ������ ���۷� ������
//			}
//		}else if(event.getSource() == btnNewButton){
//			int choice = JOptionPane.showConfirmDialog(this, "��� �Ͻðڽ��ϱ� ?", "���", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);	//(��ġ, �ؽ�Ʈ, ����, JOptionPane.(OPTION)���)
//			if(choice == 0) {
//				System.exit(0);
//			}
//		}
//	}
}

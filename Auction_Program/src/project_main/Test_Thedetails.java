package project_main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.UIManager;

class Window09 extends JFrame{
//	������Ʈ ��ġ�� ����
	private Container con = this.getContentPane();
	
	public Window09() {
		this.display();
		this.event();
		this.menu();
		this.setTitle("���� ����");
		this.setSize(800, 600);
		this.setLocationByPlatform(true);
	}

	private void menu() {
		
	}

	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 	//�ڵ� ���α׷� ���� ���� (JFrame.DISPOSE_ON_CLOSE[CLOSE�� ������ ���� ��ɾ��]) 
															//�ڽ��� JFrame�϶� DISPOSE_ON_CLOSE�̷��Ը� ������ �ȴ�
		
	}

	private void display() {
		
	}
	
}

public class Test_Thedetails {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		}catch (Exception e) {
			e.printStackTrace();
		}
		Window09 frame = new Window09();
		
		frame.setVisible(true);						//JFrame�� x��ư�� �ڵ� ���� ����� �ִ�
	}
}

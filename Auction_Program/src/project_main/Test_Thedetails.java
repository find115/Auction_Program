package project_main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.UIManager;

class Window09 extends JFrame{
//	컴포넌트 배치용 공간
	private Container con = this.getContentPane();
	
	public Window09() {
		this.display();
		this.event();
		this.menu();
		this.setTitle("스윙 예제");
		this.setSize(800, 600);
		this.setLocationByPlatform(true);
	}

	private void menu() {
		
	}

	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 	//자동 프로그램 종료 선언 (JFrame.DISPOSE_ON_CLOSE[CLOSE로 끝나는 종료 명령어들]) 
															//자신이 JFrame일땐 DISPOSE_ON_CLOSE이렇게만 쓰여도 된다
		
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
		
		frame.setVisible(true);						//JFrame은 x버튼은 자동 숨김 기능이 있다
	}
}

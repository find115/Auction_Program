package project_main;

import javax.swing.JButton;
import javax.swing.JFrame;

import network.Client_Thread;

class Window_Main extends JFrame {

	Menu menu = new Menu();
	private JButton start = new JButton("Start");
	
	public Window_Main() {
		this.menu();
		this.setTitle("Mini Project");
		this.setSize(800, 600);
		this.setLocationByPlatform(true);
		this.setResizable(false);
	}
	private void menu() {
		this.add(start);
		start.addActionListener(e->{
			Client_Thread ct = new Client_Thread();
			ct.setDaemon(true);
			ct.start();
			
			menu.setVisible(true);
		});
	}
	
	
	public static void main(String[] args) {
		
		
		Window_Main win = new Window_Main();
		win.setVisible(true);
	}
}


package network;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 * ������ �����Ű�� Ŭ����
 * ���� GUI
 * @author ���ؼ�
 */
class Server extends JFrame implements Runnable{

//	������Ʈ ��ġ�� ����
	private Container con = this.getContentPane();
	private JTextArea area = new JTextArea();
	private JScrollPane pane = new JScrollPane();
	private JButton finish = new JButton("  ����  ����    ");
	private StringBuilder sb = new StringBuilder();
	private Font font = new Font("����",Font.PLAIN, 25);
	private String ipAdd = "�ʱⰪ";
	private boolean flag = true;
	
//	ExecutorService executorService = Executors.newFixedThreadPool(1);
	
	static Server_Creation server = new Server_Creation();
	
	private int count = 0;//log�� ��� ���� �ʿ��� ����
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	public String getIpAdd(){
		return ipAdd; 
	}

	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public Server() {
		this.display();
		this.event();
		this.menu();
		this.setTitle("��� ���α׷� ����");
		this.setSize(400, 600);
		this.setLocationByPlatform(true);//�ü���� â�� ��ġ����
	}
	
	public void textArea_Write(String a) {
		sb.append(a);
		area.setText(String.valueOf(sb));
	}

	private void display() {
//		Border border = BorderFactory.createLineBorder(Color.BLACK,5);
//		Border border = BorderFactory.createTitledBorder("���� ���");
//		textArea ���� �Ұ�
		area.setEditable(false);
//		area.setBorder(border);
		finish.setFont(font);
		con.add(finish, BorderLayout.NORTH);
		con.add(pane, BorderLayout.CENTER);
		pane.setViewportView(area);
		
//		area�� �ٹٲ� ���� �� ���� ��ũ���� �Ȼ���� ó��
		area.setLineWrap(true);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		area.append("[���� ����]\n");
		
//		Runnable c_Add = new Runnable() {
//		};
//		executorService.submit(c_Add);
	}
	@Override
	public void run() {
		while(true) {
			serverLog(getCount());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void serverLog(int count) {
			if(server.function.getActivity() != count) {
//				count = server.function.getActivity();
				setCount(server.function.getActivity());
				area.append(server.function.getServerLog().toString()+"\n");
				area.setCaretPosition(area.getDocument().getLength());//�ڵ� ��ũ��  
			}
	}
	
	
	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		finish.addActionListener(e->{
//			flag = false;
			setFlag(false);
//			executorService.shutdown();
			server.stopServer();
			System.exit(0);
		});
	}

	private void menu() {
		JMenuBar bar = new JMenuBar();
		this.setJMenuBar(bar);
		
		JMenu menu = new JMenu("�޴�");
		bar.add(menu);
		
		JMenuItem exit = new JMenuItem("����");
		menu.add(exit);
		
		exit.addActionListener(e->{
			System.exit(0);
		});
		
//			����Ű ����
		KeyStroke ctrl_q = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
		exit.setAccelerator(ctrl_q);
	}
	
	public static void main(String[] args) {
		server.startServer();
		
//		Server frame = new Server();
		Runnable frame = new Server();
		Thread t = new Thread(frame);
		t.setDaemon(true);
		t.start();
		
//		frame.setVisible(true);
		((Component) frame).setVisible(true);
		
	}
}


package network;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
/**
 * ������ �����Ű�� Ŭ����
 * ���� GUI
 * @author ���ؼ�
 */
class Server extends JFrame{

//	������Ʈ ��ġ�� ����
	private Container con = this.getContentPane();
	private JTextArea area = new JTextArea();
	private JScrollPane pane = new JScrollPane();
	private JButton finish = new JButton("  ����  ����    ");
	private StringBuilder sb = new StringBuilder();
	private Font font = new Font("����",Font.PLAIN, 25);
	private String ipAdd = "�ʱⰪ";
	private boolean flag = true;
	
	ExecutorService executorService = Executors.newFixedThreadPool(1);
//	static ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	static Server_Creation server = new Server_Creation();
	Server_Function function = new Server_Function();
	//������ ����Ʈ test�ڵ�
	Item item = new Item();
	List<Item> itemList = new ArrayList<>();
	
	public String getIpAdd(){
		return ipAdd; 
	}

	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
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
		
		Runnable c_Add = new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while(true) {
						serverLog();
//						System.out.println(String.valueOf(server.itemInfo()+"\n"));
//						System.out.println(server.getList().get(0)+"\n");
						
//						���� itemList�� ���ŵ� itemList�� �־��ִ� ���
						itemList = server.getItemList();
						if(server.getList().size()!=count) {
							area.append("���� ������ �� : "+server.getList().size()+"��\n");
							count = server.getList().size();
						}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(c_Add);
	}
	
	private void serverLog() {
		if(!getIpAdd().equals(server.getC_Address())) {
			area.append(server.getC_Address()+"\n");
			setIpAdd(server.getC_Address());
			area.setCaretPosition(area.getDocument().getLength());//�ڵ� ��ũ��  
		}
	}
	
	private void event() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		finish.addActionListener(e->{
//			server.notFlag();
//			area.append(String.valueOf(server.getFalg()));//flag�� test�ڵ�
//			server.stopServer();
			flag = false;
			executorService.shutdown();
			server.stopServer();
//			executorService.shutdown();
//			server.executorService.shutdown();
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
		
		Server frame = new Server();
		frame.setVisible(true);
	}
}


















package project_main;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import network.Item;

import java.awt.Container;

public class Thedetails extends JDialog{
	
	private List<Item> itemList = new ArrayList<>();
	private int index;
	
	private Item item;
	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	
	
	
	private Border border = BorderFactory.createTitledBorder("");
	private Container con = this.getContentPane();
	private JPanel server_Title = new JPanel();	//서버에서 받은 getTitle
	private JPanel server_Image = new JPanel(); //서버에서 받은 getImage
	private JPanel server_Startday = new JPanel(); //서버에서 받은 getStartday
	private JPanel server_Explanation = new JPanel(); //서버에서 받은 getExplanation
	private JPanel server_Finishday = new JPanel();   //서버에서 받은 getFinishday
	private JPanel server_Information = new JPanel();//서버에서 받은 getInformation
	private JPanel server_Output = new JPanel(); //입찰정보출력
	private JPanel server_Bid = new JPanel();	//입찰 버튼
	private JPanel server_Seller = new JPanel();//판매자
	
	private StringBuffer InformationBuffer = new StringBuffer();
	
	private JTextArea explanation_TextArea;	//제품 설명 출력 Text
	private JTextArea output_TextArea;		//입찰 정보 출력 Text
	private JScrollPane output_Scroll;
	private JScrollPane explanation_Scroll;
	
	private JPanel design;	//디자인 패널
	
	public Thedetails(List<Item> itemList, int index){
		this.index = index;
		this.itemList = itemList;
		this.display();
		this.setTitle("상세 보기");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
	}
	
	private void display() {
	
		//서버에서 받아온 title 출력 
		server_Title.setBounds(57, 10, 356, 26);
		con.add(server_Title);
		server_Title.setLayout(new GridLayout(1, 0, 0, 0));
		server_Title.add(new JLabel("제목 : "+itemList.get(index).getTitle(),JLabel.CENTER));
		server_Title.setBorder(border);
		
		//서버에서 받은 image 출력
		server_Image.setBounds(12, 46, 445, 299);
		con.add(server_Image);
		server_Image.setLayout(new GridLayout(1, 0, 0, 0));
		server_Image.add(new JLabel(itemList.get(index).getImage()));
		server_Image.setBorder(border);
		
		//서버에서 받은 startday 출력
		SimpleDateFormat format_Start = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		String date_Start = format_Start.format(itemList.get(index).getStartDate());
		server_Startday.setBounds(57, 514, 160, 26);
		con.add(server_Startday);
		server_Startday.setLayout(new GridLayout(1, 0, 0, 0));
		server_Startday.add(new JLabel(date_Start));
		server_Startday.setBorder(border);
		
		//서버에서 받은 finishday 출력
		SimpleDateFormat format_Finish = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		String date_Finish = format_Finish.format(itemList.get(index).getFinishDate());
		server_Finishday.setBounds(253, 514, 160, 26);
		con.add(server_Finishday);
		server_Finishday.setLayout(new GridLayout(1, 0, 0, 0));
		server_Finishday.add(new JLabel(date_Finish));
		server_Finishday.setBorder(border);
		
		//입찰 태그
		server_Information.setBounds(565, 10, 141, 26);
		con.add(server_Information);
		server_Information.setLayout(new GridLayout(1, 0, 0, 0));
		server_Information.add(new Label("입찰 정보",Label.CENTER));
		server_Information.setBorder(border);
		
		//입찰 버튼 생성
		JButton button_Bid = new JButton("입 찰");
		server_Bid.setBounds(647, 490, 110, 50);
		con.add(server_Bid);
		server_Bid.setLayout(new GridLayout(1, 0, 0, 0));
		server_Bid.add(button_Bid);
		server_Bid.setBorder(border);
		button_Bid.addActionListener(e->{
			Bidding ding = new Bidding(item);
			ding.setVisible(true);
		});
		
		//서버에서 받은 판매자 정보 출력
		server_Seller.setBounds(515, 355, 242, 26);
		con.add(server_Seller);
		server_Seller.setLayout(new GridLayout(1, 0, 0, 0));
		server_Seller.add(new JLabel("ID : "+itemList.get(index).getId()));
		server_Seller.setBorder(border);
		
		//서버에서 받은 설명 출력
		explanation_TextArea = new JTextArea(itemList.get(index).getExplanation());
		explanation_Scroll = new JScrollPane(explanation_TextArea);
		server_Explanation.setBounds(12, 355, 445, 144);
		con.add(server_Explanation);
		server_Explanation.setLayout(new GridLayout(1, 0, 0, 0));
		explanation_TextArea.setLineWrap(true);
		explanation_TextArea.setEditable(false);
		explanation_Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		server_Explanation.add(explanation_Scroll);
		
		//서버에서 받은 입찰 정보 출력
		item = itemList.get(index);
		if(item.getBidsList().size() == 0 || item.getBidsList() == null) {
			output_TextArea = new JTextArea();
			output_Scroll = new JScrollPane(output_TextArea);
		}else {
			for(int i=item.getBidsList().size()-1; i>=0; i--) {
				InformationBuffer.append(item.getBidsList().get(i).getIpAdd()+"\n");
				InformationBuffer.append(item.getBidsList().get(i).getBid()+"\n");
				InformationBuffer.append(item.getBidsList().get(i).getBidTime()+"\n\n");
			}			
			output_TextArea = new JTextArea(String.valueOf(InformationBuffer));
			output_Scroll = new JScrollPane(output_TextArea);
		}
		server_Output.setBounds(505, 46, 267, 299);
		con.add(server_Output);
		server_Output.setLayout(new GridLayout(1, 0, 0, 0));
		output_TextArea.setLineWrap(true);
		output_TextArea.setEditable(false);
		output_Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		server_Output.add(output_Scroll);
		
		//디자인 패널
		design = new JPanel();
		design.setBounds(216, 514, 36, 26);
		con.add(design);
		design.setLayout(new GridLayout(1, 0, 0, 0));
		design.add(new JLabel(" ~ ",JLabel.CENTER));
	}
}

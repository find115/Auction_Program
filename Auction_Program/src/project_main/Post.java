package project_main;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;

public class Post extends JFrame{

//	private BuffSt
//	private JList<ArrayList<ArrayList<JLabel>>> image = null;
//	private ArrayList<ArrayList<ImageIcon>> icon = null;
//	private ArrayList<String> image_name = null;
	
//	List<String> image_name = new ArrayList<>();
//	List<ImageIcon> icon = new ArrayList<>();
//	List<JLabel> image = new ArrayList<>();
//	List<JButton> bt = new ArrayList<>();
//	List<JTextArea> text = new ArrayList<>();
	
	private List<String> image_name = new ArrayList<>();
	private ImageIcon[] icon = new ImageIcon[image_name.size()];
	private JLabel[] image = new JLabel[icon.length];
	
	private JButton[] but = new JButton[icon.length];
	
	private List<JTextArea> text = new ArrayList<>();
	
	public void onSet() {
		JList imagelist = new JList(image);
		this.add(imagelist);
		JList butlist = new JList(but);
		this.add(butlist);
		JList textlist = new JList((ListModel) text);
		this.add(textlist);
		
		System.out.println(textlist);
//		image = new ArrayList<ArrayList<ArrayList<JLabel>>>();
//		icon = new ArrayList<ArrayList<ImageIcon>>();
//		image_name = new ArrayList<String>();
//		
//		image_name.add("image/boknom.jpg");
//		image_name.add("image/boknom.jpg");
//		image_name.add("image/boknom.jpg");
//
//		icon.add(image_name);
	}
}

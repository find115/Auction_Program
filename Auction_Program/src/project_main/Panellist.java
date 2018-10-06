package project_main;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Panellist extends JPanel {
	
	private int size = 0;
	private JPanel[] panel_3 = new JPanel[5];
	private Border border = BorderFactory.createTitledBorder("");
	
	private Panellist() {
		for(int i=0; i<5; i++) {
			panel_3[i] = new JPanel();
			add(panel_3[i]);	
		}
		for(int i=0; i<5; i++) {	// 1~5 
			panel_3[i].setLayout(null);
			panel_3[i].setBorder(border);
			panel_3[i].setBounds(0, (70+size), 1059, 115);
			this.setBounds(205, 100, 2118, 1454);		//this
			size += 130;
			this.getRootPane().add(panel_3[i]);				//»èÁ¦
		}
	}
	public void Panellist2() {
		
	}
}

package Dinner;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Food extends JFrame{
	private JLayeredPane school = new JLayeredPane();
	public Food() {
		setTitle("저녁 뭐 먹을래?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		school.setLayout(new FlowLayout());
		school.add(new JLabel("밥"));
		JComboBox riceCombo = new JComboBox();
		school.add(riceCombo);
		school.add(new JLabel("수량"));
		JComboBox countCombo = new JComboBox();
		school.add(countCombo);
		school.add(new JLabel("라면"));
		JComboBox noodleCombo = new JComboBox();
		school.add(noodleCombo);
		
		school.setBounds(30, 30, 360, 190);
		school.setBorder(new TitledBorder(null,"학식이 최고!", TitledBorder.LEADING, TitledBorder.TOP, new Font("돋움체", Font.PLAIN, 14), null));
		c.add(school);
		
		setSize(565, 355);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Food();
	}
}

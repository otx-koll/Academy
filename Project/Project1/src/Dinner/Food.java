package Dinner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Food extends JFrame {
	private JLayeredPane school = new JLayeredPane();
	private String rice[] = { null, "고치돈", "제육볶음", "치킨마요" };
	private Integer riceMoney[] = { 0, 3500, 4000, 3000 };
	private Integer count[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private Integer noodle[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//	private Integer noodleMoney[] = {null, 2000};
	private JLabel calculate;
	private JComboBox riceCombo;
	private JComboBox countCombo;
	private JComboBox noodleCombo;
	private JCheckBox strawberryCombo;
	private int riceMul = 0;
	private int noodleMul = 0;
	private int riceMulResult = 0;
	private int noodleMulResult = 0;
	private JRadioButton vatFalse;
	private JRadioButton vatTrue;
	
	public static void main(String[] args) {
		new Food();
	}

	public Food() {
		setTitle("저녁 뭐 먹을래?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLayeredPane school = new JLayeredPane();
		school.setLayout(null);
		school.setBounds(30, 30, 360, 190);
		school.setBorder(new TitledBorder("학식이 최고!"));
		c.add(school);

		JLabel riceLabel = new JLabel("밥");
		riceLabel.setBounds(32, 30, 20, 15);
		school.add(riceLabel);

		riceCombo = new JComboBox(rice);
		riceCombo.setBounds(58, 27, 125, 21);
		riceCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = riceCombo.getSelectedIndex();
				riceMul = riceMoney[index];
			}
		});
		school.add(riceCombo);

		JLabel countLabel = new JLabel("수량");
		countLabel.setBounds(219, 30, 35, 15);
		school.add(countLabel);

		countCombo = new JComboBox(count);
		countCombo.setBounds(255, 27, 71, 21);
		countCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = countCombo.getSelectedIndex();
				riceMulResult = count[index]*riceMul;
			}
		});
		school.add(countCombo);

		JLabel noodleLabel = new JLabel("라면");
		noodleLabel.setBounds(20, 77, 40, 18);
		school.add(noodleLabel);

		noodleCombo = new JComboBox(noodle);
		noodleCombo.setBounds(58, 76, 125, 21);
		noodleCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = noodleCombo.getSelectedIndex();
					riceMulResult += noodle[index]*2000;
//					noodleMul = noodleMoney[index];
			}
		});
		school.add(noodleCombo);

		strawberryCombo = new JCheckBox("딸기요거트");
		strawberryCombo.setBounds(36, 123, 115, 23);
		school.add(strawberryCombo);

		JPanel vat = new JPanel();
		vat.setBounds(222, 219, 168, 87);
		vat.setBorder(new TitledBorder("영수증"));
		c.add(vat);

		ButtonGroup g = new ButtonGroup();
		vatFalse = new JRadioButton("부가세 미포함");
		vatTrue = new JRadioButton("부가세 포함");
		vatFalse.setSelected(true);
		g.add(vatFalse);
		g.add(vatTrue);
		vat.add(vatFalse);
		vat.add(vatTrue);

		JButton calculateBtn = new JButton("계산하기");
		calculateBtn.setBounds(402, 228, 122, 33);
		calculateBtn.addActionListener(new cal());
		c.add(calculateBtn);

		calculate = new JLabel();
		calculate.setOpaque(true);
		calculate.setBackground(Color.WHITE);
		calculate.setBorder(new LineBorder(Color.gray, 1));
		calculate.setBounds(402, 40, 122, 178);
		c.add(calculate);

		setSize(565, 355);
		setVisible(true);
	}

	class cal implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			int index = riceCombo.getSelectedIndex();
			int index2 = noodleCombo.getSelectedIndex();
			String riceComboValue = riceCombo.getSelectedItem().toString();
			int countValue = Integer.parseInt(countCombo.getSelectedItem().toString());
			int noodleValue = noodle[index2];
			int moneyValue = Integer.parseInt(riceMoney[index].toString());
			int strawberry = 0;
			
			if(vatFalse.isSelected()) {
				if(strawberryCombo.isSelected()) {
					strawberry = riceMulResult + 1500;
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"원 "+countValue+"개<br>라면 "+noodleValue+"개<br>딸기요거트 1500원<br>부가세 미포함 <br>총 "+strawberry+"원 </html>");
				}
				else
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"원 "+countValue+"개<br>라면 "+noodleValue+"개<br>부가세 미포함<br>총 "+riceMulResult+"원</html>");
			}
			else {
				if(strawberryCombo.isSelected()) {
					strawberry = riceMulResult + 1500;
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"원 "+countValue+"개<br>라면 "+noodleValue+"개<br>딸기요거트 1500원<br>부가세 포함<br>총 "+(Math.floor(strawberry*1.10)*10/10.0)+"원</html>");
				}
				else
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"원 "+countValue+"개<br>라면 "+noodleValue+"개<br>부가세 포함<br>총 "+(riceMulResult*1.10)+"원<br></html>");
			}
		}
	}
}
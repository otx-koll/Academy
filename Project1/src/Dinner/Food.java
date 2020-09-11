package Dinner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Food extends JFrame {
	private JLayeredPane school = new JLayeredPane();
	private String rice[] = { null, "��ġ��", "��������", "ġŲ����" };
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
		setTitle("���� �� ������?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);

		JLayeredPane school = new JLayeredPane();
		school.setLayout(null);
		school.setBounds(30, 30, 360, 190);
		school.setBorder(new TitledBorder("�н��� �ְ�!"));
		c.add(school);

		JLabel riceLabel = new JLabel("��");
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

		JLabel countLabel = new JLabel("����");
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

		JLabel noodleLabel = new JLabel("���");
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

		strawberryCombo = new JCheckBox("������Ʈ");
		strawberryCombo.setBounds(36, 123, 115, 23);
		school.add(strawberryCombo);

		JPanel vat = new JPanel();
		vat.setBounds(222, 219, 168, 87);
		vat.setBorder(new TitledBorder("������"));
		c.add(vat);

		ButtonGroup g = new ButtonGroup();
		vatFalse = new JRadioButton("�ΰ��� ������");
		vatTrue = new JRadioButton("�ΰ��� ����");
		vatFalse.setSelected(true);
		g.add(vatFalse);
		g.add(vatTrue);
		vat.add(vatFalse);
		vat.add(vatTrue);

		JButton calculateBtn = new JButton("����ϱ�");
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
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"�� "+countValue+"��<br>��� "+noodleValue+"��<br>������Ʈ 1500��<br>�ΰ��� ������ <br>�� "+strawberry+"�� </html>");
				}
				else
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"�� "+countValue+"��<br>��� "+noodleValue+"��<br>�ΰ��� ������<br>�� "+riceMulResult+"��</html>");
			}
			else {
				if(strawberryCombo.isSelected()) {
					strawberry = riceMulResult + 1500;
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"�� "+countValue+"��<br>��� "+noodleValue+"��<br>������Ʈ 1500��<br>�ΰ��� ����<br>�� "+(Math.floor(strawberry*1.10)*10/10.0)+"��</html>");
				}
				else
					calculate.setText("<html>"+riceComboValue+" "+riceMul+"�� "+countValue+"��<br>��� "+noodleValue+"��<br>�ΰ��� ����<br>�� "+(riceMulResult*1.10)+"��<br></html>");
			}
		}
	}
}
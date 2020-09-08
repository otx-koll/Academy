package BMI;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BMI extends JFrame {
	private JLayeredPane BodyPanel = new JLayeredPane();
	private JLabel opinion;
	private JLabel result;
	private JLabel result2;
	JTextField name;
	JTextField height;
	JTextField weight;
	JRadioButton woman;
	JRadioButton man;
	JRadioButton drinking;
	JRadioButton smoking;
	JRadioButton exercise;
	
	public BMI() {
		setTitle("신체 질량 지수 측정(BMI) - 김이박");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(3, 3, 0, 5));
		name = new JTextField(10);
		info.add(new JLabel("이    름:"));
		info.add(name);
		info.add(new JLabel(""));

		height = new JTextField("---",10);
		info.add(new JLabel("    키   :"));
		info.add(height);
		info.add(new JLabel(" (cm)"));

		info.add(new JLabel("체     중:"));
		info.add(new JTextField("--", 10));
		info.add(new JLabel(" (kg)"));
		info.setBounds(30, 40, 240, 80);
		BodyPanel.add(info);

		JPanel sex = new JPanel();
		ButtonGroup g = new ButtonGroup();
		woman = new JRadioButton("여자", true);
		man = new JRadioButton("남자");
		g.add(woman);
		g.add(man);
		sex.add(woman);
		sex.add(man);
		sex.setBorder(new TitledBorder(null, "성별",TitledBorder.LEADING, TitledBorder.TOP)); // 테두리색(new LineBorder(Color.색), 제목, 경계, 위치
		sex.setBounds(30, 140, 150, 70);
		BodyPanel.add(sex);

		JPanel habit = new JPanel();
		drinking = new JRadioButton("음주");
		smoking = new JRadioButton("흡연");
		exercise = new JRadioButton("운동");
		habit.add(drinking);
		habit.add(smoking);
		habit.add(exercise);
		habit.setBorder(new TitledBorder(null, "습  관",TitledBorder.LEADING, TitledBorder.TOP));
		habit.setBounds(30, 230, 200, 70);
		BodyPanel.add(habit);

		JButton btn = new JButton("신체 상태 측정");
		btn.setBounds(390, 40, 120, 20);
		btn.addActionListener(new buttonClick());
		c.add(btn);

		BodyPanel.setBorder(new TitledBorder(null, "Body Max Index",TitledBorder.LEADING, TitledBorder.TOP));
		BodyPanel.setBounds(40, 40, 280, 330);
		c.add(BodyPanel);

		JLabel BMIresult = new JLabel("BMI 결과");
		BMIresult.setBounds(340, 55, 50, 50);
		c.add(BMIresult);

		result = new JLabel();
		result.setBorder(new LineBorder(Color.gray, 1));
		result.setBounds(340, 90, 150, 150);
		c.add(result);

		result2 = new JLabel();
		result2.setBorder(new LineBorder(Color.gray, 1));
		result2.setBounds(370, 135, 90, 80);
		c.add(result2);

		JLabel BMIopinion = new JLabel("소   견");
		BMIopinion.setBounds(340, 240, 50, 50);
		c.add(BMIopinion);

		opinion = new JLabel();
		opinion.setBorder(new LineBorder(Color.gray, 1));
		opinion.setBounds(340, 280, 150, 85);
		c.add(opinion);

		setSize(570, 450);
		setVisible(true);
	}

	class buttonClick implements ActionListener {
		String bmiStr = "";
		String opiStr = "";
		
		public void actionPerformed(ActionEvent e) {
			if(woman.isSelected())
				bmiStr += "아름다운 ";
			else
				bmiStr += "멋진 ";
			
			bmiStr += name.getText()+"님의\n신체 질량 지수는:";
			
			result.setText(bmiStr);
			result.setVerticalAlignment(SwingConstants.TOP);
			
			if(drinking.isSelected()) 
				opiStr += drinking.getText()+" 그만 마셔요!";
			if(smoking.isSelected())
				opiStr += smoking.getText()+" 끊으세요!\n";
			if(!exercise.isSelected())
				opiStr += exercise.getText()+" 좀 하세요!\n";
			
			opinion.setText(opiStr);
			opinion.setVerticalAlignment(SwingConstants.TOP);
		}
	}

	public static void main(String[] args) {
		new BMI();
	}
}

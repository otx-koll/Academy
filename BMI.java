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
	private JTextField name;
	private JTextField height;
	private JTextField weight;
	private JRadioButton woman;
	private JRadioButton man;
	private JRadioButton drinking;
	private JRadioButton smoking;
	private JRadioButton exercise;

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

		height = new JTextField("---", 10);
		info.add(new JLabel("    키   :"));
		info.add(height);
		info.add(new JLabel(" (cm)"));

		weight = new JTextField("--", 10);
		info.add(new JLabel("체     중:"));
		info.add(weight);
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
		sex.setBorder(new TitledBorder(null, "성별", TitledBorder.LEADING, TitledBorder.TOP)); // 테두리색  : (new LineBorder(Color.색, 제목, 경계, 위치))
		sex.setBounds(30, 140, 150, 70);
		BodyPanel.add(sex);

		JPanel habit = new JPanel();
		drinking = new JRadioButton("음주");
		smoking = new JRadioButton("흡연");
		exercise = new JRadioButton("운동");
		habit.add(drinking);
		habit.add(smoking);
		habit.add(exercise);
		habit.setBorder(new TitledBorder(null, "습  관", TitledBorder.LEADING, TitledBorder.TOP));
		habit.setBounds(30, 230, 200, 70);
		BodyPanel.add(habit);

		JButton btn = new JButton("신체 상태 측정");
		btn.setBounds(390, 40, 120, 20);
		btn.addActionListener(new buttonClick());
		c.add(btn);

		BodyPanel.setBorder(new TitledBorder(null, "Body Max Index", TitledBorder.LEADING, TitledBorder.TOP));
		BodyPanel.setBounds(40, 40, 280, 330);
		c.add(BodyPanel);

		JLabel BMIresult = new JLabel("BMI 결과");
		BMIresult.setBounds(340, 55, 50, 50);
		c.add(BMIresult);

		result = new JLabel();
		result.setBorder(new LineBorder(Color.gray, 1));
		result.setBounds(340, 90, 170, 160);
		result.setVerticalAlignment(SwingConstants.TOP);
		c.add(result);

		result2 = new JLabel();
		result2.setBorder(new LineBorder(Color.gray, 1));
		result2.setBounds(380, 145, 90, 80);
		result2.setOpaque(true);
		c.add(result2);

		JLabel BMIopinion = new JLabel("소   견");
		BMIopinion.setBounds(340, 240, 50, 50);
		c.add(BMIopinion);

		opinion = new JLabel();
		opinion.setBorder(new LineBorder(Color.gray, 1));
		opinion.setBounds(340, 280, 170, 85);
		opinion.setVerticalAlignment(SwingConstants.TOP);
		c.add(opinion);

		setSize(570, 450);
		setVisible(true);
	}

	class buttonClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Double bmiResult = Math.round(Double.parseDouble(weight.getText())
					/ (Math.pow((Double.parseDouble(height.getText()) / 100), 2)) * 10) / 10.0;

			if (woman.isSelected()) {
				if (bmiResult >= 30) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>아름다운 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(고도비만)입니다</html>");
				} else if (bmiResult >= 25 && bmiResult <= 29.9) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>아름다운 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(중도비만)입니다</html>");
				} else if (bmiResult >= 23 && bmiResult <= 24.9) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>아름다운 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(과체중)입니다</html>");
				} else if (bmiResult >= 18.5 && bmiResult <= 22.9) {
					result2.setBackground(Color.green);
					result.setText(
							"<html>아름다운 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(정상)입니다</html>");
				} else {
					result2.setBackground(Color.blue);
					result.setText(
							"<html>아름다운 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(저체중)입니다</html>");
				}

			} else if (man.isSelected()) {
				if (bmiResult >= 30) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>멋진 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(고도비만)입니다</html>");
				} else if (bmiResult >= 25 && bmiResult <= 29.9) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>멋진 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(중도비만)입니다</html>");
				} else if (bmiResult >= 23 && bmiResult <= 24.9) {
					result2.setBackground(Color.red);
					result.setText(
							"<html>멋진 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(과체중)입니다</html>");
				} else if (bmiResult >= 18.5 && bmiResult <= 22.9) {
					result2.setBackground(Color.green);
					result.setText(
							"<html>멋진 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(정상)입니다</html>");
				} else {
					result2.setBackground(Color.blue);
					result.setText(
							"<html>멋진 " + name.getText() + "님의 <br>신체 질량 지수는:<br>" + bmiResult + "(저체중)입니다</html>");
				}
			}

			if (drinking.isSelected()) {
				opinion.setText("술 그만 마셔요");
				if(smoking.isSelected()) {
					opinion.setText("<html>술 그만 마셔요<br>담배 끊으세요</html>");
					if(!exercise.isSelected()) 
						opinion.setText("<html>술 그만 마셔요<br>담배 끊으세요<br>운동 하세요</html>");
				}
				else {
					if(!exercise.isSelected()) 
						opinion.setText("<html>술 그만 마셔요<br>운동 하세요</html>");
				}
			}
			else{
				if(smoking.isSelected()) {
					opinion.setText("<html>담배 끊으세요</html>");
					if(!exercise.isSelected()) 
						opinion.setText("<html>담배 끊으세요<br>운동 하세요</html>");
				}
				else if(!exercise.isSelected()) 
					opinion.setText("<html>운동 하세요</html>");
				else {
					opinion.setText("");
				}
			}
			
			try 
			{
					name.getText().equals("");
					weight.getText().equals("");
					height.getText().equals("");
			}
			catch(NullPointerException a)
			{
				opinion.setText(a.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		new BMI();
	}
}

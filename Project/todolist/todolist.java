package My;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class TodoList extends JFrame {
	
	private DefaultListModel todo = new DefaultListModel();
	private JList todoList = new JList(todo);
	private JTextField textField;
	
	public static void main(String[] args) {
		new TodoList();
	}

	public TodoList() {
		getContentPane().setBackground(new Color(250, 240, 230));
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 384);
		Container c = getContentPane();
		c.setLayout(null);
		
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String timeDate = day.format(time);
		JLabel dateLabel = new JLabel(timeDate);
		dateLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(0, 0, 0));
		dateLabel.setBounds(12, 10, 242, 15);
		c.add(dateLabel);
		
		JLabel title = new JLabel("To Do List");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("DialogInput", Font.BOLD, 18));
		title.setForeground(new Color(0, 0, 0));
		title.setBounds(12, 35, 242, 15);
		c.add(title);
		
		textField = new HintTextField("Press Enter...");
		textField.setBackground(new Color(245, 245, 245));
		textField.setBounds(12, 60, 242, 33);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				todo.addElement(t.getText());
				t.setText("");
				todoList.setModel(todo);
			}
		});
		c.add(textField);
		todoList.setSelectionBackground(new Color(255, 160, 122));
		todoList.setBorder(new LineBorder(new Color(192, 192, 192)));
		todoList.setValueIsAdjusting(true);
		todoList.setBackground(new Color(255, 222, 173));
		
		todoList.setBounds(12, 103, 242, 195);
		todoList.setVisibleRowCount(10);
		todoList.setFixedCellWidth(100);
		c.add(todoList);

		JButton delete = new JButton("Delete");
		delete.setFont(new Font("DialogInput", Font.BOLD, 12));
		delete.setBounds(94, 308, 80, 23);
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = todoList.getSelectedIndex();
				int del = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if(del == JOptionPane.CANCEL_OPTION) 
					return;
				else if(del==JOptionPane.YES_OPTION)
					todo.remove(index);
				else
					return;
			}
		});
		c.add(delete);
		
		setVisible(true);
	}
}

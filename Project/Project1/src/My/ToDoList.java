package My;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class ToDoList extends JFrame {
	
	private DefaultListModel todo = new DefaultListModel();
	private JList todoList = new JList(todo);
	private JTextField textField;
	
	public static void main(String[] args) {
		new ToDoList();
	}

	public ToDoList() {
		getContentPane().setBackground(new Color(250, 240, 230));
		setTitle("To Do List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 282, 384);
		
		Container c = getContentPane();
		c.setBackground(new Color(82,87,93));
		c.setLayout(null);
		
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String timeDate = day.format(time);
		JLabel dateLabel = new JLabel(timeDate);
		dateLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setBounds(12, 10, 242, 15);
		c.add(dateLabel);
		
		JLabel title = new JLabel("To Do List");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("DialogInput", Font.BOLD, 18));
		title.setForeground(new Color(255, 255, 255));
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
		todoList.setBackground(new Color(246,244,230));
		todoList.setBounds(12, 103, 242, 195);
		todoList.setVisibleRowCount(10);
		todoList.setFixedCellWidth(100);
		c.add(todoList);
		
		JButton all = new JButton("All");
		all.setFont(new Font("DialogInput", Font.BOLD, 12));
		all.setBounds(50, 308, 80, 23);
		all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int del = JOptionPane.showConfirmDialog(null, "모두 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if(del == JOptionPane.CANCEL_OPTION) 
					return;
				else if(del==JOptionPane.YES_OPTION)
					todo.removeAllElements();
				else
					return;
			}
		});
		c.add(all);

		JButton delete = new JButton("Delete");
		delete.setFont(new Font("DialogInput", Font.BOLD, 12));
		delete.setBounds(140, 308, 80, 23);
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

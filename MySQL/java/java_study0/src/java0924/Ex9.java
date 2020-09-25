package java0924;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex9 extends JFrame {

	private Thread thread;
	
	public Ex9() {
		setTitle("�ð�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel clockLabel = new JLabel();
		clockLabel.setFont(new Font("Gothic", Font.ITALIC, 50));

		Container contentPane = getContentPane();
		contentPane.add(clockLabel, BorderLayout.CENTER);

		JButton btnStart = new JButton("Start");
		JButton btnStop = new JButton("Stop");
		btnStop.setEnabled(false);

		// �ð� ����
		btnStart.addActionListener(event -> {

			thread = new Thread(() -> {
				while (true) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
						// break�� return ��� ����
						return; // �� �޼��尡 ȣ��� ������ �̵�
					}
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");
					String str = sdf.format(date);
					clockLabel.setText(str);
				} // while
			});
			thread.start();

			btnStart.setEnabled(false);
			btnStop.setEnabled(true);
		});

		// �ð� ����
		btnStop.addActionListener(event -> {
			// interrupt() ȣ������ ��
			// �ش� �������� �۾��ڵ忡 InterruptedException
			// ���ܸ� �߻���Ŵ(���⼭�� sleep() �޼ҵ忡�� �߻���Ŵ)
			thread.interrupt();
			
			btnStop.setEnabled(false);
			btnStart.setEnabled(true);
		});

		JPanel panel = new JPanel();
		panel.add(btnStart);
		panel.add(btnStop);

		contentPane.add(panel, BorderLayout.SOUTH);

		setLocationByPlatform(true);
		setSize(350, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex9();
		/*
		 * new Thread(() -> { while (true) { try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); } Date date = new Date();
		 * SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss"); String str =
		 * sdf.format(date); System.out.println(str); } }).start();
		 */

	} // main
}
package java0924;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Ex6 extends JFrame{
	
	public Ex6() {
		setTitle("프로그레스 바 - 스레드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JProgressBar progressBar = new JProgressBar(0, 100); 
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(e -> {
			
			Thread thread = new Thread(() -> { // new Runnable()
				
				// synchronized 블록은 한번에 한 스레드만 실행가능.
				// 임계영역(Critical Area) 설정하는 기능.
				synchronized (progressBar) {
					for(int i=0; i<=100; i++) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						progressBar.setValue(i);
					} // for
				}
			});
			thread.start();
		});
		// 람다식
		// 실행할 문장이 하나뿐이라면 {}와 세미콜론  생략 가능
		// 매개변수 없으면 () -> {} 해도 가능
		
		JPanel contentPane = (JPanel) getContentPane();
		contentPane.add(btn, BorderLayout.CENTER);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		
		setLocationByPlatform(true);
		setSize(400, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex6();
	} // main
}

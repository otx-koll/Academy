package schedule;

import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("������ �۾� ����...");
	}
}

class MyTask2 extends TimerTask {
	@Override
	public void run() {
		System.out.println("������ �۾�2 ����...");
	}
}

public class Ex1 {

	public static void main(String[] args) {
		// Timer Ŭ���� : ���� �ð������� �ݺ��Ǵ� �۾��� ������� ó����
		
		// ����(����)������� ����(��) �����尡 ����Ǹ�
		// �ڽŵ� ���� �����
		
		Timer timer = new Timer(true); // ���󽺷���
		
		MyTask task = new MyTask();
		MyTask2 task2 = new MyTask2();
		
		// 3�� ���� �� 1�ʸ��� �ݺ� ����
		timer.scheduleAtFixedRate(task, 3000, 1000);
		// 0.5�� ���� �� 3�ʸ��� �ݺ� ����
		timer.scheduleAtFixedRate(task2, 500, 3000);
		
		// ����(��)�����带 10�� ���
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		System.out.println("=== ����(��)�����带 10�� ��� ����� ===");
		
		task.cancel(); 	// Ư�� �۾� �Ѱ��� �۾� �����
		timer.cancel(); // Ÿ�̸ӿ� ��ϵ� ��� �۾��� �����
		
	} // main

}

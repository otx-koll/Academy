package schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTask3 extends TimerTask {
	@Override
	public void run() {
		System.out.println("������ �۾� ����...");
	}
}

public class Ex2 {
	
	public static void main(String[] args) {
		Timer timer = new Timer(); // �ֽ�����
		
		String str = "2021-01-22T11:19";
		str = str.replace("T", " ");
		System.out.println(str);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		
		timer.scheduleAtFixedRate(new MyTask3(), date, 1000);
		
//		timer.scheduleAtFixedRate(task, firstTime, 1000);
	}
	
}

package java0924;

public class Ex4 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // 스레드타입 리턴
		
		System.out.println(mainThread.getName()); // main
		System.out.println(mainThread.getPriority()); // 5(기본값) 
		// Priority : 우선 순위
		
		System.out.println(Thread.MAX_PRIORITY); // 10
		System.out.println(Thread.NORM_PRIORITY); // 5
		System.out.println(Thread.MIN_PRIORITY); // 1
		
		mainThread.setPriority(7);
	} // main
}

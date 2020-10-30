package java1030;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		// 키보드 입력을 파일로 저장하기
		
		// 입력스트림 준비
		Scanner scanner = new Scanner(System.in); 

		// 출력스트림 준비
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("C:/Users/admin/Desktop/자바/test.txt", true); // true : append 옵션 킴 
			
			System.out.println("키보드로 문자를 입력하세요");
			
			String line = "";
			while (scanner.hasNextLine()) {
				line = scanner.nextLine(); // 줄바꿈문자는 제외하고 한줄을 가져옴 
				if (line.length() == 0) { // 엔터키만 입력한 경우 빈문자열
					break;
				}
				
				writer.write(line + "\n"); // 출력스트림 객체는 기본적으로 버퍼를 가짐.
				writer.flush(); // 내보냄
			} // while
			
			writer.flush(); // 버퍼 비우기해서 파일에 쓰기
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				writer.close(); // close()로 닫으면 내부적으로 flush() 호출해서 버퍼 비우기 해줌
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // main
}

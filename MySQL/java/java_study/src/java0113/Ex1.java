package java0113;

/*
객체지향 언어에서 객체간의 관계 2가지
1) is-a (~이다) 관계 : 상속 관계 -> 최종 만들어지는 객체는 1개
   강아지는 동물이다. A는 B이다. A는 B를 상속받는다.
   중학생은 학생이다. 
   
2) has-a (~를 가진다) 관계 : 포함 관계 -> 최종 만들어지는 객체가 여러개.
   자동차는 엔진을 가진다. -> A는 B를 가진다. -> A는 B를 포함한다.
*/
// 1)의 예
class Animal { /* ... */ }
class Puppy extends Animal { /* ... */ }

// 2)의 예
class Engine { /* ... */ }
class Car {
	private Engine engine = new Engine();
	// getter, setter 메소드
}

public class Ex1 {
	public static void main(String[] args) {
		
	}
}

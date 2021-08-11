package java0113;

import java.util.UUID;

/*
��ü���� ���� ��ü���� ���� 2����
1) is-a (~�̴�) : ��� ���� -> ���� ��������� ��ü�� 1��
   �������� �����̴�. -> A�� B�̴�. -> A�� B�� ��ӹ޴´�.
   ���л��� �л��̴�.
   
2) has-a (~�� ������) : ���� ���� -> ���� ��������� ��ü�� ������.
   �ڵ����� ������ ������. -> A�� B�� ������. -> A�� B�� �����Ѵ�.
   ��ĳ���ʹ� �����带 ������.
*/
// 1) ��Ӱ����� ��
class Animal { /* ... */ }
class Puppy extends Animal { /* ... */ }

// 2) ���԰����� ��
class Engine { /* ... */ }
class Car {
	private Engine engine = new Engine();
	// getter, setter �޼ҵ�
}

public class Ex1 {

	public static void main(String[] args) {
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		System.out.println(uuid.toString().length());
	} // main

}
package java0113;

/*
��ü���� ���� ��ü���� ���� 2����
1) is-a (~�̴�) ���� : ��� ���� -> ���� ��������� ��ü�� 1��
   �������� �����̴�. A�� B�̴�. A�� B�� ��ӹ޴´�.
   ���л��� �л��̴�. 
   
2) has-a (~�� ������) ���� : ���� ���� -> ���� ��������� ��ü�� ������.
   �ڵ����� ������ ������. -> A�� B�� ������. -> A�� B�� �����Ѵ�.
*/
// 1)�� ��
class Animal { /* ... */ }
class Puppy extends Animal { /* ... */ }

// 2)�� ��
class Engine { /* ... */ }
class Car {
	private Engine engine = new Engine();
	// getter, setter �޼ҵ�
}

public class Ex1 {
	public static void main(String[] args) {
		
	}
}

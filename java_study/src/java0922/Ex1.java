package java0922;

abstract class Animal {
	// �������(�ʵ�)
	int age;
	String gender;

	Animal(int age, String gender) {
		this.age = age;
		this.gender = gender;
	}

	// �޼ҵ�
	abstract void speak(); // �߻� �޼ҵ�(�޼ҵ� �����ΰ� ����. ���� ���ĸ�)
}

interface Robot {

	void guardAndRecord(); // ����Ű�� ��ȭ�ϱ� �߻�޼ҵ�
}

class Puppy extends Animal implements Robot {
	private String color;

	public Puppy() {
		super(3, "����");
		color = "���";
	}

	public Puppy(int age, String gender) {
		super(age, gender);
		color = "���";
	}

	@Override // �޼ҵ� ������
	void speak() {
		System.out.println(age + "�� " + gender + " �������� �۸� ¢�´�");
	}

	@Override
	public String toString() {

		return age + "��  " + gender + " ������";
	}

	@Override
	public void guardAndRecord() {
		System.out.println("����Ű�� ��ȭ�ϱ�");
	}
}

class Cat extends Animal {

	Cat() {
		super(2, "����");
	}

	Cat(int age, String gender) {
		super(age, gender);
	}

	@Override // �޼ҵ� ������
	void speak() {
		System.out.println(age + "�� " + gender + " ����̰� �߿� ���");
	}

	@Override
	public String toString() {
		return age + "�� " + gender + " �����";
	}

}

class Duck extends Animal {

	Duck() {
		super(1, "����");
	}

	Duck(int age, String gender) {
		super(age, gender);
	}

	@Override // �޼ҵ� ������
	void speak() {
		System.out.println(age + "�� " + gender + " ������ �в� ¢�´�");
	}
	
	@Override
	public String toString() {
		return age + "�� " + gender + " ����";
	}
}

class Vet { // ���ǻ�

//	void giveShot(Puppy puppy) { // �ֻ����
//		// ���������� �ֻ������ �������� ¢�´�.
//		puppy.speak();
//	}
//
	void giveShot(Animal animal) { // �ֻ����
		// �������� �����ؼ� ����
		animal.speak();
	}
}

public class Ex1 {
	public static void main(String[] args) {
		// Puppy ��ü�� Puppy���������� �����ؼ� �޼ҵ� ȣ��ÿ���
		// ����(�����Ͻð�) ���ε�(����)�� �߻���.
		Puppy puppy = new Puppy();
		puppy.speak(); // �۸�~

		// Puppy ��ü�� Puppy���������� �����ؼ� �޼ҵ� ȣ��ÿ���
		// �������ε� �� ����(����ð�) ���ε����� �߻���.
		Animal animal = new Puppy();
		// ....
		// animal = new Cat();
		animal.speak(); // �۸�~

		System.out.println("----------------------");

		Vet vet = new Vet();
		Puppy poodle = new Puppy();

		vet.giveShot(poodle);

		Cat cat = new Cat();
		vet.giveShot(cat);

		Duck duck = new Duck();
		vet.giveShot(duck);

		Robot robotPuppy = new Puppy();
		robotPuppy.guardAndRecord();
		Animal ani = (Animal) robotPuppy;
		ani.speak();

	} // main
}

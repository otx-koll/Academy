package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import lombok.extern.java.Log;

// JUnit : �ڹ��� �����׽�Ʈ ���� (�׽�Ʈ �����ӿ�ũ)
//   ��Ŭ���� ���� IDE�� JUnit�� ���յǾ� ����.
//   JUnit�� �׽�Ʈ �޼ҵ�� �������� void, �Ű������� ����� ��.
//   �ֳ����̼� @Test�� �޼ҵ忡 ����Ǿ�� ��.

// �׽�Ʈ���̽� Ŭ����: �׽�Ʈ�� �����ϴ� Ŭ����

/*
JUnit�� �ϳ��� �׽�Ʈ Ŭ������ �����ͼ� �׽�Ʈ�� �����ϴ� ����
1. �׽�Ʈ Ŭ�������� JUnit ���� �ֳ����̼��� ���� �޼ҵ带 ��� ã�´�.
2. @BeforAll static �޼ҵ尡 ������ ���� �ѹ� �����Ѵ�
3. �׽�Ʈ Ŭ������ ������Ʈ�� �ϳ� �����.
4. @BeforeEach �޼ҵ尡 ������ �����Ѵ�.
5. @Test �޼ҵ带 �ϳ� ȣ���ϰ� �׽�Ʈ ����� �������ش�.
6. @AfterEach �޼ҵ尡 ������ �����Ѵ�.
7. ������ @Test �޼ҵ忡 ���� 3~6���� �ݺ��Ѵ�. 
8. @AfterAll static �޼ҵ尡 ������ ���� �ѹ� �����Ѵ�.
9. ��� �׽�Ʈ�� ����� �����ؼ� �����ش�.
*/

@Log
@DisplayName("�׽�Ʈ���̽� Ŭ����")
public class MyTests {
	
	private Person person;
	
	@BeforeAll // @BeforeAll�� static �޼ҵ忡�� ���ϼ� ����
	static void setUpBeforeAll() {
		log.info("@BeforeAll - static setUpBeforeAll() ȣ���");
	}
	
	@BeforeEach
	void setUp() {
		log.info("@BeforeEach - setUp() ȣ���");
		
		person = new Person("ȫ�浿", 27, false);
	}
	
	@Test
	@DisplayName("Person ��ü �׽�Ʈ")
	void testPerson() {
		log.info("@Test - testPerson() ȣ���");
		assertFalse(person.isMarried());
	}
	
	@Disabled
	@Test  // �׽�Ʈ���̽� �޼ҵ�
	void testHelloWorld() {
		log.info("@Test - testHelloWorld() ȣ���");
		// ��ü�� ��� ���� ��
		assertEquals("Hello world!", Hello.helloWorld());
	}
	
	@Test
	void testGetNumArr() {
		log.info("@Test - testGetNumArr() ȣ���");
		int[] arr = { 10, 20, 30 };
		
		assertArrayEquals(arr, Hello.getNumArr()); // �迭��ü ���� ��
		assertNotSame(arr, Hello.getNumArr()); // ��ü �ּ� ��
	}
	
	@Test
	void testReceivePositiveNumber() {
		
		// ���ܰ�ü�� Ÿ�� ��
//		Throwable exception = assertThrows(Exception.class, () -> Hello.receivePositiveNumber(-1));
		Throwable exception = assertThrows(Exception.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				Hello.receivePositiveNumber(-1);
			}
		});
		
		// ���ܰ�ü�� �޽��� ��
		assertEquals("������ ���� �� �����ϴ�..", exception.getMessage());
	}
	
	@Test
	void testCalc() {
		log.info("@Test - testCalc() ȣ���");
		assertEquals(3, Calc.add(1, 2));
		assertEquals(5, Calc.sub(7, 2));
	}
	
	@AfterEach
	void tearDown() {
		log.info("@AfterEach - tearDown() ȣ���");
	}

	@AfterAll  // @AfterAll�� static �޼ҵ忡�� ���ϼ� ����
	static void tearDownAfterAll() {
		log.info("@AfterAll - static tearDownAfterAll() ȣ���");
	}
}





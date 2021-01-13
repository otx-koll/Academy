package java0113;

// �丮��
interface Chef {
	void cook();
}

class ChineseChef implements Chef { 
	@Override
	public void cook() {
		System.out.println("�߽� �丮�ϱ�");
	}
}

class JapaneseChef implements Chef { 
	@Override
	public void cook() {
		System.out.println("�Ͻ� �丮�ϱ�");
	}
}

class KoreanChef implements Chef { 
	@Override
	public void cook() {
		System.out.println("�ѽ� �丮�ϱ�");
	}
}

// �Ĵ�
class Restaurant {
	private Chef chef;
	
	// ���԰���� �ʿ��� ��ü�� �ܺο��� ���޹޴� ��� 2���� : ������, setter
	
	public Restaurant(Chef chef) {
		this.chef = chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
		
		// instanceof ������ : ���� ��ü�� Ÿ����
		// �����ʿ� ����� Ÿ�԰� ��ġ�ϸ� true, �ƴϸ� false
		if (chef instanceof JapaneseChef) { 
			
		}
	}
	
	// �丮�� ��ü�� �̿��ؼ� �Ĵ� �޼ҵ� ����...
}

public class Ex2 {
	public static void main(String[] args) {
		// ��ü �������� ���� : �� ������ �������� ��� ����.
		// ������ DI(Dependecy Injection) �������� ����.
		
		JapaneseChef japaneseChef = new JapaneseChef();
		
		Restaurant rest= new Restaurant(japaneseChef);
		
		KoreanChef koreanChef = new KoreanChef();
		
		rest.setChef(koreanChef);
	}
}

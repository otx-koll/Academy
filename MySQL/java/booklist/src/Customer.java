
public class Customer {
	
	// 1. ��� ����
	int cusid;
	String name;
	String address;
	String phone;
	
	public Customer() {};
	
	// 1. ������ - ��������� �ʱ�ȭ
	public Customer(int cusid, String name, String address, String phone) {
		this.cusid = cusid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	// ȭ�� ��� �޼ҵ� 3�� ��ü��
	public void printCustomer_object() {
		System.out.println("\t" + cusid + "\t" + name + "\t" + address + "\t" + phone + "\t");
	}
	
	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}

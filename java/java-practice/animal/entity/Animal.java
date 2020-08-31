package workshop.animal.entity;

public abstract class Animal {
	private int legs;
	
	public Animal() {}
	
	public Animal(int legs) {
		this.legs = legs;
	}
	
	abstract void eat();
	public void walk() {
		System.out.println("�ش� ������ "+legs+"���� �ٸ��� �Ƚ��ϴ�.");
	}
}

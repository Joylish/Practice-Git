package workshop.animal.entity;

public class Fish extends Animal implements Pet{
	private String name;
	
	public Fish() {
		super(0);
	}
	
	public Fish(String name) {
		super(0);
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void walk() {
		System.out.println("�ش� ������ �ٸ��� ��� �� �Ƚ��ϴ�.");
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
	}

}

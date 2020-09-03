package workshop.animal.entity;

public class Cat extends Animal implements Pet{
	private String name;
	
	public Cat() {
		super(4);
	}
	
	public Cat(String name) {
		super(4);
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
	public void play() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
	}

}

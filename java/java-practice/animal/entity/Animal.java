package workshop.animal.entity;

public abstract class Animal {
	private int legs;
	
	public Animal() {}
	
	public Animal(int legs) {
		this.legs = legs;
	}
	
	abstract void eat();
	public void walk() {
		System.out.println("해당 동물은 "+legs+"개의 다리로 걷습니다.");
	}
}

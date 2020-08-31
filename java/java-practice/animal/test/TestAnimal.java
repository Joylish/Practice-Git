package workshop.animal.test;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Fish;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Spider;

public class TestAnimal {

	public static void main(String[] args) {
		Fish d = new Fish();
		Cat c = new Cat("Fluffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();
		
		System.out.println("=".repeat(60));
		System.out.println("[고양이] c");
		System.out.println("[이름] "+ c.getName());
		c.walk();
		System.out.println("-".repeat(60));
		System.out.println("[고양이] p");
		System.out.println("[이름] "+ p.getName());
		c.walk();
		System.out.println("=".repeat(60));
		System.out.println("[물고기] d");
		System.out.println("[이름] "+ d.getName());
		d.walk();
		System.out.println("-".repeat(60));
		System.out.println("[물고기] a");
		System.out.println("[이름] "+ ((Fish) a).getName());
		((Fish) a).walk();
		System.out.println("=".repeat(60));
		System.out.println("[거미] e");
		((Spider) e).walk();
	}

}

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
		System.out.println("[�����] c");
		System.out.println("[�̸�] "+ c.getName());
		c.walk();
		System.out.println("-".repeat(60));
		System.out.println("[�����] p");
		System.out.println("[�̸�] "+ p.getName());
		c.walk();
		System.out.println("=".repeat(60));
		System.out.println("[�����] d");
		System.out.println("[�̸�] "+ d.getName());
		d.walk();
		System.out.println("-".repeat(60));
		System.out.println("[�����] a");
		System.out.println("[�̸�] "+ ((Fish) a).getName());
		((Fish) a).walk();
		System.out.println("=".repeat(60));
		System.out.println("[�Ź�] e");
		((Spider) e).walk();
	}

}

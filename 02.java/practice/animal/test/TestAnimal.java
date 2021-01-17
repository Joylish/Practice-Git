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
		System.out.println("���� �����");
		System.out.println("����� c �̸�: "+ c.getName());
		c.play();
		c.eat();
		c.walk();
		System.out.println("-".repeat(60));
		System.out.println("���� �����");
		System.out.println("����� p �̸�: "+ p.getName());
		((Cat) p).play();
		((Cat) p).eat();
		((Cat) p).walk();
		System.out.println("=".repeat(60));
		System.out.println("���� �����");
		System.out.println("����� p �̸�: "+ d.getName());
		d.walk();
		d.eat();
		d.play();
		System.out.println("-".repeat(60));
		System.out.println("�����");
		System.out.println("����� a �̸�: "+ ((Fish) a).getName());
		((Fish) a).walk();
		((Fish) a).eat();
		((Fish) a).play();
		System.out.println("=".repeat(60));
		System.out.println("���� �Ź� e����");
		((Spider) e).walk();
		((Spider) e).eat();
	}

}

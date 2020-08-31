package workshop.book.control;

import java.util.ArrayList;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {
	
	void modifyPrice(Publication pub) {
		if(pub instanceof Magazine) {
			pub.setPrice((int) (pub.getPrice()*0.6));
		}else if(pub instanceof Novel) {
			pub.setPrice((int) (pub.getPrice()*0.8));
		}else if(pub instanceof ReferenceBook) {
			pub.setPrice((int) (pub.getPrice()*0.9));
		}
	}
	
	void printTitle(String title){
		System.out.print("==== "+title+" ====\n");
	}
	
	public static void main(String[] args) {
		ManageBook mgr = new ManageBook();
		ArrayList <Publication> pubs = new ArrayList();
		pubs.add(new Magazine("마이크로소프트","2007-10-01", 328, 9900, "매월"));
		pubs.add(new Magazine("경영과컴퓨터","2007-10-03", 316, 9000, "매월"));
		pubs.add(new Magazine("빠삐용","2007-07-01", 396, 9800, "매월"));
		pubs.add(new Magazine("남한산성","2007-04-14", 383, 11000, "매월"));
		pubs.add(new Magazine("실용주의프로그래머","2007-01-14", 496, 25000, "매월"));
		mgr.printTitle("Book 정보 출력");
		for (Publication pub:pubs) {
			System.out.println(pub.toString());
		}
		mgr.printTitle("가격정보 변경 전");
		System.out.println(
				pubs.get(2).getTitle()
				+": "
				+pubs.get(2).getPrice());
		mgr.modifyPrice(pubs.get(2));
		mgr.printTitle("가격정보 변경 후");
		System.out.println(
				pubs.get(2).getTitle()
				+": "
				+pubs.get(2).getPrice());
	}

}

package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonManager {
	// 같은 클래스 내부에서 persons 공유
	void fillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
		persons[2] = new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542");
		persons[3] = new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223");
		persons[4] = new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333");
		persons[5] = new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934");
		persons[6] = new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932");
		persons[7] = new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939");
		persons[8] = new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202");
		persons[9] = new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832");
	}
	
	void showPerson(PersonEntity[] persons) {
		for(PersonEntity person: persons) {
			System.out.println( "[이름] "+
				person.getName() +
				"\t[성별] "+
				person.getGender()+
				"\t\t[전화번호] "+
				person.getPhone()+
				"\t[주소] "+
				person.getAddress()
			);
		}
	}

	void showPerson(PersonEntity[] persons, String name) {
		for(PersonEntity person:persons) {
			// string은 reference 타입이기 때문에 
			// == 를 사용하면 메모리 주소로 비교되어 무조건 다르다는 결과가
			// 나온다.
			if(person.getName().equals(name)) {
				System.out.println(
						"[이름] "+
						person.getName() +
						"\n[성별] "+
						person.getGender()+
						"\n[전화번호] "+
						person.getPhone()+
						"\n[주소] "+
						person.getAddress()
						);
				break;
			}
		}
	}
	
	int findByPerson(PersonEntity[] persons, char gender) {
		int cnt = 0;
		for(PersonEntity person:persons) {
			if(person.getGender() == gender) {
				cnt += 1;
			}
		}
		return cnt;
	}
	
	void printTitle(String title){
		System.out.print('\n'+title+'\n');
	}
	
	void printTitleLine(){
		System.out.println("=".repeat(60));	}
	
	void printItemLine(){
		System.out.println("-".repeat(60));
	}
	
	public static void main(String[] args) {
		PersonManager pManager = new PersonManager();
		PersonEntity[] persons = new PersonEntity[10];
		
		pManager.fillPersons(persons);
		
		pManager.printTitle("@@@ 인물 정보 조회 시스템 @@@");
		pManager.printTitleLine();
		pManager.showPerson(persons);
		System.out.println("\n성별 '여 '(은)는 "
				+pManager.findByPerson(persons, '여')
				+"입니다.");
		System.out.println("성별 '남 '(은)는 "
				+pManager.findByPerson(persons, '남')
				+"입니다.");
		pManager.printTitleLine();
		pManager.printTitle("-- 이름: '김하늘'(으)로 찾기 결과입니다. --");
		pManager.printItemLine();
		pManager.showPerson(persons, "김하늘");
	}
}

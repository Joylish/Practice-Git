package workshop.person.entity;

public class PersonEntity {
	private String name;
	private String ssn;
	private String address;
	private String phone;
	private char gender;
	
	public PersonEntity(String name, String ssn, String address, String phone){
		setName(name);
		setAddress(address);
		setPhone(phone);
		setSsn(ssn);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}
	
	// 처리 로직은 set method에서
	public void setSsn(String ssn) {
		this.ssn = ssn;
		if (ssn.charAt(6)=='1'||ssn.charAt(6)=='3') gender = '남' ;
		if (ssn.charAt(6)=='2'||ssn.charAt(6)=='4') gender = '여' ;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

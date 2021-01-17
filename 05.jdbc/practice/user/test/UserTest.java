package jdbc.user.test;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

public class UserTest {
	UserDAO dao = new UserDAO();
	
	public void getUser(String userId) {
		System.out.println("=".repeat(20)+"Get One User"+"=".repeat(20));
		System.out.println(dao.getUser(userId).toString());
	}
	
	public void getUsers() {
		System.out.println("=".repeat(20)+"Get All User"+"=".repeat(20));
		for(UserVO user: dao.getUsers()) {
			System.out.println(user.toString());
		}
	}
	
	public void addUser(String userId, String name, String gender, String city) {
		System.out.println("=".repeat(20)+"Insert User"+"=".repeat(20));
		if(dao.insertUser(new UserVO(userId, name, gender, city))>0) {
			System.out.println(userId+"���� ������ ���������� ��ϵǾ����ϴ�.");
		}else {
		System.out.println(userId+"���� ������� ���߽��ϴ�.");
		}
	}
	
	public void updateUser(String userId, String key, String value) {
		System.out.println("=".repeat(20)+"Update User ["+userId+"]"+"=".repeat(20));
		if(dao.updateUser(userId, key, value)>0) {
			System.out.println(userId+"���� ������ ���������� ����Ǿ����ϴ�.");
		}else {
		System.out.println(userId+"���� ���� ���濡 �����Ͽ����ϴ�.");
		}
	}
	
	public void removeUser(String userId) {
		System.out.println("=".repeat(20)+"Remove User ["+userId+"]"+"=".repeat(20));
		if(dao.removeUser(userId)>0) {
			System.out.println(userId+"���� ������ ���������� �����Ǿ����ϴ�.");
		}else {
		System.out.println(userId+"���� ���� ������ �����Ͽ����ϴ�.");
		}
	}
	
	public static void main(String[] args)  {
		UserTest test = new UserTest();
		test.getUser("dooly");
		test.getUsers();
		test.addUser("moong", "��", "��","����");
		test.updateUser("gogo", "city", "����");
		test.getUsers();
		test.removeUser("gogo");
		test.getUsers();
	}
}

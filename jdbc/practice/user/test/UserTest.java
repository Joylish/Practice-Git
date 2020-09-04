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
			System.out.println(userId+"님의 정보가 성공적으로 등록되었습니다.");
		}else {
		System.out.println(userId+"님을 등록하지 못했습니다.");
		}
	}
	
	public void updateUser(String userId, String key, String value) {
		System.out.println("=".repeat(20)+"Update User ["+userId+"]"+"=".repeat(20));
		if(dao.updateUser(userId, key, value)>0) {
			System.out.println(userId+"님의 정보가 성공적으로 변경되었습니다.");
		}else {
		System.out.println(userId+"님의 정보 변경에 실패하였습니다.");
		}
	}
	
	public void removeUser(String userId) {
		System.out.println("=".repeat(20)+"Remove User ["+userId+"]"+"=".repeat(20));
		if(dao.removeUser(userId)>0) {
			System.out.println(userId+"님의 정보가 성공적으로 삭제되었습니다.");
		}else {
		System.out.println(userId+"님의 정보 삭제에 실패하였습니다.");
		}
	}
	
	public static void main(String[] args)  {
		UserTest test = new UserTest();
		test.getUser("dooly");
		test.getUsers();
		test.addUser("moong", "뭉", "여","거제");
		test.updateUser("gogo", "city", "서울");
		test.getUsers();
		test.removeUser("gogo");
		test.getUsers();
	}
}

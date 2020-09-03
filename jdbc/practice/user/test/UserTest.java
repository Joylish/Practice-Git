package jdbc.user.test;

import java.util.List;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

public class UserTest {

	public static void main(String[] args)  {
		UserDAO dao = new UserDAO();
		System.out.println("=".repeat(10)+"Get One User"+"=".repeat(10));
		System.out.println(dao.getUser("dooly"));
		System.out.println("=".repeat(10)+"Get All User"+"=".repeat(10));
		System.out.println(dao.getUsers());
		System.out.println("=".repeat(10)+"Insert User"+"=".repeat(10));
		System.out.println(dao.insertUser(new UserVO("woori", "우리", "여","전라")));
		System.out.println("=".repeat(10)+"Get All User"+"=".repeat(10));
		System.out.println(dao.getUsers());
	}
}

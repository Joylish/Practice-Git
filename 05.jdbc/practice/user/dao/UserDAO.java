package jdbc.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.user.vo.UserVO;

public class UserDAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "scott";
	String password = "tiger";
	
	public UserDAO(){	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver OK");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void close(Statement stmt, Connection conn) throws SQLException{
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	// user 1명 조회
	public UserVO getUser(String userId) {
		UserVO user = null;
		String sql = "select * from users where USERID = ?";
		try {
			Connection conn = getConnection();
			
			// PreparedStatement: Statement를 상속받음
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO(
						rs.getString("userid"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getString("city"));
			}
			close(stmt, conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List<UserVO> getUsers(){
		List<UserVO> users = new ArrayList<>();
		String sql = "select * from users";
		try {
			Connection conn = getConnection();
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				users.add(new UserVO(
						rs.getString("userid"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getString("city")));
			}
			close(stmt, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	public int insertUser(UserVO user) {
		int result = -1;
		String sql = "insert into users values (?, ?, ?, ?)";
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getGender());
			stmt.setString(4, user.getCity());
			
			result = stmt.executeUpdate();
			
			if(result == 1){
                conn.commit();
            }else{
                conn.rollback();
            }
			
			close(stmt, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	// user 정보가 바뀌었을 경우
	public int updateUser(String userId, String key, String value) {
		int result = -1;
		String sql = "update users set "+ key + "= ? where userId = ?";
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.setString(2, userId);
			result = stmt.executeUpdate();
			
			if(result == 1){
                conn.commit();
            }else{
                conn.rollback();
            }
			
			close(stmt, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int removeUser(String userId) {
		int result = -1;
		String sql = "delete from users where userId = ?";
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			result = stmt.executeUpdate();
			
			if(result == 1){
                conn.commit();
            }else{
                conn.rollback();
            }
			
			close(stmt, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}

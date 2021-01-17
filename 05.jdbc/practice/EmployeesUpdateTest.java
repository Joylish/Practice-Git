package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class EmployeesUpdateTest {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "hr";
	String password = "hr";
	
	public EmployeesUpdateTest(){	
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
		System.out.println("All of Connection Close");
	}
	
	public int updateEmployee(float salary, String email) {
		int rowCount = 0;
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			StringBuilder updatebuilder = new StringBuilder("update EMPLOYEES set SALARY = ")
					.append(salary)
					.append("where EMAIL = '"+ email+"'");
			
			rowCount = stmt.executeUpdate(updatebuilder.toString());
			System.out.println("updated-row count: " +rowCount);
			
			StringBuilder selectbuilder = new StringBuilder("select * from EMPLOYEES ")
					.append("where EMAIL = '"+ email+"'");
			
			System.out.println("=".repeat(10)+"Updated Row"+"=".repeat(10));
			ResultSet rs = stmt.executeQuery(selectbuilder.toString());
			while(rs.next()) {
				System.out.println(rs.getString("first_name") + " "+ rs.getString("salary"));
			}
			System.out.println("=".repeat(31));
			close(stmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	 }
	
	public static void main(String[] args) {
		EmployeesUpdateTest test = new EmployeesUpdateTest();
		
		float salary = 6800.0F;
		String email = "DLEE";
		
		test.updateEmployee(salary, email);
	}
}

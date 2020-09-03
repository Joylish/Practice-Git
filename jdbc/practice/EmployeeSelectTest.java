package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeSelectTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			System.out.println("1. Driver Class Loading");
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver OK");
			
			System.out.println("2. Connection ����");
			// ��������: jdbc, ������������: oracle
			// ���� �Ǵ� tnsnames.ora�� dbms ���̵� Ȯ���ϱ�
			// dbms ���̵�: xe	
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn.getClass().getName());
			
			System.out.println("3. Statement ����");
			stmt = conn.createStatement();
			System.out.println(stmt.getClass().getName());
			
			System.out.println("4. ResultSet ���� - SELECT SQL ����");
			Scanner sc = new Scanner(System.in);
			System.out.print("employee �̸��� � �ܾ ������ �ֽ��ϱ�: ");
			String whatlike = sc.next();
			StringBuilder builder = new StringBuilder();
			builder
			.append("select EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_NAME ")
			.append("from EMPLOYEES e, DEPARTMENTS d ")
			.append("where e.DEPARTMENT_ID = d.DEPARTMENT_ID ")
			.append("and FIRST_NAME like '%"+whatlike+"%'")
			.append("order by EMPLOYEE_ID desc");
			String sql = builder.toString();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getClass().getName());
			/*
			 EMPLOYEE_ID                               NOT NULL NUMBER(6)
			 FIRST_NAME                                         VARCHAR2(20)
			 LAST_NAME                                 NOT NULL VARCHAR2(25)
			 EMAIL                                     NOT NULL VARCHAR2(25)
			 PHONE_NUMBER                                       VARCHAR2(20)
			 HIRE_DATE                                 NOT NULL DATE
			 JOB_ID                                    NOT NULL VARCHAR2(10)
			 SALARY                                             NUMBER(8,2)
			 COMMISSION_PCT                                     NUMBER(2,2)
			 MANAGER_ID                                         NUMBER(6)
			 DEPARTMENT_ID                                      NUMBER(4)
			 */
			while(rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String name = rs.getString("FIRST_NAME");
				Date hdate = rs.getDate("HIRE_DATE");
				String dname = rs.getString("DEPARTMENT_NAME");
				System.out.println(id+ " "+ name + " "+ hdate + " " + dname);
			}
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("5.�ʿ� object �� ���������� dbms ���� ����");
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("���� �� ����!");
		}
		
	}
}

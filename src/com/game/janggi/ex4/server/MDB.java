package com.jjanggi2.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* ���� ��������
 * 
 * create ����
 * retrieve �˻�
 * update �߰�
 * delete ����
 * 
 * sorting ����
 * index 
 * 
 * 
 * 
 */
public class MDB {

	public static void main(String[] args) {
///*		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver not found");
			e.printStackTrace();
		}
//*/		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "member", "member");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SHOW DATABASES");

			if (st.execute("SHOW DATABASES"))
				rs = st.getResultSet();

			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}
		} catch (SQLException SQLex) {
			System.out.println("SQLException: " + SQLex.getMessage());
			System.out.println("SQLState: " + SQLex.getSQLState());
		}
	}

}

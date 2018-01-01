package com.costuary.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnUtil {

	public static final String url = "jdbc:mysql://192.168.11.110:3306/Costuary";//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/XX","root","XXXX")
	public static final String name = "com.mysql.jdbc.Driver";//com.mysql.jdbc.Driver
	public static final String user = "root";
	public static final String password = "root";
	public Connection conn = null;
	public PreparedStatement pst = null;

	public ConnUtil(String sql) {

		try {
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url, user, password);//get connection
			pst = conn.prepareStatement(sql);//ready to execute
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
//			System.out.println("Debug:connecting closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

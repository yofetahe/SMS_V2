package com.fidel.sms.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connection {
	
	public static Connection getConnection(){
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3309/sms_everest_v2";
		String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url+unicode, "root", "P@55w0rd@yamget");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}			
		
		return con;
	}

}

package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase{
	public static Connection Con;
	
	public static void Connect()throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRegister","root","");
		System.out.println("Connected");
		}

}

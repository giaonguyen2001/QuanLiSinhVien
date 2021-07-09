package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.sinhVienBean;


public class dungChung {
	public static Connection cn;
	public static void ketNoi() throws Exception{
		// b1: xac dinh hqtclsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		// b2: Ket noi vao CSDL
		String url ="jdbc:sqlserver://DESKTOP-FF1278R\\SQLEXPRESS:1433;databaseName=QuanLiSinhVien;user=sa; password=123 ";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	
	

	
}

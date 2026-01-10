package util;

import java.sql.*;

public class DatabaseUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/simagym";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
    	try {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (Exception e) {
    	System.out.println("Database Gagal Terkoneksi: " + e.getMessage());
    	}
		return null;
    }
}
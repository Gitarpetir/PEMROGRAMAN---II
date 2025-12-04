package util;

import java.sql.*;

public class DatabaseHelper {
	private static final String URL = "jdbc:mysql://localhost:3306/tokobuku";
    private static final String USER = "gunawan";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
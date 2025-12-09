package util;

import java.sql.*;

//Jadi ini digunakan untuk mengkoneksikan java ke database mysql
public class DatabaseUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/tokobarang";
    private static final String USER = "gunawan";
    private static final String PASSWORD = "12345";

//Program menggunakan try - catch yang dimana program mencoba untuk mengeksekusi (try)
//Jika gagal maka program akan melakukan catch untuk mengeksekusi kesalahan atau error yang terjadi
    public static Connection getConnection() {
    	try {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (Exception e) {
    	System.out.println("Database Gagal Terkoneksi: " + e.getMessage());
    	}
		return null;
    }
}
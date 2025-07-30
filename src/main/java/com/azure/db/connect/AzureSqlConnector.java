package com.azure.db.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AzureSqlConnector {
	
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:sqlserver://127.0.0.1.database.windows.net:1433;" + "database=azure;"
				+ "encrypt=true;" + "trustServerCertificate=false;" + "loginTimeout=30;";
		String user = "root";
		String password = "admin";

		return DriverManager.getConnection(url, user, password);
	}
}
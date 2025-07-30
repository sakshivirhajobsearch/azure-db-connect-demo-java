package com.azure.db.connect;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.models.CosmosDatabaseResponse;

public class DatabaseConnectionTest {

	@Test
	void testAzureSqlConnection() {
		
		try (Connection conn = AzureSqlConnector.connect()) {
			assertNotNull(conn, "Azure SQL connection should not be null.");
			System.out.println("Connected to Azure SQL Database successfully.");
		} catch (Exception e) {
			fail("Failed to connect to Azure SQL Database: " + e.getMessage());
		}
	}

	@Test
	void testCosmosDbConnection() {
		
		try (CosmosClient client = CosmosDbConnector.connect()) {
			CosmosDatabaseResponse response = client.createDatabaseIfNotExists("azure");
			assertNotNull(response, "Cosmos DB connection should not be null.");
			System.out.println("Connected to Azure Cosmos DB successfully.");
		} catch (Exception e) {
			fail("Failed to connect to Cosmos DB: " + e.getMessage());
		}
	}
	
	@Test
	void testMySQLConnection() throws SQLException {
	    String url = "jdbc:mysql://localhost:3306/mydb";
	    String user = "root";
	    String password = "admin";

	    try (Connection conn = DriverManager.getConnection(url, user, password)) {
	        assertNotNull(conn);
	        System.out.println("MySQL connected successfully!");
	    }
	}
}
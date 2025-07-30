package com.azure.db.connect;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;

public class CosmosDbConnector {
	
	public static CosmosClient connect() {
		
		String endpoint = "<your-cosmos-endpoint>";
		String key = "<your-cosmos-key>";

		return new CosmosClientBuilder().endpoint(endpoint).key(key).consistencyLevel(ConsistencyLevel.EVENTUAL)
				.buildClient();
	}
}
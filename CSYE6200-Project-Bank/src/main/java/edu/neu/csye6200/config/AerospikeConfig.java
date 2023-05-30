package edu.neu.csye6200.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class AerospikeConfig {

    private static AerospikeClient client;

    @Singleton
    public AerospikeClient getClient(){
        client = new AerospikeClient("localhost", 3000);
        System.out.println("Connected to database....");
        return client;
    }

    @Singleton
    public AeroMapper getMapper(){
        client = new AerospikeClient("localhost", 3000);
        System.out.println("Connected to database....");
        return new AeroMapper.Builder(client).build();
    }
}

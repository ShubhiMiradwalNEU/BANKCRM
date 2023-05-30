package edu.neu.csye6200.bankui.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;


public class AerospikeConfig {

    private static AerospikeClient client;

    public static AeroMapper getMapper(){
        client = new AerospikeClient("localhost", 3000);
        System.out.println("Connected to database....");
        AeroMapper mapper = new AeroMapper.Builder(client).build();
        return mapper;
    }
}

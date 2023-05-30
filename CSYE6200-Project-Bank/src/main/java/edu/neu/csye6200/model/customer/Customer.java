package edu.neu.csye6200.model.customer;


import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test", set = "customer")
public interface Customer {

    String getId();

    void setId(String id);

}

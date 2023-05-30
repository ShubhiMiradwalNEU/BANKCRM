package edu.neu.csye6200.bankui.model.customer;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import edu.neu.csye6200.bankui.model.Person;

@AerospikeRecord(namespace = "test", set = "individual")
public class Customer extends Person implements CustomerAPI {
    @AerospikeKey
    private String id;

    public Customer() {
        super();
    }


    public Customer(String firstName, String lastname, String dob, String age, String email, String address) {
        super(firstName, lastname, dob, age, email, address);
//        int count = Integer.parseInt(id) + 1;
//        this.id = "" + count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return "Customer is a " + super.toString() + " id" + id +"\n";

    }
}

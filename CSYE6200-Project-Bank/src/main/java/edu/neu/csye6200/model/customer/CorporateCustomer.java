package edu.neu.csye6200.model.customer;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import edu.neu.csye6200.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace="test", set = "customer")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CorporateCustomer extends Person implements Customer {

    @AerospikeKey
    private String id;

    private String type;
    private String ssn;
    private String acc_date;
    private String email;
    private String phone;
    private String password;

    @Override
    public String toString() {
        return "CorporateCustomer{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}

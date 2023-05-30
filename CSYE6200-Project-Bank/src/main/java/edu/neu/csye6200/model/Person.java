package edu.neu.csye6200.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
@AerospikeRecord(namespace="test")
public class Person {

    @JsonProperty(value = "firstName")
    @AerospikeBin(name = "firstname")
    private String firstName;

    @JsonProperty(value = "lastName")
    @AerospikeBin(name = "lastname")
    private String lastName;

    @JsonProperty(value = "dateOfBirth")
    @AerospikeBin(name = "dateofbirth")
    private String dateOfBirth;

    @JsonProperty(value = "st_addr")
    @AerospikeBin(name = "st_addr")
    private String st_addr;

    @JsonProperty(value = "opt_addr")
    @AerospikeBin(name = "opt_addr")
    private String opt_addr;

    @JsonProperty(value = "zipcode")
    @AerospikeBin(name = "zipcode")
    private String zipcode;

    @JsonProperty(value = "city")
    @AerospikeBin(name = "city")
    private String city;

    @JsonProperty(value = "state")
    @AerospikeBin(name = "state")
    private String state;

    @JsonProperty(value = "country")
    @AerospikeBin(name = "country")
    private String country;
}

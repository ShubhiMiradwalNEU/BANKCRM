package edu.neu.csye6200.bankui.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace="test")
public class Person {
    @AerospikeBin(name = "firstName")
    private String firstName;
    @AerospikeBin(name = "lastName")
    private String lastname;
    @AerospikeBin(name = "dob")
    private String dob;
    @AerospikeBin(name = "age")
    private String age;
    @AerospikeBin(name = "email")
    private String email;
    @AerospikeBin(name = "address")
    private String address;

    public Person() {
    }

    public Person(String firstName, String lastname, String dob, String age, String email, String address) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.dob = dob;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person \n" +
                "firstName='" + firstName + '\'' + "\n" +
                ", lastname='" + lastname + '\'' + "\n" +
                ", dob='" + dob + '\'' + "\n" +
                ", age='" + age + '\'' + "\n" +
                ", email='" + email + '\'' + "\n" +
                ", address='" + address + '\'' + "\n";
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

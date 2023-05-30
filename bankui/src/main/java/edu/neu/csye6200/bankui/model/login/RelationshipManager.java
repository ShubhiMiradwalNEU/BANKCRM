package edu.neu.csye6200.bankui.model.login;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;



@AerospikeRecord(namespace = "test", set = "login")
public class RelationshipManager {

    @AerospikeKey
    private String id;
    @AerospikeBin(name = "username")
    private String username;
    @AerospikeBin(name = "password")
    private String password;

    @AerospikeBin(name = "firstname")
    private String firstname;

    @AerospikeBin(name = "lastname")
    private String lastname;

    @AerospikeBin(name = "dob")
    private String dateofbirth;

    @AerospikeBin(name = "acc_list")
    private String acc_list;

    @AerospikeBin(name = "num_new_acc")
    private String num_new_acc;

    @AerospikeBin(name = "num_ex_acc")
    private String num_ex_acc;

    @AerospikeBin(name = "branchid")
    private String branch_id;

    public RelationshipManager() {
    }

    @Override
    public String toString() {
        return "RelationshipManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", acc_list='" + acc_list + '\'' +
                ", num_new_acc='" + num_new_acc + '\'' +
                ", num_ex_acc='" + num_ex_acc + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAcc_list() {
        return acc_list;
    }

    public void setAcc_list(String acc_list) {
        this.acc_list = acc_list;
    }

    public String getNum_new_acc() {
        return num_new_acc;
    }

    public void setNum_new_acc(String num_new_acc) {
        this.num_new_acc = num_new_acc;
    }

    public String getNum_ex_acc() {
        return num_ex_acc;
    }

    public void setNum_ex_acc(String num_ex_acc) {
        this.num_ex_acc = num_ex_acc;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
}

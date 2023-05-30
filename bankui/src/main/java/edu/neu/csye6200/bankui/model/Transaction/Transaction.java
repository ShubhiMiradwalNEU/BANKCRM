package edu.neu.csye6200.bankui.model.Transaction;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

@AerospikeRecord(namespace = "test", set = "transaction")
public class Transaction {

    @AerospikeKey
    private String id;

    @AerospikeBin(name = "acc_id")
    private String acc_id;
    @AerospikeBin(name = "customer_id")
    private String customer_id;
    @AerospikeBin(name = "amount")
    private String amount;
    @AerospikeBin(name = "type")
    private String type;
    @AerospikeBin(name = "timestamp")
    private String timestamp;

    @AerospikeBin(name = "address")
    private String address;

    public Transaction() {
    }

    public Transaction(String acc_id, String amount, String type) {
        this.acc_id = acc_id;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        acc_id = acc_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "acc_id='" + acc_id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

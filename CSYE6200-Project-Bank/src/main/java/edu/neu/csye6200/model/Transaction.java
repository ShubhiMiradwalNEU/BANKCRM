package edu.neu.csye6200.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.tools.AeroMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test",set = "transactions")
public class Transaction implements Comparable<Transaction>{

    @AerospikeKey
    @JsonProperty(value = "id")
    private String id;

    @AerospikeBin(name = "acc_id")
    @JsonProperty(value = "acc_id")
    private String acc_id;

    @AerospikeBin(name = "cust_id")
    @JsonProperty(value = "cust_id")
    private String cust_id;

    @AerospikeBin(name = "amount")
    @JsonProperty(value = "amount")
    private String amount;

    @AerospikeBin(name = "type")
    @JsonProperty(value = "type")
    private String type;

    @AerospikeBin(name = "timestamp")
    @JsonProperty(value = "timestamp")
    private String timestamp;

    @Override
    public int compareTo(@NotNull Transaction o) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
        LocalDateTime t1 = LocalDateTime.parse(this.timestamp, formatter);
        LocalDateTime t2 = LocalDateTime.parse(o.timestamp, formatter);

        return t1.compareTo(t2);
    }

    @Override
    public String toString() {
        return id +","+timestamp +","+type+","+amount;
    }
}

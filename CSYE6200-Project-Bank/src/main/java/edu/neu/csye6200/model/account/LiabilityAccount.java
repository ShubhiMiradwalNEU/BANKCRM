package edu.neu.csye6200.model.account;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord
public class LiabilityAccount extends AccountAPI{

    @AerospikeBin(name = "min_bal")
    @JsonProperty(value = "min_bal")
    protected String min_bal;

    @AerospikeBin(name = "tran_num_lmt")
    @JsonProperty(value = "tran_num_lmt")
    protected String tran_num_lmt;

    @AerospikeBin(name = "tran_amt_lmt")
    @JsonProperty(value = "tran_amt_lmt")
    protected String tran_amt_lmt;

    @Override
    public String toString() {
        return "LiabilityAccount{" +
                "min_bal='" + min_bal + '\'' +
                ", tran_num_lmt='" + tran_num_lmt + '\'' +
                ", tran_amt_lmt='" + tran_amt_lmt + '\'' +
                "} " + super.toString();
    }
}

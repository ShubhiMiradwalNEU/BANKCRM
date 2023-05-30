package edu.neu.csye6200.model.account;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.aerospike.mapper.annotations.AerospikeReference;
import com.aerospike.mapper.tools.AeroMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.neu.csye6200.model.Transaction;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AerospikeRecord
public abstract class AccountAPI {

    @AerospikeKey
    protected String id;

    @Inject
    private AeroMapper aeroMapper;
    @AerospikeBin(name = "acc_date")
    @JsonProperty(value = "acc_date")
    protected String acc_date;

    @AerospikeBin(name = "owner")
    @JsonProperty(value = "owner")
    protected List<String> owner;

    @AerospikeBin(name = "p_ac_h")
    @JsonProperty(value = "p_ac_h")
    protected String p_ac_h;

    @AerospikeBin(name = "branch_id")
    @JsonProperty(value = "branch_id")
    protected String branch_id;

    @AerospikeBin(name = "acc_bal")
    @JsonProperty(value = "acc_bal")
    protected String acc_bal;

    @AerospikeBin(name = "tran_amt_lmt")
    @JsonProperty(value = "tran_amt_lmt")
    protected String tran_amt_lmt;

    @AerospikeBin(name = "acc_status")
    @JsonProperty(value = "acc_status")
    protected String acc_status;

    @AerospikeReference
    @JsonProperty(value = "transactions")
    @AerospikeBin(name = "transactions")
    protected List<Transaction> transactions;

//    @JsonGetter(value = "transactionList")
//    public List<Transaction> getTransactionList(){
//        return (List<Transaction>) transaction.stream().map(t -> aeroMapper.read(Transaction.class,t.getId()));
//    }

    @Override
    public String toString() {
        return "AccountAPI{" +
                "id='" + id + '\'' +
                ", acc_date='" + acc_date + '\'' +
                ", owner=" + owner +
                ", p_ac_h='" + p_ac_h + '\'' +
                ", branch_id='" + branch_id + '\'' +
                ", acc_bal='" + acc_bal + '\'' +
                ", tran_amt_lmt='" + tran_amt_lmt + '\'' +
                '}';
    }

}

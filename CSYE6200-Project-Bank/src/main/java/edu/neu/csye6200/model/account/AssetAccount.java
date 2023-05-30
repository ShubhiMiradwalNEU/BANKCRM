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
public class AssetAccount extends AccountAPI{

    @AerospikeBin(name = "max_bal")
    @JsonProperty(value = "max_bal")
    private String max_bal;

    @AerospikeBin(name = "roi")
    @JsonProperty(value = "roi")
    private String roi;

    @Override
    public String toString() {
        return "AssetAccount{" +
                "max_bal='" + max_bal + '\'' +
                ", roi='" + roi + '\'' +
                "} " + super.toString();
    }
}

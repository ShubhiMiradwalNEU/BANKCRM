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
@AerospikeRecord(namespace = "test", set = "accounts")
public class HousingLoan extends AssetAccount{

    @AerospikeBin(name = "san_amt")
    @JsonProperty(value = "san_amt")
    protected String san_amt;

    @AerospikeBin(name = "property_adr")
    @JsonProperty(value = "property_adr")
    protected String property_adr;

    @Override
    public String toString() {
        return "HousingLoan{" +
                "san_amt='" + san_amt + '\'' +
                ", property_adr='" + property_adr + '\'' +
                "} " + super.toString();
    }
}

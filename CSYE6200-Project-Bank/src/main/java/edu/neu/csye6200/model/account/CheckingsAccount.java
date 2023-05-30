package edu.neu.csye6200.model.account;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test", set = "accounts")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckingsAccount extends LiabilityAccount {

    @AerospikeBin(name = "type")
    @JsonProperty(value = "type")
    protected String type;

    @AerospikeBin(name = "rm_id")
    @JsonProperty(value = "rm_id")
    protected String rm_id;

    @AerospikeBin(name = "acc_status")
    @JsonProperty(value = "acc_status")
    protected String acc_status;

    @Override
    public String toString() {
        return "CheckingsAccount{" +
                "type='" + type + '\'' +
                ", rm_id='" + rm_id + '\'' +
                ", acc_status='" + acc_status + '\'' +
                "} " + super.toString();
    }
}

package edu.neu.csye6200.model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.neu.csye6200.model.account.AccountAPI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationshipManager extends Person{

    @AerospikeBin(name = "acc_list")
    @JsonProperty(value = "acc_list")
    private List<String> acc_list;

    @AerospikeBin(name = "num_new_acc")
    @JsonProperty(value = "num_new_acc")
    private String num_new_acc;

    @AerospikeBin(name = "num_ex_acc")
    @JsonProperty(value = "num_ex_acc")
    private String num_ex_acc;

    @AerospikeBin(name = "branch_id")
    @JsonProperty(value = "branch_id")
    private String branch_id;

}

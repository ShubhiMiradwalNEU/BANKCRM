package edu.neu.csye6200.model.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.neu.csye6200.model.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String error;
    @JsonManagedReference
    private Customer customer;
}

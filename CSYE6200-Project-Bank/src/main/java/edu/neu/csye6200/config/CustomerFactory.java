package edu.neu.csye6200.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neu.csye6200.model.customer.CorporateCustomer;
import edu.neu.csye6200.model.customer.Customer;
import edu.neu.csye6200.model.customer.IndividualCustomer;
import io.micronaut.context.annotation.Factory;

@Factory
public class CustomerFactory {

    public Customer getObject(JsonNode customer){
        String type = customer.get("type").asText("X");
        ObjectMapper mapper = new ObjectMapper();
        return switch (type) {
            case "Individual" -> mapper.convertValue(customer, IndividualCustomer.class);
            case "Corporate" -> mapper.convertValue(customer, CorporateCustomer.class);
            default -> null;
        };
    }

    public Class<? extends Customer> getType(String type) {
        return switch (type) {
            case "Individual" -> IndividualCustomer.class;
            case "Corporate" -> CorporateCustomer.class;
            default -> null;
        };
    }
}

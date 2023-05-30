package edu.neu.csye6200.controller;


import com.fasterxml.jackson.databind.JsonNode;
import edu.neu.csye6200.config.CustomerFactory;
import edu.neu.csye6200.model.customer.Customer;
import edu.neu.csye6200.model.response.CustomerResponse;
import edu.neu.csye6200.service.CustomerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.List;


@Controller("/customer")
public class CustomerController {

    private CustomerService customerService;
    private CustomerFactory customerFactory;


    @Inject
    public CustomerController(CustomerService customerService, CustomerFactory customerFactory) {
        this.customerService =  customerService;
        this.customerFactory = customerFactory;
    }

    @Post(uri = "/add",consumes = MediaType.APPLICATION_JSON)
    public CustomerResponse createCustomer(@Body JsonNode customer){
        return customerService.addCustomer(customerFactory.getObject(customer));
    }

    @Get(uri = "/get/{type}/",consumes = MediaType.APPLICATION_JSON)
    public List<? extends Customer> getAllCustomers(String type){
        return customerService.getAllCustomers(customerFactory.getType(type));
    }

    @Get(uri = "/getCustomer/{id}/",consumes = MediaType.APPLICATION_JSON)
    public Customer getCustomer(String id){
        return customerService.getCustomer(id);
    }
}

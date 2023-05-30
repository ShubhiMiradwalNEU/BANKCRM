package edu.neu.csye6200.service;

import edu.neu.csye6200.model.customer.Customer;
import edu.neu.csye6200.model.response.CustomerResponse;
import edu.neu.csye6200.repository.CustomerRepository;
import edu.neu.csye6200.util.Util;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Inject
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository =  customerRepository;
    }

    public CustomerResponse addCustomer(Customer customer){

        //TODO: add factory/business logic to create customer type
        if(customer.getId()==null || "".equals(customer.getId())){
            StringBuilder customerid= Util.getUniqueId();
            customer.setId(customerid.toString());
        }
        try {
            customerRepository.saveCustomer(customer);
        } catch (Exception e){
            e.printStackTrace();
            return new CustomerResponse(e.getMessage(),null);
        }
        return new CustomerResponse("Saved",customer);
    }

    public List<? extends Customer> getAllCustomers(Class<? extends Customer> clazz){
        //TODO: Business logic/factory to get customer Type
        return customerRepository.getAllCustomers(clazz);
    }

    public Customer getCustomer(String id) {
       return customerRepository.getCUstomer(id);
    }
}

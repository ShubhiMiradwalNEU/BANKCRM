package edu.neu.csye6200.bankui.services;

import edu.neu.csye6200.bankui.directory.CustomerDirectory;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;
import com.aerospike.mapper.tools.AeroMapper;
import com.aerospike.client.AerospikeClient;



import java.util.List;

public class CustomerService {
    private static CustomerService cs = null;


    public static CustomerService getInstance(){
        if (cs == null) {
            cs = new CustomerService();
        }

        return cs;
    }

    public String addCutomertoDirectory(CustomerAPI cust){
        Customer c = (Customer)cust;
        StringBuilder message = new StringBuilder();
        try{
            if(c.getId()==null || "".equals(c.getId())){
                StringBuilder customerid= new StringBuilder();
                for(int i=0;i<16;i++){
                    customerid.append((int) (Math.random() * 10));
                }
                c.setId(customerid.toString());
            }
            CustomerDirectory.getInstance().addCustomer(cust);
            message.append("Saved to directory successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
            message.append("Error occured " + e);
        }
        return message.toString();

    }

    public List<Customer> getCustomers() {
        return CustomerDirectory.getInstance().getAllCustomers();
    }

    public boolean deleteCustomer(String email) {
        return CustomerDirectory.getInstance().deleteCustomer(email);
    }

    public boolean updateCustomer(String email, String firstName) {
        return CustomerDirectory.getInstance().updateCustomer(email,firstName);
    }

}

package edu.neu.csye6200.bankui.factories;

import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;

public class CustomerFactory {
    private static CustomerFactory cs = null;

    public static CustomerFactory getInstance() {
        if (cs == null) {
            cs = new CustomerFactory();
        }
        return cs;
    }

    public CustomerAPI getObject(String firstName, String lastName, String dob, String age, String email, String address) {
        return new Customer(firstName,lastName,dob,age,email,address);
    }

}

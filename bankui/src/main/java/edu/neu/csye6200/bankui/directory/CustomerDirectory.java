package edu.neu.csye6200.bankui.directory;

import edu.neu.csye6200.bankui.config.AerospikeConfig;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerDirectory {
    private static CustomerDirectory customerDirectory = null;
    private static List<CustomerAPI> customerdirectorylist;

    public CustomerDirectory() {
        customerdirectorylist = new ArrayList<>();
    }

    public static CustomerDirectory getInstance() {
        // TODO Auto-generated method stub
        if (customerDirectory == null) {
            customerDirectory = new CustomerDirectory();
        }
        return customerDirectory;
    }

    public void addCustomer(CustomerAPI customer) {
        try{
            System.out.println("Adding Customer");
            customerdirectorylist.add(customer);
            System.out.println(customer);
            AerospikeConfig.getMapper().save(customer);
            System.out.println("Customer Added ");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Occurred");
        }
    }

    public List<Customer> getAllCustomers() {
        return AerospikeConfig.getMapper().query(Customer.class,null);
    }

    public boolean deleteCustomer(String email) {
        System.out.println("Deleting Customer using email");
        try{
            Iterator<Customer> itr = CustomerDirectory.getInstance().getAllCustomers().iterator();

// remove all even numbers
            while (itr.hasNext()) {
                Customer customer = itr.next();
                if (customer.getEmail().equals(email)) {
                    itr.remove();
                    AerospikeConfig.getMapper().delete(customer);
                    System.out.println("Customer Deleted");
                    return true;
//                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error while deleting " + e);
        }
        return false;
    }
    public boolean updateCustomer(String email, String firstName) {
        System.out.println("Finding USer");
        try{
            Iterator<Customer> itr = CustomerDirectory.getInstance().getAllCustomers().iterator();

// remove all even numbers
            while (itr.hasNext()) {
                Customer customer = (Customer) itr.next();
//                AerospikeConfig.getMapper().read(Customer.class, id);
                if (customer.getEmail().equals(email)) {
                    customer.setFirstName(firstName);
                    AerospikeConfig.getMapper().save(customer);
                    System.out.println("Customer Updated");
                    return true;
//                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println(" Error occured " + e);
        }
        return false;
    }

}

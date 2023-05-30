package edu.neu.csye6200.repository;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.mapper.tools.AeroMapper;
import edu.neu.csye6200.config.CustomerFactory;
import edu.neu.csye6200.model.customer.Customer;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class CustomerRepository {

    private AeroMapper aeroMapper;
    private AerospikeClient aerospikeClient;
    private CustomerFactory customerFactory;

    @Inject
    public CustomerRepository(AeroMapper aeroMapper, AerospikeClient aerospikeClient, CustomerFactory customerFactory) {
        this.aeroMapper = aeroMapper;
        this.aerospikeClient = aerospikeClient;
        this.customerFactory = customerFactory;
    }

    public void saveCustomer(Customer customer){
        try{
            aeroMapper.save(customer);
            System.out.println("Saved "+customer.toString());
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception occured");
        }
    }

    public List<? extends Customer> getAllCustomers(Class<? extends Customer> clazz){
        return aeroMapper.query(clazz,null);
    }

    public <T extends Customer> T getCUstomer(String id) {
        try{
            String type = aerospikeClient.get(null,
                    new Key("test","customer",id))
                    .getString("type");
            return (T) aeroMapper.read(customerFactory.getType(type),id);
        }catch (Exception e){
            System.out.println("Error finding customer" +e);
            e.printStackTrace();
        }
        return null;
    }
}

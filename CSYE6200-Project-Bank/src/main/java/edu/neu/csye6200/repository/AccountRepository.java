package edu.neu.csye6200.repository;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.query.Filter;
import com.aerospike.client.query.Statement;
import com.aerospike.mapper.tools.AeroMapper;
import edu.neu.csye6200.config.AccountFactory;
import edu.neu.csye6200.model.Transaction;
import edu.neu.csye6200.model.account.AccountAPI;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AccountRepository {
    private AeroMapper aeroMapper;
    private AerospikeClient aerospikeClient;
    private AccountFactory accountFactory;

    @Inject
    public AccountRepository(AeroMapper aeroMapper, AerospikeClient aerospikeClient, AccountFactory accountFactory) {
        this.aeroMapper = aeroMapper;
        this.aerospikeClient = aerospikeClient;
        this.accountFactory = accountFactory;
    }

    public void saveAccount(AccountAPI account){
        try {
            aeroMapper.save(account);
            System.out.println("Saved "+account.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception Occured here");
        }
    }

    public List<? extends AccountAPI> getAllAccount(Class<? extends AccountAPI> classtype){
        return aeroMapper.query(classtype, null);
    }

    public List<? extends AccountAPI> getCustomerAccounts(String id) {
        Statement statement = new Statement();
        statement.setNamespace("test");
        statement.setSetName("accounts");
        statement.setFilter(Filter.equal("p_ac_h",id));
        List<AccountAPI> accounts = new ArrayList<>();
        aerospikeClient.query(null,statement).forEach(keyRecord -> {
            String type = keyRecord.record.getString("type");
            String accid = keyRecord.record.getString("id");
            AccountAPI accountAPI = aeroMapper
                    .read(accountFactory.getType(type),
                            accid);
            if(accountAPI.getTransactions()!=null){
                accountAPI.getTransactions().sort(null);
            }
            accounts.add(accountAPI);
        });
        return accounts;
    }

    public Transaction saveTransaction(Transaction transaction) {
        try {
            AccountAPI accountAPI = getCustomerAccounts(transaction.getCust_id())
                    .stream().filter(a -> a.getId().equals(transaction.getAcc_id())).findFirst().get();
            double bal;
            if(accountAPI.getAcc_bal()==null){
                accountAPI.setAcc_bal("0");
            }
            bal = Double.parseDouble(accountAPI.getAcc_bal());


            double amt = Double.parseDouble(transaction.getAmount());
            if("Credit".equals(transaction.getType())){

                accountAPI.setAcc_bal(String.format("%.2f",amt+bal));
            } else if ("Debit".equals(transaction.getType())) {

                accountAPI.setAcc_bal(String.format("%.2f",bal-amt));
            }
            if(accountAPI.getTransactions()!=null){
                accountAPI.getTransactions().add(transaction);
            } else {
                accountAPI.setTransactions(List.of(transaction));
            }
            aeroMapper.save(transaction);
            saveAccount(accountAPI);
            return transaction;
        } catch (Exception e) {
            System.out.println("Error adding transaction "+e);
            e.printStackTrace();
        }
        return null;
    }

    public List<Transaction> getTransactions(String id) {
       Record record = aerospikeClient.get(null,new Key("test","accounts",id));

       return aeroMapper.read(accountFactory.getType(record.getString("type")),id).getTransactions();
    }
}

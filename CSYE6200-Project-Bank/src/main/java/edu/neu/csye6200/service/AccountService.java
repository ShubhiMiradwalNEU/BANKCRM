package edu.neu.csye6200.service;

import edu.neu.csye6200.model.Transaction;
import edu.neu.csye6200.model.account.AccountAPI;
import edu.neu.csye6200.model.response.AccountResponse;
import edu.neu.csye6200.repository.AccountRepository;
import edu.neu.csye6200.util.FileUtil;
import edu.neu.csye6200.util.Util;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class AccountService {

    private final AccountRepository accountRepository;

    @Inject
    public AccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse addAccount(AccountAPI account){
        account.setAcc_status("New");
        String bal = account.getAcc_bal()!=null? account.getAcc_bal() : "0";
        account.setAcc_bal(bal);
        if(account.getId()==null || "".equals(account.getId())){
            StringBuilder customerid = Util.getUniqueId();
            account.setId(customerid.toString());
        }
        try{
            accountRepository.saveAccount(account);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new AccountResponse(e.getMessage(), null);
        }
        return new AccountResponse("Saved", account);
    }



    public List<? extends AccountAPI> getAllAccounts(Class<? extends AccountAPI> classtype){

        return accountRepository.getAllAccount(classtype);

    }


    public List<? extends AccountAPI> getCustomerAccounts(String id) {
        return accountRepository.getCustomerAccounts(id);
    }

    public Transaction addTransaction(Transaction transaction) {
        transaction.setId(Util.getUniqueId().toString());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        transaction.setTimestamp(timestamp.toString());
        return accountRepository.saveTransaction(transaction);
    }


    public void generateStatement(String id, String fileName) {
        List<Transaction> transactionList = accountRepository.getTransactions(id);
        transactionList.sort(null);
        List<String> csvlines = new ArrayList<>();
        transactionList.forEach(transaction -> {
            csvlines.add(transaction.toString());
        });
        FileUtil.writeStringsToFile(csvlines,fileName);
    }
}

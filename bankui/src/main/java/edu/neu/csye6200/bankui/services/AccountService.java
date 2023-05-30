package edu.neu.csye6200.bankui.services;

import edu.neu.csye6200.bankui.directory.AccountDirectory;
import edu.neu.csye6200.bankui.directory.CustomerDirectory;
import edu.neu.csye6200.bankui.factories.AccountFactory;
import edu.neu.csye6200.bankui.model.Transaction.Transaction;
import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;

import java.util.Iterator;
import java.util.List;

public class AccountService {
    private static AccountService as = null;

    public static AccountService getInstance() {
        if (as == null){
            as = new AccountService();
        }
        return as;
    }

    public String addAccounttoDirectory(String p_ac_h, String type, String accbal){
        String message = "";
        try{
            Iterator<Customer> itr = CustomerDirectory.getInstance().getAllCustomers().iterator();

// remove all even numbers
            while (itr.hasNext()) {
                Customer customer = (Customer) itr.next();

                if (customer.getFirstName().equals(p_ac_h)) {

                    Account acc = AccountFactory.getInstance().getObject(p_ac_h,type,accbal);
                    if(acc.getId()==null || "".equals(acc.getId())){
                        StringBuilder accid= new StringBuilder();
                        for(int i=0;i<16;i++){
                            accid.append((int) (Math.random() * 16));
                        }
                        acc.setId(accid.toString());

                    }
                    AccountDirectory.getInstance().addAccount(acc);
                    message = "Account added";
                    break;
                }
                message = "Account was not added";

            }
            return message.toString();

//            message.append("Saved to directory successfully");
        }
        catch(Exception e) {
            e.printStackTrace();
            message  = "Error occured " + e;
        }
        return message.toString();

    }

    public List<Account> getAccount() {
        return AccountDirectory.getInstance().getAllAccounts();
    }

    public boolean deleteAccount(String p_ac_h) {
        return AccountDirectory.getInstance().deleteAccount(p_ac_h);
    }

    public boolean updateAccount(String p_ac_h,String owners) {
        return AccountDirectory.getInstance().updateAccount(p_ac_h,owners);
    }
}

package edu.neu.csye6200.bankui.services;

import edu.neu.csye6200.bankui.directory.AccountDirectory;
import edu.neu.csye6200.bankui.directory.CustomerDirectory;
import edu.neu.csye6200.bankui.factories.AccountFactory;
import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.model.customer.Customer;

import java.util.Iterator;
import java.util.List;

public class RMService {
    private static RMService as = null;

    public static RMService getInstance() {
        if (as == null){
            as = new RMService();
        }
        return as;
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



//    public boolean updateAccount(String email, String firstName) {
//        return AccountDirectory.getInstance().updateAccount(email,firstName);
//    }



}

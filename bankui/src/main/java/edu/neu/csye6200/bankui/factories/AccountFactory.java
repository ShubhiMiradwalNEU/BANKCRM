package edu.neu.csye6200.bankui.factories;

import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;
import edu.neu.csye6200.bankui.model.login.LoginCredentials;

public class AccountFactory {
    private static AccountFactory cs = null;

    public static AccountFactory getInstance() {
        if (cs == null) {
            cs = new AccountFactory();
        }
        return cs;
    }

    public Account getObject(String p_ac_h,String type, String accbal) {
        return new Account(p_ac_h,accbal,type, LoginCredentials.getInstance().getRm().getUsername());
    }

}

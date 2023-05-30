package edu.neu.csye6200.bankui.directory;

import edu.neu.csye6200.bankui.config.AerospikeConfig;
import edu.neu.csye6200.bankui.controller.AccountController;
import edu.neu.csye6200.bankui.model.Transaction.Transaction;
import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;
import edu.neu.csye6200.bankui.model.login.LoginCredentials;
import edu.neu.csye6200.bankui.model.login.RelationshipManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountDirectory {
    private static AccountDirectory ad = null;
    private static List<Account> accountdirectoryList;



    public AccountDirectory() {
        accountdirectoryList = new ArrayList<>();
    }

    public static AccountDirectory getInstance(){
        if (ad == null) {
            ad = new AccountDirectory();
        }
        return ad;
    }

    public void addAccount(Account acc) {
        try{
            System.out.println("Adding Account");
            accountdirectoryList.add(acc);
            System.out.println(acc);
            AerospikeConfig.getMapper().save(acc);

            int num =  LoginCredentials.getInstance().getRm().getNum_new_acc() != null ? Integer.parseInt(LoginCredentials.getInstance().getRm().getNum_new_acc()) + 1 : 1;
            LoginCredentials.getInstance().getRm().setNum_new_acc(num + "");
            AerospikeConfig.getMapper().save(LoginCredentials.getInstance().getRm());
            System.out.println(AerospikeConfig.getMapper().read(RelationshipManager.class, LoginCredentials.getInstance().getRm().getId()));
            System.out.println("Account Added ");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Occurred");
        }
    }

    public List<Account> getAllAccounts() {
        return AerospikeConfig.getMapper().query(Account.class,null);
    }

    public boolean deleteAccount(String p_ac_h) {
        System.out.println("Deleting Customer using Account ID");
        try{
            Iterator<Account> itr = AerospikeConfig.getMapper().query(Account.class,null).iterator();
// remove all even numbers
            while (itr.hasNext()) {
                Account acc = (Account) itr.next();

                if (acc.getP_ac_h().equals(p_ac_h)) {
                    itr.remove();
                    AerospikeConfig.getMapper().delete(acc);
                    int num =  LoginCredentials.getInstance().getRm().getNum_ex_acc() != null ? Integer.parseInt(LoginCredentials.getInstance().getRm().getNum_ex_acc()) + 1 : 1;
                    LoginCredentials.getInstance().getRm().setNum_ex_acc(num + "");
                    AerospikeConfig.getMapper().save(LoginCredentials.getInstance().getRm());

                    System.out.println("Account Deleted");

                    return true;
//                    break;
                }
            }
//            return false;
        }
        catch (Exception e) {
            System.out.println("Error while deleting " + e);
        }
        return false;
    }

    public boolean updateAccount(String p_ac_h,String owners) {
        System.out.println("Finding Account");
        try{
            Iterator<Account> itr = AerospikeConfig.getMapper().query(Account.class,null).iterator();
            while (itr.hasNext()) {
                Account acc = itr.next();
                if (acc.getP_ac_h().equals(p_ac_h)) {
                    List<String> oldOwners = acc.getOwners();
                    oldOwners.add(owners);
                    acc.setOwners(oldOwners);
                    AerospikeConfig.getMapper().save(acc);
                    System.out.println("Account Updated");
                    return true;
//                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println(" Error occurred ");
        }
        return false;
    }




//TODO: unclear on which fields to update

//    public boolean updateCustomer(String email, String firstName) {
//        System.out.println("Finding USer");
//        try{
//            Iterator<Account> itr = accountdirectoryList.iterator();
//
//// remove all even numbers
//            while (itr.hasNext()) {
//                Account acc = itr.next();
//                if (acc.getId().equals(id)) {
//                    acc.setFirstName(firstName);
//                    System.out.println("Customer Updated");
//                    return true;
////                    break;
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println(" Error occured ");
//        }
//        return false;
//    }


}

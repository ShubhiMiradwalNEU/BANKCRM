package edu.neu.csye6200.bankui.directory;

import edu.neu.csye6200.bankui.config.AerospikeConfig;
import edu.neu.csye6200.bankui.model.Transaction.Transaction;
import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.services.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class TransactionDirectory {
    private static TransactionDirectory ad = null;
    List<Transaction> transactionDirectoryList= new ArrayList<Transaction>();

    public static TransactionDirectory getInstance(){
        if (ad == null) {
            ad = new TransactionDirectory();
        }
        return ad;
    }

    public void createTransaction(String prim_ach,String debit_amt,String type) {
        try{
            System.out.println("Adding Transaction");
            Transaction tran = new Transaction(prim_ach,debit_amt,type);
            if(tran.getId()==null || "".equals(tran.getId())){
                StringBuilder tranID= new StringBuilder();
                for(int i=0;i<16;i++){
                    tranID.append((int) (Math.random() * 16));
                }
                tran.setId(tranID.toString());
            }
            transactionDirectoryList.add(tran);
            System.out.println(tran);
            AerospikeConfig.getMapper().save(tran);
            List<Account> acclist = AccountService.getInstance().getAccount();
            for (Account acc: acclist) {
                if (acc.getP_ac_h().equals(prim_ach)){
                    List<String> l = acc.getTran_ids() == null ? new ArrayList<>() : acc.getTran_ids();
                    l.add(tran.getId());
                    acc.setTran_ids(l);
                    int n = acc.getAcc_bal() != null ? Integer.parseInt(acc.getAcc_bal()) - Integer.parseInt(debit_amt) : 100;
                    acc.setAcc_bal(n+"");
                    AerospikeConfig.getMapper().save(acc);
                    break;
                }
            }
            System.out.println("Transaction added ");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error Occurred");
        }
    }

    public void createCreditTransaction(String prim_ach,String credit_amt,String type) {
        try{
            System.out.println("Adding Transaction");
            Transaction tran = new Transaction(prim_ach,credit_amt,type);
            if(tran.getId()==null || "".equals(tran.getId())){
                StringBuilder tranID= new StringBuilder();
                for(int i=0;i<16;i++){
                    tranID.append((int) (Math.random() * 16));
                }
                tran.setId(tranID.toString());
            }
            transactionDirectoryList.add(tran);
            System.out.println(tran);
            AerospikeConfig.getMapper().save(tran);
            List<Account> acclist = AccountService.getInstance().getAccount();
            for (Account acc: acclist) {
                if (acc.getP_ac_h().equals(prim_ach)){
                    List<String> l = acc.getTran_ids() == null ? new ArrayList<>() : acc.getTran_ids();
                    l.add(tran.getId());
                    acc.setTran_ids(l);
                    int n = acc.getCredits_used() != null ? Integer.parseInt(acc.getCredits_used()) + Integer.parseInt(credit_amt) : Integer.parseInt(credit_amt);
                    acc.setCredits_used(n + "");
                    AerospikeConfig.getMapper().save(acc);
                    break;
                }
            }
            System.out.println("Transaction added ");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error Occurred");
        }
    }


    public List<Transaction> viewTransaction(String p_ac_h) {
        System.out.println("Finding Account");
        List<Transaction> list = AerospikeConfig.getMapper().query(Transaction.class,null);
        list.stream().filter( e-> e.getAcc_id().equals(p_ac_h)).toList();
        System.out.println(list);
        Transaction trans = null;
        try{
            return list;


        }
        catch (Exception e){
            System.out.println(" Error occurred ");
        }
        return list;
    }

}

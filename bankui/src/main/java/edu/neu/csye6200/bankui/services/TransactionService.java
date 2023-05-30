package edu.neu.csye6200.bankui.services;

import edu.neu.csye6200.bankui.directory.AccountDirectory;
import edu.neu.csye6200.bankui.directory.TransactionDirectory;
import edu.neu.csye6200.bankui.model.Transaction.Transaction;

import java.util.List;

public class TransactionService {
    private static TransactionService as = null;

    public static TransactionService getInstance() {
        if (as == null){
            as = new TransactionService();
        }
        return as;
    }



    public void createTransactions(String prim_ach,String debit_amt,String type) {
      TransactionDirectory.getInstance().createTransaction(prim_ach,debit_amt,type);
    }

    public void createcreditTransactions(String prim_ach,String credit_amt,String type) {
        TransactionDirectory.getInstance().createCreditTransaction(prim_ach,credit_amt,type);
    }

    public List<Transaction> viewTransaction(String acc_id) {
        return TransactionDirectory.getInstance().viewTransaction(acc_id);
    }
}

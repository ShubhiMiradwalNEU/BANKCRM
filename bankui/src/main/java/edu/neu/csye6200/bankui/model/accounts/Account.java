package edu.neu.csye6200.bankui.model.accounts;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import edu.neu.csye6200.bankui.directory.CustomerDirectory;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AerospikeRecord(namespace = "test", set = "account")
public class Account {
    @AerospikeKey
    private String id;
    @AerospikeBin(name = "acc_date")
    private String acc_date;
    @AerospikeBin(name = "owners")
    private List<String> owners;

    @AerospikeBin(name = "p_ac_h")
    private String p_ac_h;
    @AerospikeBin(name = "branch_id")
    private String branch_id = "boston001";
    @AerospikeBin(name = "min_bal")
    private String min_bal = "100";
    @AerospikeBin(name = "acc_bal")
    private String acc_bal = "100";
    @AerospikeBin(name = "tran_num_lmt")
    private String tran_num_lmt = "10";
    @AerospikeBin(name = "tran_amt_lmt")
    private String tran_amt_lmt = "100"; //dollars
    @AerospikeBin(name = "type")
    private String type;
    @AerospikeBin(name = "rm_id")
    private String rm_id = "1771"; // logged in rm id
    @AerospikeBin(name = "tran_ids")
    private List<String> tran_ids;
    @AerospikeBin(name = "acc-status")
    private String acc_status;

    public String getCredits_used() {
        return credits_used;
    }

    public void setCredits_used(String credits_used) {
        this.credits_used = credits_used;
    }

    @AerospikeBin(name = "credit")
    private String credits_used;

    public Account() {
    }

    public Account(String p_ac_h, String acc_bal, String type, String rm_id) {
//        this.id = (Integer.parseInt(id) + 1) + "";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        acc_date = formatter.format(date);
        this.owners = new ArrayList<>();
        owners.add(p_ac_h);
        this.p_ac_h = p_ac_h;
        if (Integer.parseInt(acc_bal) >= Integer.parseInt(min_bal)){
            this.acc_bal = acc_bal;
        }
        this.rm_id = rm_id;

        this.type = type;
        this.acc_status = "new";

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcc_date() {
        return acc_date;
    }

    public void setAcc_date(String acc_date) {
        this.acc_date = acc_date;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    public String getP_ac_h() {
        return p_ac_h;
    }

    public void setP_ac_h(String p_ac_h) {
        this.p_ac_h = p_ac_h;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getMin_bal() {
        return min_bal;
    }

    public void setMin_bal(String min_bal) {
        this.min_bal = min_bal;
    }

    public String getAcc_bal() {
        return acc_bal;
    }

    public void setAcc_bal(String acc_bal) {
        this.acc_bal = acc_bal;
    }

    public String getTran_num_lmt() {
        return tran_num_lmt;
    }

    public void setTran_num_lmt(String tran_num_lmt) {
        this.tran_num_lmt = tran_num_lmt;
    }

    public String getTran_amt_lmt() {
        return tran_amt_lmt;
    }

    public void setTran_amt_lmt(String tran_amt_lmt) {
        this.tran_amt_lmt = tran_amt_lmt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRm_id() {
        return rm_id;
    }

    public void setRm_id(String rm_id) {
        this.rm_id = rm_id;
    }

    public List<String> getTran_ids() {
        return tran_ids;
    }

    public void setTran_ids(List<String> tran_ids) {
        this.tran_ids = tran_ids;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", acc_date='" + acc_date + '\'' +
                ", owners=" + owners +
                ", p_ac_h='" + p_ac_h + '\'' +
                ", branch_id='" + branch_id + '\'' +
                ", min_bal='" + min_bal + '\'' +
                ", acc_bal='" + acc_bal + '\'' +
                ", tran_num_lmt='" + tran_num_lmt + '\'' +
                ", tran_amt_lmt='" + tran_amt_lmt + '\'' +
                ", type='" + type + '\'' +
                ", rm_id='" + rm_id + '\'' +
                ", tran_ids=" + tran_ids +
                ", acc_status='" + acc_status + '\'' +
                '}';
    }

}

package edu.neu.csye6200.bankui.directory;

import edu.neu.csye6200.bankui.config.AerospikeConfig;
import edu.neu.csye6200.bankui.model.login.LoginCredentials;
import edu.neu.csye6200.bankui.model.login.RelationshipManager;

import java.util.Iterator;
import java.util.List;

public class LoginDirectory {
    private static LoginDirectory ld = null;
//    private RelationshipManager rm;

    public static LoginDirectory getInstance() {
        if (ld == null){
            ld = new LoginDirectory();

        }
        return ld;
    }

    public boolean getAuthentication(RelationshipManager rm){

        //Logic to check in database
        List<RelationshipManager> rmlist = LoginDirectory.getInstance().getAllCredentials();
        System.out.println(rmlist);
        try{
            Iterator<RelationshipManager> itr = rmlist.iterator();

            while (itr.hasNext()) {
                RelationshipManager manager = itr.next();
                if(manager.getUsername().equals(rm.getUsername()) && manager.getPassword().equals(rm.getPassword())){
                    System.out.println("RM ID" + manager.getId());
                    LoginCredentials.getInstance().setRm(manager);
                    System.out.println("Logged in");
                    return true;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error while deleting " + e);
        }
        return false;
    }

    public List<RelationshipManager> getAllCredentials() {
        System.out.println("Listy from database ");
        System.out.println(AerospikeConfig.getMapper().query(RelationshipManager.class,null));
        return AerospikeConfig.getMapper().query(RelationshipManager.class, null);
    }
}

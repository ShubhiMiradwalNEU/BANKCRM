package edu.neu.csye6200.bankui.factories;

import edu.neu.csye6200.bankui.model.login.RelationshipManager;

public class RelationshipManagerFactory {
    private static RelationshipManagerFactory rmf = null;
    private RelationshipManager rm;

    public static RelationshipManagerFactory getInstance() {
        if (rmf == null){
            rmf = new RelationshipManagerFactory();
        }
        return rmf;
    }

    public RelationshipManager getObject(String username, String password) {
        rm = new RelationshipManager();
        rm.setUsername(username);
        rm.setPassword(password);
        return rm;
    }


}

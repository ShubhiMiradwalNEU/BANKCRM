package edu.neu.csye6200.bankui.services;

import edu.neu.csye6200.bankui.directory.LoginDirectory;
import edu.neu.csye6200.bankui.factories.RelationshipManagerFactory;
import edu.neu.csye6200.bankui.model.login.RelationshipManager;

public class LoginService {
    private static LoginService ls = null;


    public LoginService() {
    }

    public static LoginService getInstance() {
      if (ls == null ){
          ls = new LoginService();
      }
      return ls;
    }

    public boolean getAuthentication(String username , String password) {
        RelationshipManager rm = RelationshipManagerFactory.getInstance().getObject(username,password);
        if (!LoginDirectory.getInstance().getAuthentication(rm)){
            return false;
        }
        return true;
    }
}

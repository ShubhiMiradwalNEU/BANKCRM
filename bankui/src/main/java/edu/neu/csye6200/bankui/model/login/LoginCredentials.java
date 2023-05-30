package edu.neu.csye6200.bankui.model.login;


public class LoginCredentials {
    RelationshipManager rm;

    private static LoginCredentials lc = null;

    public LoginCredentials() {
    }

    public static LoginCredentials getInstance() {
        if (lc == null){
            lc = new LoginCredentials();
        }
        return lc;
    }

    public void setRm(RelationshipManager rm) {
        this.rm = rm;
    }

    public RelationshipManager getRm() {
        return  rm;
    }


}

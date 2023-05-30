package edu.neu.csye6200.bankui.controller;

import edu.neu.csye6200.bankui.HelloApplication;
import edu.neu.csye6200.bankui.model.accounts.Account;
import edu.neu.csye6200.bankui.services.AccountService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class AccountController {

    @FXML
    private TextField primaryAccountHolder;
    @FXML
    private VBox pnItems;
    @FXML
    private  TextField typeAccount;
    @FXML
    private TextField accBal;
    @FXML
    private Label viewAccountResult;
    @FXML
    private TextField updateAccountPrimAchField;
    @FXML
    private TextField updateAccountOwnersField;
    @FXML
    private Label resultUpdateAccountText;
    @FXML
    private TextField deleteAccountPrimaryAccountHolderField;
    @FXML
    private Label resultDeleteAccountText;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private void showAlert(Alert.AlertType alertType,  String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    @FXML
    protected void onaddAccountButtonClick() {
        String primaryAccHolder = primaryAccountHolder.getText().trim();
        String type = typeAccount.getText().trim();
        String acc_bal = accBal.getText().trim();

        //Validations
        if(primaryAccHolder.isEmpty() || !primaryAccHolder.matches("^[a-zA-Z]+")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter correct Primary Account Holder");
            return;
        }
        if(type.isEmpty() || !type.matches("^[A-Z]+")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter Account type");
            return;
        }
        if(acc_bal.isEmpty() || !acc_bal.matches("\\d+")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter Account Balance");
            return;
        }

        AccountService.getInstance().addAccounttoDirectory(primaryAccHolder,type,acc_bal);

        showAlert(Alert.AlertType.CONFIRMATION,  "Account Added Successfully!", "Welcome to your account" + primaryAccHolder);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws Exception {
        Parent root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));

            root = fxmlLoader.load(); //getClass().getResource("hello-view.fxml")
            System.out.println(root == null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onViewButtonClick() {
        Label[] node = new Label[10];
        List<Account> list = AccountService.getInstance().getAccount();
        int i = 0;
            for (Account c : list) {
                if (i < 10) {
                    node[i] = new Label("" + c);
                    node[i].setLayoutX(200);
                    node[i].setLayoutY(200);
                    node[i].setWrapText(true);
                    System.out.println(i);
                    pnItems.getChildren().add(node[i]);
                    i++;
                }
            }
//        viewAccountResult.setText(AccountService.getInstance().getAccount().toString());
    }

    @FXML
    protected void onUpdateAccountButtonClick() {
        String prim_ach = updateAccountPrimAchField.getText().trim();
        String owners = updateAccountOwnersField.getText().trim();
        AccountService.getInstance().updateAccount(prim_ach,owners);
        resultUpdateAccountText.setText(AccountService.getInstance().getAccount().toString());
    }

    @FXML
    protected void onDeleteAccountButtonClick() {
        String prim_ach = deleteAccountPrimaryAccountHolderField.getText().trim();
        StringBuilder sb = new StringBuilder();
        sb.append("Printing old list \n");
        sb.append(AccountService.getInstance().getAccount());
        if (AccountService.getInstance().deleteAccount(prim_ach)) {
            sb.append("=========================================\n");
            sb.append("Account Deleted \n");
            sb.append("Printing list of Accounts \n");
            sb.append(AccountService.getInstance().getAccount());
            resultDeleteAccountText.setText(sb.toString());
        }
    }

}

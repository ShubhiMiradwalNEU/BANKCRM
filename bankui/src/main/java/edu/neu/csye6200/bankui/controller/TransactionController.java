package edu.neu.csye6200.bankui.controller;

import edu.neu.csye6200.bankui.HelloApplication;
import edu.neu.csye6200.bankui.services.AccountService;
import edu.neu.csye6200.bankui.services.TransactionService;
import edu.neu.csye6200.bankui.model.Transaction.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TransactionController {
    @FXML
    private TextField readTransactionPrimaryAccountField;

    @FXML
    private TextField CreateDebitTransactionPrimaryAccountField;

    @FXML
    private TextField CreateCreditTransactionPrimaryAccountField;


    @FXML
    private Label resultCreateCreditTransactionText;


    @FXML
    private TextField CreateDebitAmountTransaction;


    @FXML
    private Label resultCreateDebitAmountTransaction;

    @FXML
    private Label resultCreateDebitTransactionText;

    @FXML
    private Label resultReadTransactionText;


    private Stage stage;
    private Scene scene;
    private Parent root;


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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onCreateCreditTransactionButtonClick(ActionEvent event) throws Exception {
        String prim_ach = CreateDebitTransactionPrimaryAccountField.getText().trim();
        String credit = CreateDebitAmountTransaction.getText().trim();
        String type = "Credit";
        StringBuilder sb = new StringBuilder();
        TransactionService.getInstance().createcreditTransactions(prim_ach, credit, type);

    }

    public void onCreateDebitTransactionButtonClick(ActionEvent event) throws Exception {
        String prim_ach = CreateDebitTransactionPrimaryAccountField.getText().trim();
        String debit_amt = CreateDebitAmountTransaction.getText().trim();
        String type = "Debit";
        StringBuilder sb = new StringBuilder();
        TransactionService.getInstance().createTransactions(prim_ach, debit_amt, type);

    }


    @FXML
    protected void onReadTransactionButtonClick() {
        String prim_ach = readTransactionPrimaryAccountField.getText().trim();
        StringBuilder sb = new StringBuilder();
       // sb.append("Printing old list \n");
       sb.append(TransactionService.getInstance().viewTransaction(prim_ach));
       resultReadTransactionText.setText(sb.toString());

    }
}


package edu.neu.csye6200.bankui.controller;

import edu.neu.csye6200.bankui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("addCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onAddAccountButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("addAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onViewAccountButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("viewAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onUpdateAccountButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("updateAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onDeleteAccountButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("deleteAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onUpdateButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("updateCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onViewButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("viewCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onDeleteButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("deleteCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onViewReport(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("ViewReport.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onCreateTransactionButtonClick(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("createTransaction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onReadTransactionButtonClick(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("readTransaction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setMaximized(true);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    public void onCreateTransactionButtonClick(ActionEvent event) throws Exception {
//        Parent root = FXMLLoader.load(HelloApplication.class.getResource("createTransaction.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    public void onReadTransactionButtonClick(ActionEvent event) throws Exception {
//        Parent root = FXMLLoader.load(HelloApplication.class.getResource("readTransaction.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}

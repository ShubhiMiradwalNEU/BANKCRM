package edu.neu.csye6200.bankui.controller;

import com.aerospike.client.Log;
import edu.neu.csye6200.bankui.HelloApplication;
import edu.neu.csye6200.bankui.directory.AccountDirectory;
import edu.neu.csye6200.bankui.directory.CustomerDirectory;
import edu.neu.csye6200.bankui.factories.CustomerFactory;
import edu.neu.csye6200.bankui.model.customer.Customer;
import edu.neu.csye6200.bankui.model.customer.CustomerAPI;
import edu.neu.csye6200.bankui.model.login.LoginCredentials;
import edu.neu.csye6200.bankui.model.login.RelationshipManager;
import edu.neu.csye6200.bankui.services.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CustomerController {


    //    private Label welcomeText;
    @FXML
    private VBox pnItems = null;
    @FXML
    private TextField emailField;
    @FXML
    private TextField deleteCustomerEmailField;
    @FXML
    private Label viewCustomerResult;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;

    @FXML
    private TextField dateofbirthField;

    @FXML
    private TextField addressField;

    @FXML
    private Label resultText;

    @FXML
    private Label resultDeleteCustomerText;
    @FXML
    private TextField updateCustomerEmailField;
    @FXML
    private TextField updateCustomerFirstNameField;

    @FXML
    private Label resultUpdateCustomerText;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label viewReportResult;

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }


    @FXML
    private Label test;

    @FXML
    protected void onSendButtonClick() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String dob = dateofbirthField.getText();


        if (firstName.isEmpty() || !firstName.matches("^[a-zA-Z]+")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter correct First Name");
            return;
        }
        if (lastName.isEmpty() || !lastName.matches("^[a-zA-Z]+")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter correct Last Name");
            return;
        }
        if (email.isEmpty() || !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter correct Email");
            return;
        }
        if (address.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter Address");
            return;
        }
        if (dob.isEmpty() || !dob.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter correct DOB in YYYY-MM-DD format");
            return;
        }


        showAlert(Alert.AlertType.CONFIRMATION, "Customer Added Successful!", "Welcome " + firstName + " " + lastName);


        //TODO: Validations

        // TODO: Service Layer call
        calltoServicelayer(firstName, lastName, email, address, dob);


    }

    private void calltoServicelayer(String firstName, String lastName, String email, String address, String dob) {
        LocalDate curDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int age = Period.between(date, curDate).getYears();
        String ageOld = "" + age;

        CustomerAPI cust = CustomerFactory.getInstance().getObject(firstName,lastName,dob,ageOld,email,address);
        CustomerService.getInstance().addCutomertoDirectory(cust);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) {
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
    protected void onUpdateButtonClick() {
        String email = updateCustomerEmailField.getText().trim();
        String firstName = updateCustomerFirstNameField.getText().trim();
        CustomerService.getInstance().updateCustomer(email, firstName);
        resultUpdateCustomerText.setText(CustomerService.getInstance().getCustomers().toString());


    }

    @FXML
    protected void onDeleteButtonClick() {
        String email = deleteCustomerEmailField.getText().trim();
        StringBuilder sb = new StringBuilder();
        sb.append("Printing old list \n");
        sb.append(CustomerService.getInstance().getCustomers());
        if (CustomerService.getInstance().deleteCustomer(email)) {
            sb.append("=========================================\n");
            sb.append("Customer Deleted \n");
            sb.append("Printing list of customers \n");
            sb.append(CustomerService.getInstance().getCustomers());
            resultDeleteCustomerText.setText(sb.toString());
        }
    }

    @FXML
//<<<<<<< Updated upstream
//<<<<<<< Updated upstream
    protected void onviewReportButtonClick() throws IOException {
        StringBuilder sb = new StringBuilder();
        RelationshipManager rm = LoginCredentials.getInstance().getRm();
        sb.append("Accounts Created: " + rm.getNum_new_acc() + "\n");
        sb.append("Accounts Deleted: " + rm.getNum_ex_acc() + "\n");

        viewReportResult.setText(sb.toString());

    }

    @FXML
        protected void onviewButtonClick () throws Exception{
//        test.setText(CustomerService.getInstance().getCustomers().toString());
//            Node[] node = new Node[10];
//            List<Customer> list = CustomerService.getInstance().getCustomers();
//            int i = 0;
//            for (Customer c : list) {
//                if (i < 10) {
//                    node[i] = FXMLLoader.load(HelloApplication.class.getResource("Item.fxml"));
//                    System.out.println(node[i]);
//                    pnItems.getChildren().add(node[i]);
//                    i++;
//                }
//            }
        viewCustomerResult.setText(CustomerService.getInstance().getCustomers().toString());
//>>>>>>> Stashed changes
        }

    }








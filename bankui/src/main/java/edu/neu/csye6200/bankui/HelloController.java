package edu.neu.csye6200.bankui;

import edu.neu.csye6200.bankui.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label invalidLoginCredentials;

    @FXML
    private TextField loginUsernameTextField;

    @FXML
    private PasswordField loginPasswordPasswordField;
    private Stage stage;
    private Scene scene;
    private Parent root;

//

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws Exception {
        String username = loginUsernameTextField.getText().trim();
        String password = loginPasswordPasswordField.getText().trim();

        if (!LoginService.getInstance().getAuthentication(username,password)){
            invalidLoginCredentials.setText(" Invalid Credentials ");
            return;
        }



        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
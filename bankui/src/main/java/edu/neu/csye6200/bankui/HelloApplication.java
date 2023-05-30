package edu.neu.csye6200.bankui;

import edu.neu.csye6200.bankui.config.AerospikeConfig;
import edu.neu.csye6200.bankui.model.login.RelationshipManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setTitle("XYZ Bank!");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        RelationshipManager rm = new RelationshipManager();
        rm.setUsername("rm1");
        rm.setPassword("abc");
        rm.setId("uuid");
        AerospikeConfig.getMapper().save(rm);
        launch();
    }
}
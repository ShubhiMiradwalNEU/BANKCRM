module edu.neu.csye6200.bankui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.object.mapper;
    requires aerospike.client;

    opens edu.neu.csye6200.bankui.model.login to java.object.mapper;
    opens edu.neu.csye6200.bankui.controller to javafx.fxml;
    opens edu.neu.csye6200.bankui.model.accounts to java.object.mapper;
    opens edu.neu.csye6200.bankui.model to java.object.mapper;
    opens edu.neu.csye6200.bankui.model.customer to java.object.mapper;
    opens edu.neu.csye6200.bankui to javafx.fxml;
    opens edu.neu.csye6200.bankui.model.Transaction to java.object.mapper;
    exports edu.neu.csye6200.bankui;
}
module com.mycompany.botanyhub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;

    opens com.mycompany.botanyhub to javafx.fxml;
    exports com.mycompany.botanyhub;
    exports com.mycompany.botanyhub.User;
    opens com.mycompany.botanyhub.User to javafx.fxml;
    exports com.mycompany.botanyhub.Controller;
    opens com.mycompany.botanyhub.Controller to javafx.fxml;
}

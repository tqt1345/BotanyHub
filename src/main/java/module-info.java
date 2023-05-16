module com.mycompany.botanyhub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.botanyhub to javafx.fxml;
    exports com.mycompany.botanyhub;
    exports User;
    opens User to javafx.fxml;
}

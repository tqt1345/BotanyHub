module com.mycompany.botanyhub {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.botanyhub to javafx.fxml;
    exports com.mycompany.botanyhub;
}

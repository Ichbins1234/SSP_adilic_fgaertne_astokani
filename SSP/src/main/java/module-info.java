module com.example.ssp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ssp to javafx.fxml;
    exports com.example.ssp;
}
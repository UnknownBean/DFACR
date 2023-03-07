module com.unknownbean.dfacr {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.unknownbean.dfacr to javafx.fxml;
    exports com.unknownbean.dfacr;
}

module com.profeco.interfaz {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.profeco.interfaz to javafx.fxml;
    exports com.profeco.interfaz;
    requires com.fasterxml.jackson.core;
    requires jackson.databind;
    
    
}

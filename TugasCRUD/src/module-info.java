module TugasCRUD {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; 
    requires java.base; 
    
    opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml; 
    opens model to javafx.base; 
}

module ProjekUAS {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;
    requires java.base; 
    requires java.desktop;
    requires transitive javafx.base;
    requires transitive javafx.graphics;
    
    opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml; 
    opens model to javafx.base; 
    
    exports controller;
    exports model;
    exports service;
    exports util;
    
}

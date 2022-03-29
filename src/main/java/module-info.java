module appli.ininity {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens appli.ininity to javafx.fxml;
    exports appli.ininity;
    exports appli.ininity.controler;
    opens appli.ininity.controler to javafx.fxml;
}
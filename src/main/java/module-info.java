module es.juliogtrenard.encuestajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.juliogtrenard.encuestajavafx to javafx.fxml;
    exports es.juliogtrenard.encuestajavafx;
}
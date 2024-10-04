package es.juliogtrenard.encuestajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {
    @FXML
    private CheckBox chkDeporte;

    @FXML
    private ListView<Label> lstDeporte;
}
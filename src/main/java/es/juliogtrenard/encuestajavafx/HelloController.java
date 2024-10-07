package es.juliogtrenard.encuestajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private CheckBox chkDeporte;

    @FXML
    private ListView<Label> lstDeporte;

    @FXML
    private Slider sliderCompras;

    @FXML
    private Slider sliderTv;

    @FXML
    private Slider sliderCine;

    @FXML
    private void initialize() {
        habilitarLista();
        tooltips();
    }

    @FXML
    public void cerrarVentana(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void habilitarLista() {
        lstDeporte.setDisable(true);

        chkDeporte.selectedProperty().addListener((observable, oldValue, newValue) -> {
            lstDeporte.setDisable(!newValue);
        });
    }

    @FXML
    private void tooltips() {
        Tooltip tooltipDeporte = new Tooltip("Marca el deporte que más te gusta.");
        Tooltip tooltipCompras = new Tooltip("Indica del 1 al 10 cuánto te gusta ir de compras.");
        Tooltip tooltipTv = new Tooltip("Indica del 1 al 10 cuánto te gusta ver televisión.");
        Tooltip tooltipCine = new Tooltip("Indica del 1 al 10 cuánto te gusta ir al cine.");

        lstDeporte.setTooltip(tooltipDeporte);
        sliderCompras.setTooltip(tooltipCompras);
        sliderTv.setTooltip(tooltipTv);
        sliderCine.setTooltip(tooltipCine);
    }
}
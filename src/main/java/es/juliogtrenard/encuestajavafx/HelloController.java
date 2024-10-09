package es.juliogtrenard.encuestajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;

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
    private TextField txtProfesion;

    @FXML
    private TextField txtNumHermanos;

    @FXML
    private ComboBox<String> cbEdad;

    @FXML
    private ToggleGroup rbGroup;

    @FXML
    private void initialize() {
        habilitarLista();
        tooltips();
    }

    @FXML
    public void mostrarDatos(ActionEvent actionEvent) {
        DecimalFormat df = new DecimalFormat("#.#");

        String mensajeErrores = "";

        String profesion = txtProfesion.getText();

        int numHermanos = 0;

        String edad = cbEdad.getSelectionModel().getSelectedItem();

        RadioButton rbSeleccionado = (RadioButton) rbGroup.getSelectedToggle();

        String rbValue = rbSeleccionado.getText();

        String deporte = "";

        double compras = sliderCompras.getValue();

        double tv = sliderTv.getValue();

        double cine = sliderCine.getValue();

        if(profesion.isEmpty()) {
            mensajeErrores += "Debes introducir tu profesión.\n";
        }

        try {
            numHermanos = Integer.parseInt(txtNumHermanos.getText());
        } catch (NumberFormatException e) {
           mensajeErrores += "El campo 'Nº de hermanos' debe ser numérico.\n";
        }

        if(chkDeporte.isSelected()) {
            try {
                deporte = lstDeporte.getSelectionModel().getSelectedItem().getText();
            } catch(NullPointerException e) {
                mensajeErrores += "Debes seleccionar un deporte.\n";
            }
        }

        if(mensajeErrores.isEmpty()) {
            String mensaje = "Profesión: " + profesion + "\n" +
                    "Nº de hermanos: " + numHermanos + "\n" +
                    "Edad: " + edad + "\n" +
                    "Sexo: " + rbValue + "\n" +
                    "Deporte que practica: " + deporte + "\n" +
                    "Grado de afición a las compras: " + df.format(compras) + "\n" +
                    "Grado de afición a ver la televisión: " + df.format(tv) + "\n" +
                    "Grado de afición a ir al cine: " + df.format(cine);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensaje);
            alerta.setHeaderText(null);
            alerta.setTitle("Información de la encuesta:");
            alerta.showAndWait();
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR, mensajeErrores);
            alerta.setHeaderText(null);
            alerta.setTitle("Errores en la encuesta:");
            alerta.showAndWait();
        }
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
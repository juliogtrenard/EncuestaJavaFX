package es.juliogtrenard.encuestajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * Controlador principal para la aplicación de una encuesta.
 * Esta clase maneja la lógica de la interfaz de usuario y los eventos de la encuesta.
 */
public class HelloController {
    /** Checkbox para indicar si se practica deporte. */
    @FXML
    private CheckBox chkDeporte;

    /** Lista de deportes disponibles para seleccionar. */
    @FXML
    private ListView<Label> lstDeporte;

    /** Slider para indicar el grado de afición a las compras. */
    @FXML
    private Slider sliderCompras;

    /** Slider para indicar el grado de afición a ver la televisión. */
    @FXML
    private Slider sliderTv;

    /** Slider para indicar el grado de afición a ir al cine. */
    @FXML
    private Slider sliderCine;

    /** Campo de texto para introducir la profesión. */
    @FXML
    private TextField txtProfesion;

    /** Campo de texto para introducir el número de hermanos. */
    @FXML
    private TextField txtNumHermanos;

    /** Combo box para seleccionar el rango de edad. */
    @FXML
    private ComboBox<String> cbEdad;

    /** Grupo de botones de radio para seleccionar el sexo. */
    @FXML
    private ToggleGroup rbGroup;

    /**
     * Inicializa el controlador. Este método se llama automáticamente
     * después de que se haya cargado el archivo FXML.
     * Llama a los métodos habilitarLista() y tooltips()
     */
    @FXML
    private void initialize() {
        habilitarLista();
        tooltips();
    }

    /**
     * Muestra los datos recopilados de la encuesta.
     * Valida la entrada y muestra una alerta con la información o los errores.
     *
     * @param actionEvent El evento que desencadena esta acción.
     */
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

    /**
     * Cierra la ventana de la aplicación.
     *
     * @param event El evento que desencadena esta acción.
     */
    @FXML
    public void cerrarVentana(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    /**
     * Habilita o deshabilita la lista de deportes basándose en el estado del checkbox.
     */
    @FXML
    private void habilitarLista() {
        lstDeporte.setDisable(true);

        chkDeporte.selectedProperty().addListener((observable, oldValue, newValue) -> {
            lstDeporte.setDisable(!newValue);
        });
    }

    /**
     * Configura los tooltips para varios elementos de la interfaz de usuario.
     */
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
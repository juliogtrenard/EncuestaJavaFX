package es.juliogtrenard.encuestajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX para realizar una encuesta.
 * Esta clase extiende la clase Application de JavaFX y configura el escenario principal.
 */
public class HelloApplication extends Application {
    /**
     * El método start para que la aplicación comience a ejecutarse.
     *
     * @param stage el escenario principal para esta aplicación, sobre el cual se puede establecer la escena de la aplicación.
     * @throws IOException si no se puede cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);
        stage.setTitle("Encuesta");
        stage.setScene(scene);

        stage.setMinWidth(600);
        stage.setMinHeight(500);

        stage.show();
    }

    /**
     * El punto de entrada principal para todas las aplicaciones JavaFX.
     * Se llama desde el método main para iniciar la aplicación JavaFX.
     *
     * @param args los argumentos de línea de comandos pasados a la aplicación.
     */
    public static void main(String[] args) {
        launch();
    }
}
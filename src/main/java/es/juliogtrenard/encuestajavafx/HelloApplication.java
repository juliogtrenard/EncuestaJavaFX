package es.juliogtrenard.encuestajavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
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

    public static void main(String[] args) {
        launch();
    }
}
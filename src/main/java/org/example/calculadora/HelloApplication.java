package org.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase {@code HelloApplication} extiende de {@link javafx.application.Application} y es la clase principal
 * para lanzar la aplicación JavaFX de la calculadora.
 * <p>
 * Carga el archivo FXML y muestra la interfaz gráfica de la calculadora.
 */
public class HelloApplication extends Application {

    /**
     * El método {@code start} es el punto de entrada principal para la aplicación JavaFX.
     * Configura el escenario principal y carga el archivo FXML que define la interfaz de la calculadora.
     *
     * @param stage el escenario principal en el que se mostrará la aplicación
     * @throws IOException si ocurre algún error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/calculadora/calculadora-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // Tamaño adecuado para la calculadora
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * El método principal {@code main} es el punto de partida de la aplicación.
     * <p>
     * Llama a {@code launch()} para iniciar la aplicación JavaFX.
     *
     * @param args argumentos de la línea de comandos (no se utilizan en esta aplicación)
     */
    public static void main(String[] args) {
        launch();
    }
}

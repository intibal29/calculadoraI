package org.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

public class HelloApplication {

    @FXML
    private TextField primernumero;

    @FXML
    private TextField segundonumero;

    @FXML
    private RadioButton suma;

    @FXML
    private RadioButton resta;

    @FXML
    private RadioButton multiplicacion;

    @FXML
    private RadioButton division;

    @FXML
    private TextField resultado;

    private ToggleGroup operaciones;

    @FXML
    public void initialize() {
        // Agrupamos los RadioButtons para que sólo uno pueda estar seleccionado
        operaciones = new ToggleGroup();
        suma.setToggleGroup(operaciones);
        resta.setToggleGroup(operaciones);
        multiplicacion.setToggleGroup(operaciones);
        division.setToggleGroup(operaciones);
    }

    // Método que se ejecuta cuando se selecciona alguna operación
    @FXML
    public void calcular(ActionEvent event) {
        // Obtenemos los números
        double num1 = Double.parseDouble(primernumero.getText());
        double num2 = Double.parseDouble(segundonumero.getText());
        double res = 0;

        // Verificamos cuál radio button está seleccionado
        if (suma.isSelected()) {
            res = num1 + num2;
        } else if (resta.isSelected()) {
            res = num1 - num2;
        } else if (multiplicacion.isSelected()) {
            res = num1 * num2;
        } else if (division.isSelected()) {
            res = num1 / num2;
        }

        // Mostramos el resultado
        resultado.setText(String.valueOf(res));
    }
}

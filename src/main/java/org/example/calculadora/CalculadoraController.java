package org.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

public class CalculadoraController {

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
        // Agrupar los RadioButtons para que solo uno pueda estar seleccionado a la vez
        operaciones = new ToggleGroup();
        suma.setToggleGroup(operaciones);
        resta.setToggleGroup(operaciones);
        multiplicacion.setToggleGroup(operaciones);
        division.setToggleGroup(operaciones);
    }

    // Este método se ejecutará cuando el usuario seleccione una operación
    @FXML
    public void calcular(ActionEvent event) {
        try {
            // Obtener los números ingresados por el usuario
            double num1 = Double.parseDouble(primernumero.getText());
            double num2 = Double.parseDouble(segundonumero.getText());
            double res = 0;

            // Determinar cuál operación se seleccionó y realizar el cálculo
            if (suma.isSelected()) {
                res = num1 + num2;
            } else if (resta.isSelected()) {
                res = num1 - num2;
            } else if (multiplicacion.isSelected()) {
                res = num1 * num2;
            } else if (division.isSelected()) {
                // Manejar la división por cero
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    resultado.setText("Error: División por cero");
                    return;
                }
            }

            // Mostrar el resultado
            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada inválida");
        }
    }
}

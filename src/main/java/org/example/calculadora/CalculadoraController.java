package org.example.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

/**
 * La clase {@code CalculadoraController} maneja la lógica de la calculadora simple,
 * permitiendo realizar operaciones básicas como suma, resta, multiplicación y división
 * a través de una interfaz gráfica controlada por FXML.
 */
public class CalculadoraController {

    /** Campo de texto para ingresar el primer número */
    @FXML
    private TextField primernumero;

    /** Campo de texto para ingresar el segundo número */
    @FXML
    private TextField segundonumero;

    /** RadioButton para seleccionar la operación de suma */
    @FXML
    private RadioButton suma;

    /** RadioButton para seleccionar la operación de resta */
    @FXML
    private RadioButton resta;

    /** RadioButton para seleccionar la operación de multiplicación */
    @FXML
    private RadioButton multiplicacion;

    /** RadioButton para seleccionar la operación de división */
    @FXML
    private RadioButton division;

    /** Campo de texto para mostrar el resultado de la operación */
    @FXML
    private TextField resultado;

    /** Agrupa los RadioButtons para que solo se pueda seleccionar una operación a la vez */
    private ToggleGroup operaciones;

    /**
     * Método de inicialización que se ejecuta cuando el controlador es cargado.
     * <p>
     * Agrupa los RadioButtons {@code suma}, {@code resta}, {@code multiplicacion} y {@code division}
     * en un {@link ToggleGroup} para garantizar que solo se seleccione una operación a la vez.
     */
    @FXML
    public void initialize() {
        operaciones = new ToggleGroup();
        suma.setToggleGroup(operaciones);
        resta.setToggleGroup(operaciones);
        multiplicacion.setToggleGroup(operaciones);
        division.setToggleGroup(operaciones);
    }

    /**
     * Método que se ejecuta cuando se selecciona una operación y se presiona el botón de calcular.
     * <p>
     * Realiza la operación seleccionada (suma, resta, multiplicación o división)
     * utilizando los valores ingresados en {@code primernumero} y {@code segundonumero}.
     * <p>
     * Si se selecciona división y el segundo número es cero, muestra un mensaje de error en el campo {@code resultado}.
     * Si los números ingresados no son válidos, también muestra un mensaje de error.
     *
     * @param event el evento que dispara el cálculo
     */
    @FXML
    public void calcular(ActionEvent event) {
        try {
            double num1 = Double.parseDouble(primernumero.getText());
            double num2 = Double.parseDouble(segundonumero.getText());
            double res = 0;

            if (suma.isSelected()) {
                res = num1 + num2;
            } else if (resta.isSelected()) {
                res = num1 - num2;
            } else if (multiplicacion.isSelected()) {
                res = num1 * num2;
            } else if (division.isSelected()) {
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    resultado.setText("Error: División por cero");
                    return;
                }
            }

            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            resultado.setText("Error: Entrada inválida");
        }
    }
}

package com.example.tipcalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Slider percentSlider;

    @FXML
    private Label percentID;

    @FXML
    private TextField amountID;

    @FXML
    private TextField tipID;

    @FXML
    private TextField totalID;
    @FXML
    public void initialize() {
        percentSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                percentID.setText(String.format("%.0f%%", newValue.doubleValue()));
            }
        });
    }
    @FXML
    public void onButtonClick(){
        try {
            double amount = Double.parseDouble(amountID.getText());
            double percent = percentSlider.getValue();
            double tip = amount * (percent / 100);
            double total = amount + tip;
            tipID.setText(String.format("%.2f", tip));
            totalID.setText(String.format("%.2f", total));
        } catch (NumberFormatException e) {
            amountID.setText("Invalid Input");
            tipID.setText("");
            totalID.setText("");
        }
    }
}
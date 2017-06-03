
package pl.sahee;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;

public class Controller {

    @FXML
    RadioButton celciusFrom;
    @FXML
    RadioButton fahrenheitFrom;
    @FXML
    RadioButton kelvinFrom;
    @FXML
    RadioButton celciusTo;
    @FXML
    RadioButton fahrenheitTo;
    @FXML
    RadioButton kelvinTo;
    @FXML
    TextField valTextField;
    @FXML
    TextField output;

    @FXML
    private void initialize() {
        selectFirstValue();
        initActions();
    }

    private void selectFirstValue() {
        celciusTo.setSelected(true);
        celciusFrom.setSelected(true);

        valTextField.setText("0");
        output.setText("");
    }

    private void initActions() {
        valTextField.setOnKeyReleased(event -> {
            convertData();
        });

        celciusTo.setOnMouseClicked(event -> convertData());
        celciusFrom.setOnMouseClicked(event -> convertData());
        kelvinTo.setOnMouseClicked(event -> convertData());
        kelvinFrom.setOnMouseClicked(event -> convertData());
        fahrenheitFrom.setOnMouseClicked(event -> convertData());
        fahrenheitTo.setOnMouseClicked(event -> convertData());
    }

    private void convertData() {
        try {
            double degreeFrom = Double.valueOf(valTextField.getText());
            double degreeTo = 0;
            String unit="";

            if  (celciusFrom.isSelected() && celciusTo.isSelected()) {
                unit=" °C";
                output.setText(String.valueOf(degreeFrom+unit));
            } else if(kelvinFrom.isSelected() && kelvinTo.isSelected()) {
                unit=" K";
                output.setText(String.valueOf(degreeFrom+unit));
            } else if (fahrenheitFrom.isSelected() && fahrenheitTo.isSelected()) {
                unit=" °F";
                output.setText(String.valueOf(degreeFrom+unit));
            } else {

                if (celciusFrom.isSelected() && kelvinTo.isSelected()) {
                    degreeTo = degreeFrom + 273.15;
                        unit=" K";
                } else if (kelvinFrom.isSelected() && fahrenheitTo.isSelected()) {
                    degreeTo = (degreeFrom * (9 / 5)) - 459.67;
                        unit=" °F";
                } else if (kelvinFrom.isSelected() && celciusTo.isSelected()) {
                    degreeTo = degreeFrom - 273.15;
                        unit=" °C";
                } else if (fahrenheitFrom.isSelected() && celciusTo.isSelected()) {
                    degreeTo = (degreeFrom - 32) / 1.8;
                        unit=" °C";
                } else if (celciusFrom.isSelected() && fahrenheitTo.isSelected()) {
                    degreeTo = (degreeFrom * (9 / 5)) + 32;
                        unit=" °F";
                } else if (fahrenheitFrom.isSelected() && kelvinTo.isSelected()) {
                    degreeTo = (degreeFrom + 459.67) / 1.8;
                        unit=" K";
                }
                
                output.setText(String.format("%.2f", degreeTo)+unit);
            }
        } catch (Exception ex) {
            output.setText("Input is not valid");
        }
    }

}

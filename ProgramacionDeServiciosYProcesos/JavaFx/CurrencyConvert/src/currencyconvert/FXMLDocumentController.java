/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconvert;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 *
 * @author Miguel
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Text text;
    @FXML
    private TextField textField;
    @FXML
    private ChoiceBox<String> choise;
    private ObservableList<String> items;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = FXCollections.observableArrayList();
        items.addAll("EUR>USD", "EUR>GBP", "USD>EUR",
                "USD>GBP", "GBP>EUR", "GBP>USD");

        choise.setItems(items);
        choise.getSelectionModel().select(0);
        choise.getSelectionModel()
                .selectedIndexProperty()
                .addListener((e) -> this.changeTextLabel());
    }
    @FXML
    private void changeText(KeyEvent event) {
        this.changeTextLabel();
    }

    private void changeTextLabel() {
        switch (choise.getSelectionModel().getSelectedItem()) {
            case "EUR>USD":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) * 1.1, 2));
                break;
            case "EUR>GBP":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) * 0.8));
                break;
            case "USD>EUR":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) / 1.1));
                break;
            case "USD>GBP":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) * 0.7));
                break;
            case "GBP>EUR":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) / 0.8));
                break;
            case "GBP>USD":
                text.setText(String.format("%.2f", Double.parseDouble(textField.getText()) / 0.7));
                break;
        }
    }
}

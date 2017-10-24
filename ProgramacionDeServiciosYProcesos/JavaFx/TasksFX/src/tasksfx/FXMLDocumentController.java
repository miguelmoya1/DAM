package tasksfx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * 
 * @author Miguel Moya Ortega
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField task;
    @FXML
    private Button deleteTask;
    @FXML
    private Button addTask;
    @FXML
    private Button save;
    @FXML
    private ListView<String> list;

    private ObservableList<String> items;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        items = FXCollections.observableArrayList();
        deleteTask = new Button();
        addTask = new Button();
        save = new Button();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("tasks.txt"))) {
            reader.lines().forEach(line -> items.add(line));
            list.setItems(items);
        } catch (FileNotFoundException e) {
            label.setText("No se ha podido leer el fichero");
        } catch (IOException e) {
            label.setText("No se ha podido leer el fichero");
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        items.remove(list.getFocusModel().getFocusedItem());
    }

    @FXML
    private void add(ActionEvent event) {
        items.add(task.getText());
        label.setText("Task added!");
    }

    @FXML
    private void save(ActionEvent event) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                    new FileWriter("tasks.txt")))) {
            items.forEach(e -> writer.println(e));
            label.setText("Tasks saved!");
        } catch (FileNotFoundException e) {
            label.setText("No se ha podido leer el fichero");
        } catch (IOException e) {
            label.setText("No se ha podido leer el fichero");
        }
    }
}

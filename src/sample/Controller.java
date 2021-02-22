package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ComboBox<String> comboBox_ezafeh = new ComboBox<>();
    @FXML
    ComboBox<String> comboBox_bardasht = new ComboBox<>();
    @FXML
    ComboBox<String> comboBox_entaghal = new ComboBox<>();
    @FXML
    ComboBox<String> comboBox_daryaft = new ComboBox<>();
    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox_ezafeh.setItems(listrz);
        comboBox_bardasht.setItems(listrz);
        comboBox_entaghal.setItems(listrz);
        comboBox_daryaft.setItems(listrz);
    }
}

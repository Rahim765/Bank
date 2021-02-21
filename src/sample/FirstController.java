package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Code.Customer;
import sample.Code.SignUp;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    PrintWriter printWriter = null;
    BufferedReader bufferedReader = null;

    @FXML
    TextField signup_name;
    @FXML
    TextField signup_num;
    @FXML
    TextField signup_cost;
    @FXML
    Label warning;
    @FXML
    ComboBox<String> arz_signup = new ComboBox<>();
    @FXML
    ComboBox<String> arz_search = new ComboBox<>();
    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان");

    public void signup(ActionEvent actionEvent){
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", true)));
            Customer customer = new Customer(signup_name.getText(),signup_num.getText(),signup_cost.getText());
            SignUp.sabt_name(customer.getName(),customer.getNumber(),customer.getCost(), warning);
            signup_name.setText("");
            signup_num.setText("");
            signup_cost.setText("");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arz_signup.setItems(listrz);
        arz_search.setItems(listrz);
    }
}

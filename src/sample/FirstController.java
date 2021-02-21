package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Code.Customer;
import sample.Code.SignUp;

import javax.swing.*;
import java.io.*;

public class FirstController {
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



}

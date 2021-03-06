package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    ComboBox<String> arz_signup ;
    @FXML
    TableView table = new TableView();
    @FXML
    TableColumn<Customer , String> name;
    @FXML
    TableColumn<Customer , String> number;
    @FXML
    TableColumn<Customer , String> mablagh;
    @FXML
    TableColumn<Customer , String> arz;


    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان");
    ObservableList<Customer> list_customer;
    public void signup(ActionEvent actionEvent){
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", true)));
            Customer customer = new Customer(signup_name.getText(),signup_num.getText(),signup_cost.getText(),arz_signup.getValue());
             new  SignUp().sabt_name(customer.getName(),customer.getNumber(),customer.getCost(), warning, arz_signup.getValue(), "Signup.txt");
            signup_name.setText("");
            signup_num.setText("");
            signup_cost.setText("");
            setlist();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Customer , String>("name"));
        number.setCellValueFactory(new PropertyValueFactory<Customer , String>("number"));
        mablagh.setCellValueFactory(new PropertyValueFactory<Customer , String>("cost"));
        arz.setCellValueFactory(new PropertyValueFactory<Customer , String>("arzCost"));
        setlist();
        arz_signup.setItems(listrz);
    }

    public void setlist(){
        list_customer = FXCollections.observableArrayList();
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Signup.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                list_customer.add(new Customer(s[0], s[1], s[2], s[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            table.setItems(list_customer);
        }
    }






}

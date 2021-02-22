package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Code.Customer;
import sample.Code.SignUp;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class BController implements Initializable {
    PrintWriter printWriter = null;
    BufferedReader bufferedReader = null;
    @FXML
    TableView table;
    @FXML
    TextField name;
    @FXML
    TextField number;
    @FXML
    TextField mablagh;
    @FXML
    ComboBox<String> arz;
    @FXML
    Button signup;
    @FXML
    Label  warning;
    @FXML
    TableColumn<Customer , String> name2;
    @FXML
    TableColumn<Customer , String> number2;
    @FXML
    TableColumn<Customer , String> mablagh2;
    @FXML
    TableColumn<Customer , String> arz2;
    ObservableList<Customer> list_customer;
    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان");

    public void sabt(ActionEvent actionEvent) {
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Badehkar.txt", true)));
            Customer customer = new Customer(name.getText(),number.getText(),mablagh.getText(), arz.getValue());
            new SignUp().sabt_name(customer.getName(),customer.getNumber(),customer.getCost(), warning, arz.getValue(), "Badehkar.txt");
            name.setText("");
            number.setText("");
            mablagh.setText("");
            setlist();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setlist(){
        list_customer = FXCollections.observableArrayList();
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Badehkar.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split(" ");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name2.setCellValueFactory(new PropertyValueFactory<Customer , String>("name"));
        number2.setCellValueFactory(new PropertyValueFactory<Customer , String>("number"));
        mablagh2.setCellValueFactory(new PropertyValueFactory<Customer , String>("cost"));
        arz2.setCellValueFactory(new PropertyValueFactory<Customer , String>("arzCost"));
        setlist();
        arz.setItems(listrz);
    }
}

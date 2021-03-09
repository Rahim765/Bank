package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @FXML
    TextField namee;
    @FXML
    TextField numbere;
    @FXML
    TextField mablaghe;
    @FXML
    ComboBox<String> arze;
    @FXML
    Button ezafeh;
    @FXML
    TextField namet;
    @FXML
    TextField numbert;
    @FXML
    TextField mablaght;
    @FXML
    ComboBox<String> arzt;
    @FXML
    Button tasfiah;
    @FXML
    TextField filter;

    ObservableList<Customer> list_customer;
    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان", "یورو" , "کالدار" );


    public void search(){
        filter.setPromptText("Filter");
        filter.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (filter.getText().equals("")){
                    setlist();
                }
                ObservableList<Customer> list_tarakonesh;
                list_tarakonesh = FXCollections.observableArrayList();
                BufferedReader bufferedReader= null;
                try {
                    bufferedReader = new BufferedReader(new FileReader("Badehkar.txt"));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] s = line.split("@");
                        if (s[0].contains(filter.getText())){
                            list_tarakonesh.add(new Customer(s[0], s[1], s[2], s[3]));
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    table.setItems(list_tarakonesh);
                }
            }

        });
    }
    public void sabt(ActionEvent actionEvent) {
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Badehkar.txt", true)));
            Customer customer = new Customer(name.getText(),number.getText(),mablagh.getText(), arz.getValue());
            new SignUp().sabt_name(customer.getName(),customer.getNumber(),customer.getCost(), warning, arz.getValue(), "Badehkar.txt");
            String tarakonesh ="";
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();
            tarakonesh= name.getText()+"@"+number.getText()+"@"+mablagh.getText()+"@"+arz.getValue()+"@"+df.format(dateobj)+"@"+"دریافت بدهی"+"\n";
            PrintWriter printWriter2 = null;
            printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
            printWriter2.print(tarakonesh);
            printWriter2.flush();
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

    public void setEzafeh(ActionEvent actionEvent){
        String x="";
        BufferedReader bufferedReader= null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Badehkar.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                if (namee.getText().equals(s[0])&& numbere.getText().equals(s[1])
                        &&arze.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaghe.getText());
                    x = x+s[0]+"@"+s[1]+"@"+String.valueOf(price+price2)+"@"+s[3]+"\n";
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"دریافت بدهی"+"\n";
                    PrintWriter printWriter2 = null;
                    printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
                    printWriter2.print(tarakonesh);
                    printWriter2.flush();
                }else {
                    x += s[0] + "@" + s[1] + "@" + s[2] + "@" + s[3] + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Badehkar.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setlist();
    }
    public void setTasfiah(ActionEvent actionEvent){
        String x="";
        BufferedReader bufferedReader= null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Badehkar.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                if (namet.getText().equals(s[0])&& numbert.getText().equals(s[1])
                        &&arzt.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaght.getText());
                    if (price-price2>0) {
                        x = x + s[0] + "@" + s[1] + "@" + String.valueOf(price - price2) + "@" + s[3] + "\n";
                    }
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"پرداخت بدهی"+"\n";
                    PrintWriter printWriter2 = null;
                    printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
                    printWriter2.print(tarakonesh);
                    printWriter2.flush();
                }else {
                    x += s[0] + "@" + s[1] + "@" + s[2] + "@" + s[3] + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Badehkar.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setlist();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name2.setCellValueFactory(new PropertyValueFactory<Customer , String>("name"));
        number2.setCellValueFactory(new PropertyValueFactory<Customer , String>("number"));
        mablagh2.setCellValueFactory(new PropertyValueFactory<Customer , String>("cost"));
        arz2.setCellValueFactory(new PropertyValueFactory<Customer , String>("arzCost"));
        setlist();
        arz.setItems(listrz);
        arze.setItems(listrz);
        arzt.setItems(listrz);
        search();
    }
}

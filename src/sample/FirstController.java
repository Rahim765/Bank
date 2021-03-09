package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Code.Customer;
import sample.Code.SignUp;
import sample.Code.Tarakoneshha;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class FirstController implements Initializable {
    PrintWriter printWriter = null;
    BufferedReader bufferedReader = null;
    @FXML
    TextField hazf_name;
    @FXML
    TextField hazf_num;
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
    @FXML
    private TextField filterField;
    @FXML
    private Button tara;
    @FXML
    private Button badeh;
    @FXML
    private Button tarak;


    ObservableList<String> listrz = FXCollections.observableArrayList("دالر", "افغانی" ,"تومان" , "یورو" , "کالدار" );
    ObservableList<Customer> list_customer;
    public void signup(ActionEvent actionEvent){
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", true)));
            Customer customer = new Customer(signup_name.getText(),signup_num.getText(),signup_cost.getText(),arz_signup.getValue());
             new  SignUp().sabt_name(customer.getName(),customer.getNumber(),customer.getCost(), warning, arz_signup.getValue(), "Signup.txt");
            String tarakonesh ="";
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();
            tarakonesh= signup_name.getText()+"@"+signup_num.getText()+"@"+signup_cost.getText()+"@"+arz_signup.getValue()+"@"+df.format(dateobj)+"@"+"اضافه"+"\n";
            PrintWriter printWriter2 = null;
            printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
            printWriter2.print(tarakonesh);
            printWriter2.flush();
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
        search();

    //    BackgroundFill background_fill = new BackgroundFill(Color.CYAN,
      //          CornerRadii.EMPTY, Insets.EMPTY);
     //   Background background = new Background(background_fill);
    ///    table.setBackground(background);
      //  table.setStyle("-fx-background-color: #93f9b911");
  //      name.setStyle("-fx-background-color: #93f9b999");
   //     number.setStyle("-fx-background-color: #93f9b999");
   //     mablagh.setStyle("-fx-background-color: #93f9b999");
     //   arz.setStyle("-fx-background-color: #93f9b999");

        tara.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/Tarakonesh.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("list Tarakonesh ha");
                    stage.setScene(new Scene(root, 646, 491));
                    stage.show();
                    // Hide this current window (if this is what you want)
                   // ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        badeh.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/BadehKaran.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("BadehKaran");
                    stage.setScene(new Scene(root, 633, 509));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    // ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        tarak.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/sample.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Tarakonesh");
                    stage.setScene(new Scene(root, 576, 400));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    // ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void search(){
        filterField.setPromptText("Filter");
        filterField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (filterField.getText().equals("")){
                    setlist();
                }
                    ObservableList<Customer> list_tarakonesh;
                    list_tarakonesh = FXCollections.observableArrayList();
                    BufferedReader bufferedReader= null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader("Signup.txt"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] s = line.split("@");
                            if (s[0].contains(filterField.getText())){
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


    public void setHazf(ActionEvent actionEvent){
        String x="";
        BufferedReader bufferedReader= null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Signup.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                if (hazf_name.getText().equals(s[0])&& hazf_num.getText().equals(s[1])) {
                }else {
                    x += s[0] + "@" + s[1] + "@" + s[2] + "@" + s[3]+"\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            setlist();
        }
    }



}

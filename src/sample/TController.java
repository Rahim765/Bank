package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Code.Customer;
import sample.Code.Tarakoneshha;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TController implements Initializable {
    @FXML
    TextField namej ;
    @FXML
    TextField numberj ;
    @FXML
    Button jostejo ;
    @FXML
    TextField nameh ;
    @FXML
    TextField numberh ;
    @FXML
    Button hazf;

    @FXML
    TableView table = new TableView();
    @FXML
    TableColumn<Tarakoneshha, String> name;
    @FXML
    TableColumn<Tarakoneshha , String> number;
    @FXML
    TableColumn<Tarakoneshha , String> mablagh;
    @FXML
    TableColumn<Tarakoneshha , String> arz;
    @FXML
    TableColumn<Tarakoneshha , String> date;
    @FXML
    TableColumn<Tarakoneshha , String> tarakonesh;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Tarakoneshha , String>("name"));
        number.setCellValueFactory(new PropertyValueFactory<Tarakoneshha , String>("number"));
        mablagh.setCellValueFactory(new PropertyValueFactory<Tarakoneshha , String>("cost"));
        arz.setCellValueFactory(new PropertyValueFactory<Tarakoneshha , String>("arzCost"));
        date.setCellValueFactory(new PropertyValueFactory<Tarakoneshha,String>("date"));
        tarakonesh.setCellValueFactory(new PropertyValueFactory<Tarakoneshha,String>("tarakonesh"));

    }

    public void setlist(){
        ObservableList<Tarakoneshha> list_tarakonesh;

        list_tarakonesh = FXCollections.observableArrayList();
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Tarakonesh.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                if (s[0].equals(namej.getText())&&s[1].equals(numberj.getText())) {
                    list_tarakonesh.add(new Tarakoneshha(s[0], s[1], s[2], s[3], s[4], s[5]));
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

    public void setHazf(ActionEvent actionEvent){
        String x="";
        BufferedReader bufferedReader= null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Tarakonesh.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                if (nameh.getText().equals(s[0])&& numberh.getText().equals(s[1])) {
                }else {
                    x += s[0] + "@" + s[1] + "@" + s[2] + "@" + s[3] + "@" + s[4] + "@" + s[5] + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setlist2();
    }

    public void setlist2(){
        ObservableList<Tarakoneshha> list_tarakonesh;

        list_tarakonesh = FXCollections.observableArrayList();
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new FileReader("Tarakonesh.txt"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split("@");
                list_tarakonesh.add(new Tarakoneshha(s[0], s[1], s[2], s[3], s[4], s[5]));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            table.setItems(list_tarakonesh);
        }
    }

}

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @FXML
    TextField namee;
    @FXML
    TextField numbere;
    @FXML
    TextField mablaghe;
    @FXML
    Button ezafeh;
    @FXML
    TextField nameb;
    @FXML
    TextField numberb;
    @FXML
    TextField mablaghb;
    @FXML
    Button bardasht;
    @FXML
    TextField namev;
    @FXML
    TextField numberv;
    @FXML
    TextField mablaghv;
    @FXML
    Button entaghal_vajh;
    @FXML
    TextField named;
    @FXML
    TextField numberd;
    @FXML
    TextField mablaghd;

    public void setEzafeh(ActionEvent actionEvent){
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
                if (namee.getText().equals(s[0])&& numbere.getText().equals(s[1])
                        &&comboBox_ezafeh.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaghe.getText());
                    x = x+s[0]+"@"+s[1]+"@"+String.valueOf(price+price2)+"@"+s[3]+"\n";
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"اضافه"+"\n";
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
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setbardasht(ActionEvent actionEvent){
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
                if (nameb.getText().equals(s[0])&& numberb.getText().equals(s[1])
                        &&comboBox_bardasht.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaghb.getText());
                    x = x+s[0]+"@"+s[1]+"@"+String.valueOf(price-price2)+"@"+s[3]+"\n";
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"برداشت"+"\n";
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
            printWriter =  new PrintWriter(new BufferedWriter(new FileWriter("Signup.txt", false)));
            printWriter.print(x);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEntaghal_vajh(ActionEvent actionEvent){
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
                if (namev.getText().equals(s[0])&& numberv.getText().equals(s[1])
                        &&comboBox_entaghal.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaghv.getText());
                    x = x+s[0]+"@"+s[1]+"@"+String.valueOf(price-price2)+"@"+s[3]+"\n";
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"انتقال"+"\n";
                    PrintWriter printWriter2 = null;
                    printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
                    printWriter2.print(tarakonesh);
                    printWriter2.flush();

                }else if (named.getText().equals(s[0])&& numberd.getText().equals(s[1])
                        &&comboBox_daryaft.getValue().equals(s[3])) {
                    int price = Integer.parseInt(s[2]);
                    int price2 = Integer.parseInt(mablaghv.getText());
                    x = x+s[0]+"@"+s[1]+"@"+String.valueOf(price+price2)+"@"+s[3]+"\n";
                    String tarakonesh ="";
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date dateobj = new Date();
                    tarakonesh= s[0]+"@"+s[1]+"@"+String.valueOf(price2)+"@"+s[3]+"@"+df.format(dateobj)+"@"+"دریافت"+"\n";
                    PrintWriter printWriter2 = null;
                    printWriter2 =  new PrintWriter(new BufferedWriter(new FileWriter("Tarakonesh.txt", true)));
                    printWriter2.print(tarakonesh);
                    printWriter2.flush();
                }
                else {
                    x += s[0] + "@" + s[1] + "@" + s[2] + "@" + s[3] + "\n";
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
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox_ezafeh.setItems(listrz);
        comboBox_bardasht.setItems(listrz);
        comboBox_entaghal.setItems(listrz);
        comboBox_daryaft.setItems(listrz);
    }
}

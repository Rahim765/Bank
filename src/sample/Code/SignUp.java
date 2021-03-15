package sample.Code;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class SignUp {

    public  void sabt_name(String name, String fname, String vallage, String number,
                           String afghani, String toman, String dollar, String kaldar, String uru, String path,Label warning) {
        boolean repeat = false;
        BufferedReader bufferedReader= null;
        PrintWriter printWriter = null;
        try {
           bufferedReader = new BufferedReader(new FileReader(path));
           printWriter =  new PrintWriter(new BufferedWriter(new FileWriter(path, true)));

            while (true) {
                String line = bufferedReader.readLine();

                if (line == null) {
                    break;
                }

                String[] s = line.split("@");
                if (name.equals(s[0])&&fname.equals(s[1]) && vallage.equals(s[2])&&number.equals(s[3])) {
                    repeat = true;
                    break;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (repeat == false) {
            printWriter.println(name  + "@" + fname  + "@" + vallage+ "@"+ number+"@"+afghani+"@"+toman
            +"@"+dollar+"@"+kaldar+"@"+uru+"\n");
            printWriter.flush();
            warning.setText("");


        } else if (repeat == true) {
            warning.setText("نام و نمبر تکراری است!");
            repeat = false;
        }


    }
}

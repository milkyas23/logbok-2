import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate; // import the LocalDate class


public class logbok<mvciew> {
    mvcview view;

    public logbok() {
        JFrame frame = new JFrame("MVCViewForm");
        view = new mvcview();
        frame.add(view.mvcpannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        view.addListener(new PublishListener());
        System.out.println(view.getText());

    }

    public class Main {

    }
        public static void main(String[] args) {
            LocalDate myObj = LocalDate.now(); // Create a date object
            System.out.println(myObj); // Display the current date

            logbok l = new logbok();
            String password = "password";

            try {


                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/te18? " +
                                "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "username", password);

                l.CharStreamExample();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }


    String textFile = "meddelande.txt";
    String data = "medelande";

    private void CharStreamExample() throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(textFile)));
            out.println(data);

        } finally {
            out.close();
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(textFile));
            System.out.println("Reading from textfile " + textFile);
            String s = in.readLine();
            System.out.println(s);

        } finally {
            in.close();
        }
    }

    private class PublishListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(view.getText() + " " + view.getUsername());
        }
    }

}

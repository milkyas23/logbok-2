import javax.swing.*;
import java.awt.event.ActionListener;

class mvcview {
    public JPanel mvcpannel;
    private JButton publish;

    public JTextArea getMeddelandTable() {
        return MeddelandeTable;
    }

    private JTextArea meddelande;
    private JTextArea username;
    private JTextArea MeddelandeTable;

    public mvcview() {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("MVCViewForm");
        frame.setContentPane(new mvcview().mvcpannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void addListener(ActionListener listenForCalcButton) {
        publish.addActionListener(listenForCalcButton);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getText() { return meddelande.getText();
    }

    public JPanel getmcvpannel() {
        return mvcpannel;
    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }
}

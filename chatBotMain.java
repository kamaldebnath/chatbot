import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
class chatBot extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea= new JTextArea();
    private JTextField textField=new JTextField();
    private JButton button=new JButton();
    private JLabel label=new JLabel();
    chatBot() throws AWTException {
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        f.setSize(500,400);
        f.getContentPane().setBackground(Color.gray);
        f.setTitle("ChatBot");
        f.add(textArea);
        f.add(textField);
        textArea.setSize(500,310);
        textArea.setLocation(0, 0);
        textArea.setBackground(Color.black);
        textField.setSize(500,25);
        textField.setLocation(0,310);
        f.add(button);
        label.setText("SEND");
        button.add(label);
        button.setSize(85,25);
        button.setLocation(200,336);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HashMap<String,String> conversation = new HashMap<>();
                try {
                    coms(conversation);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                if(e.getSource()==button) {
                    String text=textField.getText().toLowerCase();
                    textArea.setForeground(Color.GREEN);
                    textArea.append("You-->"+text+"\n");
                    textField.setText("");

                    if (conversation.containsKey(text)){
                        textArea.append("ChatBot-->"+conversation.get(text)+"\n");
                    }
                    else
                        textArea.append("ChatBot--> Sorry,I don't have an answer for that.\n");
                    }

                }


        });
    }

    public static void coms(HashMap<String, String> dialogs) throws IOException {
        dialogs.put("hii","Hello,How are you?");
        dialogs.put("who are you?","I am a Chat bot");
        dialogs.put("who are you","I am a Chat bot");
        dialogs.put("what is your name","I don't have a name.");
        dialogs.put("what is your name?","I don't have a name.");
        dialogs.put("hello","Hello,How are you?");
        dialogs.put("i am good","Glad to know that");
        dialogs.put("hi","Hello,How are you?");
        dialogs.put("hey","Hello,How are you?");
        dialogs.put("","Hello,How are you?");
        dialogs.put("play song","This feature is unavailable for this time");
        dialogs.put("play video","This feature is unavailable for this time");
        dialogs.put("who created you?","I was developed by Mr.Kamal Debnath and Mr. Bishal Sarkar.");
        dialogs.put("who invented you?","I was developed by Mr.Kamal Debnath and Mr. Bishal Sarkar.");
        dialogs.put("time", String.valueOf(LocalTime.now()));
        dialogs.put("what is the time now", String.valueOf(LocalTime.now()));
        dialogs.put("what is the time now?", String.valueOf(LocalTime.now()));
        dialogs.put("tell the time", String.valueOf(LocalTime.now()));
        dialogs.put("date", String.valueOf(LocalDate.now()));
        dialogs.put("what date is today", String.valueOf(LocalDate.now()));
        dialogs.put("what date is today?", String.valueOf(LocalDate.now()));
        dialogs.put("tell the date", String.valueOf(LocalDate.now()));


    }

}

public class chatBotMain {
    public static void main(String[] args) throws AWTException {
        new chatBot();
    }
}
package zoo;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class InputOutput {

    public static char readChar(String text) {
        String st = JOptionPane.showInputDialog(text);
        return (st == null || st.length() == 0 ? '0' : st.charAt(0));
    }

    public static String readString(String text) {
        String st = JOptionPane.showInputDialog(text);
        return (st == null ? "" : st);
    }
    
    public static int readInt(String text) {
        boolean correct = false;
        int integer = 0;
        
        while(!correct) {
            try {
                String st = JOptionPane.showInputDialog(text);
                integer = Integer.parseInt(st);
                correct = true;
            }
            catch(NumberFormatException ex){}
        }
        
        return integer;
    }

    public static boolean readBoolean(String text) {
        int i = JOptionPane.showConfirmDialog(null, text, "Query", JOptionPane.YES_NO_OPTION);
        return i == JOptionPane.YES_OPTION;
    }

    public static void displayString(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static String readPassword(String text) {
        final JPasswordField pwd = new JPasswordField();
        ActionListener al = new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                pwd.requestFocusInWindow();
            }
        };
        Timer timer = new Timer(200, al);
        timer.setRepeats(false);
        timer.start();
        Object[] objs = {text, pwd};
        String password = "";
        if (JOptionPane.showConfirmDialog(null, objs, "Input",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
            password = String.valueOf(pwd.getPassword());
        }
        return password;
    }

    static LocalDate readDate(String text) {
        boolean correct = false;
        LocalDate date = null;
        
        while(!correct) {
            try {
                String st = JOptionPane.showInputDialog(text);
                date = LocalDate.parse(st);
                correct = true;
            }
            catch(DateTimeParseException ex){}
        }
        
        return date;
    }
    
    static LocalTime readHour(String text) {
        boolean correct = false;
        LocalTime hour = null;
        
        while(!correct) {
            try {
                String st = JOptionPane.showInputDialog(text);
                hour = LocalTime.parse(st);
                correct = true;
            }
            catch(DateTimeParseException ex){}
        }
        return hour;
    }
}

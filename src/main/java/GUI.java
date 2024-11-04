
import javax.swing.*;
        import java.awt.*;
        import java.util.ArrayList;

public class GUI {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Haus");
        words.add("Baum");
        words.add("Auto");

        boolean continueTraining = true;

        while (continueTraining && !words.isEmpty()) {
            for (int i = 0; i < words.size(); i++) {
                String input = JOptionPane.showInputDialog(null, "Geben Sie das Wort ein: " + words.get(i), "Worttrainer", JOptionPane.PLAIN_MESSAGE);

                if (input == null || input.isEmpty()) {
                    continueTraining = false;
                    break;
                }

                if (input.equalsIgnoreCase(words.get(i))) {
                    JOptionPane.showMessageDialog(null, "Das war richtig!");
                    words.remove(i);
                    i--;
                } else {
                    JOptionPane.showMessageDialog(null, "Das war falsch!");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Training beendet. Verbleibende Wörter: " + words.size());
    }
}

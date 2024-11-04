import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class GUI {
    public static void main(String[] arg) {
        ArrayList<Paar> list = new ArrayList<>();
        Worttrainer worttrainer = new Worttrainer(list);
        Laden laden = new Laden();
        worttrainer = laden.strategy(worttrainer);
        list = worttrainer.getList();
        boolean weiter = true;

        String eingabe = "";
        while(weiter && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ImageIcon icon = new ImageIcon(list.get(i).getBild());
                while (icon.getIconWidth() > 300 || icon.getIconHeight() > 300) {
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance((int) (icon.getIconWidth() / 1.5), (int) (icon.getIconHeight() / 1.5), java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                }

                JLabel label = new JLabel(icon);
                eingabe = JOptionPane.showInputDialog(null, label, "Worttrainer", JOptionPane.PLAIN_MESSAGE);

                if (eingabe == null || eingabe.equals("")) {
                    weiter = false;
                    break;
                }

                boolean richtig = list.get(i).checkWord(eingabe);
                worttrainer.addTry(richtig);
                JOptionPane.showMessageDialog(null, "Das war " + (richtig ? "richtig!" : "falsch!"));

                if (richtig) {
                    list.remove(i);
                    i--;
                }
            }
        }

        JOptionPane.showMessageDialog(null,"Statistik: " + worttrainer.getVersuche() + " Versuche, " + worttrainer.getGeschafft() + " davon sind richtig.");
        Speichern speichern = new Speichern();
        speichern.strategy(worttrainer);
    }
}

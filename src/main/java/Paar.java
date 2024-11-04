import javax.swing.*;
import java.net.*;

public class Paar {
    private String wort;
    private URL bild;

    public Paar() {
    }

    public Paar(String wort, String bild){
        this.wort = wort;
        if(isURLValid(bild)) {
            try {
                this.bild = new URL(bild);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR FALSCHES URL BEI WORT: " + wort);
        }
    }


}


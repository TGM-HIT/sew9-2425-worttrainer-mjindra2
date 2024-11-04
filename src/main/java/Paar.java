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
    @Override
    public String toString(){
        return this.wort;
    }

    public String getWort(){
        return wort;
    }

    public URL getBild(){
        return bild;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public void setBild(URL bild) {
        this.bild = bild;
    }

    public boolean checkWord(String wort){
        return this.wort.equals(wort);
    }

    public static boolean isURLValid(String urlString) {
        try {
            URL urll = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) urll.openConnection();
            connection.setRequestMethod("HEAD"); // Use the HEAD method for a lightweight check
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            return false;
        }
    }


}


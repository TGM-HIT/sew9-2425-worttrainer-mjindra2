import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;


public class Worttrainer{
    private ArrayList<Paar> paare;
    private int versuche;
    private int geschafft;

    public Worttrainer(ArrayList<Paar> paare){
        this.paare = paare;
        versuche = 0;
    }

    public Worttrainer(){
        this.paare = new ArrayList<>();
        versuche = 0;
    }

    public void addTry(boolean geschafft){
        versuche++;
        if(geschafft){
            this.geschafft++;
        }
    }

    @JsonIgnore
    public ArrayList<Paar> getList(){
        return paare;
    }

    public int getVersuche(){
        return this.versuche;
    }

    public int getGeschafft(){
        return this.geschafft;
    }
}


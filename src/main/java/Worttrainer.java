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

}


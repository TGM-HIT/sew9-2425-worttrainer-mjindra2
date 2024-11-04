import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Laden implements SuL {

    @Override
    public Worttrainer strategy(Worttrainer worttrainer2) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("worttrainer.json");

            Worttrainer worttrainer = objectMapper.readValue(inputStream, new TypeReference<Worttrainer>() {});
            ArrayList<Paar> loadedList = worttrainer.getList();
            return worttrainer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

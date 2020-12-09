package Utilities;

import Models.Pokemon;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class JsonFileUtil {

    public static Pokemon getPokemonInfoFromJson(File jsonFile)
    {
        Pokemon pokemon = null; //creating an api object

        try(
                FileReader fileReader = new FileReader("src/pokedex.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )

        {
            Gson gson = new Gson();
            pokemon = gson.fromJson(jsonReader, Pokemon.class);
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        return pokemon; //return it
    }
}
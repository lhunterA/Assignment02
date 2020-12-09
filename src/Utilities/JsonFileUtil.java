package Utilities;

import Models.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class JsonFileUtil {

    public static ApiResponse getPokemonInfoFromJson(File jsonFile)
    {
        ApiResponse apiResponse = null; //creating an api object

        try(
                FileReader fileReader = new FileReader("src/pokedex.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )

        {
            Gson gson = new Gson();
            apiResponse = gson.fromJson(jsonReader, ApiResponse.class);
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        return apiResponse; //return it
    }
}
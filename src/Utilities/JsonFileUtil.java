/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File:
 */

package Utilities;

import Models.Pokemon;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class JsonFileUtil {

    public static Pokemon getPokemonInfoFromJson(File jsonFile)
    {
        Pokemon pokemon = null;

        try(FileReader fileReader = new FileReader("src/pokedex.json");
            JsonReader jsonReader = new JsonReader(fileReader);)
        {
            Gson gson = new Gson();
            pokemon = gson.fromJson(jsonReader, Pokemon.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return pokemon;
    }
}
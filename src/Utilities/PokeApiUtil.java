/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File: To grab the pokemon object as a json format and write it to the pokedex.json file
 */

package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient; //Need Java 11 or higher to use it
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PokeApiUtil {
    /**
     * First checks to see if the pokedex.json file exists - deletes it and then creates a new one to remove potential
     * json data errors.
     *
     * Create a new string which holds the get method of the API with the search input being the number of the pokemon
     * we want to call.
     *
     * Writes the json data to the pokedex.json based on the number of the pokemon we want to call.
     * @param searchinput
     */
    public static void getPokemonOnLoad(int searchinput)
    {
        //Method to delete the file to rewrite it without hiccups
        //was done in class and I liked it as it removes a potential error
        File file = new File("src/pokedex.json");
        if (file.exists())
            file.delete();

        String searchURL = "https://pokeapi.co/api/v2/pokemon/" + searchinput + "/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(searchURL)).build();

        try {
            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(Paths.get("src/pokedex.json")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

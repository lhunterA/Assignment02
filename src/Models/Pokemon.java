/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File:
 */
package Models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Pokemon
{

    @SerializedName("id")
    private String pokedexNum;

    private String name;
    private Sprite sprites;
    private String height; //Originally in decimetres
    private String weight; //Originally in hectograms
    //private ArrayList<Object> types;

    public Pokemon(String pokedexNum, String name, Sprite sprites, String height, String weight) {
        setPokedexNum(pokedexNum);
        setName(name);
        setSprites(sprites);
        setHeight(height);
        setWeight(weight);
        //this.types = types;

        //setTypes(types);
    }

    public String getPokedexNum() {
        return pokedexNum;
    }

    /**
     * If the pokemon exists (can't be zero)
     * @param pokedexNum
     */
    public void setPokedexNum(String pokedexNum) {
        int i = Integer.parseInt(height);
        if (i > 0)
            this.pokedexNum = pokedexNum;
        else
            throw new IllegalArgumentException("Please have a number");
    }

    /**
     * Format the Name to be capitalized
     * @return
     */
    public String getName() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * The name of pokemon sometime have '-' and '.'
     * Make sure there is no numbers though
     * @param name
     */
    public void setName(String name)
    {
        if (name.equals("([a-z]\\.-)*[\\sA-z\\.]"))
        this.name = name;
        else
            throw new IllegalArgumentException("Does this pokemon exist?");
    }

    public Sprite getSprites() {
        return sprites;
    }

    /**
     * If the sprite exists send it to its own class to make sure it is valid.
     * @param sprites
     */
    public void setSprites(Sprite sprites)
    {
        if (sprites != null)
        this.sprites = sprites;
        else
            throw new IllegalArgumentException("the sprite is missing");
    }

    /**
     * Format the height into cm as it is originally in decimetres
     * @return
     */
    public String getHeight() {
        int i = Integer.parseInt(height);
        i = i*10;
        return String.valueOf(i); //out put the amount in cm
    }

    /**
     * Height of the pokemon (must be greater than zero, cant be taller than 20m)
     * @param height
     */
    public void setHeight(String height) {
        int i = Integer.parseInt(height);
        if ( i > 0 && i <200)
            this.height = height;
        else
            throw new IllegalArgumentException("");
    }

    /**
     * Format the weight into kg as it is originally in hectograms
     * @return
     */
    public String getWeight() {
        int i = Integer.parseInt(weight);
        i = i/10;
        return String.valueOf(i); //out put the amount in kg
    }

    /**
     * Pokemon come in many shapes and sizes so we need to be broad. However they should weight something
     * Even ghost pokemon weight something
     * @param weight
     */
    public void setWeight(String weight) {
        int i = Integer.parseInt(weight);
        if ( i > 0 && i <200)
            this.weight = weight;
        else
            throw new IllegalArgumentException("Pokemon must exist, but smaller than 2000lbs");
    }
/*
    public PokemonType getTypes() {
        return types;
    }

    public void setTypes(PokemonType types) {
        this.types = types;
    }*/

    /**
     * Return the capitalized name of the pokemon.
     * @return
     */
    public String toString()
    {
        return getName();
    }

}

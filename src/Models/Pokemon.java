/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 * <p>
 * This File: Is the main model class for the application. Holds the pokedexnumber, name, height, weight, reference
 * to the image class (Sprite), and baseExperience. All with useful validation done.
 */
package Models;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("id")
    private int pokedexNum;

    @SerializedName("base_experience")
    private int baseExperience;

    private String name;
    private Sprite sprites;
    private int height; //Originally in decimetres
    private int weight; //Originally in hectograms

    public Pokemon(int pokedexNum, int baseExperience, String name, Sprite sprites, int height, int weight) {
        setPokedexNum(pokedexNum);
        setBaseExperience(baseExperience);
        setName(name);
        setSprites(sprites);
        setHeight(height);
        setWeight(weight);
    }

    public int getPokedexNum() {
        return pokedexNum;
    }

    /**
     * If the pokemon exists (can't be zero)
     * @param pokedexNum
     */
    public void setPokedexNum(int pokedexNum) {
        if (pokedexNum > 0)
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
    public void setName(String name) {
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
    public void setSprites(Sprite sprites) {
        if (sprites != null)
            this.sprites = sprites;
        else
            throw new IllegalArgumentException("the sprite is missing");
    }

    /**
     *
     * @return the height that is then multiplied by 10 to facilitate cm
     */
    public int getHeight() {
        return height * 10;
    }

    /**
     * Height of the pokemon (must be greater than zero, cant be taller than 20m)
     *  Format the height into cm as it is originally in decimetres
     * @param height
     */
    public void setHeight(int height) {
        if (height > 0 && height < 200)
            this.height = height;
        else
            throw new IllegalArgumentException("");
    }

    /**
     *
     * @return the weight divided by 10 to facilitate kg
     */
    public int getWeight() {
        return weight / 10;
    }

    /**
     * Pokemon come in many shapes and sizes so we need to be broad. However they should weight something
     * Even ghost pokemon weight something
     * Format the weight into kg as it is originally in hectograms
     * @param weight
     */
    public void setWeight(int weight) {
        if (weight > -1 && weight < 200)
            this.weight = weight;
        else
            throw new IllegalArgumentException("Pokemon must exist, but ghost pokemon exist smaller than 2000lbs");
    }

    /**
     *
     * @return baseExperience as a number
     */
    public int getBaseExperience() {
        return baseExperience;
    }

    /**
     * If the pokemon has at least some base experience then return as valid. As baby pokemon exist
     * @param baseExperience
     */
    public void setBaseExperience(int baseExperience) {
        if (baseExperience > 10)
            this.baseExperience = baseExperience;
        else
            throw new IllegalArgumentException("There has to be some base experience for a pokemon to exist");
    }

    /**
     * Return the just the name of the pokemon for the ListView.
     * @return
     */
    public String toString() {
        return getName();
    }

}

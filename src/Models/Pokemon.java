package Models;

import com.google.gson.annotations.SerializedName;

public class Pokemon
{

    @SerializedName("id") //The name in the Json API documentation
    private String pokedexNum; //The variable name in Java
    private String name;
    private Sprite sprites;


    /**
     * Constructor
     * @param pokedexNum
     * @param name
     * @param sprites
     */
    public Pokemon(String pokedexNum, String name, Sprite sprites) {
        setPokedexNum(pokedexNum);
        setName(name);
        setSprites(sprites);
    }


    /**
     * Getters an Setters
     * @return
     */
    public String getPokedexNum() {
        return pokedexNum;
    }

    public void setPokedexNum(String pokedexNum) {
        this.pokedexNum = pokedexNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public String toString()
    {
        String cap = name.substring(0, 1).toUpperCase() + name.substring(1);
        return String.format("%s", cap);
    }
}

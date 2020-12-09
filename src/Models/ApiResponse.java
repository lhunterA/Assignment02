package Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse
{

    @SerializedName("id") //The name in the Json API documentation
    private String pokedexNum; //The variable name in Java

    private String name;

    private Sprite sprites;

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
        return String.format("%s --- %s", pokedexNum, name);
    }}

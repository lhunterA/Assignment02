package Models;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("num") //The name in the Json API documentation
    private String pokedexNum; //The variable name in Java

    private String name;

    @SerializedName("img")
    private String imageString;

    private String[] type;
}

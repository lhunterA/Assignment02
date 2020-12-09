package Models;

import com.google.gson.annotations.SerializedName;

public class APIResponse
{
    @SerializedName("pokemon")
    private Pokemon [] pokemons;
}

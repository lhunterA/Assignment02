/**
 * Name: Lindsay Hunter
 * Student Number: 200425671
 * Class: COMP 1011 - Advanced Object Oriented Programming (Java 3)
 * Assignment: Using JSON and API's to make a simple GUI to display information to the user
 *
 * This File: Sets the path as a string to the image url of the api after going through validation.
 */


package Models;

public class Sprite {

    private String front_default;

    public String getFront_default()
    {
        return front_default;
    }

    /**
     * Makes sure that the image url for the API is in a valid image format.
     * @param front_default
     */
    public void setFront_default(String front_default) {
        String[] str = front_default.split(".");
        if (str[2] == "png") //if it is a valid image
        {
            this.front_default = front_default;
        }
        else
            throw new IllegalArgumentException("Has to be a valid image format (png)");
    }
}

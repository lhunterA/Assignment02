package Models;

public class Sprite {

    //holds the photo to be used
    private String front_default;

    public Sprite(String front_default) {
        setFront_default(front_default);
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}

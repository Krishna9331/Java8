package java8.in.action.chapter5.problem;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class Trader {

    private String name;
    private String place;

    public Trader(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

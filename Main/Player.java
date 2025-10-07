package Main;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<MechaBeast> mechaBeasts;


    public Player(String name) {
        this.name = name;
        this.mechaBeasts = new ArrayList<>();

    }

    public void addMechaBeast(MechaBeast beast) {
        if (mechaBeasts.size() < 3) {
            mechaBeasts.add(beast);
        }
    }

    public String getName() {

        return name;
    }

    public List<MechaBeast> getMechaBeasts() {

        return mechaBeasts;
    }


    //progression
    //Player.Player statistics
    //health
}
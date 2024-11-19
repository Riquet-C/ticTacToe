package player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private final String representation;

    public Player(String representation) {
        this.representation = representation;
    }
    public String getRepresentation() {
        return representation;
    }

    public abstract List<String> getMoveFromPlayer(Player player);
}

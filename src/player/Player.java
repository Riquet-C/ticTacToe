package player;

import java.util.List;

public abstract class Player {
    private final String representation;

    protected Player(String representation) {
        this.representation = representation;
    }
    public String getRepresentation() {
        return representation;
    }

    public abstract List<String> getMoveFromPlayer(Player player);
}

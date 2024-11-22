package player;

import model.Cell;
import display.Representation;

import java.util.List;

public abstract class Player {
    private final Representation representation;

    protected Player(Representation representation) {
        this.representation = representation;
    }
    public Representation getPlayerRepresentation() {
        return representation;
    }

    public abstract List<Integer> getMoveFromPlayer(Player player, Cell[][] board, int choiceToDo);
}

package player;

import cells.Cell;
import cells.CellType;

import java.util.List;

public abstract class Player {
    private final CellType representation;

    protected Player(CellType representation) {
        this.representation = representation;
    }
    public CellType getRepresentation() {
        return representation;
    }

    public abstract List<Integer> getMoveFromPlayer(Player player, Cell[][] board);
}

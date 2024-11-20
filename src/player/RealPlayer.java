package player;

import cells.Cell;
import cells.CellType;
import display.GameDisplay;
import game.Menu;

import java.util.ArrayList;

public class RealPlayer extends Player{

    private final Menu menu;

    public RealPlayer(CellType representation) {
        super(representation);
        menu = new Menu();
    }

    @Override
    public ArrayList<Integer> getMoveFromPlayer(Player player, Cell[][] board) {
        GameDisplay.LINE.display();
        Integer line = menu.cellChoice(board);

        GameDisplay.COLUMN.display();
        Integer column = menu.cellChoice(board);

        ArrayList<Integer> playerChoice = new ArrayList<>(2);
        playerChoice.add(line);
        playerChoice.add(column);

        return playerChoice;
    }
}

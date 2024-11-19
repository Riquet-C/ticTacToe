package player;

import display.GameDisplay;
import game.Menu;

import java.util.ArrayList;

public class RealPlayer extends Player{

    private final Menu menu;

    public RealPlayer(String representation) {
        super(representation);
        menu = new Menu();
    }

    @Override
    public ArrayList<String> getMoveFromPlayer(Player player) {
        GameDisplay.LINE.display();
        String line = menu.cellChoice();

        GameDisplay.COLUMN.display();
        String column = menu.cellChoice();

        ArrayList<String> playerChoice = new ArrayList<>(2);
        playerChoice.add(line);
        playerChoice.add(column);

        return playerChoice;
    }
}

package player;

import model.Cell;
import display.Representation;
import display.GameDisplay;
import menu.Menu;

import java.util.ArrayList;

public class RealPlayer extends Player {

    private final Menu menu;

    public RealPlayer(Representation representation) {
        super(representation);
        menu = new Menu();
    }

    @Override
    public ArrayList<Integer> getMoveFromPlayer(Player player, Cell[][] board, int choiceToDo) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDo);

        for (int i = 1; i <= choiceToDo; i++) {
            int choice;
            if (i == 1 ) {
                GameDisplay.COLUMN.display(board[i].length);
                choice = menu.choiceCell(board[i].length);
            } else {
                GameDisplay.LINE.display(board.length);
                choice = menu.choiceCell(board.length);
            }
            playerChoice.add(choice);
        }

        return playerChoice;
    }
}

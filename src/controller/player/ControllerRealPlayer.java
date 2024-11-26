package controller.player;

import display.GameDisplay;
import model.Cell;
import model.board.Board;
import route.Menu;

import java.util.ArrayList;

public class ControllerRealPlayer extends ControllerPlayer {

    Menu menu;

    public ControllerRealPlayer() {
        menu = new Menu();
    }

    @Override
    public ArrayList<Integer> getChoiceFromPlayer(Board board, int choiceToDo) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDo);

        for (int i = 1; i <= choiceToDo; i++) {
            int choice;
            if (i == 1 ) {
                GameDisplay.COLUMN.display(board.getBoard()[i].length);
                choice = menu.choiceCell(board.getBoard()[i].length);
            } else {
                GameDisplay.LINE.display(board.getBoard().length);
                choice = menu.choiceCell(board.getBoard().length);
            }
            playerChoice.add(choice);
        }

        return playerChoice;
    }
}

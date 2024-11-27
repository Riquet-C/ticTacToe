package controller.player;

import model.Cell;
import route.Menu;

import java.util.ArrayList;

public class RealPlayerController extends PlayerController{

    private final Menu menu;

    public RealPlayerController() {

        menu = new Menu();
    }
    @Override
    public ArrayList<Integer> getChoiceFromPlayer(Cell[][] board, int choiceToDo) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDo);

        for (int i = 1; i <= choiceToDo; i++) {
            int choice;
            if (i == 1 ) {
//                MessageForGame.COLUMN.display(board[i].length);
                choice = menu.choiceCell(board[i].length);
            } else {
//                MessageForGame.LINE.display(board.length);
                choice = menu.choiceCell(board.length);
            }
            playerChoice.add(choice);
        }

        return playerChoice;
    }
}

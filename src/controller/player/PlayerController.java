package controller.player;

import display.Menu;
import model.board.Cell;

import java.util.ArrayList;
import java.util.Random;

public class PlayerController {
    private final Random randomNumber;
    private final Menu menu;

    public PlayerController() {
        randomNumber = new Random();
        menu = new Menu();
    }

    public ArrayList<Integer> artificialChoice(Cell[][] board, int choiceToDO) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDO);

        for (int i = 1; i <= choiceToDO; i++) {
            playerChoice.add(randomNumber.nextInt(board[0].length));
        }

        return playerChoice;
    }

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

package controller.player;

import display.Menu;
import display.MessageForGame;
import display.view.GameView;
import display.view.PlayerView;
import model.board.Cell;

import java.util.ArrayList;
import java.util.Random;

public class PlayerController {
    private final Random randomNumber;
    private final Menu menu;
    private final PlayerView playerView;

    public PlayerController() {
        randomNumber = new Random();
        menu = new Menu();
        playerView = new PlayerView();
    }

    public ArrayList<Integer> artificialChoice(int col, int choiceToDO) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDO);

        for (int i = 1; i <= choiceToDO; i++) {
            playerChoice.add(randomNumber.nextInt(col));
        }
        return playerChoice;
    }

    public ArrayList<Integer> getChoiceFromPlayer(int row, int col, int choiceToDo) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDo);

        for (int i = 1; i <= choiceToDo; i++) {
            int choice;
            if (i == 1 ) {
                playerView.display(MessageForGame.COLUMN.getMessage(), col);
                choice = menu.choiceCell(col);
            } else {
                playerView.display(MessageForGame.LINE.getMessage(), row);
                choice = menu.choiceCell(row);
            }
            playerChoice.add(choice);
        }
        return playerChoice;
    }
}

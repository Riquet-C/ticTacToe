package display.view;

import display.MessageForGame;
import model.State;

public class GameView extends View {


    public void displayEndGame(Boolean isWinner, String currentPlayer) {
        if (isWinner) {
            display(MessageForGame.WIN_GAME.getMessage(), currentPlayer);
        } else {
            display(MessageForGame.FULL_BOARD.getMessage());
        }
        display(MessageForGame.ENDGAME.getMessage());
    }

}

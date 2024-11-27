package display.view;

import display.MessageForGame;
import model.board.Board;
import model.player.PlayerModel;

public class GameView extends View {

    public void displayBoard(Board board) {
        System.out.print("    ");
        for (int col = 0; col < board.getBoard()[0].length; col++) {
            System.out.printf("  %2d   ", (col + 1)); // Format des numéros de colonnes
        }
        System.out.println();
        System.out.println("   " + "+------".repeat(board.getBoard()[0].length) + "+");
        for (int i = 0; i < board.getBoard().length; i++) {
            System.out.printf("%2d | ", (i + 1));
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                board.getBoard()[i][j].getCellState().display();
                System.out.print( "  | ");
            }
            System.out.println();
            System.out.println("   " + "+------".repeat(board.getBoard()[0].length) + "+");
        }
    }

    public void displayEndGame(Boolean isWinner, PlayerModel currentPlayer) {
        if (isWinner) {
            display(MessageForGame.WIN_GAME.getMessage(), currentPlayer.getState());
        } else {
            display(MessageForGame.FULL_BOARD.getMessage());
        }
        display(MessageForGame.ENDGAME.getMessage());
    }

}

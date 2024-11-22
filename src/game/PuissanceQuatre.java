package game;

import model.Cell;
import display.Representation;
import display.GameDisplay;
import player.ArtficialPlayer;
import player.Player;
import player.RealPlayer;

import java.util.List;

public class PuissanceQuatre extends BoardGame{

    public PuissanceQuatre() {
        super(7, 6, 4);
    }

    @Override
    public void movePlayer(Player player, Cell[][] board) {
        List<Integer> choice = player.getMoveFromPlayer(player, board, 1);

        Cell cellToChange = board[getLine(choice.getFirst(), board)][choice.getFirst()];

        if (cellToChange.getCellRepresentation() == Representation.EMPTY) {
            cellToChange.setCellRepresentation(player.getPlayerRepresentation());
        } else if (player.getClass() == RealPlayer.class) {
            GameDisplay.ALREADY_CHOOSE.display();
            movePlayer(player, board);
        } else if (player.getClass() == ArtficialPlayer.class) {
            movePlayer(player, board);
        }
    }

    public int getLine(int colChoice, Cell[][] board) {
        for (int i = board.length -1; i>=0; i--) {
            if (board[i][colChoice].getCellRepresentation() == Representation.EMPTY) {
                return i;
            }
        }
      return 0;
    }
}

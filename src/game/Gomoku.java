package game;

import model.Cell;
import display.Representation;
import display.GameDisplay;
import player.ArtficialPlayer;
import player.Player;
import player.RealPlayer;

import java.util.List;

public class Gomoku extends BoardGame {
    public Gomoku() {
        super(15, 15, 5);
    }

    @Override
    public void movePlayer(Player player, Cell[][] board) {
        List<Integer> choice = player.getMoveFromPlayer(player, board, 2);

        Cell cellToChange = board[choice.get(1)][choice.get(0)];

        if (cellToChange.getCellRepresentation() == Representation.EMPTY) {
            cellToChange.setCellRepresentation(player.getPlayerRepresentation());
        } else if (player.getClass() == RealPlayer.class) {
            GameDisplay.ALREADY_CHOOSE.display();
            movePlayer(player, board);
        } else if (player.getClass() == ArtficialPlayer.class) {
            movePlayer(player, board);
        }
    }

}

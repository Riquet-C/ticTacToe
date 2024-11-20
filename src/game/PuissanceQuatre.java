package game;

import cells.Cell;
import player.Player;

public class PuissanceQuatre extends BoardGame{

    protected PuissanceQuatre(int size) {
        super(size);
    }

    @Override
    protected boolean checkDiag(Player currentPlayer, boolean isFirstDiagonal, Cell[][] board) {
        return false;
    }

    @Override
    protected boolean checkLineOrColumn(Player currentPlayer, int index, boolean isLine, Cell[][] board) {
        return false;
    }
}

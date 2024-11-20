package game;

import cells.Cell;
import cells.CellType;
import player.Player;


public class TicTacToe extends BoardGame {

    protected TicTacToe() {
        super(3);
    }

    @Override
    protected boolean checkDiag(Player currentPlayer, boolean isFirstDiagonal, Cell[][] board) {
        for (int j = 0; j < board.length; j++) {
            CellType cellValue = isFirstDiagonal
                    ? board[j][j].getCellStatement()
                    : board[j][board.length - 1 - j].getCellStatement();
            if (!cellValue.equals(currentPlayer.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected boolean checkLineOrColumn(Player currentPlayer, int index, boolean isLine, Cell[][] board) {
        for (int j = 0; j < board.length; j++) {
            CellType cellValue = isLine
                    ? board[index][j].getCellStatement()
                    : board[j][index].getCellStatement();
            if (!cellValue.equals(currentPlayer.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

}


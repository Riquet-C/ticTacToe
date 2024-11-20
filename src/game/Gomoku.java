package game;

import cells.Cell;
import cells.CellType;
import player.Player;

import java.util.ArrayList;

public class Gomoku extends BoardGame {
    protected Gomoku() {
        super(15);
    }

    @Override
    protected boolean checkDiag(Player currentPlayer, boolean isFirstDiagonal, Cell[][] board) {
        for (int j = 0; j < board.length; j++) {
            int count = 0;
            for (int k = j; k < j + 5 && k < board.length; k++) {
                CellType cellValue = isFirstDiagonal
                        ? board[j][j].getCellStatement()
                        : board[j][board.length - 1 - j].getCellStatement();
                if (!cellValue.equals(currentPlayer.getRepresentation())) {
                    return false;
                } else {
                    count++;
                }
            }
            if (count == 5) {
                return true;
            }
        }
        return true;

    }

    @Override
    protected boolean checkLineOrColumn(Player currentPlayer, int index, boolean isLine, Cell[][] board) {
        for (int j = 0; j < board.length; j++) {
            int count = 0;
            for (int k = j; k < j + 5 && k < board.length; k++) {
                CellType cellValue = isLine
                        ? board[index][k].getCellStatement()
                        : board[k][index].getCellStatement();
                if (!cellValue.equals(currentPlayer.getRepresentation())) {
                    return false;
                } else {
                    count++;
                }
            }
            if (count == 5) {
                return true;
            }
        }
        return true;
    }

}

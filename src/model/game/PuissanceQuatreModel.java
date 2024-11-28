package model.game;

import model.board.Cell;
import display.State;

import java.util.List;

public class PuissanceQuatreModel extends GameModel {

    @Override
    public Cell setCellToChange(List<Integer> choice, Cell[][] board){
        return board[getLine(choice.getFirst(), board)][choice.getFirst()];
    }

    public int getLine(int colChoice, Cell[][] board) {
        for (int i = board.length -1; i>=0; i--) {
            if (board[i][colChoice].getCellState() == State.EMPTY) {
                return i;
            }
        }
      return 0;
    }
}
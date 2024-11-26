package controller.game;

import model.Cell;
import display.State;
import model.board.Board;

import java.util.List;

public class PuissanceQuatre extends BoardGame {

    public PuissanceQuatre() {
        super(7, 6, 4);
    }


    public Cell setCellToChange(List<Integer> choice, Board board){
        return board.getBoard()[getLine(choice.getFirst(), board.getBoard())][choice.getFirst()];
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

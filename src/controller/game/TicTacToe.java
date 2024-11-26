package controller.game;

import model.Cell;
import model.board.Board;

import java.util.List;


public class TicTacToe extends BoardGame {

    public TicTacToe() {
        super(3, 3, 3);
    }

    public Cell setCellToChange(List<Integer> choice, Board board){
        return board.getBoard()[choice.get(1)][choice.get(0)];
    }
}


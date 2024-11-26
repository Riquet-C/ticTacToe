package controller.game;

import model.Cell;
import model.board.Board;

import java.util.List;

public class Gomoku extends BoardGame {
    public Gomoku() {
        super(15, 15, 5);

    }

    public Cell setCellToChange(List<Integer> choice, Board board){
        return board.getBoard()[choice.get(1)][choice.get(0)];
    }

}

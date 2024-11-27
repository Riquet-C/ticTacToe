package controller.game;

import display.GameType;
import model.Cell;

import java.util.List;

public class Gomoku extends GameController {
    public Gomoku() {
        super(15, 15, 5, GameType.Gomoku);
    }

    public Cell setCellToChange(List<Integer> choice, Cell[][] board){
        return board[choice.get(1)][choice.get(0)];
    }

}

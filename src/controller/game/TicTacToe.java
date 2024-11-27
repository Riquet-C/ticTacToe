package controller.game;

import display.GameType;
import model.Cell;

import java.util.List;


public class TicTacToe extends GameController {

    public TicTacToe() {
        super(3, 3, 3, GameType.TicTacToe);
    }

    public Cell setCellToChange(List<Integer> choice, Cell[][] board){
        return board[choice.get(1)][choice.get(0)];
    }
}


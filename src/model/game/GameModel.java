package model.game;

import model.board.Cell;

import java.util.List;


public class GameModel {

    public GameModel() {}

    public Cell setCellToChange(List<Integer> choice, Cell[][] board) {
        return board[choice.get(1)][choice.get(0)];
    }

}

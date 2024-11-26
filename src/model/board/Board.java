package model.board;

import display.State;
import model.Cell;

public class Board {

    Cell[][] board;

    public Board(int row, int col) {
        board = createBoard(row, col);
    }

    public Cell[][] getBoard(){
        return board;
    }

    protected Cell[][] createBoard(int row, int col) {
        Cell[][] board = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = new Cell(State.EMPTY);
            }
        }
        return board;
    }

    public boolean checkEmptyCell() {
        for (Cell[] cells : board) {
            for (int j = 0; j < board.length; j++) {
                if (cells[j].getCellState() == State.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}

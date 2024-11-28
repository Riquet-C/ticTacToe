package model.board;

import display.view.GameView;
import display.State;
import display.view.View;
import model.player.PlayerModel;

public class Board {

    Cell[][] board;
    View view;
    private final int col;
    private final int row;

    public Board(int row, int col) {
        board = createBoard(row, col);
        view = new GameView();
        this.col = col;
        this.row = row;
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

    public boolean exist(int i, int j) {
        return i >= 0 && i < this.row && j >= 0 && j < this.col;
    }


    public boolean checkWin(PlayerModel currentPlayer, int toWin) {

        State currentPlayerState = currentPlayer.getState();

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (checkDirection(currentPlayerState, i, j, 0, 1, toWin) // check line
                        || checkDirection(currentPlayerState, i, j, 1, 0, toWin) // check column
                        || checkDirection(currentPlayerState, i, j, 1, 1, toWin) // check diag descendante
                        || checkDirection(currentPlayerState, i, j, 1, -1, toWin)) // check diag montante
                    return true;
            }
        }
        return false;
    }

    /**
     * Two nested loops are used in the win method to iterate through the entire 2D board.
     * The loop with step allows us to start at board[row][column] and traverse X cells in a row, column, or diagonal
     * (where step MAX is the number of aligned points required to win, depending on the game).
     *
     * @param u Index to add to row
     * @param v Index to add to column
     * @return false if the cell does not exist OR is not equal to the current model/player's representation.
     * true if, after traversing K* cells, all the cells are identical.
     */
    private boolean checkDirection(State currentPlayer, int row, int column, int u, int v, int toWin) {
        for (int step = 0; step < toWin; step++) {
            if (!exist(row + u * step, column + v * step)) {
                return false;
            }
            if (getBoard()[row + u * step][column + v * step].getCellState() != currentPlayer) {
                return false;
            }
        }
        return true;
    }
}

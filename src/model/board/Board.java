package model.board;

import display.GameType;
import model.State;

import java.util.List;

public class Board {

    private final Cell[][] board;
    private final int col;
    private final int row;

    public Board(int row, int col) {
        board = createBoard(row, col);
        this.col = col;
        this.row = row;
    }

    private Cell[][] getBoard(){
        return board;
    }

    public int getNbCol() {
        return col;
    }

    public int getNbRow() {
        return row;
    }

    public String getRepresentation() {
        StringBuilder rep = new StringBuilder("    ");
        for (int col = 0; col < getBoard()[0].length; col++) {
            rep.append(String.format("  %2d   ", (col + 1)));
        }
        rep.append("\n");
        rep.append("   ").append("+------".repeat(getBoard()[0].length)).append("+\n");
        for (int i = 0; i < getBoard().length; i++) {
            rep.append(String.format("%2d ", (i + 1)));
            for (int j = 0; j < getBoard()[i].length; j++) {
                rep.append(getBoard()[i][j].getRepresentation());
            }
            rep.append("|\n");
            rep.append("   ").append("+------".repeat(getBoard()[0].length)).append("+\n");
        }
        return rep.toString();
    }

    public boolean isCellChangeable(int row, int col) {
        return board[row][col].isEmpty();
    }

    public void setCellToChange(int row, int col, State playerState) {
            board[row][col].occupy(playerState);
    }

    public int getLineForPuissanceQuatre(int colChoice) {
        for (int i = board.length -1; i>=0; i--) {
            if (board[i][colChoice].isEmpty()) {
                return i;
            }
        }
        return 0;
    }

    private Cell[][] createBoard(int row, int col) {
        Cell[][] board = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    public int setRow(int col, List<Integer> choice, GameType type) {
        if (type == GameType.PuissanceQuatre) {
            return getLineForPuissanceQuatre(col);
        } else {
            return choice.getFirst();
        }
    }

    public int setCol(List<Integer> choice, GameType type){
        if (type == GameType.PuissanceQuatre) {
            return choice.getFirst();
        } else {
            return choice.get(1);
        }
    }

    public boolean isBoardEmpty() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.getCellState() == State.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(int i, int j) {
        return i >= 0 && i < getNbRow() && j >= 0 && j < getNbCol();
    }


    public boolean checkWin(State currentPlayer, int toWin) {

        for (int i = 0; i < getNbRow(); i++) {
            for (int j = 0; j < getNbCol(); j++) {
                if (checkDirection(currentPlayer, i, j, 0, 1, toWin) // check line
                        || checkDirection(currentPlayer, i, j, 1, 0, toWin) // check column
                        || checkDirection(currentPlayer, i, j, 1, 1, toWin) // check diag descendante
                        || checkDirection(currentPlayer, i, j, 1, -1, toWin)) // check diag montante
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

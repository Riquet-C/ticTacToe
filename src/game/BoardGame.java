package game;

import menu.Menu;
import model.Cell;
import display.Representation;
import display.GameDisplay;
import player.ArtficialPlayer;
import player.Player;
import player.RealPlayer;


public abstract class BoardGame {

    private final int col;
    private final int row;
    private final Menu menu;
    private Player player1;
    private Player player2;
    private Cell[][] board;
    private final int toWin;
    private Player currentPlayer;


    protected BoardGame(int col, int row, int toWin) {
        this.col = col;
        this.row = row;
        this.toWin = toWin;
        this.menu = new Menu();
    }


    public void game() {
        createBoard();
        createPlayers();
        currentPlayer = player1;

        while (!checkWin() && checkEmptyCell()) {
            currentPlayer = changePlayer(currentPlayer);
            GameDisplay.BOARD.displayBoard(this.board);
            GameDisplay.PLAYER_IN_GAME.display(currentPlayer.getPlayerRepresentation());
            movePlayer(currentPlayer, this.board);
        }

        GameDisplay.SHOW_WINNER.displayEndGame(this.board, checkWin(currentPlayer), currentPlayer);

    }

    protected void createPlayers() {
        GameDisplay.PLAYER_CHOICE.display();
        Integer choicePlayer1 = menu.choicePlayer();
        GameDisplay.PLAYER_CHOICE.display();
        Integer choicePlayer2 = menu.choicePlayer();

        switch (choicePlayer1) {
            case 1 -> this.player2 = new ArtficialPlayer(Representation.O);
            case 2 -> this.player2 = new RealPlayer(Representation.O);
            default -> createPlayers();
        }
        switch (choicePlayer2) {
            case 1 -> this.player1 = new ArtficialPlayer(Representation.X);
            case 2 -> this.player1 = new RealPlayer(Representation.X);
            default -> createPlayers();
        }
    }

    protected void createBoard() {
        this.board = new Cell[this.row][this.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.board[i][j] = new Cell(Representation.EMPTY);
            }
        }
    }

    protected Player changePlayer(Player player) {
        return player.equals(player1) ? player2 : player1;
    }

    protected abstract void movePlayer(Player player, Cell[][] board);

    protected boolean checkEmptyCell() {
        for (Cell[] cells : board) {
            for (int j = 0; j < board.length; j++) {
                if (cells[j].getCellRepresentation() == Representation.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }


    protected boolean checkWin() {

        Representation currentPlayerRepresentation = currentPlayer.getPlayerRepresentation();

        for (int i = 0; i < board.length; i++) {
            if (checkLineOrColumn(currentPlayerRepresentation, i, true, this.board)
                    || checkLineOrColumn(currentPlayerRepresentation, i, false, this.board)
                    || checkDiag(currentPlayerRepresentation, i, true, this.board)
                    || checkDiag(currentPlayerRepresentation, i, false, this.board)) {return true;}
        }
        return false;
    }


    // TODO essayer de revoir le code vu vendredi avec Raph pour refacto
    protected boolean checkDiag(Representation currentPlayer, int i, boolean diagUp, Cell[][] board) {
        for (int j = 0; j < board.length; j++) {
            int count = 0;
            for (int step = 0; step < this.toWin; step++) {
                int newRow = diagUp ? i - step : i + step;
                int newCol = j + step;

                if (newCol >= 0 && newCol < board.length && newRow >= 0 && newRow < board.length) {
                    if (board[newRow][newCol].getCellRepresentation() == currentPlayer) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            if (count == this.toWin) {
                return true;
            }
        }
        return false;
    }

    protected boolean checkLineOrColumn(Representation currentPlayer, int index, boolean isLine, Cell[][] board) {
        for (int j = 0; j < board[index].length; j++) {
            int count = 0;
            for (int step = j; step < j + this.toWin && step < board[index].length; step++) {
                Representation cellValue = isLine
                        ? board[index][step].getCellRepresentation()
                        : board[step][index].getCellRepresentation();
                if (!cellValue.equals(currentPlayer)) {
                    return false;
                } else {
                    count++;
                }
            }
            if (count == this.toWin) {
                return true;
            }
        }
        return true;
    }
}

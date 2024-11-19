package game;

import cells.Cell;
import cells.CellType;
import display.GameDisplay;
import player.ArtficialPlayer;
import player.Player;
import player.RealPlayer;

import java.util.List;

public class TicTacToe {

    private final int size;
    private Cell[][] board;
    private final Menu menu;
    private Player playerX;
    private Player playerO;

    public TicTacToe() {
        this.size = 3;
        this.menu = new Menu();
    }

    public void game() {
        createBoard();
        createPlayers();
        Player currentPlayer = playerX;

        while (!checkWin(currentPlayer) || !checkEmptyCell()) {
            currentPlayer = changePlayer(currentPlayer);
            menu.displayBoard(this.board);
            GameDisplay.PLAYER_IN_GAME.display(currentPlayer.getRepresentation());
            movePlayer(currentPlayer);
        }
        GameDisplay.ENDGAME.display();
    }

    private void createPlayers() {
        GameDisplay.PLAYER_CHOICE.display();
        String choice1 = menu.choicePlayer();
        GameDisplay.PLAYER_CHOICE.display();
        String choice2 = menu.choicePlayer();

        switch (choice1){
            case "1" -> this.playerO = new ArtficialPlayer("O");
            case "2"-> this.playerO = new RealPlayer("O");
        }
        switch (choice2){
            case "1" -> this.playerX = new ArtficialPlayer("X");
            case "2" -> this.playerX = new RealPlayer("X");
        }
    }

    private void createBoard() {
        this.board = new Cell[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new Cell(CellType.EMPTY);
            }
        }
    }

    private Player changePlayer(Player player) {
        return player.equals(playerX) ? playerO : playerX;
    }

    private void movePlayer(Player player) {

        List<String> choice = player.getMoveFromPlayer(player);

        Cell cellToChange = this.board[Integer.parseInt(choice.get(0))][Integer.parseInt(choice.get(1))];

        if (cellToChange.getCellStatement() == CellType.EMPTY) {
            if (player.equals(playerX)) {
                cellToChange.setCellStatement(CellType.X);
            } else if (player.equals(playerO)) {
                cellToChange.setCellStatement(CellType.O);
            }
        } else {
            GameDisplay.ALREADY_CHOOSE.display();
            movePlayer(player);
        }
    }

    private boolean checkEmptyCell() {
        boolean empty = false;
        for (Cell[] cells : board) {
            for (int j = 0; j < board.length; j++) {
                if (cells[j].getCellStatement() == CellType.EMPTY) {
                    return true;
                }
            }
        }
        return empty;
    }

    private boolean checkWin(Player currentPlayer) {

        for (int i = 0; i < board.length; i++) {

            boolean line = checkLineOrColumn(currentPlayer, i, true);
            boolean column = checkLineOrColumn(currentPlayer, i, false);
            boolean diagonal = checkDiag(currentPlayer, true);
            boolean diagonal2 = checkDiag(currentPlayer, false);

            if (line || column || diagonal || diagonal2) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiag(Player currentPlayer, boolean isFirstDiagonal) {
        for (int j = 0; j < board.length; j++) {
            String cellValue = isFirstDiagonal
                    ? board[j][j].getCellStatement().toString()
                    : board[j][this.size - 1 - j].getCellStatement().toString();
            if (!cellValue.equals(currentPlayer.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLineOrColumn(Player currentPlayer, int index, boolean isLine) {
        for (int j = 0; j < board.length; j++) {
            String cellValue = isLine
                    ? board[index][j].getCellStatement().toString()
                    : board[j][index].getCellStatement().toString();
            if (!cellValue.equals(currentPlayer.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

}


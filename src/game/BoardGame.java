package game;

import cells.Cell;
import cells.CellType;
import display.GameDisplay;
import player.ArtficialPlayer;
import player.Player;
import player.RealPlayer;

import java.util.List;

public abstract class BoardGame {

    protected final int size;
    private final Menu menu;
    private Player player1;
    private Player player2;
    private Cell[][] board;

    protected BoardGame(int size) {
        this.size = size;
        this.menu = new Menu();
    }

    public void game() {
        createBoard();
        createPlayers();
        System.out.println(player1.getRepresentation());
        System.out.println(player2.getRepresentation());
        Player currentPlayer = player1;

        while (!checkWin(currentPlayer) && checkEmptyCell()) {
            currentPlayer = changePlayer(currentPlayer);
            GameDisplay.BOARD.displayBoard(this.board);
            GameDisplay.PLAYER_IN_GAME.display(currentPlayer.getRepresentation());
            movePlayer(currentPlayer);

        }

        if (checkWin(currentPlayer)) {
            GameDisplay.WIN_GAME.display();
        } else {
            GameDisplay.FULL_BOARD.display();
        }
        GameDisplay.ENDGAME.display();
    }


    protected void createPlayers() {
        GameDisplay.PLAYER_CHOICE.display();
        Integer choice1 = menu.choicePlayer();
        GameDisplay.PLAYER_CHOICE.display();
        Integer choice2 = menu.choicePlayer();

        switch (choice1) {
            case 1 -> this.player2 = new ArtficialPlayer(CellType.O);
            case 2 -> this.player2 = new RealPlayer(CellType.O);
            default -> createPlayers();
        }
        switch (choice2) {
            case 1 -> this.player1 = new ArtficialPlayer(CellType.X);
            case 2 -> this.player1 = new RealPlayer(CellType.X);
            default -> createPlayers();
        }
    }

    protected void createBoard() {
        this.board = new Cell[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new Cell(CellType.EMPTY);
            }
        }
    }

    protected Player changePlayer(Player player) {
        return player.equals(player1) ? player2 : player1;
    }

    protected void movePlayer(Player player) {
        List<Integer> choice = player.getMoveFromPlayer(player, this.board);

        Cell cellToChange = this.board[choice.get(0)][choice.get(1)];

        if (cellToChange.getCellStatement() == CellType.EMPTY) {
            if (player.equals(player1)) {
                cellToChange.setCellStatement(CellType.X);
            } else if (player.equals(player2)) {
                cellToChange.setCellStatement(CellType.O);
            }
        } else {
            GameDisplay.ALREADY_CHOOSE.display();
            movePlayer(player);
        }
    }

    protected boolean checkEmptyCell() {
        for (Cell[] cells : board) {
            for (int j = 0; j < board.length; j++) {
                if (cells[j].getCellStatement() == CellType.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkWin(Player currentPlayer) {

        for (int i = 0; i < board.length; i++) {
            boolean line = checkLineOrColumn(currentPlayer, i, true, this.board);
            boolean column = checkLineOrColumn(currentPlayer, i, false, this.board);
            boolean diagonal = checkDiag(currentPlayer, true, this.board);
            boolean diagonal2 = checkDiag(currentPlayer, false, this.board);

            System.out.println("line" +line);
            System.out.println("column" +column);
            System.out.println("diagonal" +diagonal);
            System.out.println("diagonal2" +diagonal2);

            if (line || column || diagonal || diagonal2) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean checkDiag(Player currentPlayer, boolean isFirstDiagonal, Cell[][] board);

    protected abstract boolean checkLineOrColumn(Player currentPlayer, int index, boolean isLine, Cell[][] board);

}

public class TicTacToe {

    private final int size;
    private Cell[][] board;
    private final Menu menu;
    private final Player playerX;
    private final Player playerO;

    public TicTacToe() {
        this.size = 3;
        this.menu = new Menu();
        this.playerX = new Player("X");
        this.playerO = new Player("O");
    }

    public void game() {
        createBoard();
        Player currentPlayer = playerX;

        while (checkEmptyCell()) {
            menu.displayBoard(this.board);
            GameDisplay.PLAYER_IN_GAME.display(currentPlayer.getRepresentation());
            getMoveFromPlayer(currentPlayer);
            currentPlayer = changePlayer(currentPlayer);
        }
        GameDisplay.ENDGAME.display();
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

    private void getMoveFromPlayer(Player player) {
        GameDisplay.LINE.display();
        String ligne = menu.cellChoice();

        GameDisplay.COLUMN.display();
        String colonne = menu.cellChoice();

        Cell cellToChange = this.board[Integer.parseInt(ligne)][Integer.parseInt(colonne)];

        if (cellToChange.getCellStatement() == CellType.EMPTY) {
            if (player.equals(playerX)) {
                cellToChange.setCellStatement(CellType.Player_X);
            } else if (player.equals(playerO)) {
                cellToChange.setCellStatement(CellType.Player_O);
            }
        } else {
            GameDisplay.ALREADY_CHOOSE.display();
            getMoveFromPlayer(player);
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

    public boolean checkWin() {
        boolean win = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Cell currentCell = board[i][j];
                switch (currentCell.getCellStatement()) {
                    case EMPTY -> win = false;
                }
            }
        }
        return win;
    }
}

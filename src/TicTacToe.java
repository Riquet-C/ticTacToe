public class TicTacToe {

    private final int size;
    private Cell[][] board;
    private final Menu menu;

    public TicTacToe() {
        this.size = 3;
        this.menu = new Menu();
    }

    public void game() {
        createBoard();
        while (true) {
            menu.displayBoard(this.board);
            getMoveFromPlayer();
        }
    }

    public void createBoard() {
        this.board = new Cell[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = new Cell(CellStatement.EMPTY);
            }
        }
    }

    public void getMoveFromPlayer() {
        GameDisplay.LINE.display();
        String ligne = menu.cellChoice();

        GameDisplay.COLUMN.display();
        String colonne = menu.cellChoice();

        Cell cellToChange = this.board[Integer.parseInt(ligne)][Integer.parseInt(colonne)];

        if (cellToChange.getCellStatement() == CellStatement.EMPTY) {
            cellToChange.setCellStatement(CellStatement.X);
        } else {
            GameDisplay.ALREADY_CHOOSE.display();
            getMoveFromPlayer();
        }
    }
}

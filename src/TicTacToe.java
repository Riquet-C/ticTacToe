import java.util.Arrays;

public class TicTacToe {

    private final int size;
    private Cell[][] board;

    public TicTacToe() {
        this.size = 3;
        createBoard();
    }

    public Cell[][] createBoard(){
        this.board = new Cell[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                this.board[i][j] = new Cell();
            }
        }
        return board;
    }

    public void display() {
        for(int i = 0; i < this.size; i++){
            System.out.println("\n---------------");
            for(int j = 0; j < this.size; j++){
                System.out.print("|" +board[i][j].getRepresentation() + "|");
            }
        }
    }
}

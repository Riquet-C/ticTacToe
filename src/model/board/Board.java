package model.board;

import controller.game.GameController;
import controller.player.ArtificialPlayerController;
import controller.player.PlayerController;
import controller.player.RealPlayerController;
import display.view.GameView;
import display.MessageForGame;
import display.State;
import display.view.View;
import model.Cell;
import model.player.ArtificialPlayerModel;
import model.player.PlayerModel;
import model.player.RealPlayerModel;

import java.util.List;

public class Board {

    Cell[][] board;
    View view;

    public Board(int row, int col) {
        board = createBoard(row, col);
        view = new GameView();
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

    public void placePlayerChoiceInBoard(PlayerModel player, GameController game, PlayerController playerController) {

        List<Integer> choice = playerController.getChoiceFromPlayer(board, 2);

        Cell cellToChange = game.setCellToChange(choice, board);

        if (cellToChange.getCellState() == State.EMPTY) {
            cellToChange.setCellState(player.getState());
        } else if (player.getClass() == RealPlayerModel.class) {
            view.display(MessageForGame.ALREADY_CHOOSE.getMessage());
            placePlayerChoiceInBoard(player, game, playerController);
        } else if (player.getClass() == ArtificialPlayerModel.class) {
            placePlayerChoiceInBoard(player, game, playerController);
        }
    }
}

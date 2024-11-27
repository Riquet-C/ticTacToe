package controller.game;

import controller.player.ArtificialPlayerController;
import controller.player.PlayerController;
import controller.player.RealPlayerController;
import display.*;
import display.view.GameView;
import model.board.Board;
import model.Cell;
import model.player.ArtificialPlayerModel;
import model.player.PlayerModel;

import java.util.List;

/**
 * La classe abstraite {@code BoardGame} représente le cadre de base d'un jeu de plateau générique.
 * Elle gère la logique principale du jeu, y compris la création des joueurs, la gestion du plateau,
 * et la vérification des conditions de victoire.
 * <p>
 * Cette classe doit être étendue pour implémenter des règles spécifiques de placement des pions
 * via la méthode abstraite {@code setCellToChange}.
 */
public abstract class GameController {

    private final GameView displayGame;
    private final GameType type;
    private final int col;
    private final int row;
    private final Board board;
    private final int toWin;

    protected GameController(int col, int row, int toWin, GameType type) {
        displayGame = new GameView();
        this.type = type;
        this.col = col;
        this.row = row;
        this.toWin = toWin;
        this.board = new Board(row, col);
    }

    /**
     * Démarre la boucle principale du jeu.
     * Gère les tours des joueurs jusqu'à ce qu'il y ait un gagnant ou qu'il n'y ait plus de cellules disponibles.
     */
    public void game(PlayerModel player1, PlayerModel player2) {
        PlayerModel currentPlayer = player1;
        while (!checkWin(currentPlayer) && board.checkEmptyCell()) {
            currentPlayer = changePlayer(currentPlayer, player1, player2);
            displayGame.displayBoard(board);
            displayGame.display(MessageForGame.PLAYER_IN_GAME.getMessage(), currentPlayer.getState());
            board.placePlayerChoiceInBoard(currentPlayer, this, currentPlayerController(currentPlayer));
        }
        displayGame.displayBoard(board);
        displayGame.displayEndGame(checkWin(currentPlayer), currentPlayer);
    }

    protected PlayerModel changePlayer(PlayerModel currentPlayer, PlayerModel player1, PlayerModel player2) {
        return currentPlayer.equals(player1) ? player2 : player1;
    }

    protected PlayerController currentPlayerController(PlayerModel currentPlayer) {
        if(currentPlayer.getClass() == ArtificialPlayerModel.class) {
            return new ArtificialPlayerController();
        } else {
            return new RealPlayerController();
        }
    }

    /**
     * Définit la cellule où le joueur veut jouer.
     * Cette méthode doit être implémentée par une classe concrète.
     *
     * @param choice Liste des coordonnées choisies par le joueur.
     * @param board  Plateau actuel du jeu.
     * @return Cellule à modifier.
     */
    public abstract Cell setCellToChange(List<Integer> choice, Cell[][] board);

    protected boolean checkWin(PlayerModel currentPlayer) {

        State currentPlayerState = currentPlayer.getState();

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (checkDirection(currentPlayerState, i, j, 0, 1) // check line
                        || checkDirection(currentPlayerState, i, j, 1, 0) // check column
                        || checkDirection(currentPlayerState, i, j, 1, 1) // check diag descendante
                        || checkDirection(currentPlayerState, i, j, 1, -1)) // check diag montante
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
    private boolean checkDirection(State currentPlayer, int row, int column, int u, int v) {
        for (int step = 0; step < toWin; step++) {
            if (!exist(row + u * step, column + v * step)) {
                return false;
            }
            if (board.getBoard()[row + u * step][column + v * step].getCellState() != currentPlayer) {
                return false;
            }
        }
        return true;
    }

    private boolean exist(int i, int j) {
        return i >= 0 && i < this.row && j >= 0 && j < this.col;
    }

}

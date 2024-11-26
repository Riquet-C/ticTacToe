package controller.game;

import controller.player.ControllerArtificialPlayer;
import controller.player.ControllerPlayer;
import controller.player.ControllerRealPlayer;
import model.board.Board;
import route.Menu;
import model.Cell;
import display.State;
import display.GameDisplay;
import model.player.ArtificialPlayer;
import model.player.Player;
import model.player.RealPlayer;

import java.util.List;

/**
 * La classe abstraite {@code BoardGame} représente le cadre de base d'un jeu de plateau générique.
 * Elle gère la logique principale du jeu, y compris la création des joueurs, la gestion du plateau,
 * et la vérification des conditions de victoire.
 * <p>
 * Cette classe doit être étendue pour implémenter des règles spécifiques de placement des pions
 * via la méthode abstraite {@code setCellToChange}.
 */
public abstract class BoardGame {

    private final int col;
    private final int row;
    private final Menu menu;
    private Player player1;
    private Player player2;
    private final Board board;
    private final int toWin;
    private Player currentPlayer;
    private final ControllerPlayer controllerPlayer;


    protected BoardGame(int col, int row, int toWin) {
        this.col = col;
        this.row = row;
        this.toWin = toWin;
        this.menu = new Menu();
        this.board = new Board(row, col);
        this.controllerPlayer = new ControllerPlayer();
    }

    /**
     * Démarre la boucle principale du jeu.
     * Gère les tours des joueurs jusqu'à ce qu'il y ait un gagnant ou qu'il n'y ait plus de cellules disponibles.
     */
    public void game() {
        createPlayers();
        currentPlayer = player1;

        while (!checkWin() && board.checkEmptyCell()) {
            currentPlayer = changePlayer(currentPlayer);
            GameDisplay.BOARD.displayBoard(this.board);
            GameDisplay.PLAYER_IN_GAME.display(currentPlayer.getPlayerState());
            placePlayerChoiceInBoard(currentPlayer);
        }

        GameDisplay.SHOW_WINNER.displayEndGame(this.board, checkWin(), currentPlayer);

    }

    /**
     * Crée les joueurs en demandant à l'utilisateur de choisir entre joueur réel ou artificiel.
     */
    protected void createPlayers() {
        GameDisplay.PLAYER_CHOICE.display();
        player1 = controllerPlayer.createPlayer(State.O, menu.choicePlayer());
        GameDisplay.PLAYER_CHOICE.display();
        player2 = controllerPlayer.createPlayer(State.X, menu.choicePlayer());
    }


    protected Player changePlayer(Player currentPlayer) {
        return currentPlayer.equals(player1) ? player2 : player1;
    }

    /**
     * Définit la cellule où le joueur veut jouer.
     * Cette méthode doit être implémentée par une classe concrète.
     *
     * @param choice Liste des coordonnées choisies par le joueur.
     * @param board  Plateau actuel du jeu.
     * @return Cellule à modifier.
     */
    protected abstract Cell setCellToChange(List<Integer> choice, Board board);

    /**
     * Place le choix du joueur sur le plateau.
     *
     * @param player Joueur actuel.
     */
    protected void placePlayerChoiceInBoard(Player player) {
        ControllerPlayer playerInGame = getPlayerType(player);

        List<Integer> choice = playerInGame.getChoiceFromPlayer(board, 2);

        Cell cellToChange = setCellToChange(choice, board);

        if (cellToChange.getCellState() == State.EMPTY) {
            cellToChange.setCellState(player.getPlayerState());
        } else if (player.getClass() == RealPlayer.class) {
            GameDisplay.ALREADY_CHOOSE.display();
            placePlayerChoiceInBoard(player);
        } else if (player.getClass() == ArtificialPlayer.class) {
            placePlayerChoiceInBoard(player);
        }
    }

    /**
     * Récupère le contrôleur correspondant au type de joueur.
     *
     * @param player Joueur à analyser.
     * @return Contrôleur du joueur (réel ou artificiel).
     */
    private ControllerPlayer getPlayerType(Player player) {
        if (player.getClass() == ArtificialPlayer.class) {
            return new ControllerArtificialPlayer();
        } else {
            return new ControllerRealPlayer();
        }
    }

    protected boolean checkWin() {

        State currentPlayerState = currentPlayer.getPlayerState();

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

package controller.game;

import controller.player.PlayerController;
import display.*;
import display.view.GameView;
import model.State;
import model.game.GameModel;
import model.board.Board;
import model.player.PlayerManager;
import display.Menu;

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
    private final PlayerController playerController;
    private final Menu menu;
    private final Board board;
    private final PlayerManager playerManager;
    private final int toWin;
    private final GameType type;
    private final int choiceToDo;

    protected GameController(int col, int row, int toWin, int choiceToDo, GameType type) {
        this.type = type;
        this.toWin = toWin;
        this.choiceToDo = choiceToDo;

        displayGame = new GameView();
        playerManager = new PlayerManager();
        playerController = new PlayerController();
        menu = new Menu();
        board = new Board(row, col);
    }


    /**
     * Démarre la boucle principale du jeu.
     * Gère les tours des joueurs jusqu'à ce qu'il y ait un gagnant ou qu'il n'y ait plus de cellules disponibles.
     */
    public void game() {
        createPlayers(2);
        while (!isEnding()) {
            playerManager.changePlayer();
            displayGame.display(board.getRepresentation());
            displayGame.display(MessageForGame.PLAYER_IN_GAME.getMessage(), playerManager.getCurrentState());
            movePlayer();
        }
        displayGame.display(board.getRepresentation());
        displayGame.displayEndGame(board.checkWin(playerManager.getCurrentState(), toWin), playerManager.getRepresentation());
    }

    private void createPlayers(int nbJoueur) {
        for (int i = 0; i < nbJoueur; i++) {
            State state = (i % nbJoueur == 0) ? State.O : State.X;
            displayGame.display(MessageForGame.PLAYER_CHOICE.getMessage());
            playerManager.createPlayer(state, menu.choicePlayer());
        }
    }

    private boolean isEnding() {
        return board.checkWin(playerManager.getCurrentState(), toWin) || !board.isBoardEmpty();
    }

    private void movePlayer() {
        List<Integer> choice = playerChoice();

        int col = board.setCol(choice, type);
        int row = board.setRow(col, choice, type);

        if (board.isCellChangeable(row, col)) {
            board.setCellToChange(row, col, playerManager.getCurrentState());
        } else movePlayer();
    }

    private List<Integer> playerChoice() {
        if (!playerManager.isCurrentPlayerAutonomous()) {
            return playerController.getChoiceFromPlayer(board.getNbRow(), board.getNbCol(), choiceToDo);
        } else {
            return playerController.artificialChoice(board.getNbCol(), choiceToDo);
        }
    }

}

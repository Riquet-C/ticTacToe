package controller.game;

import controller.player.PlayerController;
import display.*;
import display.view.GameView;
import model.game.GameModel;
import model.board.Board;
import model.board.Cell;
import model.game.PuissanceQuatreModel;
import model.player.ArtificialPlayerModel;
import model.player.PlayerManager;
import model.player.PlayerModel;
import display.Menu;
import model.player.RealPlayerModel;

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

    private final GameModel gameModel;
    private final GameView displayGame;
    private final PlayerController playerController;
    private final Menu menu;
    private final Board board;
    private final PlayerManager playerManager;
    private final int toWin;
    private final GameType type;
    private final int choiceToDo;

    protected GameController(int col, int row, int toWin, int choiceToDo, GameType type) {
        gameModel = setGameModel();
        displayGame = new GameView();
        playerManager = new PlayerManager();
        playerController = new PlayerController();
        menu = new Menu();
        board = new Board(row, col);

        this.type = type;
        this.toWin = toWin;
        this.choiceToDo = choiceToDo;
    }

    private GameModel setGameModel() {
       if(type == GameType.PuissanceQuatre){
           return new PuissanceQuatreModel();
       } else {
           return new GameModel();
       }
    }

    /**
     * Démarre la boucle principale du jeu.
     * Gère les tours des joueurs jusqu'à ce qu'il y ait un gagnant ou qu'il n'y ait plus de cellules disponibles.
     */
    public void game() {
        createPlayers();
        PlayerModel currentPlayer = playerManager.getCurrentPlayer();
        while (!board.checkWin(currentPlayer, toWin) && board.checkEmptyCell()) {
            currentPlayer = playerManager.getCurrentPlayer();
            displayGame.displayBoard(board);
            displayGame.display(MessageForGame.PLAYER_IN_GAME.getMessage(), currentPlayer.getState());
            movePlayer(currentPlayer);
            playerManager.changePlayer();
        }
        displayGame.displayBoard(board);
        displayGame.displayEndGame(board.checkWin(currentPlayer, toWin), currentPlayer);
    }

    private void createPlayers() {
        displayGame.display(MessageForGame.PLAYER_CHOICE.getMessage());
        PlayerModel player1 = playerManager.createPlayer(State.O, menu.choicePlayer());
        displayGame.display(MessageForGame.PLAYER_CHOICE.getMessage());
        PlayerModel player2 = playerManager.createPlayer(State.X, menu.choicePlayer());
        playerManager.setPlayers(new PlayerModel[]{player1, player2});
    }

    private void movePlayer(PlayerModel currentPlayer) {

        List<Integer> choice = playerChoice(currentPlayer);

        Cell cellToChange = gameModel.setCellToChange(choice, board.getBoard());
        if (cellToChange.getCellState() == State.EMPTY) {
            cellToChange.setCellState(currentPlayer.getState());
        } else if (currentPlayer.getClass() == RealPlayerModel.class) {
            displayGame.display(MessageForGame.ALREADY_CHOOSE.getMessage());
            movePlayer(currentPlayer);
        } else if (currentPlayer.getClass() == ArtificialPlayerModel.class) {
            movePlayer(currentPlayer);
        }
    }

    private List<Integer> playerChoice(PlayerModel currentPlayer) {
        if (!currentPlayer.isAutonomous()) {
            return playerController.getChoiceFromPlayer(board.getBoard(), choiceToDo);
        } else {
            return playerController.artificialChoice(board.getBoard(), choiceToDo);
        }
    }
}

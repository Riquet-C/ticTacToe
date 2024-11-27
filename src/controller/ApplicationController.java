package controller;

import controller.game.GameController;
import controller.game.Gomoku;
import controller.game.PuissanceQuatre;
import controller.game.TicTacToe;
import model.player.CreatePlayerModel;
import display.view.ApplicationView;
import display.MessageForGame;
import display.State;
import model.player.PlayerModel;
import route.Menu;

public class ApplicationController {

    private final CreatePlayerModel createPlayerModel;
    private final Menu menu;
    private final ApplicationView displayMenu;
    private PlayerModel player1;
    private PlayerModel player2;

    public ApplicationController() {
        createPlayerModel = new CreatePlayerModel();
        displayMenu = new ApplicationView();
        menu = new Menu();
    }

    public void game(){
        displayMenu.firstGame();
        while (true){
            GameController game = choiceGame();
            createPlayers();
            game.game(player1, player2);
            displayMenu.replay();
        }
    }

    public void createPlayers() {
        displayMenu.display(MessageForGame.PLAYER_CHOICE.getMessage());
        player1 = createPlayerModel.createPlayer(State.O, menu.choicePlayer());
        displayMenu.display(MessageForGame.PLAYER_CHOICE.getMessage());
        player2 = createPlayerModel.createPlayer(State.X, menu.choicePlayer());
    }

    public GameController choiceGame() {
        Menu menu = new Menu();
        int choice = menu.choiceGame();

        switch (choice){
            case 1 -> {
                displayMenu.display(MessageForGame.GAME.getMessage(), "Tic-Tac-Toe");
                return new TicTacToe();
            }
            case 2 -> {
                displayMenu.display(MessageForGame.GAME.getMessage(), "Gomoku");
                return new Gomoku();
            }
            case 3 -> {
                displayMenu.display(MessageForGame.GAME.getMessage(), "Puissance Quatre");
                return new PuissanceQuatre();
            }
            case 4 -> {
                displayMenu.display(MessageForGame.ENDGAME.getMessage());
                System.exit(0);
            }
            default -> {
                displayMenu.display(MessageForGame.INVALIDE_CHOICE.getMessage());
                choiceGame();
            }
        }
        return null;
    }

}

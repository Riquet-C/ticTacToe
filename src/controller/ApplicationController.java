package controller;

import controller.game.GameController;
import controller.game.Gomoku;
import controller.game.PuissanceQuatre;
import controller.game.TicTacToe;
import display.view.ApplicationView;
import display.MessageForGame;
import display.Menu;

public class ApplicationController {

    private boolean continueGame;
    private final ApplicationView displayMenu;

    public ApplicationController() {
        displayMenu = new ApplicationView();
        continueGame = true;
    }

    public void game(){
        displayMenu.firstGame();
        while (continueGame) {
            GameController game = choiceGame();
            game.game();
            displayMenu.replay();
        }
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
                continueGame = false;
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

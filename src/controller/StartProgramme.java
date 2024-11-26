package controller;

import controller.game.BoardGame;
import controller.game.Gomoku;
import controller.game.PuissanceQuatre;
import controller.game.TicTacToe;
import display.GameDisplay;
import route.Menu;

public class StartProgramme {

    public BoardGame choiceGame() {
        Menu menu = new Menu();
        int choice = menu.choiceGame();

        switch (choice){
            case 1 -> {
                GameDisplay.GAME.display("Tic-Tac-Toe");
                return new TicTacToe();
            }
            case 2 -> {
                GameDisplay.GAME.display("Gomoku");
                return new Gomoku();
            }
            case 3 -> {
                GameDisplay.GAME.display("Puissance Quatre");
                return new PuissanceQuatre();
            }
            case 4 -> {
                GameDisplay.ENDGAME.display();
                System.exit(0);
            }
            default -> {
                GameDisplay.INVALIDE_CHOICE.display();
                choiceGame();
            }
        }
        return null;
    }

    public void firstGame(){
        GameDisplay.START_GAME.display();
        GameDisplay.CHOOSE_GAME.display();
    }

    public void replay(){
        GameDisplay.CHOOSE_GAME.display();
    }

}

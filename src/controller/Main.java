package controller;

import controller.game.BoardGame;

public class Main {

    public static void main(String[] args) {
        StartProgramme gameToStart = new StartProgramme();
        gameToStart.firstGame();
        while (true){
            BoardGame game = gameToStart.choiceGame();
            game.game();
            gameToStart.replay();
        }
    }
}
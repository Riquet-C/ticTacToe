package controller.player;

import model.board.Board;

import java.util.ArrayList;
import java.util.Random;

public class ControllerArtificialPlayer extends ControllerPlayer {
    Random randomNumbers;

    public ControllerArtificialPlayer() {
        randomNumbers = new Random();
    }

    @Override
    public ArrayList<Integer> getChoiceFromPlayer(Board board, int choiceToDO) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDO);

        for (int i = 1; i <= choiceToDO; i++) {
            playerChoice.add(randomNumbers.nextInt(board.getBoard()[0].length));
        }

        return playerChoice;
    }
}

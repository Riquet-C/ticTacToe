package controller.player;

import model.Cell;

import java.util.ArrayList;
import java.util.Random;

public class ArtificialPlayerController extends PlayerController {

    private final Random randomNumber;

    public ArtificialPlayerController() {
        randomNumber = new Random();
    }
    @Override
    public ArrayList<Integer> getChoiceFromPlayer(Cell[][] board, int choiceToDO) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDO);

        for (int i = 1; i <= choiceToDO; i++) {
            playerChoice.add(randomNumber.nextInt(board[0].length));
        }

        return playerChoice;
    }
}

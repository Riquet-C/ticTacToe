package player;

import model.Cell;
import display.Representation;

import java.util.ArrayList;
import java.util.Random;

public class ArtficialPlayer extends Player {

    private final Random randomNumbers;

    public ArtficialPlayer(Representation representation) {
        super(representation);
        randomNumbers = new Random();
    }

    @Override
    public ArrayList<Integer> getMoveFromPlayer(Player player, Cell[][] board, int choiceToDO) {

        ArrayList<Integer> playerChoice = new ArrayList<>(choiceToDO);

        for (int i = 1; i <= choiceToDO; i++) {
            playerChoice.add(randomNumbers.nextInt(board[0].length));
        }

        return playerChoice;
    }
}

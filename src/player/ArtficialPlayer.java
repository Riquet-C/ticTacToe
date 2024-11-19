package player;

import display.GameDisplay;

import java.util.ArrayList;
import java.util.Random;

public class ArtficialPlayer extends Player {

    private final Random randomNumbers;

    public ArtficialPlayer(String representation) {
        super(representation);
        randomNumbers = new Random();

    }

    @Override
    public ArrayList<String> getMoveFromPlayer(Player player) {

        ArrayList<String> playerChoice = new ArrayList<>(2);
        playerChoice.add(String.valueOf(randomNumbers.nextInt(2)));
        playerChoice.add(String.valueOf(randomNumbers.nextInt(2)));

        return playerChoice;
    }
}

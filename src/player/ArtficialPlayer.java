package player;

import cells.Cell;
import cells.CellType;

import java.util.ArrayList;
import java.util.Random;

public class ArtficialPlayer extends Player {

    private final Random randomNumbers;

    public ArtficialPlayer(CellType representation) {
        super(representation);
        randomNumbers = new Random();
    }

    @Override
    public ArrayList<Integer> getMoveFromPlayer(Player player, Cell[][] board) {

        ArrayList<Integer> playerChoice = new ArrayList<>(2);
        playerChoice.add(randomNumbers.nextInt(board.length));
        playerChoice.add(randomNumbers.nextInt(board.length));

        return playerChoice;
    }
}

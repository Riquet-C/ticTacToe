package controller.player;

import display.GameDisplay;
import display.State;
import model.board.Board;
import model.player.ArtificialPlayer;
import model.player.Player;
import model.player.RealPlayer;

import java.util.List;

public class ControllerPlayer {

    public ControllerPlayer() {
    }

    // TODO create exception
    public Player createPlayer(State state, int choice){
        switch (choice) {
            case 1 -> {
                return new ArtificialPlayer(state);
            }
            case 2 -> {
                return new RealPlayer(state);
            }
            default -> new RealPlayer(state);
        }
        return null;
    }

    public List<Integer> getChoiceFromPlayer(Board board, int choiceToDo) {
        return null;
    }
}

package model.player;

import controller.player.ControllerArtificialPlayer;
import model.Cell;
import display.State;

import java.util.List;

public abstract class Player {
    private final State state;

    protected Player(State state) {
        this.state = state;
    }

    public State getPlayerState() {
        return state;
    }

}

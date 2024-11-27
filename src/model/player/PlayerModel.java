package model.player;

import display.State;

public abstract class PlayerModel {
    private final State state;

    protected PlayerModel(State state) {
        this.state = state;
    }

    public State getState() {return state;}
}

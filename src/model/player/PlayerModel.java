package model.player;

import display.State;

public abstract class PlayerModel {
    private final State state;
    private final boolean isAutonomous;

    protected PlayerModel(State state, Boolean isAutonomous) {
        this.state = state;
        this.isAutonomous = isAutonomous;
    }
    public State getState() {
        return state;
    }

    public boolean isAutonomous() {
        return isAutonomous;
    }
}

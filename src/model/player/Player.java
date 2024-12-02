package model.player;

import model.State;

public abstract class Player {
    private final State state;
    private final boolean isAutonomous;

    protected Player(State state, Boolean isAutonomous) {
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

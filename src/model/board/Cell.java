package model.board;

import display.State;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public State getCellState() {
        return state;
    }

    public void setCellState(State state) {
        this.state = state;
    }

}

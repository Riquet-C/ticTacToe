package model.board;

import model.State;

public class Cell {

    private State state;

    public Cell() {
        this.state = State.EMPTY;
    }

    public State getCellState() {
        return state;
    }


    public String getRepresentation(){
        return "| " + state.getType()+ "  ";
    }

    public boolean occupy(State state) {
        if(state != null && isEmpty() && state!=State.EMPTY) {
            this.state=state;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return state==State.EMPTY;
    }
}

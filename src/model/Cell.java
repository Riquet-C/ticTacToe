package model;

import display.Representation;

public class Cell {

    private Representation representation;

    public Cell(Representation representation) {
        this.representation = representation;
    }

    public Representation getCellRepresentation() {
        return representation;
    }

    public void setCellRepresentation(Representation representation) {
        this.representation = representation;
    }

}

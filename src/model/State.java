package model;

import model.board.Board;

public enum State {

    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),

    EMPTY("   "),
    X(ANSI_GREEN.type + " X " + ANSI_RESET.type),
    O(ANSI_YELLOW.type + " O " + ANSI_RESET.type);

    private final String type;

    State(String type) {
        this.type = type;
    }

    public String getType() {return type;}

}

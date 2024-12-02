package model.player;

import model.State;

public class PlayerFactory {
    public static Player createPlayer(State state, int choice){
        return switch (choice) {
            case 1 -> new ArtificialPlayer(state);
            case 2 -> new RealPlayer(state);
            default -> new RealPlayer(state);
        };
    }
}

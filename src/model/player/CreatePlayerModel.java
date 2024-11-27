package model.player;


import display.State;

public class CreatePlayerModel {
    // TODO create exception
    public PlayerModel createPlayer(State state, int choice){
        switch (choice) {
            case 1 -> {
                return new ArtificialPlayerModel(state);
            }
            case 2 -> {
                return new RealPlayerModel(state);
            }
            default -> new RealPlayerModel(state);
        }
        return null;
    }
}

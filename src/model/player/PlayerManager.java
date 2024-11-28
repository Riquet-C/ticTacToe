package model.player;


import display.State;

public class PlayerManager {

    private PlayerModel[] players;
    private int currentPlayerIndex =0;

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

    public void setPlayers(PlayerModel[] players) {
        this.players = players;
    }

    public PlayerModel getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public void changePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
}

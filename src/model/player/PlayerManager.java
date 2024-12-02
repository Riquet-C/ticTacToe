package model.player;

import display.MessageForGame;
import model.State;

import java.util.ArrayList;
import java.util.List;


public class PlayerManager {

    private final List<Player> players;
    private int currentPlayerIndex =0;

    public PlayerManager() {
        players = new ArrayList<>();
    }


    public void createPlayer(State state, int choice) {
      Player player = PlayerFactory.createPlayer(state, choice);
      setPlayers(player);
    }

    public void setPlayers(Player player) {
        this.players.add(player);
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public State getCurrentState() {
        return getCurrentPlayer().getState();
    }

    public String getRepresentation(){
        return getCurrentPlayer().getState().toString();
    }

    public boolean isCurrentPlayerAutonomous(){
        return getCurrentPlayer().isAutonomous();
    }

    public void changePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}

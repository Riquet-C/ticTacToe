package model.player;

import display.State;

import java.util.Random;

public class ArtificialPlayerModel extends PlayerModel {
    Random randomNumbers;

    public ArtificialPlayerModel(State state) {
        super(state);
        randomNumbers = new Random();
    }

}

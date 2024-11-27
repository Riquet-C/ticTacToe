package model.player;

import display.State;
import route.Menu;

public class RealPlayerModel extends PlayerModel {

    Menu menu;

    public RealPlayerModel(State state) {
        super(state);
        menu = new Menu();
    }

}

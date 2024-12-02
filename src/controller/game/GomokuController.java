package controller.game;

import display.GameType;

public class GomokuController extends GameController {
    public GomokuController() {
        super(15, 15, 5, 2, GameType.Gomoku);
    }
}

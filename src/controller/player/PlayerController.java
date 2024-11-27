package controller.player;

import model.Cell;

import java.util.List;

public abstract class PlayerController {

    public abstract List<Integer> getChoiceFromPlayer(Cell[][] board, int choiceToDo);

}

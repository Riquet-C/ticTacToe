package display.view;

import display.MessageForGame;

public class ApplicationView extends View {

    public void firstGame(){
        display(MessageForGame.START_GAME.getMessage());
        display(MessageForGame.CHOOSE_GAME.getMessage());
    }

    public void replay(){
        display(MessageForGame.CHOOSE_GAME.getMessage());
    }

}
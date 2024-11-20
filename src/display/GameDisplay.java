package display;

import cells.Cell;

public enum GameDisplay {

    LINE("Ecrivez le 0 ; 1 ou 2 pour choisir votre ligne \n"),
    COLUMN("Ecrivez le 0 ; 1 ou 2 pour choisir votre colonne \n"),
    ALREADY_CHOOSE("Cette case est déjà occupé, veuillez en choisir une autre \n"),
    PLAYER_IN_GAME("Au tour du joueur %s \n"),
    PLAYER_CHOICE("Tape 1 pour que le joueur soit un ordinateur, Tape 2 pour un joueur reel \n"),
    BOARD(""),
    FULL_BOARD("Plateau plein\n"),
    WIN_GAME("Gagné !\n"),
    ENDGAME("Fin du jeu. \n");

    private final String message;

    GameDisplay(String message) {
        this.message = message;
    }

    public void display(Object... parameters){
        System.out.printf(this.message, parameters);
    }

    public void displayBoard(Cell[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j].getCellStatement().display();
                System.out.print(j < board.length - 1 ? " | " : "");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("---------------");
            }
        }
    }
}

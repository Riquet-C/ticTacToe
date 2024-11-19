package display;

public enum GameDisplay {

    LINE("Ecrivez le 0 ; 1 ou 2 pour choisir votre ligne"),
    COLUMN("Ecrivez le 0 ; 1 ou 2 pour choisir votre colonne"),
    ALREADY_CHOOSE("Cette case est déjà occupé, veuillez en choisir une autre"),
    PLAYER_IN_GAME("Au tour du joueur %s \n"),
    PLAYER_CHOICE("Tape 1 pour que le joueur soit un ordinateur, Tape 2 pour un joueur reel"),
    ENDGAME("Fin du jeu, le plateau est rempli.");

    private final String message;

    GameDisplay(String message) {
        this.message = message;
    }

    public void display(Object... parameters){
        System.out.printf(this.message, parameters);
    }
}

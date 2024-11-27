package display;

public enum MessageForGame {

    ANSI_PURPLE("\u001B[35m"),
    ANSI_RESET("\u001B[0m"),
    START_GAME("╦ ╦┌─┐┬  ┌─┐┌─┐┌┬┐┌─┐  ┬┌┐┌  ┬ ┬┌─┐┬ ┬┬─┐  ┌─┐┌─┐┌┬┐┌─┐  ┌─┐┬  ┌─┐┌┬┐┌─┐┌─┐┬─┐┌┬┐  ┬┬\n" +
            "║║║├┤ │  │  │ ││││├┤   ││││  └┬┘│ ││ │├┬┘  │ ┬├─┤│││├┤   ├─┘│  ├─┤ │ ├┤ │ │├┬┘│││  ││\n" +
            "╚╩╝└─┘┴─┘└─┘└─┘┴ ┴└─┘  ┴┘└┘   ┴ └─┘└─┘┴└─  └─┘┴ ┴┴ ┴└─┘  ┴  ┴─┘┴ ┴ ┴ └  └─┘┴└─┴ ┴  oo \n"),
    CHOOSE_GAME("╔═╗┬ ┬┌─┐┬┌─┐┬┌─┐┌─┐┌─┐┌─┐  ┬ ┬┌┐┌   ┬┌─┐┬ ┬\n" +
            "║  ├─┤│ ││└─┐│└─┐└─┐├┤ ┌─┘  │ ││││   │├┤ │ │\n" +
            "╚═╝┴ ┴└─┘┴└─┘┴└─┘└─┘└─┘└─┘  └─┘┘└┘  └┘└─┘└─┘ : \n" + "1 => TICTACTOE \n" + "2 => GOMOKU \n" + "3 => Puissance 4 \n" + "4 => Quitter \n" +
            ANSI_PURPLE.message + "Taper 1 / 2 / 3 ou 4 pour choisir: \n" + ANSI_RESET.message),
    GAME("Vous avez choisi de jouer à %s\n"),
    LINE(ANSI_PURPLE.message + "Choissisez votre ligne entre 1 et %d\n" + ANSI_RESET.message),
    COLUMN(ANSI_PURPLE.message + "Choissisez votre colonne entre 1 et %d \n" +ANSI_RESET.message),
    ALREADY_CHOOSE("Cette case est déjà occupé, veuillez en choisir une autre \n"),
    PLAYER_IN_GAME("Au tour du joueur %s \n"),
    PLAYER_CHOICE(ANSI_PURPLE.message +"Tape 1 pour que le joueur soit un ordinateur, Tape 2 pour un joueur reel \n" +ANSI_RESET.message),
    INVALIDE_CHOICE("Choix invalide, veuillez en choisir un autre \n"),
    BOARD(""),
    SHOW_WINNER(""),
    FULL_BOARD("Egalité\n"),
    WIN_GAME("Gagné par le joueur %s!\n"),
    ENDGAME("╔═╗┬┌┐┌  ┌┬┐┬ ┬   ┬┌─┐┬ ┬\n" +
            "╠╣ ││││   │││ │   │├┤ │ │\n" +
            "╚  ┴┘└┘  ─┴┘└─┘  └┘└─┘└─┘ \n");


    private final String message;

    MessageForGame(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
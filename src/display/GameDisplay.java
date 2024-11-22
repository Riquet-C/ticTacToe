package display;

import model.Cell;
import player.Player;

public enum GameDisplay {

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

    GameDisplay(String message) {
        this.message = message;
    }

    public void display(Object... parameters) {
        System.out.printf(this.message, parameters);
    }

    public void displayBoard(Cell[][] board) {
        System.out.print("    ");
        for (int col = 0; col < board[0].length; col++) {
            System.out.printf("  %2d   ", (col + 1)); // Format des numéros de colonnes
        }
        System.out.println();
        System.out.println("   " + "+------".repeat(board[0].length) + "+");
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%2d | ", (i + 1));
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].getCellRepresentation().display();
                System.out.print( "  | ");
            }
            System.out.println();
            System.out.println("   " + "+------".repeat(board[0].length) + "+");
        }
    }

    public void displayEndGame(Cell[][] board, Boolean isWinner, Player currentPlayer) {
        if (isWinner) {
            GameDisplay.BOARD.displayBoard(board);
            GameDisplay.WIN_GAME.display(currentPlayer.getPlayerRepresentation());
        } else {
            GameDisplay.FULL_BOARD.display();
            GameDisplay.BOARD.displayBoard(board);
        }
        GameDisplay.ENDGAME.display();
    }
}
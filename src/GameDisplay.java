import java.util.Scanner;

public enum GameDisplay {

    LINE("Ecrivez le 0 ; 1 ou 2 pour choisir votre ligne"),
    COLUMN("Ecrivez le 0 ; 1 ou 2 pour choisir votre colonne"),
    ALREADY_CHOOSE("Cette case est déjà occupé, veuillez en choisir une autre");

    private final String message;

    GameDisplay(String message) {
        this.message = message;
    }

    public void display(){
        System.out.println(this.message);
    }
}

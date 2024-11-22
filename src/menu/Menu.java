package menu;

import game.AnswerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Vérifie si le scanner renvoie une valeur autorisée
    private int askInt(List<Integer> availableAnswers) throws AnswerException {
        if (availableAnswers == null || availableAnswers.isEmpty()) {
            throw new AnswerException("Aucun choix disponible \n");
        }
        if (scanner.hasNextInt()) {
            int answer = scanner.nextInt();
            if (!availableAnswers.contains(answer)) {
                throw new AnswerException("Choix invalide, veuillez refaire votre choix \n");
            }
            return answer;
        } else {
            throw new AnswerException("Choix invalide, veuillez refaire votre choix \n");
        }
    }

    // Créer une liste de valeur acceptée
    public List<Integer> availableAnswers(int boardLength){
        List<Integer> availableAnswers = new ArrayList<>(boardLength);
        for (int i = 0; i < boardLength ; i++) {
            availableAnswers.add(i+1);
            System.out.println(availableAnswers);
        }
        return availableAnswers;
    }

    public int choiceGame(){
        List<Integer> availableAnswers = List.of(1, 2, 3, 4);
        try {
            return askInt(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return choicePlayer();
        }
    }

    public int choiceCell(int boardLength){
        List<Integer> availableAnswers = availableAnswers(boardLength);
        try {
            return askInt(availableAnswers) -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return choiceCell(boardLength);
        }
    }

    public int choicePlayer() {
        List<Integer> availableAnswers = List.of(1, 2);
        try {
            return askInt(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return choicePlayer();
        }
    }
}

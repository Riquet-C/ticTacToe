package game;

import cells.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }


    private Integer ask(List<Integer> availableAnswers) throws Exception {
        if (availableAnswers == null || availableAnswers.isEmpty()) {
            throw new Exception("No possible answers available");
        }
        Integer answer = Integer.valueOf(scanner.nextLine());
        if (!availableAnswers.contains(answer)) {
            throw new Exception("Not acceptable answer");
        }
        return answer;
    }

    public List<Integer> availableAnswers(Cell[][] board){
        List<Integer> availableAnswers = new ArrayList<>(board.length);
        for (int i = 0; i < board.length ; i++) {
            availableAnswers.add(i);
        }
        return availableAnswers;
    }

    public Integer cellChoice(Cell[][] board){
        List<Integer> availableAnswers = availableAnswers(board);
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cellChoice(board);
        }
    }

    public Integer choicePlayer() {
        List<Integer> availableAnswers = List.of(1, 2);
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return choicePlayer();
        }
    }
}

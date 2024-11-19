package game;

import cells.Cell;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
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

    private String ask(List<String> availableAnswers) throws Exception {
        if (availableAnswers == null || availableAnswers.isEmpty()) {
            throw new Exception("No possible answers available");
        }
        String answer = scanner.nextLine();
        if (!availableAnswers.contains(answer)) {
            throw new Exception("Not acceptable answer");
        }
        return answer;
    }

    public String cellChoice(){
        List<String> availableAnswers = List.of("0", "1", "2");
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cellChoice();
        }
    }

    public String choicePlayer() {
        List<String> availableAnswers = List.of("1", "2");
        try {
            return ask(availableAnswers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cellChoice();
        }
    }
}

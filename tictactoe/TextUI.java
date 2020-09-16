package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private TicTacToe ticTacToe;

    public TextUI(Scanner scanner, TicTacToe ticTacToe) {
        this.scanner = scanner;
        this.ticTacToe = ticTacToe;
    }

    public void start() {
        ticTacToe.printBoard();
        while (true) {
            int[] coordinates = getCoordinates("Enter Coordinates: ");
            int xCoordinate = coordinates[0];
            int yCoordinate = coordinates[1];

            if (ticTacToe.makeMove(xCoordinate, yCoordinate)) {
                ticTacToe.printBoard();
                if (ticTacToe.winCheck(ticTacToe.computeSymbol())) {
                    System.out.println(ticTacToe.computeSymbol() + " wins");
                    break;
                }
                if (ticTacToe.getTurn() == 8) {
                    System.out.println("Draw");
                    break;
                }
                ticTacToe.nextTurn();
            }
        }
    }

    private int[] getCoordinates(String prompt) {
        int[] coordinates = new int[2];
        while (true)
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                String[] parts = input.split("\\s* \\s*");
                if (parts.length != 2) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                coordinates[0] = Integer.parseInt(parts[0]);
                coordinates[1] = Integer.parseInt(parts[1]);

                if (coordinates[0] < 1 || coordinates[0] > 3 ||
                        coordinates[1] < 1 || coordinates[1] > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        return coordinates;
    }
}

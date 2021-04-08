package battleship;

import java.util.Scanner;

public class Game {

    public static void play(String[][] board) {

        boolean shotLoop = true;
        System.out.println("The game starts!");
        Board.printBoard();
        System.out.print("Take a shot!\n\n> ");

        // checking and validating coordinates range and placement on the board
        while (shotLoop) {
            Main.scanner.reset();
            Main.scanner = new Scanner(System.in);
            String shotCoordinate = Main.scanner.next();
            // coordinates on board to ints
            int x1 = Character.toUpperCase(shotCoordinate.charAt(0)) - 'A' + 1;  // letter (horizontal)
            int y1 = Integer.parseInt(shotCoordinate.substring(1));               // number (vertical)
            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10) {
                if (Board.board[x1][y1].equals("O")) {
                    Board.board[x1][y1] = "X";
                    Board.printBoard();
                    System.out.println("You hit a ship!");
                } else {
                    Board.board[x1][y1] = "M";
                    Board.printBoard();
                    System.out.println("You missed!");
                }
                shotLoop = false;
                break;
            } else {
                System.out.print("\nError! You entered the wrong coordinates! Try again:\n\n> ");
            }
        }
    }
}

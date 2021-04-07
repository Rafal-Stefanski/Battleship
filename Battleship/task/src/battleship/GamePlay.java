package battleship;

import java.awt.*;
import java.util.Scanner;

public class GamePlay {

    public static void play(String[][] board) {
        System.out.println("The game starts!");
//        label:
        Main.scanner.reset();
        Main.scanner = new Scanner(System.in);
        String shotCoordinate = Main.scanner.next();
        // coordinates on board to ints
        int x1 = Character.toUpperCase(shotCoordinate.charAt(0)) - 'A' + 1;  // letter (horizontal)
        int y1 = Integer.parseInt(shotCoordinate.substring(1));               // number (vertical)

        // checking and validating coordinates range and placement on the board
        while (true) {

            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10) {
                if (Board.board[x1][y1].equals("O")) {
                    Board.board[x1][y1] = "X";
                    Board.printBoard();
                    System.out.println("\nYou hit a ship!\n");
                } else {
                    Board.board[x1][y1] = "M";
                    Board.printBoard();
                    System.out.println("\nYou missed!\n");
                }
                break;
            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
//                continue label;
            }
        }

    }

}

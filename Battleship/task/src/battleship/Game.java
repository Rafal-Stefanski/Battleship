package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    public static Scanner scanner = new Scanner(System.in);

//    public void playOnePlayerBoard(Board board) {
//
//        System.out.println("The game starts!");
//        board.printHiddenBoard();
//        System.out.print("Take a shot!\n\n> ");
//
//        // scanning, checking and validating shots coordinates.
//        while (true) {
//            scanner.reset();
//            scanner = new Scanner(System.in);
//            String shotCoordinate = scanner.next();
//            // coordinates on board to ints
//            int x1 = Character.toUpperCase(shotCoordinate.charAt(0)) - 'A' + 1;  // letter (horizontal)
//            int y1 = Integer.parseInt(shotCoordinate.substring(1));               // number (vertical)
//
//            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10) {
//                if (board.getBoard()[x1][y1].equals("M")) {
//                    System.out.print("\nError! You've already shot this spot.. Try again:\n\n> ");
////                    System.out.print("\nYou hit a ship! Try again:\n> ");
//
//                } else if (board.getBoard()[x1][y1].equals("O") || board.getBoard()[x1][y1].equals("X")) {
//                    board.getBoard()[x1][y1] = "X";
//                    board.getHiddenBoard()[x1][y1] = "X";
////                    shipCounter--;
//                    board.printHiddenBoard();
////                    if (board.checker(x1, y1)) {
////                        System.out.print("\nYou hit a ship! Try again:\n\n> ");
////                    } else
//
//                    board.shipHitCounter(x1, y1);
//
//                    if (board.getShipCounter() == 0) {
//                        System.out.println("You sank the last ship. You won. Congratulations!");
//                        break;
//                    }
////                    else {
////                        System.out.println("You sank a ship!");
////                    }
//
//                } else {
//                    board.getBoard()[x1][y1] = "M";
//                    board.getHiddenBoard()[x1][y1] = "M";
//                    board.printHiddenBoard();
//                    System.out.print("You missed! Try again:\n\n> ");
//                }
////                Board.printBoard();
////                break;
//            } else {
//                System.out.print("\nError! You entered the wrong coordinates! Try again:\n\n> ");
//            }
//        }
//    } // only for testing part includes own shooting procedure

    public void playTwoPlayers(Board boardPlayer1, Board boardPlayer2) {

        while (boardPlayer1.getShipCounter() != 0 && boardPlayer2.getShipCounter() != 0) {
            boardPlayer2.printHiddenBoard();
            System.out.print("\n---------------------");
            boardPlayer1.printBoard();
            System.out.print("Player 1, it's your turn:\n\n> ");
            takeAShot(boardPlayer2);
            System.out.println();
            promptEnterKey();

            boardPlayer1.printHiddenBoard();
            System.out.print("\n---------------------");
            boardPlayer2.printBoard();
            System.out.print("Player 2, it's your turn:\n\n> ");
            takeAShot(boardPlayer1);
            System.out.println();
            promptEnterKey();

        }
    }

    public void takeAShot(Board board) {
        // scanning, checking and validating shots coordinates.
        while (true) {
            scanner.reset();
            scanner = new Scanner(System.in);
            String shotCoordinate = scanner.next();
            // coordinates on board to ints
            int x1 = Character.toUpperCase(shotCoordinate.charAt(0)) - 'A' + 1;  // letter (horizontal)
            int y1 = Integer.parseInt(shotCoordinate.substring(1));               // number (vertical)
            scanner.reset();
            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10) {
                if (board.getBoard()[x1][y1].equals("M")) {
                    System.out.print("\nError! You've already shot this spot.. Try again:\n\n> ");

                } else if (board.getBoard()[x1][y1].equals("O") || board.getBoard()[x1][y1].equals("X")) {
                    board.getBoard()[x1][y1] = "X";
                    board.getHiddenBoard()[x1][y1] = "X";

                    board.shipHitCounter(x1, y1);

                    if (board.getShipCounter() == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    }
                    break;

                } else {
                    board.getBoard()[x1][y1] = "M";
                    board.getHiddenBoard()[x1][y1] = "M";
                    System.out.print("You missed!");
                    break;
                }
            } else {
                System.out.print("\nError! You entered the wrong coordinates! Try again:\n\n> ");
            }
        }
    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player\n...");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            System.in.read();
        } catch (IOException|NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

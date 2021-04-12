package battleship;

import java.util.Scanner;

public class Game {

    public static Scanner scanner = new Scanner(System.in);

    public static void addShip(Ship ship) {

        // lets get some coordinates
        scanner.reset();
        scanner = new Scanner(System.in);

        label:
        while (true) {
            System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n> ");
            String coordinate1 = scanner.next();
            String coordinate2 = scanner.next();

            // coordinates on board to ints
            int x1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
            int y1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)

            int x2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
            int y2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)

            // checking and validating coordinates range and placement on the board
            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10 && x2 > 0 && y2 > 0 && x2 <= 10 && y2 <= 10) {
                // changing places when first value is larger
                if (x1 > x2) {
                    int tempX1 = x2;
                    x2 = x1;
                    x1 = tempX1;
                }
                if (y1 > y2) {
                    int tempY1 = y2;
                    y2 = y1;
                    y1 = tempY1;
                }

                // checking positions
                if (x1 == x2) {                             // it's horizontal!
                    if ((y2 - y1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");

                        //checking placement on the board for collisions and overlapping - horizontally
                        for (int i = y1; i <= y2; i++) {
                            if (Board.board[x1][i].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x1 != 10) {
                                if (Board.board[x1 + 1][i].equals("O") || Board.board[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! There is other ship over or under next to this place.\n");
                                    continue label;
                                }
//                            } else if (x1 == 1) {
//                                if (Board.board[x1 + 1][i].equals("O")) {
//                                    System.out.println("Error! There is other ship below, next to this place.\n");
//                                    continue label;
//                                }
                            } else {
                                if (Board.board[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! There is other ship below, next to this place.\n");
                                    continue label;
                                }
                            }
                            if (y2 != 10) {
                                if (Board.board[x1][y1 - 1].equals("O") || Board.board[x1][y2 + 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left or right next to this place.\n");
                                    continue label;
                                }
                            } else {
                                if (Board.board[x1][y1 - 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left next to this place.\n");
                                    continue label;
                                }
                            }
                        }
                        for (int i = y1; i <= y2; i++) {
                            Board.board[x1][i] = "O";
                        }
                        Board.printBoard();
                        break;
                    } else {
                        System.out.println("Error! Wrong ship size! Try again.\n");
                    }
                } else if (y1 == y2) {                      // it's vertical!
                    if ((x2 - x1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");

                        //checking placement on the board for collisions and overlapping - vertically
                        for (int i = x1; i <= x2; i++) {
                            if (Board.board[i][y1].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x2 != 10) {
                                if (Board.board[i + 1][y1].equals("O") || Board.board[i - 1][y1].equals("O")) {
                                    System.out.println("Error! There is other ship over or under next to this place.\n");
                                    continue label;
                                }
//                            } else if (y1 == 1) {
//                                if (Board.board[i][y1 + 1].equals("O")) {
//                                    System.out.println("Error! There is other ship below, next to this place.\n");
//                                    continue label;
//                                }
//                            } else {
//                                if (Board.board[i - 1][y1].equals("O")) {                      // possibly unnecessary !
//                                    System.out.println("Error! There is other ship above.\n");
//                                    continue label;
//                                }
                            }
                            if (y1 != 10) {
                                if (Board.board[i][y1 - 1].equals("O") || Board.board[i][y2 + 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left or right next to this place.\n");
                                    continue label;
                                }
                            } else {
                                if (Board.board[i][y1 - 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left next to this place.\n");
                                    continue label;
                                }
                            }
                        }

                        for (int i = x1; i <= x2; i++) {
                            Board.board[i][y1] = "O";
                        }
                        Board.printBoard();
                        break;
                    } else {
                        System.out.println("Error! Wrong ship size! Try again.\n");
                    }
                } else {
                    System.out.println("Error! Wrong ship location! Looks like it's cross-draw. Try again.\n");
                }
            } else {
                System.out.println("Error! Wrong location! Looks like it's out of board range. Try again.\n");
            }
        }   // end of while loop
    }

    public static void play() {

        int shipCounter = (5 + 4 + 3 + 3 + 2);
//        int shipCounter = 2;  // test counter

        System.out.println("The game starts!");
        Board.printHiddenBoard();
        System.out.print("Take a shot!\n\n> ");

        // scanning, checking and validating shots coordinates.
        while (true) {
            scanner.reset();
            scanner = new Scanner(System.in);
            String shotCoordinate = scanner.next();
            // coordinates on board to ints
            int x1 = Character.toUpperCase(shotCoordinate.charAt(0)) - 'A' + 1;  // letter (horizontal)
            int y1 = Integer.parseInt(shotCoordinate.substring(1));               // number (vertical)
            if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10) {
                if (Board.board[x1][y1].equals("M") || Board.board[x1][y1].equals("X")) {
//                    System.out.print("\nError! You've already shot this spot.. Try again:\n\n> ");
                    System.out.print("\nYou hit a ship! Try again:\n> ");

                } else if (Board.board[x1][y1].equals("O")) {
                    Board.board[x1][y1] = "X";
                    Board.hiddenBoard[x1][y1] = "X";
                    shipCounter--;
                    Board.printHiddenBoard();
                    if (Board.checker(x1, y1)) {
                        System.out.print("\nYou hit a ship! Try again:\n\n> ");
                    } else if (!Board.checker(x1, y1) && shipCounter == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    } else {
                        System.out.println("You sank a ship!");
                    }

                } else {
                    Board.board[x1][y1] = "M";
                    Board.hiddenBoard[x1][y1] = "M";
                    Board.printHiddenBoard();
                    System.out.print("You missed! Try again:\n\n> ");
                }
//                Board.printBoard();
//                break;
            } else {
                System.out.print("\nError! You entered the wrong coordinates! Try again:\n\n> ");
            }
        }
    }
}

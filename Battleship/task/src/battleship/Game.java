package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Game {

    //    private final Board board = new Board();  //moved to Main.java
    public static Scanner scanner = new Scanner(System.in);

    public void addShip(Ship ship, Board board) {
        // added array to store location of each ship
        int[] arrayOfShipLocations = new int[ship.getSize()];

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
                            if (board.getBoard()[x1][i].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x1 != 10) {
                                if (board.getBoard()[x1 + 1][i].equals("O") || board.getBoard()[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board.getBoard()[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                            if (y2 != 10) {
                                if (board.getBoard()[x1][y1 - 1].equals("O") || board.getBoard()[x1][y2 + 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board.getBoard()[x1][y1 - 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                        }
                        int j = 0;
                        for (int i = y1; i <= y2; i++) {
                            board.getBoard()[x1][i] = "O";
                            arrayOfShipLocations[j] = (x1 * 10 + i);
                            j++;
                        }
                        ship.setShipLocation(arrayOfShipLocations);
                        board.printBoard();
                        // remove test below!
//                        System.out.println(">> testing ship's locations array:\n>> " + ship + Arrays.toString(ship.getShipLocation()));
//                        System.out.println(Arrays.toString(ship.getLoc()));

                        break;
                    } else {
                        System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:\n");
                    }
                } else if (y1 == y2) {                      // it's vertical!
                    if ((x2 - x1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");

                        //checking placement on the board for collisions and overlapping - vertically
                        for (int i = x1; i <= x2; i++) {
                            if (board.getBoard()[i][y1].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x2 != 10) {
                                if (board.getBoard()[i + 1][y1].equals("O") || board.getBoard()[i - 1][y1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                            if (y1 != 10) {
                                if (board.getBoard()[i][y1 - 1].equals("O") || board.getBoard()[i][y2 + 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board.getBoard()[i][y1 - 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left next to this place.\n");
                                    continue label;
                                }
                            }
                        }
                        int j = 0;
                        for (int i = x1; i <= x2; i++) {
                            board.getBoard()[i][y1] = "O";
                            arrayOfShipLocations[j] = (i * 10 + y1);
                            j++;
                        }
                        board.printBoard();
                        ship.setShipLocation(arrayOfShipLocations);
                        // remove test below!
//                        System.out.println(">> testing ship's locations array:\n>> " + ship + Arrays.toString(ship.getShipLocation()));

                        break;
                    } else {
//                        System.out.println("Error! Wrong ship size! Try again.\n");
                        System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:\n");
                    }
                } else {
                    System.out.println("Error! Wrong ship location! Try again.\n");
                }
            } else {
                System.out.println("Error! Wrong location! Try again.\n");
            }
        }   // end of while loop
    } // moved to Board.java

    public void playOnePlayerBoard(Board board) {

        System.out.println("The game starts!");
        board.printHiddenBoard();
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
                if (board.getBoard()[x1][y1].equals("M")) {
                    System.out.print("\nError! You've already shot this spot.. Try again:\n\n> ");
//                    System.out.print("\nYou hit a ship! Try again:\n> ");

                } else if (board.getBoard()[x1][y1].equals("O") || board.getBoard()[x1][y1].equals("X")) {
                    board.getBoard()[x1][y1] = "X";
                    board.getHiddenBoard()[x1][y1] = "X";
//                    shipCounter--;
                    board.printHiddenBoard();
//                    if (board.checker(x1, y1)) {
//                        System.out.print("\nYou hit a ship! Try again:\n\n> ");
//                    } else

                    board.shipHitCounter(x1, y1);

                    if (board.getShipCounter() == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    }
//                    else {
//                        System.out.println("You sank a ship!");
//                    }

                } else {
                    board.getBoard()[x1][y1] = "M";
                    board.getHiddenBoard()[x1][y1] = "M";
                    board.printHiddenBoard();
                    System.out.print("You missed! Try again:\n\n> ");
                }
//                Board.printBoard();
//                break;
            } else {
                System.out.print("\nError! You entered the wrong coordinates! Try again:\n\n> ");
            }
        }
    } // only for testing part includes own shooting procedure

    public void playTwoPlayers(Board boardPlayer1, Board boardPlayer2) {

        /**
         // print hitBoard
         // -------------- // a line
         // print boardPlayer1
         // pick spot
         // take a shot at boardPlayer2
         // check if miss or hit -> put marker in boardPlayer2 and in hitBoard in boardPlayer1
         // regardless of hit or miss -> pass to another player
         // -> ... // promptEnterKey()
         // print hitBoard
         // -------------- // a line
         // print boardPlayer2
         // pick a spot
         // take a shot at boardPlayer1
         // check if miss or hit -> put marker in boardPlayer1 and in hitBoard in boardPlayer2
         // regardless of hit or miss -> pass to another player
         // -> ... // promptEnterKey()
         * */

        if (boardPlayer1.getShipCounter() != 0 && boardPlayer2.getShipCounter() != 0) {
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
//                    System.out.print("\nYou hit a ship! Try again:\n> ");

                } else if (board.getBoard()[x1][y1].equals("O") || board.getBoard()[x1][y1].equals("X")) {
                    board.getBoard()[x1][y1] = "X";
                    board.getHiddenBoard()[x1][y1] = "X";
//                    shipCounter--;
//                    board.printHiddenBoard();
//                    if (board.checker(x1, y1)) {
//                        System.out.print("\nYou hit a ship! Try again:\n\n> ");
//                    } else

                    board.shipHitCounter(x1, y1);

                    if (board.getShipCounter() == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    }
                    break;

                } else {
                    board.getBoard()[x1][y1] = "M";
                    board.getHiddenBoard()[x1][y1] = "M";
//                    board.printHiddenBoard();
                    System.out.print("You missed!");
                    break;
                }
//                Board.printBoard();
//                break;
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

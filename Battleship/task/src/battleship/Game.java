package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private final Board board = new Board();
    public static Scanner scanner = new Scanner(System.in);

    public void prepareBoard() {
        board.prepareBoardAndHiddenBoard();
    }

    public void addShip(Ship ship) {
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
                                    System.out.println("Error! There is other ship over or under next to this place.\n");
                                    continue label;
                                }
                            } else {
                                if (board.getBoard()[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! There is other ship below, next to this place.\n");
                                    continue label;
                                }
                            }
                            if (y2 != 10) {
                                if (board.getBoard()[x1][y1 - 1].equals("O") || board.getBoard()[x1][y2 + 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left or right next to this place.\n");
                                    continue label;
                                }
                            } else {
                                if (board.getBoard()[x1][y1 - 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left next to this place.\n");
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
                        System.out.println("Error! Wrong ship size! Try again.\n");
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
                                    System.out.println("Error! There is other ship over or under next to this place.\n");
                                    continue label;
                                }
                            }
                            if (y1 != 10) {
                                if (board.getBoard()[i][y1 - 1].equals("O") || board.getBoard()[i][y2 + 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left or right next to this place.\n");
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

    public void play() {

//        int shipCounter = (5 + 4 + 3 + 3 + 2);
        int shipCounter = 5;  // test counter

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
                if (board.getBoard()[x1][y1].equals("M") || board.getBoard()[x1][y1].equals("X")) {
                    System.out.print("\nError! You've already shot this spot.. Try again:\n\n> ");
//                    System.out.print("\nYou hit a ship! Try again:\n> ");

                } else if (board.getBoard()[x1][y1].equals("O")) {
                    board.getBoard()[x1][y1] = "X";
                    board.getHiddenBoard()[x1][y1] = "X";
                    shipCounter--;
                    board.printHiddenBoard();
//                    if (board.checker(x1, y1)) {
//                        System.out.print("\nYou hit a ship! Try again:\n\n> ");
//                    } else if (!board.checker(x1, y1) && shipCounter == 0) {
//                        System.out.println("You sank the last ship. You won. Congratulations!");
//                        break;
//                    } else {
//                        System.out.println("You sank a ship!");
//                    }
                    board.shipHitCounter(x1,y1);


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
    }
}

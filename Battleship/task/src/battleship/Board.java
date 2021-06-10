package battleship;

import java.util.Scanner;

public class Board {
    public static Scanner scanner = new Scanner(System.in);

    final private String[][] board = new String[11][11];
    final private String[][] hiddenBoard = new String[11][11];

    private int shipCounter = 2; // 1 ship (DESTROYER for testing)
//    private int shipCounter = 5; // 1 ship (CRUISER for testing) + 1 ship (DESTROYER for testing)
//    private int shipCounter = (5 + 4 + 3 + 3 + 2); // all ships

    public int getShipCounter() {
        return shipCounter;
    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getHiddenBoard() {
        return hiddenBoard;
    }

    public void prepareBoardAndHiddenBoard() {

        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = " ";
                    hiddenBoard[i][j] = " ";
                } else if (i == 0) {
                    board[i][j] = Integer.toString(j);
                    hiddenBoard[i][j] = Integer.toString(j);
                } else if (j == 0) {
                    board[i][j] = Character.toString((char) (64 + i));
                    hiddenBoard[i][j] = Character.toString((char) (64 + i));
                } else {
                    board[i][j] = "~";
                    hiddenBoard[i][j] = "~";
                }
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
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
                            if (board[x1][i].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x1 != 10) {
                                if (board[x1 + 1][i].equals("O") || board[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board[x1 - 1][i].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                            if (y2 != 10) {
                                if (board[x1][y1 - 1].equals("O") || board[x1][y2 + 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board[x1][y1 - 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                        }
                        int j = 0;
                        for (int i = y1; i <= y2; i++) {
                            board[x1][i] = "O";
                            arrayOfShipLocations[j] = (x1 * 10 + i);
                            j++;
                        }
                        ship.setShipLocation(arrayOfShipLocations);
                        printBoard();
//                         remove test below!
//                        System.out.println(">> testing ship's locations array:\n>> " + ship + Arrays.toString(ship.getShipLocation()));
//                        System.out.println(Arrays.toString(ship.getShipLocation()));

                        break;
                    } else {
                        System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:\n");
                    }
                } else if (y1 == y2) {                      // it's vertical!
                    if ((x2 - x1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");

                        //checking placement on the board for collisions and overlapping - vertically
                        for (int i = x1; i <= x2; i++) {
                            if (board[i][y1].equals("O")) {
                                System.out.println("Error! This place is occupied.\n");
                                continue label;
                            }
                            if (x2 != 10) {
                                if (board[i + 1][y1].equals("O") || board[i - 1][y1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            }
                            if (y1 != 10) {
                                if (board[i][y1 - 1].equals("O") || board[i][y2 + 1].equals("O")) {
                                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                                    continue label;
                                }
                            } else {
                                if (board[i][y1 - 1].equals("O")) {
                                    System.out.println("Error! There is other ship on the left next to this place.\n");
                                    continue label;
                                }
                            }
                        }
                        int j = 0;
                        for (int i = x1; i <= x2; i++) {
                            board[i][y1] = "O";
                            arrayOfShipLocations[j] = (i * 10 + y1);
                            j++;
                        }
                        printBoard();
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
    }


    public void printBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public void printHiddenBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                System.out.print(hiddenBoard[i][j] + " ");
            }
        }
//        System.out.println("\n");
    }

    public void shipHitCounter(int x, int y) {

        checker(x, y, Ship.AIRCRAFT_CARRIER.getShipLocation());
        checker(x, y, Ship.BATTLESHIP.getShipLocation());
        checker(x, y, Ship.SUBMARINE.getShipLocation());
        checker(x, y, Ship.CRUISER.getShipLocation());
        checker(x, y, Ship.DESTROYER.getShipLocation());

    }

    public void checker(int x, int y, int[] shipArrayLoc) {
        int shipLengthLeft = 0;

        for (int j = 0; j < shipArrayLoc.length; j++) {
            if (shipArrayLoc[j] != 0) {
                shipLengthLeft++;
            }
        }

        for (int i = 0; i < shipArrayLoc.length; i++) {
            if (shipArrayLoc[i] == (x * 10 + y)) {
                shipArrayLoc[i] = 0;
                shipLengthLeft--;
                shipCounter--;
                System.out.print("\nYou hit a ship!");

                if (shipLengthLeft == 0) {
                    System.out.println("You sank a ship!");
                }
                if (shipCounter != 0 && shipLengthLeft==0) {
                    System.out.print("Specify a new target:\n\n> ");
                }
                else if (shipCounter != 0) {
//                    System.out.print("Try again:\n\n> ");
                    System.out.println("*** testing *** \n" + "shipCounter " + shipCounter);
                }

                break;
            }
        }
    }
}

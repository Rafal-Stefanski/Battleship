package battleship;

import battleship.ship.AircraftCarrier;
import battleship.ship.Battleship;
import battleship.ship.Ship;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {


    public static void main(String[] args) {

        // Write your code here

        Board.prepareBoard();
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        Battleship battleship = new Battleship();

//        addShip(aircraftCarrier);
//        Board.printBoard();

        addShip(battleship);
        Board.printBoard();


    }



    public static void addShip(Ship ship) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n\n> ");
            String coordinate1 = scanner.next();
            String coordinate2 = scanner.next();
            scanner.close();

//            while (true) {

                boolean ifHorizontal = false, ifVertical = false;

                // coordinates on board
                int i1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
                int j1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)

                int i2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
                int j2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)

                if (i1 == i2) {
                    ifHorizontal = true;
                } else if (j1 == j2) {
                    ifVertical = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");
//                    addShip();
                }


                if (ifHorizontal || ifVertical) {
                    if (j2 - j1 == ship.getSize() - 1) {
                        for (int i = j1; i <= j2; i++) {
                            Board.board[i1][i] = "O";
                        }
                    } else if (i2 - i1 == ship.getSize() - 1) {
                        for (int i = i1; i <= i2; i++) {
                            Board.board[i][j1] = "O";
                        }
                    } else {
                        System.out.println("Error! Wrong size of ship, sorry mate. Try again:");
//                        addShip();
                    }
                }
                System.out.println("i1 = " + i1);
                System.out.println("j1 = " + j1);
            }

//        } catch (NoSuchElementException e) {
//            System.out.println(e.getMessage());
//        }



//        return Board.board;

    }
}
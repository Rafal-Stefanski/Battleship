package battleship;

import java.util.Arrays;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 *
 * protocol for 2 players game:
 * player1 - boardPlayer1 - with ships
 *         - board4shotsPlayer1 - board with hits and misses aimed at boardPlayer2
 *
 * player2 - boardPlayer2 - with ships
 *         - board4shotsPlayer2 - board with hits and misses aimed at boardPlayer1
 *
 *      Game stars.
 *      Player 1 adds ships
 *      Player 2 adds ships
 *
 *      Take a shot - command, Player 1 stars
 *      board4shotsPlayer1
 *      -----------------
 *      boardPlayer1
 *
 *      player 1 takes a shot:
 *      if hits puts X on boards4shotsPlayer1 and boardPlayer 2
 *      if misses puts M ---||----
 *      switch
 *
 *      Take a shot - command, Player 2
 *      board4shotsPlayer2
 *      -----------------
 *      boardPlayer2
 *
 *      player 2 takes a shot:
 *      the same..
 *      switch
 *
 */

public class Main {

    public static void main(String[] args) {

        Skirmish skirmish = new Skirmish();

        skirmish.skirmish();

//        Game gamePlayer1 = new Game();
//        Game gamePlayer2 = new Game();
//
//        gamePlayer1.prepareBoard();
//
//        gamePlayer1.addShip(Ship.AIRCRAFT_CARRIER);
//        gamePlayer1.addShip(Ship.BATTLESHIP);
//        gamePlayer1.addShip(Ship.SUBMARINE);
//        gamePlayer1.addShip(Ship.CRUISER);
//        gamePlayer1.addShip(Ship.DESTROYER);
//
//        gamePlayer2.prepareBoard();
//
//        gamePlayer2.addShip(Ship.AIRCRAFT_CARRIER);
//        gamePlayer2.addShip(Ship.BATTLESHIP);
//        gamePlayer2.addShip(Ship.SUBMARINE);
//        gamePlayer2.addShip(Ship.CRUISER);
//        gamePlayer2.addShip(Ship.DESTROYER);
//
//
////        System.out.println("******* test section ********");
//////        System.out.println(">> testing ship's locations array:\n>> " + Ship.AIRCRAFT_CARRIER + Arrays.toString(Ship.AIRCRAFT_CARRIER.getLoc()));
////        System.out.println(Ship.BATTLESHIP + Arrays.toString(Ship.BATTLESHIP.getShipLocation()));
////        System.out.println(Ship.SUBMARINE + Arrays.toString(Ship.SUBMARINE.getShipLocation()));
////        System.out.println("******* test section ********");
//
//        gamePlayer1.play();
//        gamePlayer2.play();
    }


    public static void fastCheck() {

//        Pattern p = Pattern.compile("[a-jA-J]([1-9]|10)\\s[a-jA-J]([1-9]|10)");
//        Matcher m = p.matcher(coordinates);
//
//        if (m.matches()) {
//            System.out.println("coordinates are in range.");
//            return true;
//        } else {
//            System.out.println("coordinates doesn't match");
//            return false;
//        }


//        System.out.println("**** fast check ****");
//        System.out.println("i1 = " + i1);
//        System.out.println("j1 = " + j1);
//        System.out.println("i2 = " + i2);
//        System.out.println("j2 = " + j2);
//        System.out.println("****   ******   ****");
    }
}
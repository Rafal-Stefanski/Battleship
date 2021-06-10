package battleship;

import java.io.IOException;
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
        Game game = new Game();
        Board boardPlayer1 = new Board();
        Board boardPlayer2 = new Board();

        System.out.println("Player 1, place your ships on the game field");
        boardPlayer1.prepareBoardAndHiddenBoard();

//        boardPlayer1.addShip(Ship.AIRCRAFT_CARRIER);
//        boardPlayer1.addShip(Ship.BATTLESHIP);
//        boardPlayer1.addShip(Ship.SUBMARINE);
//        boardPlayer1.addShip(Ship.CRUISER);
        boardPlayer1.addShip(Ship.DESTROYER);

        Game.promptEnterKey();
        System.out.println("Player 2, place your ships on the game field");
        boardPlayer2.prepareBoardAndHiddenBoard();

//        boardPlayer2.addShip(Ship.AIRCRAFT_CARRIER);
//        boardPlayer2.addShip(Ship.BATTLESHIP);
//        boardPlayer2.addShip(Ship.SUBMARINE);
//        boardPlayer2.addShip(Ship.CRUISER);
        boardPlayer2.addShip(Ship.DESTROYER);

        Game.promptEnterKey();
        //        System.out.println("The game starts!");
        game.playTwoPlayers(boardPlayer1, boardPlayer2);

//        System.out.println("******* test section ********");
////        System.out.println(">> testing ship's locations array:\n>> " + Ship.AIRCRAFT_CARRIER + Arrays.toString(Ship.AIRCRAFT_CARRIER.getLoc()));
//        System.out.println(Ship.BATTLESHIP + Arrays.toString(Ship.BATTLESHIP.getShipLocation()));
//        System.out.println(Ship.SUBMARINE + Arrays.toString(Ship.SUBMARINE.getShipLocation()));
//        System.out.println("******* test section ********");



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

package battleship;

import java.io.IOException;

import java.io.IOException;

public class Skirmish {


    public void skirmish() {

//        boldSizeOfString();

//        Game gamePlayer1 = new Game();
//        Game gamePlayer2 = new Game();
//        Game game = new Game();
//        final Board boardPlayer1 = new Board();
//        final Board boardPlayer2 = new Board();
//        System.out.println("Player 1, place your ships on the game field");

//        gamePlayer1.prepareBoard();
//        game.prepareBoard(boardPlayer1, boardPlayer2);


//        gamePlayer1.addShip(Ship.AIRCRAFT_CARRIER);
//        gamePlayer1.addShip(Ship.BATTLESHIP);
//        gamePlayer1.addShip(Ship.SUBMARINE);
//        gamePlayer1.addShip(Ship.CRUISER);
//        gamePlayer1.addShip(Ship.DESTROYER);

//        promptEnterKey();
//        System.out.println("Player 1, place your ships on the game field");
//        gamePlayer2.prepareBoard();

//        gamePlayer2.addShip(Ship.AIRCRAFT_CARRIER);
//        gamePlayer2.addShip(Ship.BATTLESHIP);
//        gamePlayer2.addShip(Ship.SUBMARINE);
//        gamePlayer2.addShip(Ship.CRUISER);
//        gamePlayer2.addShip(Ship.DESTROYER);


//        System.out.println("******* test section ********");
////        System.out.println(">> testing ship's locations array:\n>> " + Ship.AIRCRAFT_CARRIER + Arrays.toString(Ship.AIRCRAFT_CARRIER.getLoc()));
//        System.out.println(Ship.BATTLESHIP + Arrays.toString(Ship.BATTLESHIP.getShipLocation()));
//        System.out.println(Ship.SUBMARINE + Arrays.toString(Ship.SUBMARINE.getShipLocation()));
//        System.out.println("******* test section ********");

//        gamePlayer1.playOnePlayerBoard(gamePlayer1);
//        gamePlayer2.playOnePlayerBoard();


    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void boldSizeOfString() {
        String strNormalSize = "\033[0;0m";
        String strBoldSize = "\033[0;1m";
        System.out.println(strBoldSize + "\nBattleship console game,\ncreated by Rafal Stefanski.\n" + strNormalSize);
    }
}
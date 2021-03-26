package battleship.ship;

public class AircraftCarrier implements Ship {
    public static final String NAME = "AircraftCarrier";
    public static final int SIZE = 5;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}

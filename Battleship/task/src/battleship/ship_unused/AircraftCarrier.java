package battleship.ship_unused;

public class AircraftCarrier implements Ship {
    public static final String NAME = "Aircraft Carrier";
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

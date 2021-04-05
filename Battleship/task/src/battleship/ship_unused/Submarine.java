package battleship.ship_unused;

public class Submarine implements Ship{
    public static final String NAME = "Submarine";
    public static final int SIZE = 3;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}

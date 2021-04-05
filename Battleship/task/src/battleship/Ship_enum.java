package battleship;

public enum Ship_enum {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship",4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    public final String name;
    public final int size;

    Ship_enum(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}

package battleship;

public enum Ship {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5, new int[5]),
    BATTLESHIP("Battleship", 4, new int[4]),
    SUBMARINE("Submarine", 3, new int[3]),
    CRUISER("Cruiser", 3, new int[3]),
    DESTROYER("Destroyer", 2, new int[2]);

    public String name;
    public int size;
    public int[] shipLocation;

    Ship(String name, int size, int[] shipLocation) {
        this.name = name;
        this.size = size;
        this.shipLocation = shipLocation;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int[] getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(int[] shipLocation) {
        this.shipLocation = shipLocation;
    }
}

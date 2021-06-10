package battleship;

public class ShipInit {
    public String name;
    public int size;
    public int[] shipLocation;

    public ShipInit(String name, int size, int[] shipLocation) {
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

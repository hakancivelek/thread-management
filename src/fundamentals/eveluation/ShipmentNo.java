package fundamentals.eveluation;

public class ShipmentNo {
    private final String number;

    public ShipmentNo(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "ShipmentNo{" +
                "number='" + number + '\'' +
                '}';
    }
}
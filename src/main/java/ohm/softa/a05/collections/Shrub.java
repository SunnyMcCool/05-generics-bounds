package ohm.softa.a05.collections;

public class Shrub extends Plant{

    PlantColor ShrubColor;

    public Shrub(double height, String family, String name, PlantColor FlowerColor) {
        super(height, family, name);
        this.ShrubColor = PlantColor.GREEN;
    }

    @Override
    public String ToString() {
        return "shrub power";
    }

    @Override
    public int compareTo(double height) {
        return 0;
    }

    @Override
    public int compareTo(Object other) {
        return 0;
    }
}

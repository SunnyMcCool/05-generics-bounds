package ohm.softa.a05.model;

public class Shrub extends Plant{

    PlantColor ShrubColor;

    public Shrub(double height, String family, String name) {
        super(height, family, name);
        this.ShrubColor = PlantColor.GREEN;
    }

    @Override
    public PlantColor getColor() {
        return ShrubColor;
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

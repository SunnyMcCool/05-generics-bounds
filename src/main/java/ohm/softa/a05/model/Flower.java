package ohm.softa.a05.model;

public class Flower extends Plant {

    private final PlantColor FlowerColor;

    public Flower(double height, String family, String name, PlantColor FlowerColor) {
        super(height, family, name);

        if(FlowerColor == PlantColor.GREEN) {
                throw new IllegalArgumentException("not green");

        }
        else{
            this.FlowerColor = FlowerColor;
        }
    }


    @Override
    public PlantColor getColor() {
        return FlowerColor;
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

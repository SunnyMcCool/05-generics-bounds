package ohm.softa.a05.model;

public class Flower extends Plant {

    // final: einmal deklariert, nicht mehr änderbar
    // private: nur in Plant einsehbar, für außen getColor()
    private final PlantColor FlowerColor;

    public Flower(double height, String family, String name, PlantColor FlowerColor) {
        // geht an höheren Konstruktor von Plant
        super(height, family, name);

        if(FlowerColor == PlantColor.GREEN) {
                throw new IllegalArgumentException("not green");

        }
        else {
            this.FlowerColor = FlowerColor;
        }
    }

    @Override
    public PlantColor getColor() { return FlowerColor; }


}

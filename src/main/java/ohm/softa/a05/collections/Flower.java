package ohm.softa.a05.collections;

public class Flower extends Plant {

    PlantColor FlowerColor;

    public Flower(double height, String family, String name, PlantColor FlowerColor) {
        super(height, family, name);
        if(FlowerColor == PlantColor.GREEN) {
            try {
                throw new Exception("not green");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            this.FlowerColor = FlowerColor;
        }
    }

    @Override
    public String ToString() {
        return "flower power";
    }

    @Override
    public int compareTo(double height) {
        int returnValue = 0;
        if(this.height < height)
            returnValue=-1;
        else if (this.height > height)
            returnValue=1;

        return returnValue;
    }

    @Override
    public int compareTo(Object other) {
        return 0;
    }
}

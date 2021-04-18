package ohm.softa.a05.model;


public abstract class Plant implements Comparable {
    double height;
    String family;
    String name;
    private Object o;

    public Plant(double height, String family, String name)
    {
        this.height = height;
        this.family = family;
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o){
        return(this.o == o);
    }

    public int hashCode(){
        return 0;
    }

    public abstract String ToString();



    public abstract int compareTo(double height);

    //public enum getColor(){
        // PlantColor.getColor();
    //}
}

package ohm.softa.a05.model;


import ohm.softa.a05.collections.Comparable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Plant implements Comparable<Plant> {

    private final double height;
    private final String family;
    private final String name;

    protected Plant(double height, String family, String name)
    {
        // Exceptions aus Musterlösung
        if(family == null || family.length() == 0) throw new IllegalArgumentException("Specify a family");
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Specify a name");
        if(height <= 0.0) throw new IllegalArgumentException("Height may not be less or equal zero");

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

    public abstract PlantColor getColor();


    // aus Musterlösung
    // was passiert hier?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Plant)) return false;

        Plant plant = (Plant) o;

        return new EqualsBuilder()
                .append(getHeight(), plant.getHeight())
                .append(getFamily(), plant.getFamily())
                .append(getName(), plant.getName())
                .append(getColor(), plant.getColor())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFamily())
                .append(getName())
                .append(getHeight())
                .append(getColor())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("family", family)
                .append("name", name)
                .append("height", height)
                .append("color", getColor())
                .toString();
    }

    @Override
    public int compareTo(Plant plant) {
        return Double.compare(this.height, plant.height);
    }


}

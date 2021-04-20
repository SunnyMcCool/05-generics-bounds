package ohm.softa.a05.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

// Soll generisches Comparable implementieren
public abstract class Plant implements Comparable<Plant> {

    private final double height;
    private final String family;
    private final String name;

    protected Plant(double height, String family, String name)
    {
        // Exceptions aus Musterlösung
        // Wenn ein Argument null sein sollte
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

    // Abstract, da erst definierbar, wenn eine Flower oder Shrub erstellt wurde
    public abstract PlantColor getColor();


    // aus Musterlösung
    // return true, wenn Objekte beide gleich
    // false, wenn nicht
    @Override
    public boolean equals(Object o) {
        // Wenn Objekte gleich
        if (this == o) return true;

        // o ist keine Instanz von Pflanze
        if (!(o instanceof Plant)) return false;

        // o wird gecastet zu Pflanze
        Plant plant = (Plant) o;

        // EqualsBuilder vergleicht alle Eigenschaften miteinander nach Gleichheit
        return new EqualsBuilder()
                // if height == plant.height && ...
                .append(getHeight(), plant.getHeight())
                .append(getFamily(), plant.getFamily())
                .append(getName(), plant.getName())
                .append(getColor(), plant.getColor())
                // returns true if fields are equal
                .isEquals();
    }

    // integraler Wert, der Objekte in Hash-Container ablegt
    @Override
    public int hashCode() {
        // 17*37 + 45 = 674
        return new HashCodeBuilder(17, 37)
                .append(getFamily())
                .append(getName())
                .append(getHeight())
                .append(getColor())
                .toHashCode();
    }

    // Gebe alle Eigenschaften als String aus
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("family", family)
                .append("name", name)
                .append("height", height)
                .append("color", getColor())
                .toString();
    }


    // die compareTo-Methode vergleich zwei Pflanzenhöhen miteinander
    // Gleich groß = 0
    // a kleiner b = -1
    // a größer b = 1
    @Override
    public int compareTo(Plant plant) {

        return Double.compare(this.getHeight(), plant.getHeight());
    }


}

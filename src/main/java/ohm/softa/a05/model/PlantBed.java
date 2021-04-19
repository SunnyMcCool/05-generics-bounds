package ohm.softa.a05.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;

// A PlantBed may contain any subclass of Plant but nothing else!
public class PlantBed<T extends Plant>{

    private final SimpleList<T> plantList;

    // Konstruktor
    public PlantBed() {
        plantList = new SimpleListImpl<>();
    }

    // Pflanzen ins Beet hinzufügen
    public void add(T plant) {
        plantList.add(plant);
    }

    // Anzahl der Pflanzen im Beet
    public int size() {
        return plantList.size();
    }

    // Farbe geht rein -> gefilterete Liste kommt raus
    public SimpleList<T> getPlantsByColor(PlantColor color){
        // p = jede einzelne Pflanze, die in Liste ist
        return plantList.filter(p -> p.getColor().equals(color));
    }

    public SimpleList<T> getPlantList() {
        //hack to get a copy of the current list
        return plantList.map(p -> p);
    }


}

package ohm.softa.a05.collections;

import ohm.softa.a05.model.PlantColor;

import java.util.Iterator;

public class PlantBed<T> implements SimpleList<T>{

    SimpleList<T> plants;

    public SimpleList<T> getPlantsByColor(PlantColor color){
        return plants;
    }

    @Override
    public void add(T o) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}

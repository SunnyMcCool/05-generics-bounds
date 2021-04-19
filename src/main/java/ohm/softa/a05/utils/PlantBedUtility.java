package ohm.softa.a05.utils;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;

import java.util.HashMap;
import java.util.Map;

 // PECS (Producer Extends, Consumer Super)
 // Metal und Pandabären

// Warum abstrakt und privat?
public abstract class PlantBedUtility implements SimpleList {

    private PlantBedUtility(){

    }

    // <T extends Plant> = erlaubt alle Kindsklassen von Plant
    public static <T extends Plant>
        // In Map wird PlantColor und SimpleList<T> geworfen
        Map<PlantColor, SimpleList<T>>
            // Ein Beet wird reingegeben
            splitBedByColor(PlantBed<T> plantBed) {

        // In Map wird PlantColor und SimpleList<T> geworfen
        // neue Hashmap generiert
        Map<PlantColor, SimpleList<T>> result = new HashMap<>();

        for (T plant : plantBed.getPlantList()) {
            // Wenn Ergebnis nicht die Farbe der Pflanze erhält
            // gebe die Farbe in eine neue leere Liste
            if (!result.containsKey(plant.getColor())) {
                result.put(plant.getColor(), new SimpleListImpl<>());
            }
            // Nehme die entsprechende Liste und füge aktuelle Pflanze hinzu
            result.get(plant.getColor()).add(plant);
        }

        return result;
    }

    //shortest variant
    // T akzeptiert alle Kindsklassen von Plant
    public static <T extends Plant>
        // ? akzeptiert alle Kindsklassen von T
        Map<PlantColor, SimpleList<? extends T>>
            // ? akzeptiert alle Kindsklassen von T
            splitBedByColor2(PlantBed<? extends T> plantBed) {

        Map<PlantColor, SimpleList<? extends T>> result = new HashMap<>();
        // iterieren der Enum-Farben
        for (PlantColor color : PlantColor.values()) {
            // alle Pflanzen mit der akutellen Farbe
            result.put(color, plantBed.getPlantsByColor(color));
        }
        return result;
    }
}

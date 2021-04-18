package ohm.softa.a05.tests.utils;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.utils.PlantBedUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
class PlantUtilityTests {

    private PlantBed<Flower> flowerBed;

    @BeforeEach
    void setup() {
        flowerBed = new PlantBed<>();

        flowerBed.add(new Flower(0.4,"Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerBed.add(new Flower(0.3, "Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.35, "Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.35, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerBed.add(new Flower(0.35, "Rosa chinensis", "Dragonflower", PlantColor.ORANGE));
        flowerBed.add(new Flower(0.6, "Curly Sue", "Straight Andy", PlantColor.BLUE));
    }

    @Test
    void testSplitByBedByColorResultingSize() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        assertEquals(4, split.keySet().size());
    }

    @Test
    void testSplitByBedByColorPureness() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testSplitByBedByColorPureness2() {
        Map<PlantColor, SimpleList<? extends Flower>> split = PlantBedUtility.splitBedByColor2(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }
}
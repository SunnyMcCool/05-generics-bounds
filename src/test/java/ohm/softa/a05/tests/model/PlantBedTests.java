package ohm.softa.a05.tests.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
class PlantBedTests {

    private PlantBed<Flower> flowerBed;
    private PlantBed<Shrub> shrubBed;

    @BeforeEach
    void setup() {
        flowerBed = new PlantBed<>();
        shrubBed = new PlantBed<>();

        flowerBed.add(new Flower(0.4,"Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerBed.add(new Flower(0.3, "Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.35, "Golden Celebration", "Goldveilchen", PlantColor.YELLOW));
        flowerBed.add(new Flower(0.35, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerBed.add(new Flower(0.35, "Rosa chinensis", "Dragonflower", PlantColor.ORANGE));
        flowerBed.add(new Flower(0.6, "Curly Sue", "Straight Andy", PlantColor.BLUE));

        shrubBed.add(new Shrub(1.5, "Buxus sempervirens", "Buxus"));
        shrubBed.add(new Shrub(1.1, "Buxus sempervirens", "Buxus"));
        shrubBed.add(new Shrub(1.2, "Buxus sempervirens", "Buxus"));
        shrubBed.add(new Shrub(1.4, "Buxus sempervirens", "Buxus"));
    }

    @Test
    void testCreateEmptyPlantBed() {
        PlantBed<Flower> plantBed = new PlantBed<>();
        assertEquals(0, plantBed.size());
    }

    @Test
    void testGetSize() {
        assertEquals(4, shrubBed.size());
        assertEquals(7, flowerBed.size());
    }

    @Test
    void testGetPlantsByColorYellow() {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.YELLOW);
        assertEquals(3, flowers.size());
        for(Flower f : flowers) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorRed() {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.RED);
        assertEquals(2, flowers.size());
        for(Flower f : flowers) {
            assertEquals(PlantColor.RED, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorGreen() {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(0, flowers.size());

        SimpleList<Shrub> shrubs = shrubBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(4, shrubs.size());
    }
}
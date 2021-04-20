package ohm.softa.a05.tests.model;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlowerTest {

    @Test
    void testCreateGreenFlower() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.GREEN));
    }

    @Test
    void testCreateFlowerWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0.5, "Citrus", null, PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithEmptyFamily() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0.5, null, "Schlafmohn", PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(-10.0, "Abracadabra", "Zauberblume", PlantColor.RED));
    }

    @Test
    void testGetCorrectColor() {
        Flower f = new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED);
        assertEquals(PlantColor.RED, f.getColor());
    }

    @Test
    void testGetCorrectHeight() {
        Flower f = new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED);
        assertEquals(0.5, f.getHeight(), 0.0000001);
    }

    @Test
    void testGetCorrectName() {
        Flower f = new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED);
        assertEquals("Zauberblume", f.getName());
    }

    @Test
    void testGetCorrectFamily() {
        Flower f = new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED);
        assertEquals("Abracadabra", f.getFamily());
    }

    @Test
    void testSortFlowers() {
        List<Plant> flowerList = new LinkedList<>();

        flowerList.add(new Shrub(3.5, "Buxus sempervirens", "Buxus"));
        flowerList.add(new Flower(1.0, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerList.add(new Shrub(5.5, "Buxus sempervirens", "Buxus"));
        flowerList.add(new Flower(0.5, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerList.add(new Shrub(1.5, "Buxus sempervirens", "Buxus"));
        flowerList.add(new Flower(0.75, "Abracadabra", "Zauberblume", PlantColor.RED));
        flowerList.add(new Shrub(4.5, "Buxus sempervirens", "Buxus"));
        flowerList.add(new Flower(2.5, "Abracadabra", "Zauberblume", PlantColor.RED));

        // Liste sortieren nach Höhe
        flowerList.sort(Plant::compareTo);

        // Test, ob korrekt sortiert wurde
        // aktuelle Höhe mit letzter verglichen
        double lastHeight = 0.0;
        for(Plant f : flowerList){
            assertTrue(f.getHeight() > lastHeight);
            lastHeight = f.getHeight();
        }
    }
}
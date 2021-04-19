package ohm.softa.a05.tests.model;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShrubTests {

    @Test
    void testGetColor() {
        assertEquals(PlantColor.GREEN, new Shrub(1.5, "Buxus sempervirens", "Buxus").getColor());
    }

    @Test
    void testCreateShrubWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Shrub(1.5, "Buxus sempervirens", null));
    }

    @Test
    void testCreateShrubWithEmptyFamily() {
        assertThrows(IllegalArgumentException.class, () -> new Shrub(1.5, null, "Buxus"));
    }

    @Test
    void testCreateShrubWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Shrub(-1.5, "Buxus sempervirens", "Buxus"));
    }

    @Test
    void testGetCorrectHeight() {
        Shrub s = new Shrub(1.5, "Buxus sempervirens", "Buxus");
        assertEquals(1.5, s.getHeight(), 0.0000001);
    }

    @Test
    void testGetCorrectName() {
        Shrub s = new Shrub(1.5, "Buxus sempervirens", "Buxus");
        assertEquals("Buxus", s.getName());
    }

    @Test
    void testGetCorrectFamily() {
        Shrub s = new Shrub(1.5, "Buxus sempervirens", "Buxus");
        assertEquals("Buxus sempervirens", s.getFamily());
    }

    @Test
    void testSortShrub() {
        List<Plant> shrubList = new LinkedList<>();

        shrubList.add(new Shrub(3.5, "Buxus sempervirens", "Buxus"));
        shrubList.add(new Shrub(5.5, "Buxus sempervirens", "Buxus"));
        shrubList.add(new Shrub(1.5, "Buxus sempervirens", "Buxus"));

        // Liste sortieren nach Höhe
        shrubList.sort(Plant::compareTo);

        // Liste sortieren nach Höhe
        double lastHeight = 0.0;
        for(Plant s : shrubList){
            assertTrue(s.getHeight() > lastHeight);
            lastHeight = s.getHeight();
        }

        System.out.println(shrubList);
    }
}
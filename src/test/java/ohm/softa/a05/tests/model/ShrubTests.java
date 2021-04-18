package ohm.softa.a05.tests.model;

import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Peter Kurfer
 * Created on 11/2/17.
 */
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
        assertEquals("Buxus sempervirens", s.getName());
    }

    @Test
    void testGetCorrectFamily() {
        Shrub s = new Shrub(1.5, "Buxus sempervirens", "Buxus");
        assertEquals("Buxus", s.getFamily());
    }
}
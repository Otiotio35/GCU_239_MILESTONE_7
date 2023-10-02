package salable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/*
 * @version 10/01/2023 ID: 21024608
* @author toafik otiotio
*/
public class ArmorTest {

    /**
     * Test the getters and setters of the Armor class.
     */
    @Test
    public void testGettersAndSetters() {
        Armor armor = new Armor("Armor", "Plate Armor", "Heavy armor", 100.0, 2, "Plate");
     // Test the getter for armor type
        assertEquals("Plate", armor.getArmorType());
        // Test the setter for armor type
        armor.setArmorType("Chainmail");
        assertEquals("Chainmail", armor.getArmorType());
    }
}

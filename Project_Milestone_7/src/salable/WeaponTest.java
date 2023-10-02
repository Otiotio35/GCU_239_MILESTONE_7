package salable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Test class for the Weapon class.
 *
 * @version 10/01/2023 ID: 21024608
 * @author toafik otiotio
 */
public class WeaponTest {

    @Test
    public void testGettersAndSetters() {
        Weapon weapon = new Weapon("Weapon", "Sword", "Sharp sword", 50.0, 3, 15);

        assertEquals(15, weapon.getPower());

        weapon.setPower(20);
        assertEquals(20, weapon.getPower());
    }

    /**
     * Test the getters and setters of the Weapon class.
     */
    @Test
    public void testCompareTo() {
        Weapon warHammer = new Weapon("Weapon", "War Hammer", "Heavy hammer.", 1100.50, 70, 10);
        Weapon longbow = new Weapon("Weapon", "Longbow", "Long-range archery.", 950.00, 80, 5);
        Weapon spear = new Weapon("Weapon", "Spear", "Thrusting weapon.", 850.50, 90, 8);
        Weapon flail = new Weapon("Weapon", "Flail", "Spiked ball.", 920.00, 75, 12);

        assertTrue(warHammer.compareTo(longbow) > 0); // "War Hammer" < "Longbow"
        assertTrue(longbow.compareTo(warHammer) < 0); // "Longbow" > "War Hammer"
        assertTrue(spear.compareTo(flail) > 0); // "Spear" < "Flail"
    }

}

package salable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * Test class for the Health class.
 *
 * @version 10/01/2023 ID: 21024608
 * @author toafik otiotio
 */
public class HealthTest {
	/**
     * Test the getters and setters of the Health class.
     */
    @Test
    public void testGettersAndSetters() {
        Health health = new Health("Health", "Potion", "Restores health", 5.0, 10, 25);

        assertEquals(25, health.getPower());

        health.setPower(30);
        assertEquals(30, health.getPower());
    }
}

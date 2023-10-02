package salable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

	public class SalableTest {

	    @Test
	    public void testGettersAndSetters() {
	        Salable salable = new Salable("Type", "Product", "Description", 10.0, 5);

	        assertEquals("Type", salable.getType());
	        assertEquals("Product", salable.getName());
	        assertEquals("Description", salable.getDescription());
	        assertEquals(10.0, salable.getPrice(), 0.001);
	        assertEquals(5, salable.getQuantity());

	        salable.setType("New Type");
	        salable.setName("New Product");
	        salable.setDescription("New Description");
	        salable.setPrice(20.0);
	        salable.setQuantity(10);

	        assertEquals("New Type", salable.getType());
	        assertEquals("New Product", salable.getName());
	        assertEquals("New Description", salable.getDescription());
	        assertEquals(20.0, salable.getPrice(), 0.001);
	        assertEquals(10, salable.getQuantity());
	    }
	}


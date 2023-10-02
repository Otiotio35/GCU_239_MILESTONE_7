package inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import salable.Salable;

public class InventoryManagerTest {
	 /*
     * Test class for the InventoryManager class.
    * @version 10/01/2023 ID: 21024608
    * @author toafik otiotio
    */
    private InventoryManager inventoryManager;

    /**
     * Set up the test by initializing the InventoryManager instance.
     * You may need to provide a test file path for the constructor.
     */
    @BeforeEach
    public void setUp() {
        // Initialize the inventory manager (you may need to provide a test file path)
        inventoryManager = new InventoryManager("InFile.txt");
    }

    /**
     * Test adding a product to the inventory.
     */
    @Test
    public void testAddProduct() {
        // Test adding a product to the inventory
        Salable product = new Salable("Type", "Product", "Description", 10.0, 5);
        inventoryManager.addProduct(product);

        assertNotNull(inventoryManager.getProduct("Product"));
    }
    /**
     * Test removing a product from the inventory.
     */

    @Test
    public void testRemoveProduct() {
        // Test removing a product from the inventory
        Salable product = new Salable("Type", "Product", "Description", 10.0, 5);
        inventoryManager.addProduct(product);
        boolean removed = inventoryManager.removeProduct(product, 3);

        assertTrue(removed);
        assertEquals(2, inventoryManager.getProduct("Product").getQuantity());
    }
    /**
     * Test loading the inventory from a file.
     *
     * @throws IOException if there's an issue with loading the inventory.
     */
   @Test
    public void testLoadInventory() throws IOException {
        // Load the inventory from the test file "InFile.txt"
        inventoryManager.loadInventory();

        // Check if a specific product from the test data exists in the inventory
        assertNotNull(inventoryManager.getProduct("War Hammer"));
    }
   /**
    * Test updating the inventory with new data.
    */
    @Test
    public void testUpdateInventory() {
        // Test updating inventory with new data
        String testData = "Type: NewType|Name: NewProduct|Description: NewDescription|Price: 15.0|Quantity: 10\n";
        boolean updated = inventoryManager.updateInventory(testData);

        assertTrue(updated);
        assertNotNull(inventoryManager.getProduct("NewProduct"));
    }
    /**
     * Test purchasing a product.
     */
    @Test
    public void testPurchaseProduct() {
        // Test purchasing a product
        Salable product = new Salable("Type", "Product", "Description", 10.0, 5);
        inventoryManager.addProduct(product);

        boolean purchased = inventoryManager.purchaseProduct("Product", 3);

        assertTrue(purchased);
        assertEquals(2, inventoryManager.getProduct("Product").getQuantity());
    }
   // Test canceling a purchase
    @Test
    public void testCancelPurchase() {
        // Test canceling a purchase
        Salable product = new Salable("Type", "Product", "Description", 10.0, 5);
        inventoryManager.addProduct(product);
        inventoryManager.purchaseProduct("Product", 3);

        boolean canceled = inventoryManager.cancelPurchase("Product", 2);

        assertTrue(canceled);
        assertEquals(4, inventoryManager.getProduct("Product").getQuantity());
    }
}

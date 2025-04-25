package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart Test Suite")
class ShoppingCartTest {

    @Test
    @DisplayName("Test adding valid item")
    void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        // getItemCount not required in rubric, so removed
        assertEquals(1.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test adding item with empty name (expect exception)")
    void testAddEmptyNameThrows() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("", 1.0));
    }

    @Test
    @DisplayName("Test adding item with zero price (expect exception)")
    void testAddZeroPriceThrows() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Freebie", 0.0));
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    void testAddNegativePriceThrows() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Bad", -5.0));
    }

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.removeItem("Apple");
        assertEquals(0, cart.getItemCount());
    }

    @Test
    @DisplayName("Test removing non-existent item (expect exception)")
    void testRemoveNonExistentItemThrows() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.removeItem("Banana"));
    }

    @Test
    @DisplayName("Test applying SAVE10")
    void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying SAVE20")
    void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid code (expect exception)")
    void testApplyInvalidCodeThrows() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testGetTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 2.0);
        assertEquals(3.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testGetTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 100.0);
        cart.addItem("Banana", 50.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(135.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testGetTotalCostEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    void testCartSizeUpdates() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 2.0);
        assertEquals(2, cart.getItemCount());
        cart.removeItem("Apple");
        assertEquals(1, cart.getItemCount());
    }
}

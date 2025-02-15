package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingItemTest {

    @BeforeEach
    void setUp() {
        ItemIdGenerator.getInstance().reset();
    }


    @Test
    void getId() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertEquals(1, item.getId());
    }

    @Test
    void getName() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertEquals("Milk", item.getName());
    }

    @Test
    void getPrice() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertEquals(1.99, item.getPrice());
    }

    @Test
    void getQuantity() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertEquals(2, item.getQuantity());
    }

    @Test
    void testToString() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertEquals("ShoppingItem{id=1, name='Milk', price=1.99, quantity=2}", item.toString());
    }

    @Test
    void testEquals() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertNotEquals(item, new ShoppingItem("Milk", 1.99, 1));
        assertNotEquals(item, new ShoppingItem("Milk", 2.99, 2));
        assertNotEquals(item, new Object());
    }

    @Test
    void testHashCode() {
        ShoppingItem item = new ShoppingItem("Milk", 1.99, 2);
        assertNotEquals(item.hashCode(), new ShoppingItem("Milk", 1.99, 2).hashCode());
        assertEquals(item.hashCode(), Long.hashCode(1));
    }
}